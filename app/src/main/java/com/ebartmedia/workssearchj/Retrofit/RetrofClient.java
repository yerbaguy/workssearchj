package com.ebartmedia.workssearchj.Retrofit;

import com.ebartmedia.workssearchj.Interfaces.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofClient {


    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private static RetrofClient mInstance;
    private Retrofit retrofit;

    private RetrofClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized RetrofClient getInstance() {

        if (mInstance == null) {

            mInstance = new RetrofClient();
        }

        return mInstance;
    }

    public Api getApi() {

        return retrofit.create(Api.class);
    }

}
