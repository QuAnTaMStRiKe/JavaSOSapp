package com.example.javasosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OnClickEmerContacts extends AppCompatActivity {
Button backBtn1, saveBtn1;
Intent i;
String name_1, name_2, name_3, number_1, number_2, number_3;
EditText editText, editText2, editTextTextPersonName, editTextTextPersonName2, editTextTextPersonName3, editTextTextPersonName4 ;
SharedPreferences pref;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_emer_contacts);
        backBtn1 = findViewById(R.id.backBtn1);
        saveBtn1 = findViewById(R.id.saveBtn1);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        backBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(OnClickEmerContacts.this, OnClickUserProfile.class);
                startActivity(i);
            }
        });
        saveBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name_1 = editText.getText().toString();
               number_1 = editText2.getText().toString();
               name_2 = editTextTextPersonName.getText().toString();
               number_2 = editTextTextPersonName2.getText().toString();
               name_3 = editTextTextPersonName3.getText().toString();
               number_3 = editTextTextPersonName4.getText().toString();
               pref = getApplicationContext().getSharedPreferences("myKey", Context.MODE_PRIVATE);
               editor = pref.edit();
               i = new Intent(OnClickEmerContacts.this, Contacts.class);
               editor.putString("Name_1", name_1);
               editor.putString("Number_1", number_1);
               editor.putString("Name_2", name_2);
               editor.putString("Number_2", number_2);
               editor.putString("Name_3", name_3);
               editor.putString("Number_3", number_3);
               editor.apply();
               startActivity(i);
            }
        });
    }
}