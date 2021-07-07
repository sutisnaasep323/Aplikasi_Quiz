package com.example.aplikasiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity_Main extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView; // untuk menampilkan skor saat ini
    private TextView mQuestionView; // untuk menampilkan jawaban
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer; // untuk mengecek jawabannya benar atau tidak
    private int mScore = 0; // current total score
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.tv_question);
        mButtonChoice1 = findViewById(R.id.btn_opsi1);
        mButtonChoice2 = findViewById(R.id.btn_opsi2);
        mButtonChoice3 = findViewById(R.id.btn_opsi3);
        mButtonChoice4 = findViewById(R.id.btn_opsi4);
        updateQuestion();

        updateScore(mScore);
    }

    public void updateQuestion(){
        if (mQuestionNumber < mQuestionLibrary.getLength()){
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(QuizActivity_Main.this, "it was the last question!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity_Main.this, HighestScoreActivity.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    public void updateScore(int point){
        mScoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength());
    }

    public void onClick(View view){
        Button answer = (Button) view;

        if (answer.getText() == mAnswer){
            mScore = mScore + 1;
            Toast.makeText(QuizActivity_Main.this, "Benar", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(QuizActivity_Main.this, "Salah", Toast.LENGTH_SHORT).show();
        }

        updateScore(mScore);
        updateQuestion();
    }

}