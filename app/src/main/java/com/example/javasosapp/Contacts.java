package com.example.javasosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {
SharedPreferences pref;
String name_1, name_2, name_3, number_1, number_2, number_3;
TextView name1, name2, name3, number1, number2, number3;
Button editData, backBtnContacts;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        name1 = findViewById(R.id.name1);
        number1 = findViewById(R.id.number1);
        name2 = findViewById(R.id.name2);
        number2 = findViewById(R.id.number2);
        name3 = findViewById(R.id.name3);
        number3 = findViewById(R.id.number3);
        editData = findViewById(R.id.editData);
        backBtnContacts = findViewById(R.id.backBtnContacts);

        pref = getSharedPreferences("myKey", Context.MODE_PRIVATE);
        name_1 = pref.getString("Name_1", "");
        number_1 = pref.getString("Number_1", "");
        name_2 = pref.getString("Name_2", "");
        number_2 = pref.getString("Number_2", "");
        name_3 = pref.getString("Name_3", "");
        number_3 = pref.getString("Number_3", "");

        name1.setText(name_1);
        number1.setText(number_1);
        name2.setText(name_2);
        number2.setText(number_2);
        name3.setText(name_3);
        number3.setText(number_3);
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Contacts.this, OnClickEmerContacts.class);
                startActivity(i);
            }
        });

        backBtnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Contacts.this, OnClickUserProfile.class);
                startActivity(i);
            }
        });
    }
}