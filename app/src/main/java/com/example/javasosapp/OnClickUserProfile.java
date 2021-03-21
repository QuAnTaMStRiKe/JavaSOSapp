package com.example.javasosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OnClickUserProfile extends AppCompatActivity {
    Button backBtn1, homeBtn1, eMsg, eContacts ;
    EditText editText;
    String message;
    SharedPreferences pref;
    Intent i;
    TextView name1, number1, editText5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_user_profile);

        backBtn1 = findViewById(R.id.backBtn1);
        homeBtn1 = findViewById(R.id.homeBtn1);
        eMsg = findViewById(R.id.eMsg);
        eContacts = findViewById(R.id.eContacts);
        name1 = findViewById(R.id.name1);
        number1 = findViewById(R.id.number1);
        editText5 = findViewById(R.id.editText5);
        backBtn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(OnClickUserProfile.this, MainActivity.class);
                startActivity(i);
            }
        });


        homeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i =new Intent(OnClickUserProfile.this, MainActivity.class);
                startActivity(i);
            }
        });

        if(editText5 == null){
        eMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(OnClickUserProfile.this, Message.class);
                startActivity(i);
            }
        });
        }

        if(name1 == null && number1 == null){
        eContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(OnClickUserProfile.this, Contacts.class);
                startActivity(i);
            }
        });}
    }
}
