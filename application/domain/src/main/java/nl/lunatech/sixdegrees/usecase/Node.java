package nl.lunatech.sixdegrees.usecase;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Node {

  private Node parent;
  private boolean visited;
  private String value;
  private List<Node> edges;

  public Node(String movie) {
    this.value = movie;
    this.edges = new ArrayList<>();
  }

  public void addEdges(Node node) {
    this.edges.add(node);
    node.getEdges().add(this);
  }
}
