package com.example.truthanddarefinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
// made by punya sharma
// this file contains code for bottle animation and switching activities

public class bottlespin extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private Random random = new Random();
    private float lastDirection;
    public static String key; // for saved preferences
    TextView question;  // where we see the truth/dare

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottlespin);

        button = findViewById(R.id.buttonspin);
        imageView = findViewById(R.id.imageViewbottle);
        question = (TextView) findViewById(R.id.Questionview);

    }

    public void spinbottle(View v)
    {
        float newDirection = random.nextInt(3600);
        float pivoitX = imageView.getWidth()/2;
        float pivoitY = imageView.getHeight()/2;
        if (Math.abs(lastDirection - newDirection) < 360)
        {
            newDirection = lastDirection + newDirection + 360;
        }
        Animation rotate = new RotateAnimation(lastDirection,  newDirection, pivoitX, pivoitY);

        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection = newDirection;
        imageView.startAnimation(rotate);


    }

    public void truthclick(View v) {

        Random r = new Random();
        int randomNumber = r.nextInt(5);
        SharedPreferences pre=getSharedPreferences("key1", Context.MODE_PRIVATE);
        String q =pre.getString(String.valueOf(randomNumber),"");
        question.setText(q);

    }
    public void dareclick(View v)
    {
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        SharedPreferences pre=getSharedPreferences("key2", Context.MODE_PRIVATE);
        String q =pre.getString(String.valueOf(randomNumber),"");
        question.setText(q);
    }

    public void editQuestions(View v)
    {
        Intent intent= new Intent(this,edit_questions.class);
        startActivity(intent);
    }

    public void clearq(View v){
        question.setText("");
    }
}

