package com.androidcafe.task_test;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Reverse_Sentence extends AppCompatActivity {

    TextView parText, result, output;
    EditText inputNo;
    String endingwords, reversewords;

    List<List<String>> mylist;
    List<String> reverselist;
    List<String> list1;
    String test, test2;
    int i;

    List<String> straightlist;
    List<String> backlist;

    List<String> lastlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse__sentence);
        parText = findViewById(R.id.parText);
        result = findViewById(R.id.outputText);
        inputNo = findViewById(R.id.editText);
        output = findViewById(R.id.out);

        Model_Class model = new Model_Class(" Modern humans arrived on the Indian subcontinent from Africa no later than 55,000 years ago.");
        parText.setText(model.paragraph);


    }

    public void getResult(View view) {

        String last_data="";

        if (inputNo.getText().length()>0)
        {
            int size =0;

            try {
                size = Integer.parseInt(inputNo.getText().toString());
            }catch (Exception e)
            {

            }

            String data[] = parText.getText().toString().split(Pattern.quote("."));
            mylist = new ArrayList<>();
            straightlist = new ArrayList<>();
            lastlist = new ArrayList<>();

            for (int i=0;i<data.length;i++)
            {

                String[] s = data[i].split(" ");

                mylist.add(Arrays.asList(s));



            }

            for (List<String> list:mylist)
            {

                straightlist.addAll(list);
            }





            Collections.reverse(straightlist);


            for (int i=0;i<size;i++)
            {
                lastlist.add(straightlist.get(0));

                straightlist.remove(0);

            }

            Collections.reverse(lastlist);
            for (String lst:lastlist)
            {
                last_data = last_data+lst+" ";

            }



            result.setVisibility(View.VISIBLE);
            String str="";

            for (String lastoutput:straightlist)
            {
                str = str+lastoutput+" ";

            }


            result.setText(str+last_data+".");

        }
        else
        {
            inputNo.setError("Please enter number");
        }


    }





}