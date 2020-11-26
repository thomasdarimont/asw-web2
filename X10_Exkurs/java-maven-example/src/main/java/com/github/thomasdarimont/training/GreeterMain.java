package com.github.thomasdarimont.training;

import com.github.thomasdarimont.training.greeting.Greeter;
import com.github.thomasdarimont.training.greeting.HelloGreeter;

public class GreeterMain {

    public static void main(String[] args) {
        Greeter greeter = new HelloGreeter();

        if (args.length == 0) {
            System.out.println("Please pass a name as first argument.");
            System.exit(-1);
        }

        System.out.println(greeter.greet(args[0]));
    }
}
