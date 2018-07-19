package com.hemonth.routes.xmltojson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XMLToJSONRouteTest extends CamelTestSupport{

    @Override
    public RouteBuilder createRouteBuilder(){
        return new XMLToJSONRoute();
    }

    @Test
    public void marhsalEmployeeXMLToJSON(){
        String input = "<Employee><id>1234</id><name>hemonth</name><joinDate>01/14/2018</joinDate></Employee>";

        String output = template.requestBody("direct:marshalEmployeeXMLToJSON", input, String.class);
        System.out.println("json output:"+output);
    }
}
