package nl.oliveira.rest;

import nl.oliveira.CommonsTest;
import nl.oliveira.ComponentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

@ComponentTest
@DisplayName("Runs all tests for title feature")
class TitleControllerComponentTest extends CommonsTest {

  private static final String API_PATH = "/api/titles/";

  @Nested
  @DisplayName("GET " + API_PATH)
  class FindTitle {

    @Test
    @DisplayName("should get one result with a primary movie title")
    void findMovieUsingPrimaryTitleWithOneResult() {
      // arrange
      String token = login("test");

      // act
      var response = doGet(API_PATH + "Back to the Future", token);

      // assert
      response
        .statusCode(HttpStatus.OK.value())
        .body("$", hasSize(1))
        .body("primary_title", hasItem("Back to the Future"))
        .body("original_title", hasItem("Back to the Future Original"))
        .body("start_year", hasItem(1985))
        .body("runtime_minutes", hasItem(240))
        .body("genres", hasItem("Sci-fi,Comedy"));
    }

    @Test
    @DisplayName("should get one result with a original movie title")
    void findMovieUsingOriginalTitleWithOneResult() {
      // arrange
      String token = login("test");

      // act
      var response = doGet(API_PATH + "Back to the Future Original", token);

      // assert
      response
        .statusCode(HttpStatus.OK.value())
        .body("$", hasSize(1))
        .body("primary_title", hasItem("Back to the Future"))
        .body("original_title", hasItem("Back to the Future Original"))
        .body("start_year", hasItem(1985))
        .body("runtime_minutes", hasItem(240))
        .body("genres", hasItem("Sci-fi,Comedy"));
    }

    @Test
    @DisplayName("should result not fount when there isn't a match with the user query")
    void findWithoutResult() {
      // arrange
      String token = login("test");

      // act
      var response = doGet(API_PATH + "Some movie", token);

      // assert
      response
        .statusCode(HttpStatus.NOT_FOUND.value());
    }

  }

}
