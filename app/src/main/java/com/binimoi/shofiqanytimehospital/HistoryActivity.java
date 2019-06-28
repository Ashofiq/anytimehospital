package com.binimoi.shofiqanytimehospital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final TextView name = findViewById(R.id.name);
        //final TextView status = findViewById(R.id.status);

        SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
        String emaill = sharedPreferences_email.getString("patientEmail", "do not");

        //String email = "shofiq@gmail.com";
        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        Call<List<Order>> call = api.getpatientorderhistory(emaill);

        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                List<Order> h = response.body();

                for (Order value: h){
                    String m = "";
                    //String service_name = value.getService_name();
                    //int statu = value.getStatus();
                    //m +=  "name: "+ value.getService_name()+"\n \n \n";
                    //m +=  "name: "+ value.getDate()+"\n";

                    //status.append(value.getStatus()+"\n");
                    int s = value.getStatus();
                    if (s == 0){
                        name.append(value.getService_name()+"\n"+"New order"+"\n"+"---------------------------------"+"\n");
                    }else if(s == 1){
                        name.append(value.getService_name()+"\n"+"Order Processing.."+"\n"+"---------------------------------"+"\n");
                    }else if(s == 2){
                        name.append(value.getService_name()+"\n"+"Order Complete"+"\n"+"---------------------------------"+"\n");
                    }


                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


    public void backarrow(View v){
        Intent i = new Intent(HistoryActivity.this, HomeActivity.class);
        startActivity(i);
    }
}
