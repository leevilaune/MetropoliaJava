package com.leevilaune.notebook.model;

public class Note {

    private String title;
    private String content;
    private static int id;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
        id++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
