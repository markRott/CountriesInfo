package com.test.countriesapp.utils;

import android.support.annotation.Nullable;

/**
 * Created by sma on 18.10.17.
 */

public class StringUtils {

    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

}
