package com.example.lab2.controller;

public class NextQuestion {

    private static int index = 0;

    public int getCurrentQuestion() {
        return index;}

    public int getNextQuestionIndex(){
        index++;
        return index;
    }
}
