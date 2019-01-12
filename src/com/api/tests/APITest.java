package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.logic.APIClass;
import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class APITest {
  @Test
  public void Get() throws Exception {	  
	 Response apiResponse = APIClass.apiGetMethod("http://restapi.demoqa.com/utilities/weather/city/pune");	 
	 
	 String value = JsonPath.read(apiResponse.asString(), "$.City");
	 Assert.assertEquals("Pune", value);
	 System.out.println(value);
  }
  
  @Test
  public void Post() throws Exception {	 
	  
	 System.out.println("---------------------------------------------------");	  
	 String requestBody = "{\"name\": \"morpheus2\",\"job\": \"leader\"}";	  
	 Response apiResponse = APIClass.apiPOSTMethod("https://www.reqres.in/api/users","application/json",requestBody);	 
	
	 String value = JsonPath.read(apiResponse.asString(), "$.name");	
	 System.out.println(value);
  }
  
   @Test
  public void Del() throws Exception {	  
	 Response apiResponse = APIClass.apiDeleteMethod("https://www.reqres.in/api/users/2","","application/json");	 
	 
	 //String value = JsonPath.read(apiResponse.asString(), "$.City");
	 //Assert.assertEquals("Pune", value);
	// System.out.println(value);
  }
}
