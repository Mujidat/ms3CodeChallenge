package com.ms3.csvFileReader.csvFileReader.model;

public class Response {
    private int totalRecords;
    private int successfulRecords;
    private int failedRecords;

    public Response(int totalRecords, int successfulRecords, int failedRecords) {
        this.totalRecords = totalRecords;
        this.successfulRecords = successfulRecords;
        this.failedRecords = failedRecords;
    }

    @Override
    public String toString() {
        return "Response{" +
                "totalRecords=" + totalRecords +
                ", successfulRecords=" + successfulRecords +
                ", failedRecords=" + failedRecords +
                '}';
    }
}
