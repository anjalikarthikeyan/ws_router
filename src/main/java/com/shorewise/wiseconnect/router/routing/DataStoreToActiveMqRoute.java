package com.shorewise.wiseconnect.router.routing;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.apache.camel.model.rest.RestBindingMode;

@Component
public class DataStoreToActiveMqRoute extends RouteBuilder {

    @Override
    public void configure() {
    	
    	// Configure REST DSL to use swagger
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "DataStore to ActiveMQ API")
            .apiProperty("api.version", "1.0");

        // REST endpoint to trigger the process
        rest("/wiseconnect")
            .post("/transactions/extract-and-sendTomq")
            .consumes(MediaType.APPLICATION_XML_VALUE)
            .produces(MediaType.APPLICATION_JSON_VALUE)
            .to("direct:readAndSendToActiveMQ");

     // Route to read, process, and send records to ActiveMQ
        from("direct:readAndSendToActiveMQ")
            .routeId("datastore-to-activemq-route")
            .log("Reading 'Received' records from the database")
            // SQL query to fetch 'received' records
            .to("sql:select xml_data from xml_storage.transactional_xml where status = 'Received'")
            .split(body()) // Split for processing multiple rows
                .log("Sending XML record to ActiveMQ")
                .setExchangePattern(ExchangePattern.InOnly)
                .to("activemq:queue:Processed") // Send to ActiveMQ queue
                .log("Record sent to ActiveMQ")
                // Update record status in the database
                .process(exchange -> log.info("Received XML message:", exchange.getIn().getBody(String.class)))           
                .to("sql:update xml_storage.transactional_xml set status = 'Processed'")
                .process(exchange -> log.info("Message forwarded to ActiveMQ queue: Ingress"))
            .end();
    }
               
}
