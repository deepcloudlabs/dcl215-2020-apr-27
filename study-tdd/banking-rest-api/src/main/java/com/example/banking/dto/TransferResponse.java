package com.example.banking.dto;

public class TransferResponse {
    private String status;

    public TransferResponse() {
    }

    public TransferResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "status='" + status + '\'' +
                '}';
    }
}
