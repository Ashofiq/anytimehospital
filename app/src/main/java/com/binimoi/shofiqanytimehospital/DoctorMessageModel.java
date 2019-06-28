package com.binimoi.shofiqanytimehospital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorMessageModel {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("message")
    @Expose
    private String message;

    public DoctorMessageModel(String email,String message){
        this.email = email;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
