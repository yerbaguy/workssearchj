package com.ebartmedia.workssearchj.Model;

public class LoginResult {


    public int id;
    public Boolean success;
    public String username;

    public LoginResult() {


    }

    public LoginResult(int id, Boolean success, String username) {
        this.id = id;
        this.success = success;
        this.username = username;
    }
}
