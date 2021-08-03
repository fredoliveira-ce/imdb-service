package nl.lunatech.rest.movie.person;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import nl.lunatech.movie.person.usecase.Person;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PersonResponse {

  private String name;
  private String birthYear;
  private String deathYear;
  private String profession;
  private String fortitles;

  public static PersonResponse from(final Person person) {
    return PersonResponse.builder()
      .name(person.getName())
      .birthYear(person.getBirthYear() > 0
        ? String.valueOf(person.getBirthYear())
        : null)
      .deathYear(person.getDeathYear())
      .profession(person.getProfession())
      .fortitles(person.getFortitles())
      .build();
  }
}
