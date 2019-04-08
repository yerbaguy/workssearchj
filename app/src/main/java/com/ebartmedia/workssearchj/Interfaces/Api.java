package com.ebartmedia.workssearchj.Interfaces;

import com.ebartmedia.workssearchj.Model.TokenRequest;
import com.ebartmedia.workssearchj.Model.TokenResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("api/create")
    Call<ResponseBody> createUser(

            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password

    );


}
