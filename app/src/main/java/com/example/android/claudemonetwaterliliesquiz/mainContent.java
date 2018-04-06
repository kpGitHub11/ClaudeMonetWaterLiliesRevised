package com.example.android.claudemonetwaterliliesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);
    }

    /** Called when the user taps the TEST YOUR KNOWLEDGE button */
    public void takeQuiz(View view) {
        Intent intent = new Intent(this, quizContent.class);
        startActivity(intent);
    }
}
