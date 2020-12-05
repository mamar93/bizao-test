package com.bizao.test.service;

import com.bizao.test.dto.request.CheapestQuoteRequestDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class SkyscannerExecutor {

    private final static String BASE_URL = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0";
    private final static String API_KEY = "c606f7b3b4msh14a57d4e99e5c86p1eacd5jsn54ccde703cbf";
    private final static String API_HOST ="skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    public static String execute(CheapestQuoteRequestDTO requestDTO) {
        HttpClient client = HttpClientBuilder.create()
                .disableAutomaticRetries()
                .setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(20 * 1000).build())
                .build();
        try {
            String url = BASE_URL + "/"+requestDTO.getCountry()+"/"+requestDTO.getCurrency()+"/"+requestDTO.getLocal()+"/"+requestDTO.getOrigin()
                    +"/"+requestDTO.getDestination()+"/"+requestDTO.getOutbounddate();
            HttpGet get = new HttpGet(url);
            get.setHeader("Accept", "application/json");
            get.setHeader("x-rapidapi-key", API_KEY);
            get.setHeader("x-rapidapi-host", API_HOST);
            HttpResponse httpResponse = client.execute(get);

            return  EntityUtils.toString(httpResponse.getEntity());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
