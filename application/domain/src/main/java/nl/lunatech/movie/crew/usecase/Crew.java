package nl.lunatech.movie.crew.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "title_crew")
public class Crew {

  @Id
  @Column(name = "tconst")
  private String id;

  @Column
  private String directors;

  @Column
  private String writers;

}
