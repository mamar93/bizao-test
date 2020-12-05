package com.bizao.test.service;

import com.bizao.test.dto.request.CheapestQuoteRequestDTO;
import com.bizao.test.dto.response.CheapestQuoteResponseDTO;
import com.bizao.test.dto.response.SkysacannerResponse;
import com.bizao.test.dto.response.TravelpayoutsDataResponse;
import com.bizao.test.utils.JSONUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class QuoteService {

    private static final Logger log = LoggerFactory.getLogger(QuoteService.class);

    public CheapestQuoteResponseDTO getCheapestQuote(CheapestQuoteRequestDTO requestDTO) {

        try {
            //get skyscanner response for cheapest quotes
            String skyscannerJsonResponse = SkyscannerExecutor.execute(requestDTO);
            JSONObject jsonObject = new JSONObject(skyscannerJsonResponse);
            skyscannerJsonResponse = "{ \"Quotes\":" + jsonObject.get("Quotes").toString() + "}";
            SkysacannerResponse skysacannerResponse = JSONUtils.parseJson(skyscannerJsonResponse, SkysacannerResponse.class);

            //get travelpayouts data response for cheapest quote grouped by month
            String travelpayoutsDataJsonResponse = TravelpayoutsDataExecutor.execute(requestDTO);
            jsonObject = new JSONObject(travelpayoutsDataJsonResponse);
            String outbounddate = requestDTO.getOutbounddate();
            String month = outbounddate.substring(0, outbounddate.lastIndexOf("-"));
            jsonObject = new JSONObject(jsonObject.get("data").toString());
            travelpayoutsDataJsonResponse = jsonObject.get(month).toString();
            travelpayoutsDataJsonResponse = "{ \"Quote\":" + jsonObject.get(month).toString() + "}";
            TravelpayoutsDataResponse travelpayoutsDataResponse = JSONUtils.parseJson(travelpayoutsDataJsonResponse, TravelpayoutsDataResponse.class);

            long minPrice = travelpayoutsDataResponse.getQuote().getPrice();

            for(SkysacannerResponse.Quotes quotes : skysacannerResponse.getQuotes())
            {
                if(quotes.getMinPrice() < minPrice)
                {
                    minPrice = quotes.getMinPrice();
                }
            }

            CheapestQuoteResponseDTO cheapestQuoteResponseDTO = new CheapestQuoteResponseDTO(minPrice,requestDTO.getOrigin(), requestDTO.getDestination(), requestDTO.getCurrency() , requestDTO.getOutbounddate());

            return cheapestQuoteResponseDTO;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please review the parameters provided.");
        }

    }

}
