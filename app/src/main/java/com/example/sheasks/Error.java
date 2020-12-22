package com.example.sheasks;

public class Error {

    private String Page;
    private String Text;
    private long date;
    private String author;
    private String isResolved;

    public Error(String page, String text, long date) {
        Page = page;
        Text = text;
        this.date = date;
    }

    public Error() {
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = page;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
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

    public String getIsResolved() {
        return isResolved;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsResolved(String isResolved) {
        this.isResolved = isResolved;
    }
}
