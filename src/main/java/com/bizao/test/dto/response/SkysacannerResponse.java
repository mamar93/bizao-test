package com.bizao.test.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class SkysacannerResponse {

    public List<Quotes> Quotes;

    @Data
    public static class Quotes {
        public long QuoteId;
        public long MinPrice;
        public boolean Direct;
        public OutboundLeg OutboundLeg;
        public String QuoteDateTime;

        @Data
        public static class OutboundLeg {
            public List<Long> CarrierIds;
            public long OriginId;
            public long DestinationId;
            public String DepartureDate;
        }
    }
}

