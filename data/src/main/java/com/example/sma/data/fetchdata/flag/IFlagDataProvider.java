package com.example.sma.data.fetchdata.flag;

import io.reactivex.Flowable;

/**
 * Created by sma on 18.10.17.
 */

public interface IFlagDataProvider {

    Flowable<byte[]> getFlagByteArray(final String flagUrl);
}
