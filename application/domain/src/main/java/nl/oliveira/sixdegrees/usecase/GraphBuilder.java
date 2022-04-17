package nl.oliveira.sixdegrees.usecase;

import nl.oliveira.movie.title.usecase.Title;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.isNull;

@Component
public class GraphBuilder {

  public Graph buildGraph(Set<Title> movies) {
    final var graph = new Graph();

    movies.forEach(title -> {
      var movieNode = new Node(title.getId());
      graph.addNode(movieNode);
      connectVertex(graph, title, movieNode);
    });

    return graph;
  }

  private void connectVertex(Graph graph, Title title, Node movieNode) {
    title.getCast().forEach(cast -> {
      var person = cast.getPersonId();
      var node = isNull(graph.getNode(person)) ? new Node(person) : graph.getNode(person);

      graph.addNode(node);
      movieNode.addEdges(node);
    });
  }

}
