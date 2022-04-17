package nl.oliveira.rest.movie.title;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import nl.oliveira.movie.title.usecase.Title;
import nl.oliveira.rest.movie.cast.CastResponse;
import nl.oliveira.rest.movie.crew.CrewResponse;

import java.util.List;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TitleResponse {

  private String primaryTitle;
  private String originalTitle;
  private boolean isAdult;
  private Integer startYear;
  private Integer endYear;
  private Integer runtimeMinutes;
  private String genres;
  private List<CastResponse> cast;
  private CrewResponse crew;

  public static TitleResponse from(final Title title) {
    return TitleResponse.builder()
      .primaryTitle(title.getPrimaryTitle())
      .originalTitle(title.getOriginalTitle())
      .isAdult(title.isAdult())
      .startYear(title.getStartYear())
      .endYear(title.getEndYear())
      .runtimeMinutes(title.getRuntimeMinutes())
      .genres(title.getGenres())
      .cast(CastResponse.from(title.getCast()))
      .crew(CrewResponse.from(title.getCrew()))
      .build();
  }
}
