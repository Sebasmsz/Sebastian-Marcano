package com.example.Service;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {

    private static final String API_URL =
            "https://api.frankfurter.app/latest?from=EUR&to=USD";

    public double getEuroToUsdRate() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());

            return json.getJSONObject("rates").getDouble("USD");

        } catch (Exception e) {
            System.err.println("Error obteniendo tipo de cambio: " + e.getMessage());
            return 1.0; // fallback seguro
        }
    }
}
