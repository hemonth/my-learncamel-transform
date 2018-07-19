package com.hemonth.process;

import com.hemonth.domain.Employee;
import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class CustomProcessXstream implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        StringTokenizer tonkenizer = new StringTokenizer(body,",");
        Employee employee = new Employee();
        while(tonkenizer.hasMoreElements()){
            employee.setId((Integer) tonkenizer.nextElement());
            employee.setName((String) tonkenizer.nextElement());
            employee.setJoinDate((String) tonkenizer.nextElement());
        }
        exchange.getIn().setBody(employee);
    }
}
