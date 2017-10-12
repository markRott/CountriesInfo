package com.test.countriesapp.utils.image.picasso;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.test.countriesapp.utils.image.IImageLoader;

/**
 * Created by sma on 10.10.17.
 */

public class PicassoImageLoaderImpl implements IImageLoader {

    private Context context;

    public PicassoImageLoaderImpl(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(
            String url,
            ImageView target,
            @DrawableRes int placeholderDrawable,
            @DrawableRes int errorDrawable) {

        Picasso.with(context)
                .load(url)
                .placeholder(placeholderDrawable)
                .error(errorDrawable)
                .into(target, new Callback() {
                    @Override
                    public void onSuccess() {
                        Logger.i("Success");
                    }

                    @Override
                    public void onError() {
                        Logger.e("Error");
                    }
                })
        ;
    }
}
