package com.example.domain.model;

public class Result<T> {

    public enum Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    public final Status status;
    public final T data;
    public final String error;

    private Result(Status status, T data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> Result<T> loading() {
        return new Result<>(Status.LOADING, null, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(Status.SUCCESS, data, null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(Status.ERROR, null, message);
    }
}

