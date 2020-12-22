package com.example.sheasks;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class User {
    private   String Email , Password;
    private String Admin;
    private ArrayList<String> categories;

    public User(){}


    public User(String E, String P){
        this.Email=E;
        this.Password=P;
    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
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