package com.bizao.test.dto.response;

import lombok.Data;

@Data
public class CheapestQuoteResponseDTO {
    private long minPrice;
    private String origin;
    private String destination;
    private String currency;
    private String departure_at;

    public CheapestQuoteResponseDTO(long minPrice, String origin, String destination, String currency, String departure_at) {
        this.minPrice = minPrice;
        this.origin = origin;
        this.destination = destination;
        this.currency = currency;
        this.departure_at = departure_at;
    }
}
