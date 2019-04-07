package com.ebartmedia.workssearchj.Retrofit;

import com.ebartmedia.workssearchj.Model.LoginResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMyAPI {



//    @GET("api/getresult")
//    Observable<List<LoginResult>> getLoginResult();


    @GET("api/getotherresult")
    Observable<List<LoginResult>> getLoginResult();
}
