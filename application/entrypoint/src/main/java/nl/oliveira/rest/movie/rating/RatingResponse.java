package nl.oliveira.rest.movie.rating;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import nl.oliveira.movie.rating.usecase.Rating;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RatingResponse {

  private String title;
  private String genres;
  private Float averageRating;
  private int votes;

  public static RatingResponse from(Rating rating) {
    return RatingResponse.builder()
      .title(rating.getTitle())
      .genres(rating.getGenres())
      .averageRating(rating.getAverageRating())
      .votes(rating.getVotes())
      .build();
  }
}
