package nl.lunatech.sixdegrees.usecase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BreadthFirstSearch {

  public static void searchUsingBreadthFirst(final Node startNode, final Node endNode) {
    final var queue = new LinkedList<Node>();
    startNode.setVisited(true);
    queue.add(startNode);

    while (hasQueue(queue)) {
      var currentNode = queue.remove();
      if (isTargetFound(endNode, currentNode)) {
        break;
      }

      currentNode.getEdges()
        .forEach(neighbor -> checkVisit(queue, currentNode, neighbor));
    }
  }

  private static void checkVisit(LinkedList<Node> queue, Node currentNode, Node neighbor) {
    if (notVisited(neighbor)) {
      neighbor.setVisited(true);
      neighbor.setParent(currentNode);
      queue.add(neighbor);
    }
  }

  private static boolean notVisited(Node neighbor) {
    return !neighbor.isVisited();
  }

  private static boolean hasQueue(List<Node> queue) {
    return !queue.isEmpty();
  }

  private static boolean isTargetFound(Node endNode, Node current) {
    return current == endNode;
  }

}
