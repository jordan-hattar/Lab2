package com.example.lab2.controller;

import com.example.lab2.model.AllQuestions;

public class Score {


    public final int CORRECT_ANSWER = 10;
    public final int SKIP_QUESTION = -5;
    public final int WRONG_ANSWER = -10;

    public int score=0;


    public Score(){score = 0;}

    AllQuestions allQs = new AllQuestions();

    public void correctAnswer() {score +=CORRECT_ANSWER;}

    public void skipQuestion() {score +=SKIP_QUESTION;}

    public void wrongAnswer(){score +=WRONG_ANSWER;}

    public int getScore(){
        return score;
    }

}
