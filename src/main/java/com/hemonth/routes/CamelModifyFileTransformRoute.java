package com.hemonth.routes;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileTransformRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .transform(body().regexReplaceAll(",","*"))
                .to("mock:output");
    }
}
