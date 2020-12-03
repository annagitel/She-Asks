package com.example.sheasks;


import java.util.HashMap;
import java.util.Map;

public class User {
    private   String Email , Password , Admin;

    public User(){}

    public User(String E, String P){
        this.Email=E;
        this.Password=P;
        this.Admin = "0";


    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setAdmin(String admin) {
        Admin = admin;
    }

    public String getAdmin() {
        return Admin;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

}