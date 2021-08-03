package nl.lunatech.rest.movie.crew;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import nl.lunatech.movie.crew.usecase.Crew;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CrewResponse {

  private String directors;
  private String writers;

  public static CrewResponse from(final Crew crew) {
    return CrewResponse.builder()
      .directors(crew.getDirectors())
      .writers(crew.getWriters())
      .build();
  }

}
