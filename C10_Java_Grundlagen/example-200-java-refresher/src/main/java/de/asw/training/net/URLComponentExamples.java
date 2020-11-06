package de.asw.training.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class URLComponentExamples {

    public static void main(String[] args) throws MalformedURLException {
        URI uri = URI.create("https://user:password@www.example.com:8042/over/there?name=ferret&type=animal#nose");

        System.out.println(uri);
        System.out.println("Scheme: " + uri.getScheme());
        System.out.println("Scheme-SpecificPart: " + uri.getSchemeSpecificPart());
        System.out.println("Userinfo: " + uri.getUserInfo());
        System.out.println("Host: " + uri.getHost());
        System.out.println("Authority: " + uri.getAuthority());
        System.out.println("Port: " + uri.getPort());
        System.out.println("Path: " + uri.getPath());
        System.out.println("Query: " + uri.getQuery());
        System.out.println("Fragment: " + uri.getFragment());

        System.out.println("####");

        URL url = uri.toURL();
        // URI in URL umwandeln
        System.out.println("URL " + url);
    }
}
