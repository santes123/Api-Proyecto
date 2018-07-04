package com.pumpun.proyectformapiantoniogonzalez.Api_sources.Rest;

/**
 * Created by pumpun5 on 4/10/17.
 */

import com.google.gson.GsonBuilder;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.API_classes.APIGravity;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.API_classes.APIGravity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pumpun5 on 29/9/17.
 */

public class APIClientGravity {

    private APIGravity api;
    public static String BASE_URL = "http://evaluartes.com/gravityformsapi/";
    private static Retrofit retrofit = null;
    private static APIClientGravity restClient;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private APIClientGravity(String baseUrl) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .readTimeout(100, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
                GsonConverterFactory.create(
                        new GsonBuilder()
                                .excludeFieldsWithoutExposeAnnotation()
                                .create()))
                .client(httpClient)
                .build();
        this.BASE_URL = baseUrl;
        api = retrofit.create(APIGravity.class);
    }

    public static APIClientGravity getInstance()  {
        if (restClient == null) {
            restClient = new APIClientGravity("http://evaluartes.com/gravityformsapi/");
        }
        return restClient;
    }

    public APIGravity getApi() {
        return api;
    }

}
