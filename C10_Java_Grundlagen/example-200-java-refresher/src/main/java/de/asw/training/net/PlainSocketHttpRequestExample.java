package de.asw.training.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PlainSocketHttpRequestExample {

    public static void main(String[] args) throws Exception {

        // Open TCP Socket Connection
        try (Socket socket = new Socket("www.example.com", 80)) {

            // Send HTTP Request
            try (PrintStream out = new PrintStream(socket.getOutputStream())) { //
                out.println("GET /index.html HTTP/1.1"); // HTTP Request Line
                out.println("Host: www.example.com"); // HTTP Host Header to select domain
                out.println(); // CR+LF
            } // automatically close PrintStream

            // Read HTTP Response (Status-Line + Header + Body)
            try (Scanner in = new Scanner(socket.getInputStream())) {
                while (in.hasNextLine()) {
                    System.out.println(in.nextLine());
                }
            }
        }
    }
}
