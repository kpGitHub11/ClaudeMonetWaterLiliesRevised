package com.example.android.claudemonetwaterliliesquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class quizResults extends AppCompatActivity {

    int scoreQuestion1;
    int scoreQuestion2;
    int scoreQuestion3;
    int scoreQuestion4;
    int scoreQuestion5;
    int scoreQuestion6;
    int scoreQuestion7;
    int finalScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        //GET ALL OF THE ANSWERS THAT WERE PASSED FROM THE QUIZ
        /*  *******************************************************************************
        //SHOULD FIGURE OUT IF THIS CAN BE PROCESSED WITH A FOR LOOP AND AN ARRAY - AND HOW
        ********************************************************************************* */
        String answer1Text = getIntent().getExtras().getString("ANSWER_1");
        TextView answer1 = findViewById(R.id.answer_01);
        answer1.setText(answer1Text);
        boolean question2a = getIntent().getExtras().getBoolean("ANSWER_2A");
        boolean question2b = getIntent().getExtras().getBoolean("ANSWER_2B");
        boolean question2c = getIntent().getExtras().getBoolean("ANSWER_2C");
        boolean question3a = getIntent().getExtras().getBoolean("ANSWER_3A");
        boolean question3b = getIntent().getExtras().getBoolean("ANSWER_3B");
        boolean question3c = getIntent().getExtras().getBoolean("ANSWER_3C");
        boolean question4a = getIntent().getExtras().getBoolean("ANSWER_4A");
        boolean question4b = getIntent().getExtras().getBoolean("ANSWER_4B");
        boolean question4c = getIntent().getExtras().getBoolean("ANSWER_4C");
        String answer5Text = getIntent().getExtras().getString("ANSWER_5");
        TextView answer5 = findViewById(R.id.answer_05);
        answer5.setText(answer5Text);
        boolean question6a = getIntent().getExtras().getBoolean("ANSWER_6A");
        boolean question6b = getIntent().getExtras().getBoolean("ANSWER_6B");
        boolean question6c = getIntent().getExtras().getBoolean("ANSWER_6C");
        boolean question7a = getIntent().getExtras().getBoolean("ANSWER_7A");
        boolean question7b = getIntent().getExtras().getBoolean("ANSWER_7B");
        boolean question7c = getIntent().getExtras().getBoolean("ANSWER_7C");
        /*  *******************************************************************
        //SHOULD FIGURE OUT IF THIS CAN BE PROCESSED WITH A FOR LOOP AND AN ARRAY - AND HOW
        ********************************************************************* */
        if (question2a) {
            CheckBox checkBox2a = findViewById(R.id.CheckBox2a);
            checkBox2a.setChecked(true);
        }
        if (question2b) {
            CheckBox checkBox2b = findViewById(R.id.CheckBox2b);
            checkBox2b.setChecked(true);
        }
        if (question2c) {
            CheckBox checkBox2c = findViewById(R.id.CheckBox2c);
            checkBox2c.setChecked(true);
        }
        if (question3a) {
            RadioButton radioButton3a = findViewById(R.id.answer3a);
            radioButton3a.setChecked(true);
        }
        if (question3b) {
            RadioButton radioButton3b = findViewById(R.id.answer3b);
            radioButton3b.setChecked(true);
        }
        if (question3c) {
            RadioButton radioButton3c = findViewById(R.id.answer3c);
            radioButton3c.setChecked(true);
        }
        if (question4a) {
            CheckBox checkBox4a = findViewById(R.id.CheckBox4a);
            checkBox4a.setChecked(true);
        }
        if (question4b) {
            CheckBox checkBox4b = findViewById(R.id.CheckBox4b);
            checkBox4b.setChecked(true);
        }
        if (question4c) {
            CheckBox checkBox4c = findViewById(R.id.CheckBox4c);
            checkBox4c.setChecked(true);
        }
        if (question6a) {
            CheckBox checkBox6a = findViewById(R.id.CheckBox6a);
            checkBox6a.setChecked(true);
        }
        if (question6b) {
            CheckBox checkBox6b = findViewById(R.id.CheckBox6b);
            checkBox6b.setChecked(true);
        }
        if (question6c) {
            CheckBox checkBox6c = findViewById(R.id.CheckBox6c);
            checkBox6c.setChecked(true);
        }
        if (question7a) {
            RadioButton radioButton7a = findViewById(R.id.answer7a);
            radioButton7a.setChecked(true);
        }
        if (question7b) {
            RadioButton radioButton7b = findViewById(R.id.answer7b);
            radioButton7b.setChecked(true);
        }
        if (question7c) {
            RadioButton radioButton7c = findViewById(R.id.answer7c);
            radioButton7c.setChecked(true);
        }
        /* Check if each answer is correct and if it is set the TextView with question()Correct as the id to "correct"
        // and set the color to the correctColor and set the score for question() to 1
        // If the answer is not correct set the question()Correct text to "incorrect" and set the color to the errorColor
        // and display the correct answer */
        //QUESTION 1
        TextView question1Correct = findViewById(R.id.question_1_correct_text);
        TextView question1CorrectAnswer = findViewById(R.id.question_1_correct_answer);
        question1CorrectAnswer.setVisibility(View.GONE);
        String answer1String = answer1.getText().toString();
        String correctAnswer1 = getString(R.string.answer_one);
        /*this code trims the input answer and the correct answer, replaces all spaces with no space, and then ignores case,
        in case someone misspells the answer by putting a space in the wrong place or not capitalizing it correctly */
        if (answer1String.trim().replaceAll("\\s+", "").equalsIgnoreCase(correctAnswer1.trim().replaceAll("\\s+", ""))) {
            String question1CorrectText = getString(R.string.correctLabel);
            question1Correct.setText(question1CorrectText);
            question1Correct.setTextColor(getResources().getColor(R.color.correctColor));
            scoreQuestion1 = 1;
        } else {
            String question1IncorrectText = getString(R.string.incorrectLabel);
            question1Correct.setText(question1IncorrectText);
            question1Correct.setTextColor(getResources().getColor(R.color.errorColor));
            question1CorrectAnswer.setVisibility(View.VISIBLE);
            String question1CorrectAnswerText = getString(R.string.correctAnswerQuestion1);
            question1CorrectAnswer.setText(question1CorrectAnswerText);
            question1CorrectAnswer.setTextColor(getResources().getColor(R.color.errorColor));
        }
        //QUESTION 2
        TextView question2Correct = findViewById(R.id.question_2_correct_text);
        TextView question2CorrectAnswer = findViewById(R.id.question_2_correct_answer);
        question2CorrectAnswer.setVisibility(View.GONE);
        if (question2a && !question2b && question2c) {
            String question2CorrectText = getString(R.string.correctLabel);
            question2Correct.setText(question2CorrectText);
            question2Correct.setTextColor(getResources().getColor(R.color.correctColor));
            scoreQuestion2 = 1;
        } else {
            String question2IncorrectText = getString(R.string.incorrectLabel);
            question2Correct.setText(question2IncorrectText);
            question2Correct.setTextColor(getResources().getColor(R.color.errorColor));
            question2CorrectAnswer.setVisibility(View.VISIBLE);
            String question2CorrectAnswerText = getString(R.string.correctAnswerQuestion2);
            question2CorrectAnswer.setText(question2CorrectAnswerText);
            question2CorrectAnswer.setTextColor(getResources().getColor(R.color.errorColor));
        }
        //QUESTION 3
        TextView question3Correct = findViewById(R.id.question_3_correct_text);
        TextView question3CorrectAnswer = findViewById(R.id.question_3_correct_answer);
        question3CorrectAnswer.setVisibility(View.GONE);
        if (!question3a && question3b && !question3c) {
            String question3CorrectText = getString(R.string.correctLabel);
            question3Correct.setText(question3CorrectText);
            question3Correct.setTextColor(getResources().getColor(R.color.correctColor));
            scoreQuestion3 = 1;
        } else {
            String question3IncorrectText = getString(R.string.incorrectLabel);
            question3Correct.setText(question3IncorrectText);
            question3Correct.setTextColor(getResources().getColor(R.color.errorColor));
            question3CorrectAnswer.setVisibility(View.VISIBLE);
            String question3CorrectAnswerText = getString(R.string.correctAnswerQuestion3);
            question3CorrectAnswer.setText(question3CorrectAnswerText);
            question3CorrectAnswer.setTextColor(getResources().getColor(R.color.errorColor));
        }
        //QUESTION 4
        TextView question4Correct = findViewById(R.id.question_4_correct_text);
        TextView question4CorrectAnswer = findViewById(R.id.question_4_correct_answer);
        question4CorrectAnswer.setVisibility(View.GONE);
        if (question4a && question4b && !question4c) {
            String question4CorrectText = getString(R.string.correctLabel);
            question4Correct.setText(question4CorrectText);
            question4Correct.setTextColor(getResources().getColor(R.color.correctColor));
            scoreQuestion4 = 1;
        } else {
            String question4IncorrectText = getString(R.string.incorrectLabel);
            question4Correct.setText(question4IncorrectText);
            question4Correct.setTextColor(getResources().getColor(R.color.errorColor));
            question4CorrectAnswer.setVisibility(View.VISIBLE);
            String question4CorrectAnswerText = getString(R.string.correctAnswerQuestion4);
            question4CorrectAnswer.setText(question4CorrectAnswerText);
            question4CorrectAnswer.setTextColor(getResources().getColor(R.color.errorColor));
        }
        //QUESTION 5
        TextView question5Correct = findViewById(R.id.question_5_correct_text);
        TextView question5CorrectAnswer = findViewById(R.id.question_5_correct_answer);
        question5CorrectAnswer.setVisibility(View.GONE);
        String answer5String = answer5.getText().toString();
        String correctAnswer5 = getString(R.string.answer_five);
        /*this code trims the input answer and the correct answer, replaces all spaces with no space, and then ignores case,
        in case someone misspells the answer by putting a space in the wrong place or not capitalizing it correctly */
        if (answer5String.trim().replaceAll("\\s+", "").equalsIgnoreCase(correctAnswer5.trim().replaceAll("\\s+", ""))) {
            String question5CorrectText = getString(R.string.correctLabel);
            question5Correct.setText(question5CorrectText);
            question5Correct.setTextColor(getResources().getColor(R.color.correctColor));
            scoreQuestion5 = 1;
        } else {
            String question5IncorrectText = getString(R.string.incorrectLabel);
            question5Correct.setText(question5IncorrectText);
            question5Correct.setTextColor(getResources().getColor(R.color.errorColor));
            question5CorrectAnswer.setVisibility(View.VISIBLE);
            String question5CorrectAnswerText = getString(R.string.correctAnswerQuestion5);
            question5CorrectAnswer.setText(question5CorrectAnswerText);
            question5CorrectAnswer.setTextColor(getResources().getColor(R.color.errorColor));
        }
        //QUESTION 6
        TextView question6Correct = findViewById(R.id.question_6_correct_text);
        TextView question6CorrectAnswer = findViewById(R.id.question_6_correct_answer);
        question6CorrectAnswer.setVisibility(View.GONE);
        if (question6a && question6b && question6c) {
            String question6CorrectText = getString(R.string.correctLabel);
            question6Correct.setText(question6CorrectText);
            question6Correct.setTextColor(getResources().getColor(R.color.correctColor));
            scoreQuestion6 = 1;
        } else {
            String question6IncorrectText = getString(R.string.incorrectLabel);
            question6Correct.setText(question6IncorrectText);
            question6Correct.setTextColor(getResources().getColor(R.color.errorColor));
            question6CorrectAnswer.setVisibility(View.VISIBLE);
            String question6CorrectAnswerText = getString(R.string.correctAnswerQuestion6);
            question6CorrectAnswer.setText(question6CorrectAnswerText);
            question6CorrectAnswer.setTextColor(getResources().getColor(R.color.errorColor));
        }
        //QUESTION 7
        TextView question7Correct = findViewById(R.id.question_7_correct_text);
        TextView question7CorrectAnswer = findViewById(R.id.question_7_correct_answer);
        question7CorrectAnswer.setVisibility(View.GONE);
        /* Check if Answer 7 is correct and if it is set the TextView with question7Correct as the id to "correct"
        // and set the color to the correctColor and set the score for question7 to 1
        // If the answer is not correct set the question7Correct text to "incorrect" and set the color to the errorColor
        // and display the correct answer */
        if (question7a && !question7b && !question7c) {
            String question7CorrectText = getString(R.string.correctLabel);
            question7Correct.setText(question7CorrectText);
            question7Correct.setTextColor(getResources().getColor(R.color.correctColor));
            scoreQuestion7 = 1;
        } else {
            String question7IncorrectText = getString(R.string.incorrectLabel);
            question7Correct.setText(question7IncorrectText);
            question7Correct.setTextColor(getResources().getColor(R.color.errorColor));
            question7CorrectAnswer.setVisibility(View.VISIBLE);
            String question7CorrectAnswerText = getString(R.string.correctAnswerQuestion7);
            question7CorrectAnswer.setText(question7CorrectAnswerText);
            ResourcesCompat.getColor(getResources(), R.color.errorColor, null);
            question7CorrectAnswer.setTextColor(getResources().getColor(R.color.errorColor));
        }
        //TALLY UP THE SCORE FOR EACH QUESTION AND SAVE INTO finalScore
        finalScore = scoreQuestion1;
        finalScore += scoreQuestion2;
        finalScore += scoreQuestion3;
        finalScore += scoreQuestion4;
        finalScore += scoreQuestion5;
        finalScore += scoreQuestion6;
        finalScore += scoreQuestion7;
        // Capture the layout's TextView with the ID finalScoreText and set the string completedScore as its text
        TextView scoreResults = findViewById(R.id.finalScoreText);
        String completedScore = "Your score is " + finalScore + "/7";
        scoreResults.setText(completedScore);
    }
    //
    //EVENTUALLY CHANGE THE URL STRING BELOW TO REFLECT THE FRENCH VERSION OF THE SITE IF THE LANGUAGE IS FRENCH
    /** Called when the user taps the Learn More Online button */
        public void learnMoreOnline(View view) {
            Intent learnMoreOnline = new Intent(android.content.Intent.ACTION_VIEW);
            learnMoreOnline.setData(Uri.parse(getString(R.string.musee_orangerie_website)));
            startActivity(learnMoreOnline);
        }
}
