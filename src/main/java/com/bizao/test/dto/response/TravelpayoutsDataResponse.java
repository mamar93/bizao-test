package com.bizao.test.dto.response;

import lombok.Data;

@Data
public class TravelpayoutsDataResponse {

    public Quote Quote;

    @Data
    public static class Quote{
        public String return_at;
        public String expires_at;
        public long price;
        public long transfers;
        public long flight_number;
        public String origin;
        public String destination;
        public String departure_at;
        public String airline;
    }

}
