package com.example.javasosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Message extends AppCompatActivity {
SharedPreferences pref;
TextView editText5;
Button backBtnMessage, editData;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText5 = findViewById(R.id.editText5);
        backBtnMessage = findViewById(R.id.backBtnMessage);
        editData = findViewById(R.id.editData);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        pref = getSharedPreferences("myKey", Context.MODE_PRIVATE);
        String message = pref.getString("Message","");
        editText5.setText(message);
        backBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               i = new Intent(Message.this, OnClickUserProfile.class);
               startActivity(i);
            }
        });
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}