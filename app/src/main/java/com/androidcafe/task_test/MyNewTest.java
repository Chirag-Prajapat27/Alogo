package com.androidcafe.task_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.regex.Pattern;

public class MyNewTest extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_new_test);
        btn = findViewById(R.id.btn);

        Model_Class model = new Model_Class("Hi there. My name is Sam. This is my lucky day. I like coding so much. This is it.");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String line[] = model.toString().split(Pattern.quote("."));

//                line.toString().trim().indexOf(" ");



                for (String str:line) {

                    Log.d("myvalu",""+str.length());
//                    String word[] = str.toString().split(" ");


                }

            }
        });



    }
}