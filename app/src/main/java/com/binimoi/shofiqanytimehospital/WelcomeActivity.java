package com.binimoi.shofiqanytimehospital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void docbtn(View v){
        Intent i = new Intent(WelcomeActivity.this, DoctorLoginRegActivity.class);
        startActivity(i);
    }

    public void patientbtn(View v){
        Intent i = new Intent(WelcomeActivity.this, PatientLoginRegActivity.class);
        startActivity(i);
    }


    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
        if (sharedPreferences.getString("patientEmail", null) != null){
            Intent i = new Intent(WelcomeActivity.this, HomeActivity.class);
            startActivity(i);
        }

        SharedPreferences doctorsharedPreferences = getSharedPreferences("doctorDetails", Context.MODE_PRIVATE);
        if (doctorsharedPreferences.getString("doctorEmail", null) != null){
            Intent i = new Intent(WelcomeActivity.this, DoctorDashboardActivity.class);
            startActivity(i);
        }
    }

}
