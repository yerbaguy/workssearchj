package com.ebartmedia.workssearchj;

import android.content.ClipData;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.ebartmedia.workssearchj.Model.LoginResult;
import com.ebartmedia.workssearchj.Retrofit.IMyAPI;
import com.ebartmedia.workssearchj.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView textViewLogin, textViewCreateAccount;

    NavigationView navigationView;

    IMyAPI iMyAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Retrofit retrofit = RetrofitClient.getInstance();
        iMyAPI = retrofit.create(IMyAPI.class);

      //  fetchData();



//        textViewLogin = findViewById(R.id.textViewLogin);
        textViewCreateAccount = findViewById(R.id.textViewCreateAccount);


//        View header = navigationView.getHeaderView(0);
//        textViewLogin = (TextView) header.findViewById(R.id.textViewLogin);



//        addword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(getApplicationContext(), AddWord.class);
//
//                startActivity(intent);
//
//            }
//        });



//        textViewLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                System.out.println("Login");
//
//            }
//        });




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
       // Boolean success = false;
        short success;



        Log.d("displayData", "displayData");


        username = loginResults.get(0).getUsername();
        success = loginResults.get(0).getSuccess();

        Log.d("displayData", "displayData" + username);
        Log.d("displayData", "displayData" + success);



    }



//    private void toLogin(View view) {
//
//        textViewLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                System.out.println("login");
//
//            }
//        });
//
//
//    }



//    private void onClickCreateLogin(View v) {
//
//        textViewLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                System.out.println("Login");
//            }
//        });
//    }



    void createAccount(View view) {


        System.out.println("Registration");


        Intent intent = new Intent(getApplicationContext(), Registration.class);

        startActivity(intent);


    }


    void createLogin(View view) {


        System.out.println("Login");


        Intent intent = new Intent(getApplicationContext(), Login.class);

        startActivity(intent);


    }



    @Override
    protected void onStop() {

        compositeDisposable.clear();
        super.onStop();
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.addword) {


                    Intent intent = new Intent(getApplicationContext(), AddWord.class);

                    startActivity(intent);

//            Toast.makeText(this, "Thie is Main Page", Toast.LENGTH_SHORT).show();



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
