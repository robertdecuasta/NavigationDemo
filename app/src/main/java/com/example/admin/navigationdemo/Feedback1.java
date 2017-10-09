package com.example.admin.navigationdemo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Feedback1 extends AppCompatActivity {
    EditText editText, editText1;
    RadioGroup radioGroup;
    RadioButton good,verygood,bad,average;
    //    RadioButton radioButton;
    String result;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_feedback);

            editText = (EditText)findViewById(R.id.message);
            editText1 = (EditText) findViewById(R.id.yo);
            radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
            radioGroup.clearCheck();
            imageButton = (ImageButton) findViewById(R.id.ib);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                    good =(RadioButton)radioGroup.findViewById(R.id.good);
                    verygood =(RadioButton)radioGroup.findViewById(R.id.verygood);
                    bad =(RadioButton)radioGroup.findViewById(R.id.bad);
                    average =(RadioButton)radioGroup.findViewById(R.id.average);
                    if (i == R.id.good){

                        result = good.getText().toString();
                    }else if (i== R.id.verygood)
                    {
                        result = verygood.getText().toString();
                    }else if (i== R.id.bad) {
                        result = bad.getText().toString();
                    }
                    else if (i== R.id.average) {
                        result = average.getText().toString();
                    }
                }
            });

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (editText.getText().toString().isEmpty()||editText1.getText().toString().isEmpty())
                        Toast.makeText(getApplicationContext(),"Enter Feedback",Toast.LENGTH_SHORT).show();

                    else {
                    }
                    sendEmail();
                }

            });


        }


    private void sendEmail() {

        String message = editText.getText().toString();
        String[] to ={"zalak.suthar@triforce.co.in"};


        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Feedback Status");
        emailIntent.putExtra(Intent.EXTRA_TEXT,message+result);


        try{
            startActivity(Intent.createChooser(emailIntent,"send mail..."));
            finish();
            Log.i("Finished sending email","");

        }catch (ActivityNotFoundException ex){


        }
    }




}



