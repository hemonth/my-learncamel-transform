package com.hemonth.routes;

import com.hemonth.process.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .process(new CamelFileExampleProcessor())
                .log("Received MessageBody is ${body} and Headers are ${headers}")
                .to("file:data/output")
                .to("mock:output");
    }
}
