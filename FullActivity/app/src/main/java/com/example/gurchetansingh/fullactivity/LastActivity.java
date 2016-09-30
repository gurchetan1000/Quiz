package com.example.gurchetansingh.fullactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LastActivity extends Activity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        Intent i=getIntent();
        Integer ss=i.getIntExtra("Score", 0);
        sharedpreferences = getSharedPreferences(LoginActivity.MyFILE, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        Integer check=sharedpreferences.getInt("Score",0);
        if(ss>check)
        {
            editor.putInt("Score",ss);
            editor.commit();
        }

        TextView s=(TextView)findViewById(R.id.finalscore);
        s.setText("Your Score : "+ss);
        Button tryagain=(Button)findViewById(R.id.tryagain);
        Button exit=(Button)findViewById(R.id.exit);
        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent();
                ii.setClass(LastActivity.this,GameStart.class);
                startActivity(ii);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
