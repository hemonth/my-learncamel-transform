package com.hemonth.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyFileTransformRouteTest extends CamelTestSupport{

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyFileTransformRoute();
    }

    @Test
    public void testTransformRoute() throws InterruptedException {
        String expected = "007*James Bond*Secret Agent";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:sampleInput","007,James Bond,Secret Agent");
        assertMockEndpointsSatisfied();
    }
}
