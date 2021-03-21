package com.example.javasosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "SMSPermission";
    private final Integer SEND_SMS_CODE = 101;
    private final String TAG2 = "SMSPermission";
    private final Integer  SEND_LOCATION_CODE = 102;
    SharedPreferences pref;
    Button sosBtn, UserBtn;
    Intent i;
    private void setupPermissions() {
        Integer permission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
        );

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to send sms denied");
            makeRequest();
        }
    }
    private void setupLocationPermissions() {
        Integer permission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
        );

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG2, "Permission to send Location denied");
            makeLocationRequest();
        }
    }
    private final void makeRequest() {
        ActivityCompat.requestPermissions((Activity)this,
                new String[]{"android.permission.SEND_SMS"},
                this.SEND_SMS_CODE);
    }
    private final void makeLocationRequest() {
        ActivityCompat.requestPermissions((Activity)this,
                new String[]{"android.permission.ACCESS_FINE_LOCATION"},
                this.SEND_LOCATION_CODE);
    }

    public void onRequestPermissionsResult(
            int requestCode,
            String[] permissions,
            int[] grantResults) {
        if (requestCode == this.SEND_SMS_CODE) {
            if (grantResults.length != 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Log.i(this.TAG, "Permission has been granted by user");
            } else {
                Log.i(this.TAG, "Permission has been denied by user");
            }
        } else if (requestCode == this.SEND_LOCATION_CODE) {
            if (grantResults.length != 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Log.i(this.TAG2, "Permission has been granted by user");
            } else {
                Log.i(this.TAG2, "Permission has been denied by user");
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sosBtn = findViewById(R.id.sosBtn);
        UserBtn = findViewById(R.id.UserBtn);
        pref = getApplicationContext().getSharedPreferences("myKey", Context.MODE_PRIVATE);
        setupPermissions();
        setupLocationPermissions();
        sosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPStracker g = new GPStracker(MainActivity.this.getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    String location_message = "http://maps.google.com/maps?q=$lat,$lon";
                    String number_1 = pref.getString("Number_1", "");
                    String number_2 = pref.getString("Number_2", "");
                    String number_3 = pref.getString("Number_3", "");
                    SmsManager smsManager = SmsManager.getDefault();
                    StringBuffer smsBody = new StringBuffer();
                    smsBody.append(Uri.parse(location_message));
                    SmsManager.getDefault().sendTextMessage(number_1, null, smsBody.toString(), null, null);
                    SmsManager.getDefault().sendTextMessage(number_2, null, smsBody.toString(), null, null);
                    SmsManager.getDefault().sendTextMessage(number_3, null, smsBody.toString(), null, null);
                }
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this.getApplicationContext(), 0, MainActivity.this.getIntent(), 0);
                SmsManager sms = SmsManager.getDefault();
                String number_1 = pref.getString("Number_1", "");
                String number_2 = pref.getString("Number_2", "");
                String number_3 = pref.getString("Number_3", "");
                String message = pref.getString("Message", "");
                sms.sendTextMessage(number_1,null,message,pi,null);
                sms.sendTextMessage(number_2,null,message,pi,null);
                sms.sendTextMessage(number_3,null,message,pi,null);

                Toast.makeText(getApplicationContext(),"Emergency Message Sent", Toast.LENGTH_LONG).show();
            }

        });

        UserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, OnClickUserProfile.class);
                startActivity(i);
            }
        });
    }
}