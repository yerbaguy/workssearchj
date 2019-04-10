package com.ebartmedia.workssearchj.Retrofit;

import com.ebartmedia.workssearchj.Interfaces.ApiCheck;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofittClient {

    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private static RetrofittClient mInstance;

    private Retrofit retrofit;

    private RetrofittClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized RetrofittClient getInstance() {

        if (mInstance == null) {

            mInstance = new RetrofittClient();
        }

        return mInstance;
    }

    public ApiCheck getApi() {

        return retrofit.create(ApiCheck.class);
    }

}
