package com.example.card_quiz_castillo15_game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz4 extends AppCompatActivity {

    //declare variables
    private static RadioGroup radG;
    private static RadioButton rad_b;
    private static Button but_quiz1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        onClickListenerButton();
    }


    public void onClickListenerButton(){
        radG = (RadioGroup)findViewById(R.id.radioG);
        but_quiz1 =(Button)findViewById(R.id.button_quiz1);

        but_quiz1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        int sel_id = radG.getCheckedRadioButtonId();
                        rad_b = (RadioButton)findViewById(sel_id);

                        //comfirmation UI
                        AlertDialog.Builder alertDlg = new AlertDialog.Builder(Quiz4.this);
                        alertDlg.setMessage("Is "+ rad_b.getText().toString()+" your final answer?");
                        alertDlg.setCancelable(false);

                        alertDlg.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // If the color combo is right
                                String answer = "Black + White";

                                if (rad_b.getText().toString().equals(answer)){

                                    String q1 = "Question 4: Correct ~ "+answer;

                                    Toast.makeText(Quiz4.this,q1,Toast.LENGTH_SHORT).show();

                                    SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("QUIZRESULT4",q1);
                                    editor.commit();

                                    startActivity(new Intent(Quiz4.this, Quiz5.class));

                                }

                                //If the color combo is wrong
                                else{

                                    String q1 = "Question 4: Wrong ~ "+rad_b.getText().toString();
                                    Toast.makeText(Quiz4.this, q1,Toast.LENGTH_SHORT).show();
                                    //Saves user input
                                    SharedPreferences sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("QUIZRESULT4",q1);
                                    editor.commit();
                                    startActivity(new Intent(Quiz4.this, Quiz5.class));



                                }


                            }
                        });
                        //if user clicks no during confirmation UI
                        alertDlg.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Quiz4.this,
                                        "Retry",Toast.LENGTH_SHORT).show();
                            }
                        });
                        //needed to close confirmation UI so it works
                        AlertDialog alert = alertDlg.create();
                        alert.setTitle("Dialog Header");
                        alert.show();


                    }

                }
        );



    }
}


