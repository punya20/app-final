package com.example.truthanddarefinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class edit_questions extends AppCompatActivity {


 Button buttontruth,buttondare,buttontruthsave,buttondaresave;
 LinearLayout Layoyttruth,Layoutdare;

 TextView v;
 EditText q1,q2,q3,q4,q5,q11,q12,q13,q14,q15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_questions);

        buttontruth=(Button)findViewById(R.id.button_truth);
        buttondare=(Button)findViewById(R.id.button_dare);

        Layoyttruth=(LinearLayout)findViewById(R.id.layouttruth);
        Layoutdare=(LinearLayout)findViewById(R.id.layoutdare);
        v=(TextView)findViewById(R.id.textView5);

        Layoyttruth.setVisibility(Layoyttruth.INVISIBLE);
        Layoutdare.setVisibility(Layoutdare.INVISIBLE);




    }
    public void ontruthclick(View view)
    {
        Layoyttruth.setVisibility(Layoyttruth.VISIBLE);
        Layoutdare.setVisibility(Layoutdare.INVISIBLE);

        v.setText("Truth");
        q1=(EditText)findViewById(R.id.q1);
        q2=(EditText)findViewById(R.id.q2);
        q3=(EditText)findViewById(R.id.q3);
        q4=(EditText)findViewById(R.id.q4);
        q5=(EditText)findViewById(R.id.q5);

        buttontruthsave=(Button)findViewById(R.id.buttontruthsave);



        SharedPreferences pre=getSharedPreferences("key1",Context.MODE_PRIVATE);
        String a =pre.getString("0","");
        String b =pre.getString("1","");
        String c =pre.getString("2","");
        String d =pre.getString("3","");
        String e =pre.getString("4","");

        q1.setText(a);
        q2.setText(b);
        q3.setText(c);
        q4.setText(d);
        q5.setText(e);



    }

    public void ondareclick(View View)
    {
        Layoutdare.setVisibility(Layoutdare.VISIBLE);
        Layoyttruth.setVisibility(Layoyttruth.INVISIBLE);

        v.setText("Dare");
        q11=(EditText)findViewById(R.id.q11);
        q12=(EditText)findViewById(R.id.q12);
        q13=(EditText)findViewById(R.id.q13);
        q14=(EditText)findViewById(R.id.q14);
        q15=(EditText)findViewById(R.id.q15);

        buttondaresave=(Button)findViewById(R.id.buttondaresave);

        SharedPreferences pre=getSharedPreferences("key2",Context.MODE_PRIVATE);
        String k =pre.getString("0","");
        String l =pre.getString("1","");
        String m =pre.getString("2","");
        String n =pre.getString("3","");
        String o =pre.getString("4","");

        q11.setText(k);
        q12.setText(l);
        q13.setText(m);
        q14.setText(n);
        q15.setText(o);


    }

    public void ontruthsave(View view)
    {
        SharedPreferences pref =getSharedPreferences("key1", Context.MODE_PRIVATE);
        SharedPreferences.Editor p =pref.edit();
        p.putString("0",q1.getText().toString());
        p.putString("1",q2.getText().toString());
        p.putString("2",q3.getText().toString());
        p.putString("3",q4.getText().toString());
        p.putString("4",q5.getText().toString());

        p.apply();
        Intent inte =new Intent(this,bottlespin.class);
        startActivity(inte);

    }

    public void ondaresave(View view)
    {
        SharedPreferences pref =getSharedPreferences("key2", Context.MODE_PRIVATE);
        SharedPreferences.Editor p =pref.edit();
        p.putString("0",q11.getText().toString());
        p.putString("1",q12.getText().toString());
        p.putString("2",q13.getText().toString());
        p.putString("3",q14.getText().toString());
        p.putString("4",q15.getText().toString());

        p.apply();
        Intent inte =new Intent(this,bottlespin.class);
        startActivity(inte);

    }

}
