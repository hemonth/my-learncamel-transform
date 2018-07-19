package com.hemonth.routes;

import com.hemonth.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamleModifyBeamRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .bean(new CamelBean(),"map1") //default method is map in bean class
                .log("Bean output body is ${body}")
                .to("mock:output");
    }
}
