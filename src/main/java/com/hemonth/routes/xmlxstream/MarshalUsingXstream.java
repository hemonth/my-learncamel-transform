package com.hemonth.routes.xmlxstream;

import com.hemonth.process.CustomProcessXstream;
import org.apache.camel.builder.RouteBuilder;

public class MarshalUsingXstream extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:xmlInput")
                .process(new CustomProcessXstream())
                .marshal().xstream()
                .log("After Marshalling body is ${body}")
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
