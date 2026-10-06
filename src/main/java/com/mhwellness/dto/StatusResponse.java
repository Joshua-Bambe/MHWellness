package com.mhwellness.dto;

public class StatusResponse {
    //Instance Variables based
    // on what was used in the
    // Home controller class
    private String application;
    private String status;
    private int version;
    private boolean databaseConnected;

    //Constructor that will initialize
    // the four attributes of the
    // private instances created
    public StatusResponse(String application, String status,
                          int version, boolean databaseConnected){
        this.application = application;
        this.status = status;
        this.version = version;
        this.databaseConnected = databaseConnected;
    }

    //Getter methods for each of
    // the four attributes in the class

    //Getter method for the attribute application
    public String getApplication(){
        return application;
    }

    //Getter method for the attribute status
    public String getStatus(){
        return status;
    }

    //Getter method for the attribute version
    public int getVersion(){
        return version;
    }

    //Getter method for the attribute databaseConnected
    public boolean isDatabaseConnected(){
        return databaseConnected;
    }
}
