package restassuredtestcases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class AssignmentResponsePostcheckCode {
	@Test(priority = 1)
	public void testPostCreateUser() {

		System.out.println("******************* TEST 1 *************");

		baseURI = "https://reqres.in/api";

		JSONObject requestDataPostCreate = new JSONObject();
		requestDataPostCreate.put("name", "Peter");
		requestDataPostCreate.put("job", "Developer");

		System.out.println(requestDataPostCreate.toJSONString());

		given()

				.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(requestDataPostCreate.toJSONString())

				.when()

				.post("/users")

				.then()

				.statusCode(201).log().all();

	}

	@Test(priority = 2)
	public void testPostRegisterSuccessfull() {

		System.out.println("******************* TEST 2 *************");

		baseURI = "https://reqres.in/api";

		JSONObject requestForRegistersuccessfull = new JSONObject();

		requestForRegistersuccessfull.put("email", "eve.holt@reqres.in");
		requestForRegistersuccessfull.put("password", "pistol");

		System.out.println(requestForRegistersuccessfull.toJSONString());

		given()

				.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(requestForRegistersuccessfull.toJSONString())

				.when()

				.post("/register")

				.then()

				.statusCode(200).log().all();

	}

	@Test(priority = 3)
	public void testPostRegisterUnsuccessfull() {

		System.out.println("******************* TEST 3 *************");

		baseURI = "https://reqres.in/api";

		JSONObject requestPostRegisterUnsuccessfull = new JSONObject();
		requestPostRegisterUnsuccessfull.put("email", "Elissa@gmail.com");

		System.out.println(requestPostRegisterUnsuccessfull.toJSONString());

		given()

				.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(requestPostRegisterUnsuccessfull.toJSONString())

				.when()

				.post("/register")

				.then()

				.statusCode(400).log().all();

	}

	@Test(priority = 4)
	public void testPostLoginSuccessfull() {

		System.out.println("******************* TEST 4 *************");

		baseURI = "https://reqres.in/api";

		JSONObject requestPostLoginSuccessfull = new JSONObject();
		requestPostLoginSuccessfull.put("email", "eve.holt@reqres.in");
		requestPostLoginSuccessfull.put("password", "cityslicka");

		System.out.println(requestPostLoginSuccessfull.toJSONString());

		given()

				.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(requestPostLoginSuccessfull.toJSONString())

				.when()

				.post("/login")

				.then()

				.statusCode(200).log().all();

	}

	@Test(priority = 5)
	public void testPostLoginUnSuccessfull() {

		System.out.println("******************* TEST 5 *************");

		baseURI = "https://reqres.in/api";

		JSONObject requestPostLoginUnSuccessfull = new JSONObject();
		requestPostLoginUnSuccessfull.put("email", "Edwin@gmail.com");

		System.out.println(requestPostLoginUnSuccessfull.toJSONString());

		given()

				// .header("Content-Type","application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(requestPostLoginUnSuccessfull.toJSONString())

				.when()

				.post("/login")

				.then()

				.statusCode(400).log().all();
	}

	@Test(priority = 6)

	public void FinalAssesmentTestforuser() {

		System.out.println("******************* TEST 6 *************");

		baseURI = "https://reqres.in/api";

		// Register a user >> extract id and token

		JSONObject reqDataForRegisterSucessfull = new JSONObject();

		reqDataForRegisterSucessfull.put("email", "eve.holt@reqres.in");
		reqDataForRegisterSucessfull.put("password", "pistol");

		System.out.println(reqDataForRegisterSucessfull.toJSONString());

		given()

				.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(reqDataForRegisterSucessfull.toJSONString())

				.when()

				.post("/register")

				.then()

				.statusCode(200).log().all();

		String token = given().body(reqDataForRegisterSucessfull.toJSONString()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).header("charset", "utf-8").when().post("/register").then().extract()
				.path("token");

		System.out.println(token + " Token is extract sucessfully");

		int id = given().body(reqDataForRegisterSucessfull.toJSONString()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).header("charset", "utf-8").when().post("/register").then().extract()
				.path("id");

		System.out.println(id + "Id Extract ");

		// Log in with the above created user >> extract token

		reqDataForRegisterSucessfull.put("email", "eve.holt@reqres.in");
		reqDataForRegisterSucessfull.put("password", "cityslicka");

		System.out.println(reqDataForRegisterSucessfull.toJSONString());
		System.out.println("Login with above created user");

		given()

				.header("Content-Type", "application/json")

				.accept(ContentType.JSON).body(reqDataForRegisterSucessfull.toJSONString())

				.when()

				.post("/login")

				.then()

				.statusCode(200).log().all();

		String tokenForLoginSucessfull = given().body(reqDataForRegisterSucessfull.toJSONString())
				.contentType(ContentType.JSON).accept(ContentType.JSON).header("charset ", "utf-8").when()
				.post("/login").then().extract().path("token");

		System.out.println(tokenForLoginSucessfull + "  : Sucessfully Done ");

		// run get single user to find the same user id >> validate name and job details

		given()

				.get("/users/" + id)

				.then().statusCode(200).body("data.id", equalTo(4)).body("data.first_name", equalTo("Eve")).log()
				.body();

		// SINGLE <RESOURCE> use the same user if >> validate details

		given()

				.get("/unknown/" + id)

				.then().statusCode(200).body("data.id", equalTo(4)).body("data.name", equalTo("aqua sky"))

				// we are logging everything

				.log().everything().log().body();

		// then update user details >> add validations >> search user and validate again

		reqDataForRegisterSucessfull.put("name", "Peter");
		reqDataForRegisterSucessfull.put("job", "Tester");

		given().body(reqDataForRegisterSucessfull.toJSONString()).when().patch("/unknown/" + id).then().statusCode(200)
				.log().body();
		System.out.println(id + "updated : Scucessfully");

		// search Again if it is updated or not

		given()

				.get("/unknown/" + id).then().statusCode(200).body("data.id", equalTo(4)).log().body();
		System.out.println("User is updated : Sucessfully");

		// patch same user >> validate response >> search user >> validate

		reqDataForRegisterSucessfull.put("name", "EDwinMusk");
		reqDataForRegisterSucessfull.put("job", "ScrumMaster");

		given().body(reqDataForRegisterSucessfull.toJSONString()).when().patch("/users/" + id).then().statusCode(200)
				.log().body();
		System.out.println(id + "Patch : Scucessfully");

		// Search user and validate again

		given()

				.get("/users/" + id).then().statusCode(200).body("data.id", equalTo(4)).log().body();

		System.out.println(id + "patch is validate : Scucessfully");

		// delete same user >> validate code >> search user >> validate

		when().delete("/users/" + id).then().statusCode(204).log().ifStatusCodeIsEqualTo(204);
		System.out.println(id + "User is deleted : Scucessfully ");

		// Search again for sucessfull delete

		given().get("/users/" + id).then().statusCode(200).body("data.id", equalTo(4)).log().body();

		System.out.println(id + " Search user again if deleted : Scucessfully");

	}

}
