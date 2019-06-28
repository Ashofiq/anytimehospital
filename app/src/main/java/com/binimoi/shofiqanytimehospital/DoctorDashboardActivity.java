package com.binimoi.shofiqanytimehospital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.isEmpty;

public class DoctorDashboardActivity extends AppCompatActivity {


    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);

        message = (TextView) findViewById(R.id.message);

        SharedPreferences sharedPreferences_email = getSharedPreferences("doctorDetails", Context.MODE_PRIVATE);
        final String emaill = sharedPreferences_email.getString("doctorEmail", "do not");

        //String email = "shofiq@gmail.com";
        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        api.getdoctormessage(emaill).enqueue(new Callback<DoctorMessageModel>() {
            @Override
            public void onResponse(Call<DoctorMessageModel> call, Response<DoctorMessageModel> response) {

               message.setText(response.body().getMessage());

            }

            @Override
            public void onFailure(Call<DoctorMessageModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    public void logout(View v){
        boolean editor = getSharedPreferences("doctorDetails", Context.MODE_PRIVATE).edit().remove("doctorEmail").commit();
        Toast.makeText(getApplicationContext(), "Logout successfully", Toast.LENGTH_LONG).show();

        Intent i = new Intent(DoctorDashboardActivity.this, WelcomeActivity.class);
        startActivity(i);

    }
}
