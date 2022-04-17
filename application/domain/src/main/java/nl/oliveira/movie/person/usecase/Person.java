package nl.oliveira.movie.person.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static java.util.Objects.isNull;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "name_basics")
public class Person {

  @Id
  @Column(name = "nconst")
  private String id;

  @Column(name = "primaryname")
  private String name;

  @Column(name = "birthyear")
  private Integer birthYear;

  @Column(name = "deathyear")
  private String deathYear;

  @Column(name = "primaryprofession")
  private String profession;

  @Column(name = "knownfortitles")
  private String fortitles;

  public Integer getBirthYear() {
    return isNull(birthYear)
      ? 0
      : birthYear;
  }
}
