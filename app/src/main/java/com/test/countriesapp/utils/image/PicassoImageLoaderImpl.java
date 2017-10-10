package com.test.countriesapp.utils.image;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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
                .into(target);
    }
}
