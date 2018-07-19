package com.hemonth.routes.xmlxstream;

import com.hemonth.routes.xmlxstream.MarshalUsingXstream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport{

    @Override
    public RouteBuilder createRouteBuilder(){
        return new MarshalUsingXstream();
    }

    @Test
    public void testMarshalUsingXstream(){
        String input = "1234,hemonth,01142018";
        template.sendBody("direct:xmlInput",input);
    }

}
