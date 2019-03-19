package com.example.card_quiz_castillo15_game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizInstruction extends AppCompatActivity {

    Button qButton;
    TextView tv1,tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_instruction);

        //links the variables to the textviewer and buttons from the xml file
        qButton=(Button)findViewById(R.id.quiz);
        tv1 =(TextView)findViewById(R.id.q1);
        tv2 =(TextView)findViewById(R.id.q2);
        tv3 =(TextView)findViewById(R.id.q3);
        tv4 =(TextView)findViewById(R.id.q4);
        tv5 =(TextView)findViewById(R.id.q5);
    }
    //starts quiz
    public void startquiz(View view) {
        startActivity(new Intent(QuizInstruction.this, Quiz1.class));
    }

    public void getData(View v) {
        //reads stored data
        SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String q1string = sp.getString("QUIZRESULT1", "");
        String q2string = sp.getString("QUIZRESULT2", "");
        String q3string = sp.getString("QUIZRESULT3", "");
        String q4string = sp.getString("QUIZRESULT4", "");
        String q5string = sp.getString("QUIZRESULT5", "");

        //displays the stored data
        tv1.setText(q1string);
        tv2.setText(q2string);
        tv3.setText(q3string);
        tv4.setText(q4string);
        tv5.setText(q5string);
    }
}
