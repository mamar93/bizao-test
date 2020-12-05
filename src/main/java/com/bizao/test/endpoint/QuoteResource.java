package com.bizao.test.endpoint;


import com.bizao.test.dto.request.CheapestQuoteRequestDTO;
import com.bizao.test.dto.response.CheapestQuoteResponseDTO;
import com.bizao.test.service.QuoteService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/quote")
public class QuoteResource {

    @Autowired
    private QuoteService quoteService;

    @GetMapping(path = "/cheapest")
    @ResponseBody
    @io.swagger.v3.oas.annotations.Operation(summary = "Get the cheapest quote for an origin and a destination and on a specific date by comparing travelpayouts and skyscanner quotes", tags = {"Flight Data"}, responses = {
            @ApiResponse(description = "Get the cheapest quote for an origin and a destination and on a specific date by comparing travelpayouts and skyscanner quotes", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "400", description = "BAD PARAMETERS"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    public ResponseEntity<?> getCheapestQuote(@Valid @BeanParam CheapestQuoteRequestDTO requestDTO) {
        CheapestQuoteResponseDTO cheapestQuoteResponseDTO = quoteService.getCheapestQuote(requestDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("data", cheapestQuoteResponseDTO);
        return ResponseEntity.ok(map);
    }
}
