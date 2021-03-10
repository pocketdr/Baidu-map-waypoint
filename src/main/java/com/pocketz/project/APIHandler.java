package com.pocketz.project;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class APIHandler {
    
    String uri;

    public void setURI(String uri) {
        this.uri = uri;
    }

    public String sendRequest() throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        
        HttpRequest request = HttpRequest.newBuilder(new URI(uri)).header("User-Agent", "Java HttpClient")
        		.header("Accept", "*/*").timeout(Duration.ofSeconds(5)).version(Version.HTTP_2).build();
		
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        return response.body();
    }
}
