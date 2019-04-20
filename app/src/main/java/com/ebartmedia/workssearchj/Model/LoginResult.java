package com.ebartmedia.workssearchj.Model;

public class LoginResult {


    private int id;
  //  private Boolean success;
    private short success;
    private String username;

    public LoginResult(int id, short success, String username) {
        this.id = id;
        this.success = success;
        this.username = username;
    }

    public LoginResult(short success, String username) {
       // this.id = id;
        this.success = success;
        this.username = username;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setSuccess(short success) {
        this.success = success;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public short getSuccess() {
        return success;
    }

    public String getUsername() {
        return username;
    }
}
