package com.example.javasosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OnClickEmerMsg extends AppCompatActivity {
Button saveBtn2, backbtn1;
EditText editText;
String message;
SharedPreferences pref;
SharedPreferences.Editor editor;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_emer_msg);
        saveBtn2 = findViewById(R.id.saveBtn2);
        editText = findViewById(R.id.editText);
        backbtn1 = findViewById(R.id.backBtn1);

        saveBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = editText.getText().toString();
                pref = getApplicationContext().getSharedPreferences("myKey", Context.MODE_PRIVATE);
                editor = pref.edit();
                editor.putString("Message", message);
                editor.apply();
                 i = new Intent(OnClickEmerMsg.this,Message.class);
                startActivity(i);
            }
        });

        backbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 i = new Intent(OnClickEmerMsg.this, OnClickUserProfile.class);
                startActivity(i);
            }
        });
    }
}