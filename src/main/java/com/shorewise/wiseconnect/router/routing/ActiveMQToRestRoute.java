package com.shorewise.wiseconnect.router.routing;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQToRestRoute extends RouteBuilder {
    
    private static final Logger logger = LogManager.getLogger(ActiveMQToRestRoute.class);

    @Override
    public void configure() {
        // REST configuration
        restConfiguration()
            .component("servlet")
            .port(8092)
            .host("localhost")
            .bindingMode(RestBindingMode.auto)
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "shorewise wiseconnect router")
            .apiProperty("api.version", "1.0")
            .apiProperty("cors", "true");

        // REST endpoint to trigger ActiveMQ consumption
        rest("/wiseconnect")
            .get("/transactions/view-processed")
            .route()
            .to("direct:startActiveMqConsumption")
            .process(exchange -> logger.info("ActiveMQ consumption route triggered"))
            .endRest();

        from("direct:startActiveMqConsumption")
            .setExchangePattern(ExchangePattern.InOnly)
            .process(exchange -> logger.info("Starting ActiveMQ consumption"))
            .pollEnrich("activemq:queue:Processed", (oldExchange, newExchange) -> {
                // Here you can aggregate or combine the messages as needed
                if (oldExchange == null) {
                    return oldExchange;
                } else {
                    // Combine or aggregate the messages in some way
                    String oldBody = oldExchange.getIn().getBody(String.class);
                    String newBody = newExchange.getIn().getBody(String.class);
                    String combinedMessage = oldBody + "\n" + newBody;
                    oldExchange.getIn().setBody(combinedMessage);
                    return oldExchange;
                }
            })
            .choice()
            .when(body().isNotNull())
                .process(exchange -> logger.info("Received and aggregated messages from Ingress: {}", exchange.getIn().getBody(String.class)))
                .to("activemq:queue:Egress")
                .process(exchange -> logger.info("Forwarded message to Egress"))
            .otherwise()
                .process(exchange -> logger.warn("Aggregated message body is null, skipping forwarding to AnotherQueue"))
            .end();
    }
}
