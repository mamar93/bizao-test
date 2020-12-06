package com.bizao.test.dto.response;

import javax.ws.rs.core.Response;

public class WsHttpResponse<T extends BasicResponse> {

    private int status;
    private T entity;

    public WsHttpResponse(int status, T entity) {
        this.status = status;
        this.entity = entity;
    }

    public WsHttpResponse(T entity) {
        this(entity.getHttpStatus(), entity);
    }


    /**
     * Builds the response and enable cors
     *
     * @return
     */
    public Response build() {
        return Response
                .status(status)
                .entity(entity)
                .build();
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
