package com.binimoi.shofiqanytimehospital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Callback;
import retrofit2.Response;

public class PatientProfileActivity extends AppCompatActivity {

    Api api;
    TextView name, email, phone, address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);

        SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
        String emaill = sharedPreferences_email.getString("patientEmail", "do not");

        //String email = "shofiq@gmail.com";
        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        api.getpatient(emaill).enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(retrofit2.Call<Patient> call, Response<Patient> response) {
                name.setText(response.body().getName());
                email.setText(response.body().getEmail());
                phone.setText(response.body().getPhone());
                address.setText(response.body().getAddress());
            }

            @Override
            public void onFailure(retrofit2.Call<Patient> call, Throwable t) {

            }
        });

    }

    public void logout(View v){
        boolean editor = getSharedPreferences("patientDetails", Context.MODE_PRIVATE).edit().remove("patientEmail").commit();
        Toast.makeText(getApplicationContext(), "Logout successfully", Toast.LENGTH_LONG).show();

        Intent i = new Intent(PatientProfileActivity.this, WelcomeActivity.class);
        startActivity(i);

    }

    public void backarrow(View v){
        Intent i = new Intent(PatientProfileActivity.this, HomeActivity.class);
        startActivity(i);
    }
}
