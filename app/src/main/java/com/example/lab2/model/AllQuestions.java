package com.example.lab2.model;

import com.example.lab2.R;

public class AllQuestions {

    private int currentQuestion = 0;
    private int questionIndex;

    public Question[] allQuestions = {
            new Question(R.string.math_q,true,false),
            new Question(R.string.math_q1,false,true),
            new Question(R.string.coding_q,true,false),
            new Question(R.string.android_q,false,true),
            new Question(R.string.mac_q,true,false),
            new Question(R.string.cs_q,true,false),
            new Question(R.string.calculus_q,false,true),
            new Question(R.string.linear_q,true,false)

    };

    public AllQuestions(){questionIndex = 0;}

    public Question getQuestion(int index){
        index = index % allQuestions.length;
        return allQuestions[index];
    }


}
