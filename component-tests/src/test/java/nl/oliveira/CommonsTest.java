package nl.oliveira;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import nl.oliveira.user.usecase.User;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.util.UriUtils;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ComponentTest
public class CommonsTest {

  @LocalServerPort
  private int port;

  public ValidatableResponse doGet(String path, final String token) {
    return RestAssured.given()
      .port(port)
      .log()
      .all(true)
      .urlEncodingEnabled(false)
      .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
      .header(AUTHORIZATION, token)
      .get(UriUtils.encodePath(path, "UTF-8"))
      .then()
      .log()
      .all(true);
  }

  public String login(String username) {
    return RestAssured.given()
      .port(port)
      .urlEncodingEnabled(false)
      .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
      .body(User.builder().username(username).build())
      .post("/login")
      .getHeader("Authorization");
  }

}
