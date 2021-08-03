package nl.lunatech.rest;

import nl.lunatech.CommonsTest;
import nl.lunatech.ComponentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

@ComponentTest
@DisplayName("Runs all tests for rating feature")
public class RatingControllerComponentTest extends CommonsTest {

  public static final String API_PATH = "/api/ratings/";

  @Nested
  @DisplayName("GET " + API_PATH)
  class FindTitle {

    @Test
    @DisplayName("should get one result with a genre description")
    void findRatingsByGenreWithOneResult() {
      // arrange
      String token = login("test");

      // act
      var response = doGet(API_PATH + "Sci-fi", token);

      // assert
      response
        .statusCode(HttpStatus.OK.value())
        .body("$", hasSize(1))
        .body("title", hasItem("Back to the Future"))
        .body("genres", hasItem("Sci-fi,Comedy"))
        .body("average_rating", hasItem(Float.parseFloat("6.1")))
        .body("votes", hasItem(1674));
    }

    @Test
    @DisplayName("should get two results with a genre description")
    void findRatingsByGenreWithTwoResult() {
      // arrange
      String token = login("test");

      // act
      var response = doGet(API_PATH + "Documentary", token);

      // assert
      response
        .statusCode(HttpStatus.OK.value())
        .body("$", hasSize(2));
    }

    @Test
    @DisplayName("should not fount result with a unknown genre")
    void findWithoutResult() {
      // arrange
      String token = login("test");

      // act
      var response = doGet(API_PATH + "fantasy", token);

      // assert
      response
        .statusCode(HttpStatus.NOT_FOUND.value());
    }

  }

}
