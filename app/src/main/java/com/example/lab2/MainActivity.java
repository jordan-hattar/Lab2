package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;

import com.example.lab2.controller.NextQuestion;
import com.example.lab2.controller.Score;
import com.example.lab2.model.AllQuestions;
import com.example.lab2.model.Question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_INDEX = "GAME_MAIN_ACTIVITY";

    private TextView questionView;
    private TextView scoreView;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button quitButton;

    AllQuestions allQuestions = new AllQuestions();
    NextQuestion nextQuestion = new NextQuestion();
    Score score = new Score();

    private final String N_TAG = "IN_ONCLICK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView questionView = findViewById(R.id.questionView);
        TextView scoreView = findViewById(R.id.scoreView);
        questionView.setText(R.string.q_start);
        scoreView.setText(R.string.initial_score);


        Button true_button = findViewById(R.id.t_button);
        Button false_button = findViewById(R.id.f_button);
        Button next_button = findViewById(R.id.next_button);
        Button summaryButton = findViewById(R.id.summaryButton);

// couldn't figure out the bug where the true/false/next buttons don't always count the score correctly
        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = nextQuestion.getCurrentQuestion();
                Question question = null;
                try {
                    question = allQuestions.getQuestion(index);
                } catch (Exception e) {
                    Log.d(TAG_INDEX, "index out of bounds");
                }

                if (question.isQuestionTrue()) {
                    score.correctAnswer();
                    scoreView.setText(String.valueOf(score.getScore()));
                    index = allQuestions.getQuestion(index).getQuestionId();
                }
                if(question.isQuestionFalse()) {
                    score.wrongAnswer();
                    scoreView.setText((String.valueOf(score.getScore())));
                    index = allQuestions.getQuestion(index).getQuestionId();
                }

                questionView.setText(allQuestions.getQuestion(index).getQuestionId());
            }
        });

        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int index = nextQuestion.getCurrentQuestion();
            Question question = null;
            try {
                question = allQuestions.getQuestion(index);
            } catch (Exception e) {
                Log.d(TAG_INDEX, "index out of bounds");
            }

            if (question.isQuestionFalse()) {
                score.correctAnswer();
                scoreView.setText(String.valueOf(score.getScore()));
                index = nextQuestion.getNextQuestionIndex();
            }
            if (question.isQuestionTrue()) {
                score.wrongAnswer();
                scoreView.setText(String.valueOf(score.getScore()));
                index = nextQuestion.getNextQuestionIndex();
            }


            questionView.setText(allQuestions.getQuestion(index).getQuestionId());
        }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = nextQuestion.getCurrentQuestion();
                Question question = null;
                try {
                    question = allQuestions.getQuestion(index);
                } catch (Exception e) {
                    Log.d(TAG_INDEX, "index out of bounds");
                }

                score.skipQuestion();

                scoreView.setText(String.valueOf(score.getScore()));
                index = nextQuestion.getNextQuestionIndex();

                questionView.setText(allQuestions.getQuestion(index).getQuestionId());
            }
        });

        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SummaryActivity(view);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void SummaryActivity(View view){
        Intent intent = new Intent(MainActivity.this,SummaryActivity.class);
        intent.putExtra("score",score.getScore());
    }


}