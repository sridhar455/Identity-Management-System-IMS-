package com.example.freecharge.spring.model;

import com.example.freecharge.spring.enumOBJ.Status;

public class ResponseModel {

    Status status;

    public String getStatusmessage() {
        return statusmessage;
    }

    public void setStatusmessage(String statusmessage) {
        this.statusmessage = statusmessage;
    }

    String statusmessage ;
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
