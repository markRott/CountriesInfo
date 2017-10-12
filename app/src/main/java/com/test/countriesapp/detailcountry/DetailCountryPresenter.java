package com.test.countriesapp.detailcountry;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.caverock.androidsvg.SVG;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.base.BasePresenter;
import com.test.countriesapp.cache.LruCacheForCountryFlagImpl;
import com.test.countriesapp.utils.CollectionsUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sma on 12.10.17.
 */

@InjectViewState
public class DetailCountryPresenter extends BasePresenter<IDetailCountryView> {

    private byte[] bitmapBytes;
    private HttpImageRequestTask requestTask;
    private LruCacheForCountryFlagImpl cache;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void loadCountryFlagInSvgFormat(String url) {
        if (TextUtils.isEmpty(url)) return;
        if (!CollectionsUtil.isNullOrEmpty(cache) && cache.containsKey(url)) {
            bitmapBytes = cache.get(url);
            getViewState().renderCountryFlag(bitmapBytes);
        } else {
            requestTask = new HttpImageRequestTask(url);
            requestTask.execute();
        }
    }

    public void setCacheForCountryFlag(LruCacheForCountryFlagImpl cacheForCountryFlag) {
        this.cache = cacheForCountryFlag;
    }

    private class HttpImageRequestTask extends AsyncTask<Void, Void, byte[]> {

        private String flagUrl;

        HttpImageRequestTask(String url) {
            this.flagUrl = url;
        }

        @Override
        protected byte[] doInBackground(Void... params) {
            try {
                final SVG svg = getSvgFromNetwork();
                final Bitmap bitmap = convertSvgToBitmap(svg);
                bitmapBytes = convertBitmapToByteArray(bitmap);
                cache.put(flagUrl, bitmapBytes);
                Logger.i("loadCountryFlagInSvgFormat doInBackground finish");
            } catch (Exception e) {
                Logger.e("loadCountryFlagInSvgFormat doInBackground fail = " + e.getMessage());
            }
            return bitmapBytes;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            Logger.i("loadCountryFlagInSvgFormat onPostExecute");
            getViewState().renderCountryFlag(bitmapBytes);
        }

        private SVG getSvgFromNetwork() throws Exception {
            final URL url = new URL(flagUrl);
            final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            final InputStream inputStream = urlConnection.getInputStream();
            final SVG svg = SVG.getFromInputStream(inputStream);
            return svg;
        }

        private Bitmap convertSvgToBitmap(SVG svg) throws IOException {
            Bitmap bitmap = null;
            if (svg.getDocumentWidth() != -1) {
                bitmap = Bitmap.createBitmap((int) Math.ceil(svg.getDocumentWidth()),
                        (int) Math.ceil(svg.getDocumentHeight()),
                        Bitmap.Config.ARGB_8888);
                final Canvas bmcanvas = new Canvas(bitmap);
                bmcanvas.drawRGB(255, 255, 255);
                svg.renderToCanvas(bmcanvas);
            }
            return bitmap;
        }

        private byte[] convertBitmapToByteArray(final Bitmap bitmap) throws IOException {
            byte[] bytes = null;
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();
            stream.close();
            return bytes;
        }
    }
}
