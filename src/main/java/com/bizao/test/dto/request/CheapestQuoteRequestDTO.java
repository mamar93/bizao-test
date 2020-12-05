package com.bizao.test.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CheapestQuoteRequestDTO {
    @NotEmpty(message = "the country must be provided")
    private String country;
    @NotEmpty(message = "the currency must be provided")
    private String currency;
    @NotEmpty(message = "the local must be provided")
    private String local;
    @NotEmpty(message = "the origin must be provided")
    @Size(max = 3, min = 3)
    private String origin;
    @NotEmpty(message = "the destination must be provided")
    @Size(max = 3, min = 3)
    private String destination;
    @NotEmpty(message = "the outbounddate must be provided")
    private String outbounddate;
}
