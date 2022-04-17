package nl.oliveira.sixdegrees;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.oliveira.movie.person.usecase.Person;
import nl.oliveira.movie.title.usecase.Title;
import nl.oliveira.sixdegrees.dataprovider.SixDegreesDao;
import nl.oliveira.sixdegrees.exception.NodeNotFoundException;
import nl.oliveira.sixdegrees.usecase.GraphBuilder;
import nl.oliveira.sixdegrees.usecase.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;
import static nl.oliveira.sixdegrees.usecase.BreadthFirstSearch.searchUsingBreadthFirst;

@Slf4j
@Service
@RequiredArgsConstructor
public class SixDegreesService {

  public static final int PAGE_SIZE = 5000;
  private final SixDegreesDao dataLoader;
  private final GraphBuilder graphBuilder;

  private final Set<Title> movies = new HashSet<>();

  public List<String> playGame(final Person source, final Person target) {
    movies.addAll(dataLoader.loadData(source.getId()));
    movies.addAll(dataLoader.loadData(target.getId()));
    movies.addAll(dataLoader.loadData(PAGE_SIZE, 0));

    var graph = graphBuilder.buildGraph(movies);
    final var startNode = graph.setStart(source.getId());
    final var endNode = graph.setEnd(target.getId());

    if (isNull(startNode) || isNull(endNode)) {
      throw new NodeNotFoundException(source.getId());
    }

    searchUsingBreadthFirst(startNode, endNode);

    return buildReversePath(endNode);
  }

  private ArrayList<String> buildReversePath(final Node endNode) {
    var path = new ArrayList<Node>();

    connectNodes(endNode, path);

    return reversePath(path);
  }

  private void connectNodes(Node endNode, ArrayList<Node> path) {
    path.add(endNode);

    var next = endNode.getParent();
    while (next != null) {
      path.add(next);
      next = next.getParent();
    }
  }

  private ArrayList<String> reversePath(ArrayList<Node> path) {
    var reversePath = new ArrayList<String>();
    for (int i = path.size() - 1; i >= 0; i--) {
      reversePath.add(path.get(i).getValue());
    }
    return reversePath;
  }

  private void diveInSearchPaginated(int limit, int offset) {
    log.info("Try to fetch more data with limit {} and offset {}", limit, offset);
    movies.addAll(dataLoader.loadData(limit, offset));
  }

}
