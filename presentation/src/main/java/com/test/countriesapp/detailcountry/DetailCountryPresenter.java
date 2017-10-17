package com.test.countriesapp.detailcountry;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.caverock.androidsvg.SVG;
import com.example.interfaces.IPostExecutionThread;
import com.example.sma.data.cache.lru.LruCacheForCountryFlagImpl;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.base.BasePresenter;
import com.test.countriesapp.base.BaseSubscriber;
import com.test.countriesapp.utils.CollectionsUtil;

import org.reactivestreams.Publisher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sma on 12.10.17.
 */

@InjectViewState
public class DetailCountryPresenter extends BasePresenter<IDetailCountryView> {

    @Inject
    LruCacheForCountryFlagImpl cache;
    @Inject
    IPostExecutionThread mainThread;

    private String flagUrl;
    private byte[] bitmapBytes;
//    private HttpImageRequestTask requestTask;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().startLoadFlag();
    }

    @Override
    public void attachView(IDetailCountryView view) {
        Logger.i("attachView");
        super.attachView(view);
    }

    @Override
    public void detachView(IDetailCountryView view) {
        super.detachView(view);
        Logger.i("detachView");
    }

    @Override
    public void destroyView(IDetailCountryView view) {
        super.destroyView(view);
        Logger.i("destroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i("onDestroy");
    }

    @Override
    public void inject() {
        MyApp.getAppComponent().inject(this);
        System.out.println("cache = " + cache);
        System.out.println("mainThread = " + mainThread);
    }

    public void loadCountryFlagInSvgFormat(String url) {
        if (TextUtils.isEmpty(url)) return;
        this.flagUrl = url;
        if (!CollectionsUtil.isNullOrEmpty(cache) && cache.containsKey(url)) {
            bitmapBytes = cache.get(url);
            getViewState().renderCountryFlag(bitmapBytes);
        } else {
//            requestTask = new HttpImageRequestTask(url);
//            requestTask.execute();
            asyncLoadFlag()
                    .subscribeOn(Schedulers.io())
                    .observeOn(mainThread.getScheduler())
                    .subscribe(new LoadFlagSubscriber())
            ;
        }
    }

    public Flowable<byte[]> asyncLoadFlag() {
        return Flowable.defer(new Callable<Publisher<? extends byte[]>>() {
            @Override
            public Publisher<? extends byte[]> call() throws Exception {
                return Flowable.just(syncLoadFlag());
            }
        });
    }

    private byte[] syncLoadFlag() throws Exception {
        final SVG svg = getSvgFromNetwork();
        final Bitmap bitmap = convertSvgToBitmap(svg);
        bitmapBytes = convertBitmapToByteArray(bitmap);
        cache.put(flagUrl, bitmapBytes);
        Logger.i("loadCountryFlagInSvgFormat doInBackground finish");
        return bitmapBytes;
    }

    private class LoadFlagSubscriber extends BaseSubscriber<byte[]> {
        @Override
        public void onNext(byte[] o) {
            bitmapBytes = o;
            getViewState().renderCountryFlag(bitmapBytes);
        }

        @Override
        public void onError(Throwable t) {
            Logger.e("LoadFlagSubscriber = " + t.getMessage());
        }
    }

   /*
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
    */

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
