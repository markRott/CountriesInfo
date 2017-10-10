package com.test.countriesapp.utils.image;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * Created by sma on 10.10.17.
 */

public interface IImageLoader {

    void loadImage(String url,
                   ImageView target,
                   @DrawableRes int placeholderDrawable,
                   @DrawableRes int errorDrawable);
}
