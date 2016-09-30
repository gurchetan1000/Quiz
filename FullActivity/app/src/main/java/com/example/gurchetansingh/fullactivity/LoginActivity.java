package com.example.gurchetansingh.fullactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity extends Activity {
    public static final String MyFILE = "MyQuiz";
    public static final String Name = "nameKey";
    public static final String Login = "Login";
    public static final String Score = "Score";
    public static final String Database = "Database";
    SharedPreferences sharedpreferences;

    String fullname;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        final EditText first=(EditText)findViewById(R.id.firstname);
        final EditText last=(EditText)findViewById(R.id.lastname);
        Button submit=(Button)findViewById(R.id.submit);
        sharedpreferences=getSharedPreferences(MyFILE, Context.MODE_PRIVATE);
        Boolean val = sharedpreferences.getBoolean(Login, false);
        if(val!=false)
        {
            Intent i=new Intent(getApplicationContext(), HomeScreen.class);
            String val1=sharedpreferences.getString(Name, null);
            i.putExtra("Name", val1);
            startActivity(i);
            finish();
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ff=first.getText().toString();
                String ll=last.getText().toString();
                if(ff.length()==0 && ll.length()==0)
                {
                    Toast.makeText(LoginActivity.this,"Please fill the credentials properly",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Name, ff);
                    editor.putInt(Score, 0);

                    editor.putBoolean(Database,false);
                    editor.putBoolean(Login, true);
                    editor.commit();
                    Intent i = new Intent(LoginActivity.this, HomeScreen.class);
                    i.putExtra("Name", ff);
                    startActivity(i);
                    finish();
                }

            }
        });

    }

}
