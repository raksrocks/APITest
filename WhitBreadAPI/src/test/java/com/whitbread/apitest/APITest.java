/**
 * 
 */
package com.whitbread.apitest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.google.gson.Gson;
import com.whitbread.beans.Payload;
import com.whitbread.beans.PayloadList;
import com.whitbread.beans.Response;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * @author Administrator
 *
 */

public class APITest {
	 
	 private String[] HEADERS = { "Key", "Value"}; //headers in csv file
	 private String url;
	 //private String response;
	 private Response responseBody = new Response();
	 private List<Payload> inputList = new ArrayList<Payload>(); // to load input data table
	 private Map<String,Response> resultMap = new HashMap<String,Response>(); // to store the result
	 
	 
	 @Given("URL available in the file")
	 public void loadURLFile() {
	     // Logic to load the csv file and read the URL
		 try {
		    Reader in = new FileReader("./URL.csv");
		    Iterable<CSVRecord> records = CSVFormat.DEFAULT
				  .withHeader(HEADERS)
				  .withFirstRecordAsHeader()
				  .parse(in);			
		    for (CSVRecord record : records) 
		        if(record.get("Key").equals("URL"))
		        	url = record.get("Value");		        
		    RestAssured.baseURI = url.trim();		    
		 } catch (IOException e) {
			 fail("Unable to read URL file, error: "+e.getLocalizedMessage());	
			 e.printStackTrace();
		 }
	 }
	 
	 @Given("^The customer data as$")
	 public void customer_data(PayloadList payloads) {
		 inputList.addAll(payloads.getPayloads());
	 }
	 
	 @When("send POST request to API")
	 public void send_POST_to_API() {
	     // call the API
		 inputList.forEach(i -> postAPI(i) );		
	 }
	 
	 /**
	 * @param body
	 * @return
	 */
	private Response postAPI(Payload body) {
		 Response resp = new Response();
		 try {		

		 resp = new Gson().fromJson(given()
		         .contentType(ContentType.JSON)
		         .body(body)
		         .post("")
		         .then()
		         .statusCode(200)
		         .extract()
		         .response().asPrettyString(), Response.class);
		 //responseBody = resp;
		 resultMap.put(body.getEmail(), resp);
		 }catch (Exception e) {
			fail("Unable to load the URL");
		}
		 return resp;
	 }
	
	 /**
		 * @param body
		 * @return
		 */
		private Response getAPI(String email) {
			 Response resp = new Response();
			 try {		 
				 loadURLFile();
				 resp = new Gson().fromJson(given().get("/"+email)
			         .then()
			         .extract()
			         .response().asPrettyString(), Response.class);
			 }catch (Exception e) {
				fail("Unable to load the URL: "+e.getLocalizedMessage());
				
			}
			 return resp;
		 }
	 
		/**
		 * @param body
		 * @return
		 */
		private Response deleteAPI(String email) {
			 Response resp = new Response();
			 try {		 
				 loadURLFile();
				 resp = new Gson().fromJson(given().delete("/"+email)
			         .then()
			         .extract()
			         .response().asPrettyString(), Response.class);
			 }catch (Exception e) {
				fail("Unable to load the URL: "+e.getLocalizedMessage());				
			}
			 return resp;
		 }
		
	 @Then("^verify the Status for ([^\"]*) as ([^\"]*)$")
	 public void verify_the_status(String email, String status) {
		 if(status.equalsIgnoreCase("success")) {
			 assertEquals("200",resultMap.get(email).getStatusCode());
			 assertEquals(email.replace("@", ""), resultMap.get(email).getBody().getCustomerId());
		 }
		 else
			 assertEquals("Missing mandatory data",resultMap.get(email).getErrorMessage());
	 }
	 
	 @When("^I give ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*)$")
	 public void setupPayload(String email, String password, String firstName, String lastName, String title) throws Throwable {
	       Payload pl = new Payload(email, password, firstName, lastName, title); 
	       responseBody = postAPI(pl);
	 }
	 @Then("^the result should be ([^\"]*)$")
	 public void validateResult(String result) throws Throwable {
		 if("success".equalsIgnoreCase(result))
			 assertEquals("200", responseBody.getStatusCode());
		 else
			 assertEquals(result, responseBody.getErrorMessage());		 
	 }
	 
	 @When("^getCustomer API is called with ([^\"]*)$")
	 public void getCustomerAPICall(String email) throws Throwable {
	       responseBody = getAPI(email);
	 }
	 
	 @Then("^customerId ([^\"]*) is returned$")
	 public void validateResultForGetCall(String customerId) throws Throwable {
		 if(customerId.contains("@"))
			 assertEquals(customerId.replace("@", "%40"),responseBody.getCustomerId());
		 else
			 assertEquals(customerId, responseBody.getMessage());
	 }
	 
	 @When("^deleteCustomer API is called with ([^\"]*)$")
	 public void deleteCustomerAPICall(String email) throws Throwable {
	       responseBody = deleteAPI(email);
	 }
	 
	 @Then("^([^\"]*) is deleted$")
	 public void validateResultForDeleteCall(String result) throws Throwable {
		 if(result.equalsIgnoreCase("true"))
			 assertTrue(responseBody.isDeleted());
		 else
			 assertEquals(result, responseBody.getMessage());
	 }
}
