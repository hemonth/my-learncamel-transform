package com.hemonth.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        String expectedOutput = "1234:hemonth:java developer\n" +
                "1204:pavan:.NET developer\n";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedOutput);
        Thread.sleep(5000);
        File file = new File("data/input");
        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();
    }

}
