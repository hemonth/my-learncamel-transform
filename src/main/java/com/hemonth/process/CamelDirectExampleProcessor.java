package com.hemonth.process;

import org.apache.camel.Exchange;

public class CamelDirectExampleProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String inputBody = (String)exchange.getIn().getBody();
        String outputBody = inputBody.replaceAll(",",":");
        exchange.getIn().setBody(outputBody);
    }
}
