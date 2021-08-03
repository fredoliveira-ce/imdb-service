package nl.lunatech.rest.sixdegrees;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SixDegreesResponse {

  private double elapsedTime;
  private int degrees;
  private List<String> nodes;

}
