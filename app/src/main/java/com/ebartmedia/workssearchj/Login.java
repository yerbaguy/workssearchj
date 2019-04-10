package com.ebartmedia.workssearchj;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ebartmedia.workssearchj.Interfaces.Api;
import com.ebartmedia.workssearchj.Model.LoginResult;
import com.ebartmedia.workssearchj.Retrofit.IMyAPI;
import com.ebartmedia.workssearchj.Retrofit.RetrofClient;
import com.ebartmedia.workssearchj.Retrofit.RetrofitClient;
import com.ebartmedia.workssearchj.Retrofit.RetrofittClient;

import java.io.IOException;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    EditText username, password;
    Button login;

    IMyAPI iMyAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

//    IMyAPI iMyAPI;
//    Api api;
//    CompositeDisposable compositeDisposable = new CompositeDisposable();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        login = (Button) findViewById(R.id.buttonLogin);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        Retrofit retrofit = RetrofitClient.getInstance();
        iMyAPI = retrofit.create(IMyAPI.class);

//        Retrofit retrofit = RetrofitClient.getInstance();
//        iMyAPI = retrofit.create(IMyAPI.class);


//        Retrofit retrofit = RetrofClient.getInstance();
//        api = retrofit.create(Api.class);


      //  fetchData();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("Login");


                String usern = username.getText().toString();
                String passwd = password.getText().toString();

                System.out.println("Login - usern" + usern);
                System.out.println("Login - passwd" + passwd);


     //       }
      //  });


                Call<ResponseBody> call = RetrofittClient
                        .getInstance()
                        .getApi()
                        .checkUser(usern, passwd);



                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                        try {
                            String s = response.body().string();

                            fetchData();

                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });



            }
        });





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void fetchData() {

        compositeDisposable.add(iMyAPI.getLoginResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<LoginResult>>() {
                    @Override
                    public void accept(List<LoginResult> loginResults) throws Exception {

                        displayData(loginResults);
                    }
                }));


    }

    private void displayData(List<LoginResult> loginResults) {

        String username = "";
        Boolean success = false;

        Log.d("displayData", "displayData");


        username = loginResults.get(0).getUsername();
        success = loginResults.get(0).getSuccess();

        Log.d("displayData", "displayData" + username);
        Log.d("displayData", "displayData" + success);



    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
