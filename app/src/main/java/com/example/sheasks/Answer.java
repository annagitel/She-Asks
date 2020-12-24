package com.example.sheasks;

public class Answer {
    private String data;
    private long date;
    private String author;

    public Answer() {
    }

    public Answer(String data, long date, String author) {
        this.data = data;
        this.date = date;
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
