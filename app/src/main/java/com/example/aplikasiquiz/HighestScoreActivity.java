package com.example.aplikasiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView txtScore = findViewById(R.id.tv_skor_anda);
        TextView txtHightScore = findViewById(R.id.tv_skor_tertinggi);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your Score: " + score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highScore = mypref.getInt("highscore", 0);
        if (highScore >= score){
            txtHightScore.setText("High Score: " + highScore);
        } else {
            txtHightScore.setText("New highscore: " + score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }

    }

    public void onClick(View view) {
        Intent intent = new Intent (HighestScoreActivity.this, QuizActivity_Main.class);
        startActivity(intent);
    }
}