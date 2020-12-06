package com.bizao.test.dto.response;

import com.bizao.test.utils.WsMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BasicResponse {
    private int status = 200;
    @JsonIgnore
    private int httpStatus = 200;
    private String message;
    private Object data;

    public BasicResponse() {
    }

    public BasicResponse(int status) {
        this.status = status;
        if (status >= 1002 && status <= 1006) {
            setMessage("‘Unauthorized’");
            setData(null);
        }
    }
    public BasicResponse(WsMessage wsMessage) {
        this.httpStatus = wsMessage.getHttpStatus();
        this.status = wsMessage.getCode();
        this.message = wsMessage.getMessage();

    }

    public Response response() {

        return new WsHttpResponse<>(this).build();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

}
