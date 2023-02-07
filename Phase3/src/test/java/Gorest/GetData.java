package Gorest;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetData extends BaseTest{
	
	@Test
	public void getReq() {
		
		RestAssured
			.given()
				.contentType("application/json")
				.header("Authorization","Bearer b17e153e48fdeae82fb5d29644cdcb5b7246377d0feee98c02a84a97e5e331c3")
			.when()
				.get("https://gorest.co.in/public/v2/users/315491")
			.then()
				.statusCode(200)
				.log().all()
			.and()
				.body("email", is ("singha123@gmail.com"));	
		logger.info("Response Verified");
				
	}
	
	

	}
