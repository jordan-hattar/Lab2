package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    private TextView textView;
    private Button quitButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int score = getIntent().getIntExtra("score", -1);

        textView = findViewById(R.id.scoreView2);
        textView.setText(String.valueOf(score).toString());

        quitButton = findViewById(R.id.quit_Button);
        backButton = findViewById(R.id.back_button);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuitApp(v);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity(view);
            }
        });
    }
        public void QuitApp (View view){
            SummaryActivity.this.finish();
            System.exit(0);
        }
    public void MainActivity(View view){
        Intent intent = new Intent(SummaryActivity.this,MainActivity.class);
        startActivity(intent);
        SummaryActivity.this.finish();
    }
    }
