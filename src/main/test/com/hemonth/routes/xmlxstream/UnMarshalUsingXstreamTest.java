package com.hemonth.routes.xmlxstream;

import com.hemonth.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new UnMarshalUsingXstream();
    }

    @Test
    public void unMarshalXStreamTest() throws InterruptedException {
        Employee employee = new Employee();
        employee.setId(1234);
        employee.setName("Hemonth");
        employee.setJoinDate("01/14/2018");

        String xmlInput = "<Employee><id>1234</id><name>hemonth</name><joinDate>01/14/2018</joinDate></Employee>";
        template.sendBody("direct:xmlInput",xmlInput);

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(employee);

        assertMockEndpointsSatisfied();
    }
}
