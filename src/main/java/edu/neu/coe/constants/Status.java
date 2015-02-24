package edu.neu.coe.constants;

public enum Status {

    PENDING("P"), ACTIVE("A"), INACTIVE("I");

    private String statusCode;

    private Status(String s) {
        statusCode = s;
    }

    public String getStatusCode() {
        return statusCode;
    }

}