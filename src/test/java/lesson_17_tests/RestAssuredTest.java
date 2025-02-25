package lesson_17_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;


import static io.restassured.RestAssured.*;

public class RestAssuredTest {

    @BeforeEach
    public void configureRestAssured(){
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void getRequest(){
        given().baseUri(baseURI)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when().get("/get")
                .then().log().body()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRawText(){
        String requestBody = "This is expected to be sent back as part of response body.";

        given().baseUri(baseURI)
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when().post("/post")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    public void postFormData(){
        given().baseUri(baseURI)
                .contentType(ContentType.URLENC)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().post("/post")
                .then().log().body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putRequest(){
        String requestBody = "Hi my name is Eminem";

        given().baseUri(baseURI)
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when().put("/put")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    public void patchRequest(){
        String requestBody = "Hi my name is Cristiano";

        given().baseUri(baseURI)
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when().patch("/patch")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    public void deleteRequest(){
        String requestBody = "Hi my name is Leo";

        given().baseUri(baseURI)
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when().delete("/delete")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }
}

