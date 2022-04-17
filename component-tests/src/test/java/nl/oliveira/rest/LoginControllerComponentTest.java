package nl.oliveira.rest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import nl.oliveira.CommonsTest;
import nl.oliveira.ComponentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriUtils;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ComponentTest
@DisplayName("Runs all tests for login feature")
class LoginControllerComponentTest extends CommonsTest {

  private static final String API_PATH = "/api/titles";

  @LocalServerPort
  private int port;

  @Test
  @DisplayName("should not authorize request without token")
  void findMovieWithUnauthorizedUser() {
    // arrange
    String token = login("unauthorized");

    // act
    var response = doGet("Back to the Future", token);

    // assert
    response
      .statusCode(HttpStatus.FORBIDDEN.value());
  }

  public ValidatableResponse doGet(String title, final String token) {
    RequestSpecification request = RestAssured.given()
      .port(port)
      .log()
      .all(true)
      .urlEncodingEnabled(false)
      .header(CONTENT_TYPE, APPLICATION_JSON_VALUE);

    if (nonNull(token)) {
      request.header(AUTHORIZATION, token);
    }

    return request.get(UriUtils.encodePath(API_PATH + "/" + title, "UTF-8"))
      .then()
      .log()
      .all(true);
  }

}
