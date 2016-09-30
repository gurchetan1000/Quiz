package com.example.gurchetansingh.fullactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.LoginManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HomeScreen extends Activity {
    TextView welcome;
    Button b1;
    Button b2;
    Button b3;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        welcome = (TextView) findViewById(R.id.welcome);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        Intent i = getIntent();
        final String name = i.getStringExtra("Name");
        welcome.setText("Welcome " + name);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(HomeScreen.this, GameStart.class);
                i.putExtra("Name", name);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences = getSharedPreferences(LoginActivity.MyFILE, Context.MODE_PRIVATE);
                Integer val = sharedpreferences.getInt("Score", 0);
                Intent i = new Intent();
                i.setClass(HomeScreen.this, HighScore.class);
                i.putExtra("Score", val);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences = getSharedPreferences(LoginActivity.MyFILE, Context.MODE_PRIVATE);
                final SharedPreferences.Editor editor = sharedpreferences.edit();


                editor.clear();
                editor.commit();

                Intent i = new Intent();
                i.setClass(HomeScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }


        });

    }


}
