package com.ebartmedia.workssearchj.Retrofit;

import com.ebartmedia.workssearchj.Model.LoginResult;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IMyAPI {



//    @GET("api/getresult")
//    Observable<List<LoginResult>> getLoginResult();


    @FormUrlEncoded
    @POST("api/create")
    Call<ResponseBody> checkUser(

            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password

    );


    @GET("api/getotherresult")
    Observable<List<LoginResult>> getLoginResult();

    @GET("api/fromlogout")
    Observable<List<LoginResult>> fromlogoutUser();

}
