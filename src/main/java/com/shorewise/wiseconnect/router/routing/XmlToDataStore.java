package com.shorewise.wiseconnect.router.routing;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import com.shorewise.wiseconnect.router.model.ServiceRequest;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component
public class XmlToDataStore extends RouteBuilder {
    
    private static final Logger logger = LogManager.getLogger(XmlToDataStore.class);

    @Override
    public void configure() {
        // Configure REST DSL and Swagger
        restConfiguration()
            .component("servlet")
            .port(8092)
            .host("localhost")
            .bindingMode(RestBindingMode.xml)
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "shorewise wiseconnect router")
            .apiProperty("api.version", "1.0")
            .apiProperty("cors", "true"); // Enable CORS if needed

        // Define REST service with error handling
        onException(Exception.class)
            .handled(true)
            .process(exchange -> {
                Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                logger.error("Error processing XML message", exception);
                exchange.getMessage().setBody("Error processing XML message: " + exception.getMessage());
                exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
            });

        // REST endpoint configuration
        rest("/wiseconnect/xmlToDataStore")
            .post()
            .consumes(MediaType.APPLICATION_XML_VALUE)
            .produces(MediaType.APPLICATION_JSON_VALUE)
            .type(ServiceRequest.class)
            .route()
                .process(exchange -> {
                    // Log incoming message, ensure not to log sensitive data
                    String xmlMessage = exchange.getIn().getBody(String.class);
                    logger.info("Received XML message: {}", xmlMessage);
                })
                .setExchangePattern(ExchangePattern.InOut) // Expecting a response
                .to("bean:dataStoreBeanProcessor")
                .process(exchange -> {
                    // Processed response
                    Object response = exchange.getMessage().getBody();
                    logger.info("XML message processed by DataStoreBeanProcessor, response: {}", response);
                    exchange.getMessage().setBody(response); // Set the response body
                })
            .endRest();
    }
}
