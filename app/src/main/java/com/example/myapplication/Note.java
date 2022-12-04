package com.example.myapplication;

public class Note {
    private String title;
    private String description;

    public Note() {
        //public default Constructor
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    //over-riding toString()
    public String toString()
    {
        return "Title : "+this.title+"\n"+"Description : "+this.description;
    }
}
