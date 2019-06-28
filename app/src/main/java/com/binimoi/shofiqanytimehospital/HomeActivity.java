package com.binimoi.shofiqanytimehospital;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    CardView physiotherapy, nurse, doctor, medicine, email;
    CircleImageView profile;
    TextView name;
    TextView txtclose;
    Dialog mydialog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mydialog = new Dialog(this);

        physiotherapy = findViewById(R.id.physiotherapy);
        nurse = findViewById(R.id.nurse);
        doctor = findViewById(R.id.doctor);
        medicine = findViewById(R.id.medicine);
        profile = findViewById(R.id.profile);
        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemReselectedListener(navLisner);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, PatientProfileActivity.class);
                startActivity(i);
            }
        });


        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Comming Soon Ambulance Service", Toast.LENGTH_LONG).show();
            }
        });

        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Comming Soon Medicine Service", Toast.LENGTH_LONG).show();
            }
        });




        SharedPreferences sharedPreferences = getSharedPreferences("patientDetails", Context.MODE_PRIVATE);

        if (sharedPreferences.contains("patientEmail") && sharedPreferences.contains("patientPassword")){
            String email = sharedPreferences.getString("patientEmail", "do not");
            String password = sharedPreferences.getString("patientPassword", "do not");

            //name.setText(email);
        }


        physiotherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, TherapyActivity.class);
                startActivity(i);
            }
        });

        nurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, NurseActivity.class);
                startActivity(i);
            }
        });

    }


//    working
    public BottomNavigationView.OnNavigationItemReselectedListener navLisner = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case  R.id.home :
                    Intent home = new Intent(HomeActivity.this, HomeActivity.class);
                    startActivity(home);
                    break;

                case  R.id.history :
                    Intent history = new Intent(HomeActivity.this, HistoryActivity.class);
                    startActivity(history);
                    break;

                case  R.id.about :
                    popupshow();
                    break;

                case  R.id.share :
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    String body = "share body";
                    String subj = "share subj";
                    i.putExtra(Intent.EXTRA_SUBJECT,"my new app");
                    String link = "http://anytimehospital.com";
                    i.putExtra(Intent.EXTRA_TEXT, "try id"+ link);
                    startActivity(Intent.createChooser(i,"share using"));

                    break;

            }
        }

    public void popupshow(){

        mydialog.setContentView(R.layout.aboutpopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mydialog.show();
    }

};




//    not working
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case  R.id.home :
//                Intent home = new Intent(HomeActivity.this, HomeActivity.class);
//                startActivity(home);
//
//            case  R.id.history :
//                Intent history = new Intent(HomeActivity.this, HistoryActivity.class);
//                startActivity(history);
//
//            case  R.id.share :
//                Intent s = new Intent(HomeActivity.this, HistoryActivity.class);
//                startActivity(s);
//        }
//    }
}
