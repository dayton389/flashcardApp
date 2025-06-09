package com.flashcards.Model;

public class Flashcard {
    private int id;
    private String front;
    private String back;

    public Flashcard() {}

    public Flashcard(int id, String front, String back) {
        this.id = id;
        this.front = front;
        this.back = back;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }


    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
