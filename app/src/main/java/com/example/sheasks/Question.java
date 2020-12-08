package com.example.sheasks;

public class Question {

    private String Key;
    private String Category;
    private String Text;
    private long Date;

    public Question(String key, String category, String text, long date) {
        Category = category;
        Text = text;
        Date = date;
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
