package com.ebartmedia.workssearchj.Retrofit;

import com.ebartmedia.workssearchj.Model.LoginResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMyAPI {



    @GET("api/getloginresult")
    Observable<List<LoginResult>> getLoginResult();
}
