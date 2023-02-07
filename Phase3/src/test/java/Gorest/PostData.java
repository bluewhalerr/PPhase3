package Gorest;
import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostData extends BaseTest {
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod
	public void postReq() {
		map.put("name","singha12");
		logger.info("Added name");
		map.put("email","singha123@gmail.com");
		logger.info("Added email");
		map.put("gender","male");
		logger.info("Added gender");
		map.put("status","active");
		logger.info("Added status");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public/v2/users";
		logger.info("Payload created");
	}
	
	@Test
	public void Create() {
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
				.header("Authorization","Bearer b17e153e48fdeae82fb5d29644cdcb5b7246377d0feee98c02a84a97e5e331c3")
				.when()
				.post()
				.then()
					.statusCode(201)
					.log().all();
		logger.info("Response Captured");
		
	}
}
