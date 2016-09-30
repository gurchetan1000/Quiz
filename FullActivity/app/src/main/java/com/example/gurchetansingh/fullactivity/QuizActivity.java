package com.example.gurchetansingh.fullactivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import java.util.List;

public class QuizActivity extends Activity {
    List<Question> datalist;
    Question current;
    Integer no;
    TextView quesno;

    TextView questiontext;
    RadioGroup grp;
    RadioButton selected;
    RadioButton optiona;
    RadioButton optionb;
    RadioButton optionc;
    RadioButton optiond;
    Button next;
    Integer totalscore;
    Integer roundscore = -1;
    TextView scoretext;
    String newname;
    TextView check;
    Button checknext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ActiveAndroid.initialize(this);
        Intent i = getIntent();
        newname = i.getStringExtra("Name");
        Question question = new Question();
        current = new Question();
        quesno = (TextView) findViewById(R.id.qno);
        questiontext = (TextView) findViewById(R.id.ques);

        grp = (RadioGroup) findViewById(R.id.radiogrp);
        optiona = (RadioButton) findViewById(R.id.optiona);
        optionb = (RadioButton) findViewById(R.id.optionb);
        optionc = (RadioButton) findViewById(R.id.optionc);
        optiond = (RadioButton) findViewById(R.id.optiond);
        scoretext = (TextView) findViewById(R.id.scoretext);
        next = (Button) findViewById(R.id.next);

        no = 1;
        totalscore = 0;
        datalist = question.returnall();


        Log.e("Datalistsize", String.valueOf(datalist.size()));
        Log.e("Question1", String.valueOf(datalist.get(no - 1).ques));


        current = datalist.get(no - 1);
        quesno.setText("Q" + no);

        questiontext.setText(current.ques);
        optiona.setText(current.a);
        optionb.setText(current.b);
        optionc.setText(current.c);
        optiond.setText(current.d);
        scoretext.setText("Score: " + totalscore);

//
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = grp.getCheckedRadioButtonId();
                selected = (RadioButton) findViewById(id);
                int pos = (grp.indexOfChild(selected));
                assert selected != null;
                assert selected != null;
                Log.e("Selectedans", pos + "");
                Log.e("Actualans", current.ans + "");
                if (selected == null) {
                    Toast.makeText(QuizActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();
                } else {

                    if (pos == current.ans && roundscore == -1) {
                        roundscore = 1;

                    } else if (pos != current.ans && roundscore == -1) {
                        roundscore = 0;
//
                    }
//


                    totalscore = totalscore + roundscore;
                    roundscore = -1;
                    no++;
                    if (no == 11) {
                        Intent lastintent = new Intent();
                        lastintent.setClass(QuizActivity.this, LastActivity.class);
                        lastintent.putExtra("Score", totalscore);
                        startActivity(lastintent);
                    }
                    current = datalist.get(no - 1);
                    grp.clearCheck();
                    quesno.setText("Q" + no);

                    questiontext.setText(current.ques);
                    optiona.setText(current.a);
                    optionb.setText(current.b);
                    optionc.setText(current.c);
                    optiond.setText(current.d);
                    scoretext.setText("Score: " + totalscore);


                }


            }
        });


    }



}
