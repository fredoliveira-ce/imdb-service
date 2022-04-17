package nl.oliveira.movie.cast.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.oliveira.movie.person.usecase.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@IdClass(CastCompositeKey.class)
@Table(name = "title_principals")
public class Cast {

  @Id
  @Column(name = "tconst")
  private String titleId;

  @Id
  @Column(name = "ordering")
  private Integer ordering;

  @Id
  @Column(name = "nconst")
  private String personId;

  @Transient
  private Person person;

  @Column
  private String category;

  @Column
  private String job;

  @Column
  private String characters;

}
