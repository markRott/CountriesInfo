package com.example.sma.data.fetchdata.flag;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.caverock.androidsvg.SVG;
import com.example.sma.data.cache.lru.LruCacheForCountryFlagImpl;
import com.orhanobut.logger.Logger;

import org.reactivestreams.Publisher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;

/**
 * Created by sma on 18.10.17.
 */

public class FlagDataProviderFromNetwork implements IFlagDataProvider {

    private final LruCacheForCountryFlagImpl lruCache;

    private String flagUrl;
    private byte[] bitmapBytes;

    public FlagDataProviderFromNetwork(LruCacheForCountryFlagImpl lruCache) {
        this.lruCache = lruCache;
    }

    @Override
    public Flowable<byte[]> getFlagByteArray(final String flagUrl) {
        this.flagUrl = flagUrl;
        return asyncLoadFlag();
    }

    private Flowable<byte[]> asyncLoadFlag() {
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

        lruCache.put(flagUrl, bitmapBytes);
        Logger.i("loadCountryFlagInSvgFormat finish");

        return bitmapBytes;
    }

    private SVG getSvgFromNetwork() throws Exception {
//        flagUrl = "http://www.mocky.io/v2/59ee79833300008339b5c917";
        final URL url = new URL(flagUrl);
        final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        System.out.println("urlConnection = " + urlConnection);
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
