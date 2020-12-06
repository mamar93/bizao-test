package com.bizao.test.utils;

public enum WsMessage {
    WS_SUCCESS(200, 200, "Success"),
    WS_ERROR(400, 205, "BAD REQUEST");
    private int    httpStatus;
    private int    code;
    private String message;
    private String developerMessage;

    WsMessage(int httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    WsMessage(int httpStatus, int code, String message, String developerMessage) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }


}
