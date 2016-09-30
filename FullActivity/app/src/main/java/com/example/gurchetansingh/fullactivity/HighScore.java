package com.example.gurchetansingh.fullactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HighScore extends Activity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        Intent i=getIntent();
        Integer val=i.getIntExtra("Score", 0);
        TextView score=(TextView)findViewById(R.id.score);
        score.setText(val+"");
    }
}
