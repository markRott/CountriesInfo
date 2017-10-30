package com.test.countriesapp.dagger2.app;

import com.example.sma.data.IApplicationApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sma on 10.10.17.
 */

@Module
public class ApiModule {

    @Singleton
    @Provides
    public IApplicationApi provideApplicationApi() {
        final Retrofit retrofit = initRetrofit();
        return retrofit.create(IApplicationApi.class);
    }

    private Retrofit initRetrofit() {
        final Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                        .baseUrl(IApplicationApi.BASE_URL)
                        .addConverterFactory(initConverterFactory())
                        .addCallAdapterFactory(initCallAdapterFactory())
                        .client(initOkHttpClient());

        return retrofitBuilder.build();
    }

    private Converter.Factory initConverterFactory() {

        return GsonConverterFactory.create();
    }

    private CallAdapter.Factory initCallAdapterFactory() {

        return RxJava2CallAdapterFactory.create();
    }

    private OkHttpClient initOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.build();
    }
}
