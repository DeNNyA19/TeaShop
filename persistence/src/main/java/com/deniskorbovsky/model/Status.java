package com.deniskorbovsky.model;


public enum Status {

    NEW("Новый"), WAIT("Ожидание"), PAID("Оплачен");
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
