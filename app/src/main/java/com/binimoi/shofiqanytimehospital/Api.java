package com.binimoi.shofiqanytimehospital;

import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("app/patientsignup.php/")
    @FormUrlEncoded
    Call<Patient> patientsignup(
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("email") String email,
            @Field("password") String password,
            @Field("address") String address);


    // Patient login
    @GET("app/patientlogin.php")
    Call<Patient> patientlogin(
            @Query("email") String email,
            @Query("password") String password);


    // order
    @POST("app/order.php")
    @FormUrlEncoded
    Call<Order> patientorder(
            @Field("patient_email") String email,
            @Field("service_name") String service_name,
            @Field("price") String price);



    // profile
    @GET("app/patientprofile.php")
    Call<Patient> getpatient(@Query("email") String email);


    // history
    @GET("app/patientorderhistory.php")
    Call<List<Order>> getpatientorderhistory(@Query("patient_email") String patient_email);


    // doctor
    @POST("app/doctorsignup.php/")
    @FormUrlEncoded
    Call<Doctor> doctor_signup(
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("email") String email,
            @Field("password") String password,
            @Field("address") String address);


    // Doctor login
    @GET("app/doctorlogin.php")
    Call<Doctor> doctorlogin(
            @Query("email") String email,
            @Query("password") String password);


    // Doctor message
    @GET("app/doctor_message.php")
    Call<DoctorMessageModel> getdoctormessage(
            @Query("email") String email);


}
