package com.binimoi.shofiqanytimehospital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("patient_email")
    @Expose
    private String patient_email;

    @SerializedName("service_name")
    @Expose
    private String service_name;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("date")
    @Expose
    private String date;

    private int isSuccess;
    private String message;

    public void order(int id, String patient_email, String service_name, String price, int status, String data, int isSuccess, String message){
        this.id = id;
        this.patient_email = patient_email;
        this.service_name = service_name;
        this.price = price;
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
