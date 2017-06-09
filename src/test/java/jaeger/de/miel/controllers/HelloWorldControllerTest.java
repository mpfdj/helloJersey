package jaeger.de.miel.controllers;


import jaeger.de.miel.controllers.HelloWorldController;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class HelloWorldControllerTest {

    private HelloWorldController controller;

    @Test
    public void test() {
        controller = new HelloWorldController();
        Response response = controller.helloWorld();
        assertEquals("HelloWorld!", response.getEntity().toString());
    }
}
