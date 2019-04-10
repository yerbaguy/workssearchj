package com.ebartmedia.workssearchj.Interfaces;

import com.ebartmedia.workssearchj.Model.LoginResult;
import com.ebartmedia.workssearchj.Model.TokenRequest;
import com.ebartmedia.workssearchj.Model.TokenResponse;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("api/create")
    Call<ResponseBody> createUser(

            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password

    );


    @FormUrlEncoded
    @POST("api/tologin")
    Call<ResponseBody> checkUser(

            @Field("username") String username,
            @Field("password") String password

    );



}
