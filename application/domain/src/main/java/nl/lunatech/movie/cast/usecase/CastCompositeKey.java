package nl.lunatech.movie.cast.usecase;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class CastCompositeKey implements Serializable {

  private String titleId;
  private Integer ordering;
  private String personId;

}
