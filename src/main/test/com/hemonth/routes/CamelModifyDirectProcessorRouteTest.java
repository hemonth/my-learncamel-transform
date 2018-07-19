package com.hemonth.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport{
    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest(){
        String expected = "007:James Bond:Secret Agent";
        String input = "007,James Bond,Secret Agent";
        String output = (String) template.requestBody("direct:sampleInput", input);
        assertEquals(expected,output);
    }

    @Test
    public void processDirectUsingMock() throws InterruptedException {
        String input = "007,James Bond,Secret Agent";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived("007:James Bond:Secret Agent");
        template.sendBody("direct:sampleInput",input);
        assertMockEndpointsSatisfied();
    }

}
