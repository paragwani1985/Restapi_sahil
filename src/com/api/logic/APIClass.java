package com.api.logic;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIClass {

	public static Response apiGetMethod(String URI) throws Exception {

		
		Response API_response = RestAssured.given().get(URI);
		
		if (API_response.getStatusCode() == 200) {
			System.out.println(("ResponseCode for API is " + API_response.getStatusCode()));
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		
		System.out.println(API_response.asString());
		return API_response;
	}

	public static Response apiPOSTMethod(String URI, String header_content_type,
			String request_body) throws Exception {
		
		Response API_response = RestAssured.given()
				.header("content-type", header_content_type)
				.body(request_body).post(URI);

		if (API_response.getStatusCode() == 200 || API_response.getStatusCode() == 201) {
			System.out.println(("ResponseCode for API is " + API_response.getStatusCode()));
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}		
		System.out.println(API_response.asString());
		return API_response;
	}
	
	public static Response apiDeleteMethod(String URI, String Authorization, String header_content_type) throws Exception {
		
		Response API_response = (Response) RestAssured.given()
				.header("content-type", header_content_type).delete(URI);
		
		if (API_response.getStatusCode() == 204 || API_response.getStatusCode() == 201) {
			System.out.println(("ResponseCode for API is " + API_response.getStatusCode()));
		} else {
			throw new Exception("ResponseCode for API is " + API_response.getStatusCode());
		}
		System.out.println(API_response.asString());
		return API_response;
	}

}
