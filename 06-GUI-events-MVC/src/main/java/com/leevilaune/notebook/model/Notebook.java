package com.leevilaune.notebook.model;

import java.util.ArrayList;

public class Notebook {

    private ArrayList<Note> notes;

    public Notebook(){
        this.notes = new ArrayList<>();
    }
    public void addNote(Note n){
        this.notes.add(n);
    }

    public void removeNote(Note n){
        this.notes.remove(n);
    }
    public Note getNote(String name){
        Note[] note = new Note[1];
        this.notes.stream()
                .filter(n -> n.getTitle().equalsIgnoreCase(name))
                .findFirst().ifPresent(n -> note[0]=n);
        return note[0];
    }
}
