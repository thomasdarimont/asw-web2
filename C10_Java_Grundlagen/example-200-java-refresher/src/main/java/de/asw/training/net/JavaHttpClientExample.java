package de.asw.training.net;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaHttpClientExample {

    public static void main(String[] args) throws Exception {

        simpleGetRequestDemo();

        simplePostRequestDemo();
    }

    private static void simplePostRequestDemo() throws Exception {

        System.out.println("#### simplePostRequestDemo");

        var body = HttpRequest.BodyPublishers.ofString("test123");

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .header("Content-type", "text/plain")
                .POST(body)
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var statusCode = response.statusCode();
        System.out.printf("### Status Code: %s%n", statusCode);

        HttpHeaders headers = response.headers();
        System.out.printf("### Response Headers: %s%n", headers);

        System.out.println("### Body:");
        System.out.println(response.body());
    }

    private static void simpleGetRequestDemo() throws Exception {

        System.out.println("#### simpleGetRequestDemo");

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .header("Accept", "text/html")
                .GET()
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var statusCode = response.statusCode();
        System.out.printf("### Status Code: %s%n", statusCode);

        HttpHeaders headers = response.headers();
        System.out.printf("### Response Headers: %s%n", headers);

        System.out.println("### Body:");
        System.out.println(response.body());
    }
}
