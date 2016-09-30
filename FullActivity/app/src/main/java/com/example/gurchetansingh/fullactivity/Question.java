package com.example.gurchetansingh.fullactivity;

import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gurchetan singh on 20-Aug-16.
 */
@Table(name = "Ques")
public class Question extends Model implements Serializable {

    @Column(name = "ques")
    String ques;
    @Column(name = "ans")
    int ans;
    @Column(name = "a")
    String a;
    @Column(name = "b")
    String b;
    @Column(name = "c")
    String c;
    @Column(name = "d")
    String d;

    public static List<Question> returnall(){
        return new Select().from(Question.class).orderBy("RANDOM()").execute();
    }}
