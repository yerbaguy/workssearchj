package com.ebartmedia.workssearchj.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {


    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {

        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);

    }

    public void storeUserData(LoginResult loginResult) {

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();

        spEditor.putString("username", loginResult.getUsername());
        //  spEditor.putString("email", users.getEmail());
       // spEditor.putShort("success", loginResult.getSuccess());
        spEditor.putInt("success", loginResult.getSuccess());

        spEditor.commit();

    }

    public LoginResult getLoggedInUser() {

//        String username = userLocalDatabase.getString("username", "");
//        String email = userLocalDatabase.getString("email", "");
//        String password = userLocalDatabase.getString("password", "");

        String username = userLocalDatabase.getString("username", "");
     //   Boolean success = userLocalDatabase.getBoolean("success", false);
      //   success = (short) userLocalDatabase.getInt("success", 0);

         int success = userLocalDatabase.getInt("success", 0);



//        Users storedUser = new Users(username, email,password);

        LoginResult storedUser = new LoginResult((short) success, username);

        return storedUser;

    }


    public void setUserLoggedIn(int loggedIn) {

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
      //  spEditor.putBoolean("loggedIn", loggedIn);

        spEditor.putInt("loggedIn", loggedIn);

        spEditor.commit();
    }


    public boolean getUserLoggedIn() {

        if (userLocalDatabase.getBoolean("loggedIn", false) == true) {

            return true;
        } else {

            return false;
        }
    }


    public void clearUserData() {

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
