package com.example.myapplication;

import com.google.firebase.firestore.Exclude;

public class Note {
    private String title;
    private String description;
    private String documentId;

    public Note() {
        //public default Constructor
    }

    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
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
        return "ID : "+documentId+"\n"+"Title : "+this.title+"\n"+"Description : "+this.description;
    }
}
