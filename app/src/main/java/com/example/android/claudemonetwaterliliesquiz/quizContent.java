package com.example.android.claudemonetwaterliliesquiz;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quizContent extends AppCompatActivity {

    String answer1String;
    String answer5String;
    Boolean answer2a = false;
    Boolean answer2b = false;
    Boolean answer2c = false;
    Boolean answer3a = false;
    Boolean answer3b = false;
    Boolean answer3c = false;
    Boolean answer4a = false;
    Boolean answer4b = false;
    Boolean answer4c = false;
    Boolean answer6a = false;
    Boolean answer6b = false;
    Boolean answer6c = false;
    Boolean answer7a = false;
    Boolean answer7b = false;
    Boolean answer7c = false;
    int scoreTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_content);
    }
    /**
     * this method checks if the string entered in the EditText box for question 1 matches the correct answer
     * and returns the answer1Score
     */
    private int checkAnswer1 () {
        int answer1Score = 0;
        String correctAnswer1 = getString(R.string.answer_one);
        EditText simpleEditText = findViewById(R.id.answer_01);
        answer1String = simpleEditText.getText().toString();
        /*this code trims the input answer and the correct answer, replaces all spaces with no space, and then ignores case,
        in case someone misspells the answer by putting a space in the wrong place or not capitalizing it correctly */
        if (answer1String.trim().replaceAll("\\s+", "").equalsIgnoreCase(correctAnswer1.trim().replaceAll("\\s+", ""))) {
            answer1Score = 1;
        }
        return answer1Score;
    }
    /**
     * this method checks which of the check boxes are checked for question 2
     * and returns the answer2Score
     */
    private int checkAnswer2 () {
        int answer2Score = 0;
        CheckBox checkBox2a = findViewById(R.id.CheckBox2a);
        CheckBox checkBox2b = findViewById(R.id.CheckBox2b);
        CheckBox checkBox2c = findViewById(R.id.CheckBox2c);
        answer2a = checkBox2a.isChecked();
        answer2b = checkBox2b.isChecked();
        answer2c = checkBox2c.isChecked();
        if (checkBox2a.isChecked() && checkBox2c.isChecked() && (!checkBox2b.isChecked())) {
            answer2Score = 1;
        }
        return answer2Score;
    }
    /**
     * this method checks which of the check boxes are checked for question 3
     * and returns the answer3Score
     */
    private int checkAnswer3() {
        int answer3Score = 0;
        RadioButton radioButton3a = findViewById(R.id.answer3a);
        RadioButton radioButton3b = findViewById(R.id.answer3b);
        RadioButton radioButton3c = findViewById(R.id.answer3c);
        answer3a = radioButton3a.isChecked();
        answer3b = radioButton3b.isChecked();
        answer3c = radioButton3c.isChecked();
        if (radioButton3b.isChecked()) {
            answer3Score = 1;
        }
        return answer3Score;
    }
    /**
     * this method checks which of the check boxes are checked for question 4
     */
    private int checkAnswer4 () {
        int answer4Score = 0;
        CheckBox checkBox4a = findViewById(R.id.CheckBox4a);
        CheckBox checkBox4b = findViewById(R.id.CheckBox4b);
        CheckBox checkBox4c = findViewById(R.id.CheckBox4c);
        answer4a = checkBox4a.isChecked();
        answer4b = checkBox4b.isChecked();
        answer4c = checkBox4c.isChecked();
        if (checkBox4a.isChecked() && checkBox4b.isChecked() && !checkBox4c.isChecked()) {
            answer4Score = 1;
        }
        return answer4Score;
    }
    /**
     * this method checks the text entered in the answer 5 EditText
     */
    private int checkAnswer5 () {
        int answer5Score = 0;
        String correctAnswer5 = getString(R.string.answer_five);
        EditText simpleEditText2 = findViewById(R.id.answer_05);
        answer5String = simpleEditText2.getText().toString();
        /*this code trims the input answer and the correct answer, replaces all spaces with no space, and then ignores case,
        in case someone misspells the answer by putting a space in the wrong place or not capitalizing it correctly */
        if (answer5String.trim().replaceAll("\\s+", "").equalsIgnoreCase(correctAnswer5.trim().replaceAll("\\s+", ""))) {
            answer5Score = 1;
        }
        return answer5Score;
    }
    /**
     * this method checks which of the check boxes are checked for question 4
     */
    private int checkAnswer6 () {
        int answer6Score = 0;
        CheckBox checkBox6a = findViewById(R.id.CheckBox6a);
        CheckBox checkBox6b = findViewById(R.id.CheckBox6b);
        CheckBox checkBox6c = findViewById(R.id.CheckBox6c);
        answer6a = checkBox6a.isChecked();
        answer6b = checkBox6b.isChecked();
        answer6c = checkBox6c.isChecked();
        if (checkBox6a.isChecked() && checkBox6b.isChecked() && checkBox6c.isChecked()) {
            answer6Score = 1;
        }
        return answer6Score;
    }
    /**
     * this method checks radio button question for question 7
     */
    private int checkAnswer7() {
        int answer7Score = 0;
        RadioButton radioButton7a = findViewById(R.id.answer7a);
        RadioButton radioButton7b = findViewById(R.id.answer7b);
        RadioButton radioButton7c = findViewById(R.id.answer7c);
        answer7a = radioButton7a.isChecked();
        answer7b = radioButton7b.isChecked();
        answer7c = radioButton7c.isChecked();
        if (radioButton7a.isChecked()) {
            answer7Score = 1;
        }
        return answer7Score;
    }
    /** Called when the user taps the Submit Your Answers button */
    public void submitAnswers(View view) {
        //CHECK IF ANY OF THE QUESTIONS HAVE STILL NOT BEEN ANSWERED (FUNCTION CHECK NONE ANSWERED checkNoAnswer)
        //IF THEY HAVEN'T THEN RUN missingAnswersMessage
        if (checkNoAnswer()) {
            missingAnswersMessage();
            //OTHERWISE TALLY THE SCORE AND SEND THE ANSWER INFO TO THE NEXT ACTIVITY
        } else {
            scoreTotal = checkAnswer1();
            scoreTotal += checkAnswer2();
            scoreTotal += checkAnswer3();
            scoreTotal += checkAnswer4();
            scoreTotal += checkAnswer5();
            scoreTotal += checkAnswer6();
            scoreTotal += checkAnswer7();
            Intent intent = new Intent(this, quizResults.class);
            intent.putExtra("SCORE_TOTAL", scoreTotal);
            intent.putExtra("ANSWER_1", answer1String);
            intent.putExtra("ANSWER_2A", answer2a);
            intent.putExtra("ANSWER_2B", answer2b);
            intent.putExtra("ANSWER_2C", answer2c);
            intent.putExtra("ANSWER_3A", answer3a);
            intent.putExtra("ANSWER_3B", answer3b);
            intent.putExtra("ANSWER_3C", answer3c);
            intent.putExtra("ANSWER_4A", answer4a);
            intent.putExtra("ANSWER_4B", answer4b);
            intent.putExtra("ANSWER_4C", answer4c);
            intent.putExtra("ANSWER_5", answer5String);
            intent.putExtra("ANSWER_6A", answer6a);
            intent.putExtra("ANSWER_6B", answer6b);
            intent.putExtra("ANSWER_6C", answer6c);
            intent.putExtra("ANSWER_7A", answer7a);
            intent.putExtra("ANSWER_7B", answer7b);
            intent.putExtra("ANSWER_7C", answer7c);
            startActivity(intent);
        }
    }
    // **************************************
    // NOTES - TO WORK OUT - SET THE CODE UP TO CHANGE THE TEXT TO JUST TO METHODS AND PASS IN THE VARIABLE FOR WHICH QUESTION TO CHANGE
    // **************************************
    private boolean checkNoAnswer() {
        // create the boolean variable checkNoAnswer and set it to false
        boolean checkNoAnswer = false;
        // Check if there is no answer for question 1
        EditText simpleEditText = findViewById(R.id.answer_01);
        String answer1String = simpleEditText.getText().toString().trim();
        TextView question1 = findViewById(R.id.question_1);
        if (answer1String.matches("")) {
            checkNoAnswer = true;
            question1.setTextColor(getResources().getColor(R.color.errorColor));
        } else {
            question1.setTextColor(Color.BLACK);
        }
        // Check if there is no answer for question 2
        CheckBox checkBox2a = findViewById(R.id.CheckBox2a);
        CheckBox checkBox2b = findViewById(R.id.CheckBox2b);
        CheckBox checkBox2c = findViewById(R.id.CheckBox2c);
        TextView question2 = findViewById(R.id.question_2);
        if (!checkBox2a.isChecked() && !checkBox2b.isChecked() && !checkBox2c.isChecked()) {
            checkNoAnswer = true;
            question2.setTextColor(getResources().getColor(R.color.errorColor));
        } else {
            question2.setTextColor(Color.BLACK);
        }
        // Check if there is no answer for question 3
        RadioButton radioButton3a = findViewById(R.id.answer3a);
        RadioButton radioButton3b = findViewById(R.id.answer3b);
        RadioButton radioButton3c = findViewById(R.id.answer3c);
        TextView question3 = findViewById(R.id.question_3);
        if (!radioButton3a.isChecked() && !radioButton3b.isChecked() && !radioButton3c.isChecked()) {
            checkNoAnswer = true;
            question3.setTextColor(getResources().getColor(R.color.errorColor));
        } else {
            question3.setTextColor(Color.BLACK);
        }
        // Check if there is no answer for question 4
        CheckBox checkBox4a = findViewById(R.id.CheckBox4a);
        CheckBox checkBox4b = findViewById(R.id.CheckBox4b);
        CheckBox checkBox4c = findViewById(R.id.CheckBox4c);
        TextView question4 = findViewById(R.id.question_4);
        if (!checkBox4a.isChecked() && !checkBox4b.isChecked() && !checkBox4c.isChecked()) {
            checkNoAnswer = true;
            question4.setTextColor(getResources().getColor(R.color.errorColor));
        } else {
            question4.setTextColor(Color.BLACK);
        }
        // Check if there is no answer for question 5
        EditText simpleEditText2 = findViewById(R.id.answer_05);
        String answer5String = simpleEditText2.getText().toString().trim();
        TextView question5 = findViewById(R.id.question_5);
        if (answer5String.matches("")) {
            checkNoAnswer = true;
            question5.setTextColor(getResources().getColor(R.color.errorColor));
        } else {
            question5.setTextColor(Color.BLACK);
        }
        // Check if there is no answer for question 6
        CheckBox checkBox6a = findViewById(R.id.CheckBox6a);
        CheckBox checkBox6b = findViewById(R.id.CheckBox6b);
        CheckBox checkBox6c = findViewById(R.id.CheckBox6c);
        TextView question6 = findViewById(R.id.question_6);
        if (!checkBox6a.isChecked() && !checkBox6b.isChecked() && !checkBox6c.isChecked()) {
            checkNoAnswer = true;
            question6.setTextColor(getResources().getColor(R.color.errorColor));
        } else {
            question6.setTextColor(Color.BLACK);
        }
        // Check if there is no answer for question 7
        RadioButton radioButton7a = findViewById(R.id.answer7a);
        RadioButton radioButton7b = findViewById(R.id.answer7b);
        RadioButton radioButton7c = findViewById(R.id.answer7c);
        TextView question7 = findViewById(R.id.question_7);
        if (!radioButton7a.isChecked() && !radioButton7b.isChecked() && !radioButton7c.isChecked()) {
            checkNoAnswer = true;
            question7.setTextColor(getResources().getColor(R.color.errorColor));
        } else {
            question7.setTextColor(Color.BLACK);
        }
        return checkNoAnswer;
    }

    // **************************************
    // NOTES - TO WORK OUT - SET THE HINT BUTTONS UP SO THAT THEY GET PASSED A VARIABLE RELATING TO THE NUMBER AND THE TEXT CHANGES ACCORDINGLY
    // **************************************

    /** Called when the user taps the Question 1 hint button */
    public void hintQuestion1(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.question_1_hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
        toast.show();
    }
    /** Called when the user taps the Question 2 hint button */
    public void hintQuestion2(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.question_2_hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
        toast.show();
    }
    /** Called when the user taps the Question 3 hint button */
    public void hintQuestion3(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.question_3_hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
        toast.show();
    }
    /** Called when the user taps the Question 4 hint button */
    public void hintQuestion4(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.question_4_hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
        toast.show();
    }
    /** Called when the user taps the Question 5 hint button */
    public void hintQuestion5(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.question_5_hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
        toast.show();
    }
    /** Called when the user taps the Question 6 hint button */
    public void hintQuestion6(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.question_6_hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
        toast.show();
    }
    /** Called when the user taps the Question 7 hint button */
    public void hintQuestion7(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.question_7_hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
        toast.show();
    }
    /** Called when the user taps the Submit Your Answers button and there are questions that have not been answered */
    public void missingAnswersMessage() {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.answer_all_questions), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 0);
            toast.show();
    }
}
