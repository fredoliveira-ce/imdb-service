package nl.oliveira.sixdegrees.usecase;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class  Graph {

  private List<Node> nodes;
  private HashMap<String, Node> graphMap;
  private Node start;
  private Node end;

  public Graph() {
    this.nodes = new ArrayList<>();
    this.graphMap = new HashMap<>();
  }

  public void addNode(Node node) {
    nodes.add(node);
    var title = node.getValue();
    this.graphMap.put(title, node);
  }

  public Node getNode(String actor) {
    return this.graphMap.get(actor);
  }

  public Node setStart(String actor) {
    this.start = this.graphMap.get(actor);
    return this.start;
  }

  public Node setEnd(String actor) {
    this.end = this.graphMap.get(actor);
    return this.end;
  }
}
