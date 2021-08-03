package nl.lunatech.rest.movie.cast;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import nl.lunatech.movie.cast.usecase.Cast;
import nl.lunatech.rest.movie.person.PersonResponse;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CastResponse {

  private Integer ordering;
  private PersonResponse person;
  private String category;
  private String job;
  private String characters;

  public static List<CastResponse> from(final List<Cast> cast) {
    return cast.stream()
      .map(CastResponse::buildResponse)
      .collect(Collectors.toList());
  }

  private static CastResponse buildResponse(final Cast cast) {
    return CastResponse.builder()
      .ordering(cast.getOrdering())
      .person(PersonResponse.from(cast.getPerson()))
      .category(cast.getCategory())
      .job(cast.getJob())
      .characters(cast.getCharacters())
      .build();
  }
}
