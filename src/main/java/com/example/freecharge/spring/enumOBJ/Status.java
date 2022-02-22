package com.example.freecharge.spring.enumOBJ;

public enum Status {
    REGESTERSUCCESS("IMS-000", "REGESTERSUCCESS"),
    LOGIN("IMS-001", "LOGIN"),
    LOGOUT("IMS-002", "LOGOUT"),
    INVALID("IMS-003", "INVALID"),
    SESSIOSNEXPIRED("IMS-004", "SESSIOSNEXPIRED");
    private String statusCode;
    private String statusMessage;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    Status(String statusCode, String statusMessage)
    {
        this.statusCode=statusCode;
        this.statusMessage=statusMessage;
    }
}


