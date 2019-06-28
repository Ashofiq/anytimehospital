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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class TherapyActivity extends AppCompatActivity {

    ImageView back_arrow;
    TextView moreinfo, price1,price2, price3, price4,price5, service_name1, service_name2, service_name3, service_name4, service_name5;
    Button processorder, add1, add2,add3,add4,add5;

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapy);

        int images[] = {R.drawable.therapy1, R.drawable.therapy2, R.drawable.therapy3};

        v_flipper = findViewById(R.id.v_flipper);


        for (int i = 0; i < images.length; i++ ){
            flipperimages(images[i]);
        }



        // order button invisible
        //processorder.setVisibility(View.INVISIBLE);

        price1 = findViewById(R.id.price1);
        price2 = findViewById(R.id.price2);
        price3 = findViewById(R.id.price3);
        price4 = findViewById(R.id.price4);
        price5 = findViewById(R.id.price5);

        service_name1 = findViewById(R.id.service_name1);
        service_name2 = findViewById(R.id.service_name2);
        service_name3 = findViewById(R.id.service_name3);
        service_name4 = findViewById(R.id.service_name4);
        service_name5 = findViewById(R.id.service_name5);

        processorder = findViewById(R.id.processorder);
        add1 = findViewById(R.id.add1);
        add2 = findViewById(R.id.add2);
        add3 = findViewById(R.id.add3);
        add4 = findViewById(R.id.add4);
        add5 = findViewById(R.id.add5);


//        ImageView back_arrow = (ImageView) findViewById(R.id.back_arrow);
//        back_arrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(TherapyActivity.this, HomeActivity.class);
//                startActivity(i);
//            }
//        });




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

                processorder.setText(service_name+" "+price);

            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processorder.setVisibility(View.VISIBLE);
                add2.setText("Added");
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
                add3.setText("Added");
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
                add4.setText("Added");
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
                add5.setText("Added");
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



        processorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("patientOrder", Context.MODE_PRIVATE);
                final ProgressDialog progressDialog = new ProgressDialog(TherapyActivity.this);

                if (sharedPreferences.contains("patientEmail") && sharedPreferences.contains("serviceName") && sharedPreferences.contains("price")){
                    String patient_email = sharedPreferences.getString("patientEmail", "");
                    String service_name = sharedPreferences.getString("serviceName", "");
                    String price = sharedPreferences.getString("price", "");



                    if (service_name.equals("") && price.equals("")){
                        Toast.makeText(TherapyActivity.this, "Please add Service", Toast.LENGTH_SHORT).show();
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
                                Intent i = new Intent(TherapyActivity.this, HistoryActivity.class);
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
                    Toast.makeText(TherapyActivity.this, n, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Toast.makeText(TherapyActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        boolean editor = getSharedPreferences("patientOrder", Context.MODE_PRIVATE).edit().remove("serviceName").remove("price").commit();
    }


    public void backarrow(View view){
       Intent i = new Intent(TherapyActivity.this, HomeActivity.class);
       startActivity(i);
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
