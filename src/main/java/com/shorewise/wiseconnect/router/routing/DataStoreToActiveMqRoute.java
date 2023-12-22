package com.shorewise.wiseconnect.router.routing;

import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import com.shorewise.wiseconnect.router.repository.TransactionalXmlRepository;
import com.shorewise.wiseconnect.router.entity.TransactionalXml;

@Component
public class DataStoreToActiveMqRoute extends RouteBuilder {

    @Autowired
    private TransactionalXmlRepository transactionalXmlRepository;

    @Override
    public void configure() {
        // Configure REST DSL for Swagger support
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .apiContextPath("/api-doc")
                .apiProperty("api.title", "DataStore to ActiveMQ Route")
                .apiProperty("api.version", "1.0");

        // Define REST endpoint
        rest("/datastore")
            .post("/toActiveMQ")
            .produces(MediaType.APPLICATION_JSON_VALUE)
            .route()
                .to("direct:readAndSendToActiveMQ")
            .endRest();

        // Define Camel route
        from("direct:readAndSendToActiveMQ")
            .routeId("datastore-to-activemq-route")
            .log(LoggingLevel.INFO, "Fetching 'received' records from the database")
            .bean(this, "fetchRecords")
            .split(body())  // Serialize to XML
                .log(LoggingLevel.INFO, "Sending record to ActiveMQ")
                // Removed JSON marshaling, handle as XML
                .setExchangePattern(ExchangePattern.InOnly)
                .to("activemq:queue:ProcessedQueueData")
                .bean(this, "updateRecordStatus")
                .log(LoggingLevel.INFO, "Record status updated to 'processed'")
            .end();
    }

    public List<TransactionalXml> fetchRecords() {
        List<TransactionalXml> records = transactionalXmlRepository.findByStatus("Received");
        if (records.isEmpty()) {
            log.info("No 'received' records found in the database.");
        } else {
            records.forEach(record -> log.info("Fetched record with ID: {}", record.getId()));
        }
        return records;
    }

    public void updateRecordStatus(TransactionalXml record) {
        record.setStatus("Processed");
        transactionalXmlRepository.save(record);
        log.info("Updated record status to 'processed' for ID: {}", record.getId());
    }
}
