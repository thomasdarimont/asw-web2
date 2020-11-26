package com.github.thomasdarimont.training.greeting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreeterTest {

    @Test
    void testHelloGreeter() {

        HelloGreeter greeter = new HelloGreeter();

        String greeting = greeter.greet("World");

        Assertions.assertEquals("Hello World", greeting);
    }
}