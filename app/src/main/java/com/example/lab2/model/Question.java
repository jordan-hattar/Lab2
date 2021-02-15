package com.example.lab2.model;

public class Question {

    private int id;
    private boolean answerIsTrue;
    private boolean answerIsFalse;


    public Question(int id, boolean isTrue, boolean isFalse){
        this.id = id;
        answerIsTrue = isTrue;
        answerIsFalse = isFalse;
    }

    public int getQuestionId(){
        return id;
    }

    public boolean isQuestionTrue(){
        return answerIsTrue;
    }

    public boolean isQuestionFalse() {
        return answerIsFalse;}


}
