package com.goit.feature;

import com.goit.feature.exception.NotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String URL_PATH = "https://http.cat/";

    public String getStatusImage(int code) throws IOException, InterruptedException, NotFoundException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_PATH + code))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 404) {
            return response.uri().toString();
        } else {
            throw new NotFoundException("There is not image for HTTP status " + code + "!\nEnter HTTP status code:");
        }
    }
}
