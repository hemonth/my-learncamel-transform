package com.hemonth.routes.xmltojson;

import com.hemonth.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class XMLToJSONRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        //marshal xml to json
        from("direct:marshalEmployeeXMLToJSON")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true");

        XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName(Employee.class.getName());

        //unmarshal json to xml route
        from("direct:unMarshalEmployeeJSONToXML")
                .to("log:?level=INFO&showBody=true")
                .unmarshal(xmlJsonDataFormat)
                .to("log:?level=INFO&showBody=true");
    }
}
