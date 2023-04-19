package com.andmal;

public class Comment {
    private long id;
    private String body;
    private String date;

    public Comment(){}

    public Comment(long id, String body, String date) {
        this.id = id;
        this.body = body;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
