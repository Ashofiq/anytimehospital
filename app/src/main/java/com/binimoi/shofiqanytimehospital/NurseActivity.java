package com.binimoi.shofiqanytimehospital;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NurseActivity extends AppCompatActivity {

    TextView service_name1, service_name2, service_name3, service_name4, service_name5, service_name6, service_name7, service_name8;
    TextView price1, price2, price3, price4, price5,price6,price7,price8;
    Button add1, add2, add3,add4, add5, add6, add7, add8, processorder;

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);

        int images[] = {R.drawable.nurse3, R.drawable.nurse2, R.drawable.nurse1};

        v_flipper = findViewById(R.id.v_flipper);


        for (int i = 0; i < images.length; i++ ){
            flipperimages(images[i]);
        }

        price1 = findViewById(R.id.price1);
        price2 = findViewById(R.id.price2);
        price3 = findViewById(R.id.price3);
        price4 = findViewById(R.id.price4);
        price5 = findViewById(R.id.price5);
        price6 = findViewById(R.id.price6);
        price7 = findViewById(R.id.price7);
        price8 = findViewById(R.id.price8);

        service_name1 = findViewById(R.id.service_name1);
        service_name2 = findViewById(R.id.service_name2);
        service_name3 = findViewById(R.id.service_name3);
        service_name4 = findViewById(R.id.service_name4);
        service_name5 = findViewById(R.id.service_name5);
        service_name6 = findViewById(R.id.service_name6);
        service_name7 = findViewById(R.id.service_name7);
        service_name8 = findViewById(R.id.service_name8);

        processorder = findViewById(R.id.processorder);
        add1 = findViewById(R.id.add1);
        add2 = findViewById(R.id.add2);
        add3 = findViewById(R.id.add3);
        add4 = findViewById(R.id.add4);
        add5 = findViewById(R.id.add5);
        add6 = findViewById(R.id.add6);
        add7 = findViewById(R.id.add7);
        add8 = findViewById(R.id.add8);


        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price1.getText().toString();
                String service_name = service_name1.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText("Order -> "+service_name+" "+price);

            }
        });


        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price2.getText().toString();
                String service_name = service_name2.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText(service_name+" "+price);

            }
        });


        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price3.getText().toString();
                String service_name = service_name3.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText(service_name+" "+price);

            }
        });


        add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price4.getText().toString();
                String service_name = service_name4.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText(service_name+" "+price);

            }
        });


        add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price5.getText().toString();
                String service_name = service_name5.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText(service_name+" "+price);

            }
        });

        add6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price6.getText().toString();
                String service_name = service_name6.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText(service_name+" "+price);

            }
        });

        add7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price7.getText().toString();
                String service_name = service_name7.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText(service_name+" "+price);

            }
        });


        add8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add1.setText("Added");

                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);

                String price = price8.getText().toString();
                String service_name = service_name8.getText().toString();
                SharedPreferences sharedPreferences_email = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);
                String patient_email = sharedPreferences_email.getString("patientEmail", "do not");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("patientEmail", patient_email);
                editor.putString("serviceName", service_name);
                editor.putString("price", price);
                editor.commit();

                processorder.setText(service_name+" "+price);

            }
        });



        processorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);
                final ProgressDialog progressDialog = new ProgressDialog(NurseActivity.this);

                if (sharedPreferences.contains("patientEmail") && sharedPreferences.contains("serviceName") && sharedPreferences.contains("price")){
                    String patient_email = sharedPreferences.getString("patientEmail", "");
                    String service_name = sharedPreferences.getString("serviceName", "");
                    String price = sharedPreferences.getString("price", "");

                    if (service_name.equals("") && price.equals("")){
                        Toast.makeText(NurseActivity.this, "Please add Service", Toast.LENGTH_SHORT).show();
                    }else{
                        patientorder(patient_email,service_name,price);


                        progressDialog.setTitle("Processing To Order");
                        progressDialog.setMessage("Please Wait.");
                        progressDialog.setProgress(100);
                        progressDialog.show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                progressDialog.dismiss();
                                Intent i = new Intent(NurseActivity.this, HistoryActivity.class);
                                startActivity(i);
                            }}, 3000);
                    }


                }
            }
        });

    }


    private void patientorder(String patient_email, String service_name, String price) {

        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        api.patientorder( patient_email,  service_name,  price).enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                String n = new Order().getMessage();
                if(response.isSuccessful()) {
                    Toast.makeText(NurseActivity.this, n, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Toast.makeText(NurseActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        boolean editor = getSharedPreferences("patientOrder", Context.MODE_PRIVATE).edit().remove("serviceName").remove("price").commit();
    }

    public void backarrow(View view){
        Intent i = new Intent(NurseActivity.this, HomeActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getGroupId();
        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


    //    image slider
    public void flipperimages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

//        animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

}
