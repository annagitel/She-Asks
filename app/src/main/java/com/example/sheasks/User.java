package com.example.sheasks;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class User {
    private   String Email , Password;
    String Admin;
    ArrayList<String> categories;

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

    public void setAdmin(String admin){
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

    public void addCategory(String category){
        categories.add(category);
    }

    public void removeCategory(String category){
        categories.remove(category);
    }



}