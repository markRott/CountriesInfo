package com.test.countriesapp.utils.image.glide;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.caverock.androidsvg.SVG;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.R;
import com.test.countriesapp.utils.image.IImageLoader;

import java.io.InputStream;

/**
 * Created by sma on 12.10.17.
 */

public class GlideImaleLoaderImpl implements IImageLoader {

    private Context context;
    private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> glideRequestBuilder;

    public GlideImaleLoaderImpl(Context context) {
        this.context = context;
        initGlide();
    }

    /**
     *  Load svg image from network.
     */
    @Override
    public void loadImage(String url, ImageView target, @DrawableRes int placeholderDrawable,
                          @DrawableRes int errorDrawable) {

        Uri uri = Uri.parse(Uri.decode(url));
        glideRequestBuilder
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .load(uri)
                .listener(new RequestListener<Uri, PictureDrawable>() {
                    @Override
                    public boolean onException(
                            Exception e, Uri uri, Target<PictureDrawable> target, boolean b) {
                        Logger.e("Glide onException = " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(
                            PictureDrawable pictureDrawable, Uri uri,
                            Target<PictureDrawable> target, boolean b, boolean b1) {

                        Logger.i("Glide onResourceReady = " + uri.toString());
                        return false;
                    }
                })
                .into(target);
    }

    private void initGlide() {
        glideRequestBuilder = Glide.with(context)
                .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .animate(android.R.anim.fade_in)
                .listener(new SvgSoftwareLayerSetter<Uri>());
    }
}
