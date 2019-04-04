package com.example.spring.gitcommitid;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.contains;

/**
 * @author xinj.x
 */
public class RestAssuredTest {

  @Before
  public void setUp() {
    RestAssured.baseURI = "http://localhost:8081";
  }
  @Test
  public void givenUrl_whenJsonResponseConformsToSchema_thenCorrect() {
    get("/events?id=390").then().assertThat()
            .body(matchesJsonSchemaInClasspath("event_0.json"));
  }

  @Test
  public void givenUrl_whenValidatesResponseWithInstanceSettings_thenCorrect() {
    JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
            .setValidationConfiguration(
                    ValidationConfiguration.newBuilder()
                            .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
            .freeze();
    get("/events?id=390").then().assertThat()
            .body(matchesJsonSchemaInClasspath("event_0.json")
                    .using(jsonSchemaFactory));
  }
  
  @Test
  public void requestLocalRest_andAssertByAssured() {
    get("/api/book/{id}", 1).then().statusCode(200)
    .assertThat().body("title", equalTo("十万个为什么"));
  }

  /**
   * rest assured解析json
   */
  @Test
  public void requestLocalRest_andAssertArray() {
    get("/api/book").then()
            .statusCode(200)
            .assertThat()
            .body("$..id", contains("2","4"));
  }

  /**
   * 登录成功后重定向->>> 302
   */
  @Test
  public void given_authentication_test() {
    given().auth()
            .form("user", "user12", FormAuthConfig.springSecurity())
            .contentType(ContentType.JSON)
            .expect()
            .statusCode(302)
            .log().all()
            .when()
            .post();

    get("/version").then()
            .assertThat()
            .body("$[git.branch]", equalTo("master"));
  }
}
