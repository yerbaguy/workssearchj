package com.ebartmedia.workssearchj.Model;

public class TokenRequest {


    public int id;

    private String username;

    private String email;

    private String password;


    public TokenRequest(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public void setId(int id) {

        this.id = id;
    }


    public int getId() {

        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
