package com.shorewise.wiseconnect.router.beanprocessor;

import java.io.IOException;
import java.io.StringReader;
import java.util.UUID;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.camel.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component("dataStoreBeanProcessor")
public class DataStoreBeanProcessor {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger logger = LogManager.getLogger(DataStoreBeanProcessor.class);

    String operation;

    public void process(@Body String body) {
    	// Example of parsing the body to extract XML and other data
    	// This parsing depends on the format of 'body'
    	String xmlData = extractXmlFrom(body); // Implement this method based on your data format
    	String status = extractStatusFrom(body); // Similarly extract status
    	String user = extractUserFrom(body); // And the user
    	UUID uuid = UUID.randomUUID();
    	String uuidString = uuid.toString();
    	String id = "d55cae9f-c859-4a81-ae33-bc27f1250edc";//extractUUIDFrom(body);
    	xmlParser(body);
    	//recordExists(id);
    	// SQL statement with placeholders for parameters
    	
    	String insertSQL = "INSERT INTO xml_storage.transactional_xml "
    			+ "(id, xml_data, operation_type, status, created_user, updated_user, created_at, updated_at) "
    			+ "VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
    	
    	String updateSQL = "UPDATE xml_storage.transactional_xml SET xml_data = ?, operation_type = ?, status = ?, updated_user = ?,"
    			+ "updated_at = CURRENT_TIMESTAMP WHERE id = ?";

    	try {
    		if(!recordExists(id)) {
    			logger.info("Inserting record into database");
    			int res = insertRecord(insertSQL, uuidString, xmlData, operation, status, user);
    			logger.info("Record inserted successfully with ID: " + uuidString);
    		}
    		else {
    			user="truser02";
    			logger.info("Updating record in database");
    			System.out.println("Update SQL: UPDATE xml_storage.transactional_xml SET xml_data = '"+ xmlData + "', operation_type= '"+operation+"', status = '" + status +
    					"', updated_user = '"+ user +"',updated_at = CURRENT_TIMESTAMP WHERE id = '"+id+'\'');
    			int res = updateRecord(updateSQL, xmlData, operation, status, user, id);
    			logger.info("Record updated successfully for ID: " + id);
    		}
    	}
    	catch (InvalidResultSetAccessException e) 
    	{
    		throw new RuntimeException(e);
    	} 
    	catch (DataAccessException e)
    	{
    		logger.info("Record cannot be inserted/updated into DB due to an exception."+ e);
    		throw new RuntimeException(e);
    	}
    }
    
    //Check if entry already exists in database
    private boolean recordExists(String id) {
    	String sql = "SELECT * from xml_storage.transactional_xml where id = '"+id+"'";
    	return !jdbcTemplate.queryForList(sql).isEmpty();
    }
    
    //Insert new entry into xml_storage.transactional_xml
    private int insertRecord(String insertSQL, String uuidString, String xmlData, String operation, String status, String createdUser) {
    	return jdbcTemplate.update(insertSQL, uuidString, xmlData, operation, status, createdUser, createdUser);
    }
    
    //Update an entry in xml_storage.transactional_xml table using id as an identifier
    private int updateRecord(String updateSQL, String xmlData, String operation, String status, String updated_user, String uuidString) {
    	return jdbcTemplate.update(updateSQL, xmlData, operation, status, updated_user, uuidString);
    }

    // Example methods to parse the incoming message
    private String extractXmlFrom(String body) {
        // Implement parsing logic here
        return body; // Return extracted XML
    }

    private String extractStatusFrom(String body) {
        // Implement parsing logic here
        return "Received"; // Return extracted status
    }

    private String extractUserFrom(String body) {
        // Implement parsing logic here
        return "truser01"; // Return extracted user
    }
    
    private void xmlParser(String xmlData) {
    	// Instantiate the Factory
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	dbf.setNamespaceAware(true);
    	try {

    		// process XML securely, avoid attacks like XML External Entities (XXE)
    		dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

    		// parse XML file
    		DocumentBuilder db = dbf.newDocumentBuilder();
    		Document doc = db.parse(new InputSource(new StringReader(xmlData)));

    		doc.getDocumentElement().normalize();

    		//System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());

    		//String user = getElementValue(doc, "urn:control.services.tiplus2.misys.com", "User");
    		operation = getElementValue(doc, "urn:control.services.tiplus2.misys.com", "Operation");
    		String credentials = getElementValue(doc, "urn:control.services.tiplus2.misys.com", "Credentials");
    		String reference = getElementValue(doc, "urn:common.service.ti.apps.tiplus2.misys.com", "Reference");
    				
    		//String customer = getElementValue(doc, "urn:common.service.ti.apps.tiplus2.misys.com", "Customer");

    		System.out.println("Operation: "+operation+
    				" Reference: "+reference+" Credentials: "+credentials);

    	} catch (ParserConfigurationException | SAXException | IOException e) {
    		logger.info("XML cannot be parsed due to an exception."+ e);
    	}
    }
    
    
    //Get Element Value by Tag Name - Name Space
    private String getElementValue(Document doc, String url, String element) {
    	NodeList list = doc.getElementsByTagNameNS(url, element);    	
    	return list.getLength()!=0 ? list.item(0).getTextContent() : "";
    }
}