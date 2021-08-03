package nl.lunatech.rest;

import nl.lunatech.CommonsTest;
import nl.lunatech.ComponentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@ComponentTest
@DisplayName("Runs all tests for six degrees feature")
class SixDegreesControllerComponentTest extends CommonsTest {

  private static final String API_PATH = "api/six-degrees/";

  @Test
  @DisplayName("should find target through the grath within eight degrees")
  @Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:six-degrees.sql")
  void playGameAndFindWithinMoreThanSixHops() {
    // arrange
    String token = login("test");

    // act
    var response = doGet(API_PATH + "Lauren Bacall", token);

    // assert
    response
      .assertThat()
      .statusCode(HttpStatus.OK.value())
      .body("degrees", is(8));
  }

  @Test
  @DisplayName("should find target through the grath within four degrees")
  @Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:six-degrees.sql")
  void playGameAndFindWithinFourHops() {
    // arrange
    String token = login("test");

    // act
    var response = doGet(API_PATH + "Markus Waldow", token);

    // assert
    response
      .assertThat()
      .statusCode(HttpStatus.OK.value())
      .body("degrees", is(4));
  }

  @Test
  @DisplayName("should find target through the grath within two degrees")
  @Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:six-degrees.sql")
  void playGameAndFindWithinTwoHops() {
    // arrange
    String token = login("test");

    // act
    var response = doGet(API_PATH + "Jennifer Lawrence", token);

    // assert
    response
      .assertThat()
      .statusCode(HttpStatus.OK.value())
      .body("degrees", is(2));
  }

  @Test
  @DisplayName("should result not fount when there isn't link with the target")
  void findWithoutResult() {
    // arrange
    String token = login("test");

    // act
    var response = doGet(API_PATH + "Jennifer Lawrence", token);

    // assert
    response
      .statusCode(HttpStatus.NOT_FOUND.value());
  }

}
