package com.binimoi.shofiqanytimehospital;

public class LoginResponse {

    private static Patient patient;
    private boolean error;
    private String message;

    public LoginResponse(boolean error, String message, Patient patient) {
        this.error = error;
        this.message = message;
        this.patient = patient;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public static Patient getPatient() {
        return patient;
    }
}
