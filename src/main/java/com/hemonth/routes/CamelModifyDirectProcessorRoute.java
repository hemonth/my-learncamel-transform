package com.hemonth.routes;

import com.hemonth.process.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .process(new CamelDirectExampleProcessor())
                .log("Received Message Body is ${body} and Headers are ${headers}")
                .to("mock:output")
                .to("file:dataOutput?fileName=output.txt");
    }
}
