package com.binimoi.shofiqanytimehospital;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientLoginRegActivity extends AppCompatActivity {

    EditText patient_email, patient_password, patient_name, patient_phone, patient_address;
    ProgressDialog progressDialog;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login_reg);

        progressDialog = new ProgressDialog(this);

        final TextView patient_text = findViewById(R.id.patient_text);
        final Button patient_login_btn = findViewById(R.id.patient_login_btn);
        final TextView patient_reg_link = findViewById(R.id.patient_reg_link);
        final Button patient_reg_btn = findViewById(R.id.patient_reg_btn);

        final EditText patient_name = findViewById(R.id.patient_name);
        final EditText patient_phone = findViewById(R.id.patient_phone);

        final EditText patient_email = findViewById(R.id.patient_email);
        final EditText patient_password = findViewById(R.id.patient_password);
        final EditText patient_address = findViewById(R.id.patient_address);

        patient_name.setVisibility(View.GONE);
        patient_phone.setVisibility(View.GONE);
        patient_reg_btn.setVisibility(View.GONE);
        patient_address.setVisibility(View.GONE);

        patient_reg_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient_login_btn.setVisibility(View.INVISIBLE);
                patient_reg_link.setVisibility(View.INVISIBLE);
                patient_text.setText("Register Patient");

                patient_reg_btn.setVisibility(View.VISIBLE);
                patient_name.setVisibility(View.VISIBLE);
                patient_phone.setVisibility(View.VISIBLE);
                patient_reg_btn.setVisibility(View.VISIBLE);
                patient_address.setVisibility(View.VISIBLE);
                patient_reg_btn.setEnabled(true);
            }
        });


        api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        patient_reg_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(patient_name.getText().toString().equals("")){
                    Toast.makeText(PatientLoginRegActivity.this, "Enter name", Toast.LENGTH_LONG).show();
                }else if(patient_phone.getText().toString().equals("")){
                    Toast.makeText(PatientLoginRegActivity.this, "Enter phone", Toast.LENGTH_LONG).show();
                }else if(patient_address.getText().toString().equals("")){
                    Toast.makeText(PatientLoginRegActivity.this, "Enter Address", Toast.LENGTH_LONG).show();
                }else if(patient_email.getText().toString().equals("")){
                    Toast.makeText(PatientLoginRegActivity.this, "Enter email", Toast.LENGTH_LONG).show();
                }else if(patient_password.getText().toString().equals("")){
                    Toast.makeText(PatientLoginRegActivity.this, "Enter password", Toast.LENGTH_LONG).show();
                }else{
                    signup(patient_name.getText().toString(), patient_phone.getText().toString(), patient_email.getText().toString(),patient_password.getText().toString(),patient_address.getText().toString());
                }


            }
        });


        patient_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(patient_email.getText().toString().equals("")){
                    Toast.makeText(PatientLoginRegActivity.this, "Enter email", Toast.LENGTH_LONG).show();
                }else if(patient_password.getText().toString().equals("")){
                    Toast.makeText(PatientLoginRegActivity.this, "Enter Password", Toast.LENGTH_LONG).show();
                }else{
                    patientlogin(patient_email.getText().toString(), patient_password.getText().toString());
                }

            }
        });

    }


    public void signup(String patient_name, String patient_mobile, String patient_email, String patient_password, String patient_address){

        api.patientsignup(patient_name, patient_mobile,patient_email, patient_password, patient_address).enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                if(response.isSuccessful()) {
                    Intent i = new Intent(PatientLoginRegActivity.this,PatientProfileActivity.class);
                    startActivity(i);
                    Toast.makeText(PatientLoginRegActivity.this, "Register successfully", Toast.LENGTH_LONG).show();

                    //Toast.makeText(PatientLoginRegActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Toast.makeText(PatientLoginRegActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void patientlogin(final String patient_email, final String patient_password){

        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);
        Call<Patient> login = api.patientlogin( patient_email, patient_password);

            login.enqueue(new Callback<Patient>() {
                @Override
                public void onResponse(Call<Patient> call, Response<Patient> response) {
                    if (response.body().getIsSuccess() == 1) {
                        //get username
                        //String email = response.body().getEmail();

                        Toast.makeText(PatientLoginRegActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(PatientLoginRegActivity.this,HomeActivity.class);
                        startActivity(i);

                        SharedPreferences sharedPreferences = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("patientEmail", patient_email);
                        editor.putString("patientPassword", patient_password);
                        editor.commit();


                        //startActivity(new Intent(PatientLoginRegActivity.this,HomeActivity.class));
                    } else if(response.body().getIsSuccess() == 0){
                        Toast.makeText(PatientLoginRegActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }

                }


                @Override
                public void onFailure(Call<Patient> call, Throwable t) {
                    Intent i = new Intent(PatientLoginRegActivity.this,PatientLoginRegActivity.class);
                    startActivity(i);
                    Toast.makeText(PatientLoginRegActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


    }


    public boolean checkvalidate(){

        if(patient_email.getText().toString().equals("")){
            patient_email.setError("email your email");
            return false;
        }else if(patient_password.getText().toString().equals("")){
            patient_password.setError("email your Password");
            return false;
        }else{
            return true;
        }
    }


}
