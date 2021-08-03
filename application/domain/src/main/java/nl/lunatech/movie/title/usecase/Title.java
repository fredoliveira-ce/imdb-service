package nl.lunatech.movie.title.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.lunatech.movie.cast.usecase.Cast;
import nl.lunatech.movie.crew.usecase.Crew;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "title_basics")
public class Title {

  @Id
  @Column(name = "tconst")
  private String id;

  @Column(name = "titletype")
  private String titleType;

  @Column(name = "primarytitle")
  private String primaryTitle;

  @Column(name = "originaltitle")
  private String originalTitle;

  @Column(name = "isadult")
  private boolean isAdult;

  @Column(name = "startyear")
  private Integer startYear;

  @Column(name = "endyear")
  private Integer endYear;

  @Column(name = "runtimeminutes")
  private Integer runtimeMinutes;

  @Column(name = "genres")
  private String genres;

  @Transient
  private List<Cast> cast;

  @Transient
  private Crew crew;

}
