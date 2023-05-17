package demo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TrelloAPI {
	
//	I am going to test end points of trello
//	I want to create the baseUrl because it is common to all the end-points
  	public static String baseurl = "https://trello.com/";
  	public static String key = "8ac5a72c3caaea3cbbdb6ad03fce7e16";
  	public static String token = "ATTAc94efdce31b8083f450e7910680c6037fce79a6f214837d20a2443276d82e32145A9C6FA";
  	public static String id ;
  	
  	@Test
  	public void CreateBoard() 
  	{
//  		Rest : Assured we work with the below ascpect
//  		given: request -contains, body,headers-authorization - content-type, queryParameter
//  		when: resource /board (this will have only resource)
//  		then: response - assertion -string format -- jsonpath()
  		
  		RestAssured.baseURI = baseurl;
  		
  	    Response  response =	given().queryParam("name", "masai")
  		.queryParam("key",key)
  		.queryParam("token",token)
  		.header("Content-Type", "application/json")
  		
  		.when()
  		.post("/1/boards")
  		
  		.then()
  		.assertThat().statusCode(200).contentType(ContentType.JSON)
  		.extract().response();
//  	    this below code will get response in the string format and store in jsonresponse var
  	    String jsonresponse = response.asString();
//  	    this should print entire response 
  	    System.out.println(jsonresponse);
//  	    the below code will convert my entire response in the json object 
  	   JsonPath js = new JsonPath(jsonresponse);
//  	   this is to fetch the specific object
  	    id = js.get("id");
  	    System.out.println(id);
  		
  	}

}
