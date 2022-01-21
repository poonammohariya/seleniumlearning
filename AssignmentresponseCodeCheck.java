package restassuredtestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class AssignmentresponseCodeCheck {

	@Test(priority = 1)
	public void testGetListUser() {

		System.out.println("******************* TEST 1 *************");

		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().statusCode(200).log().all();
	}

	@Test(priority = 2)
	public void testGetSingleUser() {

		System.out.println("******************* TEST 2 *************");

		baseURI = "https://reqres.in/api";

		given().get("/users/2").then().statusCode(200).log().all();
	}

	@Test(priority = 3)
	public void testGetSingleUserNotFound() {

		System.out.println("******************* TEST 3 *************");

		baseURI = "https://reqres.in/api";

		given().get("/users/23").then().statusCode(404).log().all();
	}

	@Test(priority = 4)
	public void testGetlistResources() {

		System.out.println("******************* TEST 4 *************");

		baseURI = "https://reqres.in/api";

		given().get("/unknown").then().statusCode(200).log().all();
	}

	@Test(priority = 5)
	public void testGetSingleResources() {

		System.out.println("******************* TEST 5 *************");

		baseURI = "https://reqres.in/api";

		given().get("/unknown/2").then().statusCode(200).log().all();
	}

	@Test(priority = 6)
	public void testGetSingleResourcesNotFound() {

		System.out.println("******************* TEST 6 *************");

		baseURI = "https://reqres.in/api";

		given().get("/unknown/23").then().statusCode(404).log().all();
	}

	@Test(priority = 7)
	public void testGetDelayedResponse() {

		System.out.println("******************* TEST 7 *************");

		baseURI = "https://reqres.in/api";

		given().get("users?delay=3").then().statusCode(200).log().all();
	}

}
