package com.hemonth.process;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//processor process the input data from producer and returns processed data to consumer
public class CamelFileExampleProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        String newString = "";
        System.out.println("pre exchange body is:" + exchange.getIn().getBody());
        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();
        try (BufferedReader br = new BufferedReader(new FileReader(file.getFile()))) {
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                newString = newString.concat(readLine.replaceAll(",", ":").concat("\n"));
            }
            exchange.getIn().setBody(newString);
        }
        System.out.println("post exchange body is:" + exchange.getIn().getBody());
    }
}
