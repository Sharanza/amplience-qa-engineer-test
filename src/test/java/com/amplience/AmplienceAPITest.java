package com.amplience;

import org.testng.Assert; //used to validate response status 
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AmplienceAPITest {

    @Test
    public void RequestResponseDetails() {
        // base URL to the RESTful web service
        RestAssured.baseURI = "https://api.github.com/users/6wl";
        // Gets the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();
        // Make a request to the server by specifying the method Type and URL (path)
        Response response = httpRequest.request(Method.GET, "");
        // Prints the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

        // Gets all the headers. Return value is of type Headers
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        // Access header with a given name. Header = Content-Type
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);

        // Get the status code of the request.
        // If request is successful, the status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned
        Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */,
                "Correct status code returned");

        // Retrieve the body of the Response
        // <?> is a wildcard which means any type
        ResponseBody<?> body = response.getBody();

        // To check for sub string presence get the Response body as a String
        String bodyAsString = body.asString();
        // You can test the response body by putting in different values and switching
        // the value to false which returns a failed build and specifies the error
        Assert.assertEquals(bodyAsString.contains("Manchester") /* Expected value */, true /* Actual Value */,
                "Response body contains Manchester");

        // added an additional automated assertion to highlight
        // the followers number being wrong
        // followers data comes back with 20 but the tech test brief specifies 21
        Assert.assertEquals(bodyAsString.contains("21") /* Expected value */, true /* Actual Value */,
                "Response body contains 20 followers");
    }
}