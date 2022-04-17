package nl.oliveira.movie.rating.usecase;

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
@Table(name = "title_ratings")
public class Rating {

  @Id
  @Column(name = "tconst")
  private String id;

  @Column(name = "averagerating")
  private Float averageRating;

  @Column(name = "numvotes")
  private int votes;

  private String title;

  private String genres;

}
