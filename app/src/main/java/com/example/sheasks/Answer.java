package com.example.sheasks;

public class Answer {
    private String data;
    private String date;
    private String author;

    public Answer(String data, String date, String author) {
        this.author = author;
        this.data = data;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getData() {
        return data;
    }

    public String getDate() {
        return date;
    }
}
