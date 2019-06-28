package com.binimoi.shofiqanytimehospital;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DoctorLoginRegActivity extends AppCompatActivity {

    EditText doctor_name, doctor_phone, doctor_address, doctor_email, doctor_password;
    ProgressDialog progressDialog;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login_reg);

        final ProgressDialog progressDialog = new ProgressDialog(DoctorLoginRegActivity.this);

        final TextView doctor_text = findViewById(R.id.doctor_text);
        final Button doctor_login_btn = findViewById(R.id.doctor_login_btn);
        final TextView doctor_reg_link = findViewById(R.id.doctor_reg_link);
        final Button doctor_reg_btn = findViewById(R.id.doctor_reg_btn);

        final EditText doctor_name = (EditText) findViewById(R.id.doctor_name);
        final EditText doctor_phone = (EditText) findViewById(R.id.doctor_phone);
        final EditText doctor_email = (EditText) findViewById(R.id.doctor_email);
        final EditText doctor_password = (EditText) findViewById(R.id.doctor_password);
        final EditText doctor_address = (EditText) findViewById(R.id.doctor_address);

        doctor_login_btn.setVisibility(View.VISIBLE);
        doctor_name.setVisibility(View.GONE);
        doctor_phone.setVisibility(View.GONE);
        doctor_address.setVisibility(View.GONE);



        doctor_reg_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctor_login_btn.setVisibility(View.GONE);
                doctor_reg_link.setVisibility(View.GONE);
                doctor_text.setText("Register Doctor");

                doctor_name.setVisibility(View.VISIBLE);
                doctor_phone.setVisibility(View.VISIBLE);
                doctor_address.setVisibility(View.VISIBLE);
            }
        });



        doctor_reg_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(doctor_email.getText().toString().equals("")){
                    Toast.makeText(DoctorLoginRegActivity.this, "Enter email", Toast.LENGTH_LONG).show();
                }else if(doctor_password.getText().toString().equals("")){
                    Toast.makeText(DoctorLoginRegActivity.this, "Enter Password", Toast.LENGTH_LONG).show();
                }else if(doctor_phone.getText().toString().equals("")){
                    Toast.makeText(DoctorLoginRegActivity.this, "Enter Phone", Toast.LENGTH_LONG).show();
                }else if(doctor_address.getText().toString().equals("")){
                    Toast.makeText(DoctorLoginRegActivity.this, "Enter address", Toast.LENGTH_LONG).show();
                }else if(doctor_name.getText().toString().equals("")){
                    Toast.makeText(DoctorLoginRegActivity.this, "Enter Name", Toast.LENGTH_LONG).show();
                }else {
                    progressDialog.setTitle("Processing To Registration");
                    progressDialog.setMessage("Please Wait...");
                    progressDialog.setProgress(100);
                    progressDialog.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            progressDialog.dismiss();

                        }}, 3000);
                    doctor_signup(doctor_name.getText().toString(), doctor_phone.getText().toString(), doctor_email.getText().toString(), doctor_password.getText().toString(), doctor_address.getText().toString());
                }
            }
        });

        doctor_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(doctor_email.getText().toString().equals("")){
                    Toast.makeText(DoctorLoginRegActivity.this, "Enter email", Toast.LENGTH_LONG).show();
                }else if(doctor_password.getText().toString().equals("")){
                    Toast.makeText(DoctorLoginRegActivity.this, "Enter Password", Toast.LENGTH_LONG).show();
                }else {
                    doctorsignin(doctor_email.getText().toString(), doctor_password.getText().toString());
                }
            }
        });

    }


    public void doctor_signup(String doctor_name, String doctor_phone, String doctor_email, String doctor_password, String doctor_address){

        api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        api.doctor_signup(doctor_name, doctor_phone, doctor_email, doctor_password, doctor_address).enqueue(new Callback<Doctor>() {
            @Override
            public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                if(response.isSuccessful()) {

                    Intent i = new Intent(DoctorLoginRegActivity.this, WelcomeActivity.class);
                    startActivity(i);
                    Toast.makeText(DoctorLoginRegActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Doctor> call, Throwable t) {
                Toast.makeText(DoctorLoginRegActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //doctor signin

    public void doctorsignin(final String doctor_email, final String doctor_password){

        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);
        Call<Doctor> login = api.doctorlogin( doctor_email, doctor_password);

        login.enqueue(new Callback<Doctor>() {
            @Override
            public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                if (response.body().getIsSuccess() == 1) {
                    Intent i = new Intent(DoctorLoginRegActivity.this, DoctorDashboardActivity.class);
                    startActivity(i);
                    Toast.makeText(DoctorLoginRegActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                    SharedPreferences sharedPreferences = getSharedPreferences("doctorDetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("doctorEmail", doctor_email);
                    editor.putString("doctorPassword", doctor_password);
                    editor.commit();

                }else{
                    Toast.makeText(DoctorLoginRegActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Doctor> call, Throwable t) {
                Intent i = new Intent(DoctorLoginRegActivity.this,DoctorLoginRegActivity.class);
                startActivity(i);
                Toast.makeText(DoctorLoginRegActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
