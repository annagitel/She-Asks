package com.example.sheasks;

import java.util.ArrayList;

public class Question {

    private String Key;
    private String Category;
    private String Text;
    private long Date;
    private ArrayList<Answer> answers;
    private String isResolved;
    private String author; //users email

    public Question(String key, String category, String text, long date) {
        Category = category;
        Text = text;
        Date = date;
        isResolved = "0";
        answers = new ArrayList<Answer>();
    }

    public Question() {
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public long getDate() {
        return Date;
    }

    public void setDate(long date) {
        this.Date = date;
    }
}
