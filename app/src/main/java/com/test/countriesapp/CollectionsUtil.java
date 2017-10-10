package com.test.countriesapp;

import java.util.Collection;
import java.util.Map;

/**
 * Created by sma on 10.10.17.
 */

public class CollectionsUtil {

    public static boolean isNullOrEmpty(final Collection<?> c) {

        return c == null || c.isEmpty();
    }

    public static boolean isNullOrEmpty(final Map<?, ?> m) {

        return m == null || m.isEmpty();
    }
}
