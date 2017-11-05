package com.example.sma.data;

import com.example.sma.data.entities.CountryEntity;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by sma on 10.10.17.
 */

public interface IApplicationApi {

    String SVG = ".svg";
    String BASE_URL = "https://restcountries.eu/";
    String BASE_URL_FOR_FLAG_IMAGE = "https://restcountries.eu/data/";

    //@GET — принимает параметры с @Query, @Path и @QueryMap.

    /**
     * @POST, @PUT, @DELETE — принимает параметры типа @Part, @Field и @Body. Тут есть еще один нюанс.
     * @Part мы можем использовать только с параметром @Multipart,
     * а @Field с параметром @FormUrlEncoded. Наоборот нельзя, потому что они работают только в паре.
     */

    //    @GET("http://www.mocky.io/v2/59ee79833300008339b5c917")
    @GET(BASE_URL + "rest/v2/all")
    Flowable<List<CountryEntity>> fetchAllCountries();

    // http://www.umori.li/api/get?name=bash&num=50
    @GET("http://www.umori.li/api/")
    Single<Object> getData(@Query("name") String name, @Query("num") int num);

    //users/{user}/repos
    @GET("users/{user}/repos")
    Single<Object> getData1(@Path("user") String userName);

    @Headers({"Cache-Control: max-age=640000", "User-Agent: My-App-Name"})
    @GET("some/endpoint")
    Single<Object> getData2();

    @Multipart
    @POST("some/endpoint")
    Single<Object> uploadImage(@Part("image") RequestBody image, @Part("description") RequestBody description);


    // При использовании пары "имя/значение" в POST-запросах применяется аннотации
    // @FormUrlEncoded и @FieldMap:
    @FormUrlEncoded
    @POST("/some/endpoint")
    Single<Object> someEndpoint(@FieldMap Map<String, String> names);


    //динамические адреса
    @GET
    public Call<File> getZipFile(@Url String url);

}
