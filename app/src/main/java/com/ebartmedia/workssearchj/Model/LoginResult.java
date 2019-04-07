package com.ebartmedia.workssearchj.Model;

public class LoginResult {


    private int id;
    private Boolean success;
    private String username;

    public LoginResult(int id, Boolean success, String username) {
        this.id = id;
        this.success = success;
        this.username = username;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getUsername() {
        return username;
    }
}
