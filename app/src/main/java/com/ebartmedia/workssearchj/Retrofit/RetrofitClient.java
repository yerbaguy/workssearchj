package com.ebartmedia.workssearchj.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Retrofit ourInstance;

    public static Retrofit getOurInstance() {

        if (ourInstance == null)
            ourInstance = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        return ourInstance;
    }

    private RetrofitClient() {


    }
}
