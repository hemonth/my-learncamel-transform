package com.hemonth.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamleModifyBeamRouteTest extends CamelTestSupport{

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamleModifyBeamRoute();
    }

    @Test
    public void testBeanRoute() throws InterruptedException {
        String expected = "0000* Mr. Bean* sitcom actor";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        String output = (String) template.requestBody("direct:beanInput", "0000, Mr. Bean, sitcom actor");
//        template.sendBody("direct:beanInput","0000, Mr. Bean, sitcom actor");
        assertMockEndpointsSatisfied();

    }
}
