package nl.lunatech.sixdegress;

import nl.lunatech.sixdegrees.SixDegreesService;
import nl.lunatech.sixdegrees.dataprovider.SixDegreesDao;
import nl.lunatech.sixdegrees.exception.NodeNotFoundException;
import nl.lunatech.sixdegrees.usecase.GraphBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static nl.lunatech.sixdegress.templates.MoviesTemplate.buildPerson;
import static nl.lunatech.sixdegress.templates.MoviesTemplate.load;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
@DisplayName("Runs all tests for service layer")
class SixDegreesServiceTest {

  @Mock
  private SixDegreesDao dao;

  @Spy
  private GraphBuilder graphBuilder;

  @InjectMocks
  private SixDegreesService service;

  @Test
  @DisplayName("Play the game and find the target in six degrees")
  void shouldFindTheLowestPathInSixDegree() {
    Mockito.when(dao.loadData(anyInt(), anyInt())).thenReturn(load());
    Mockito.when(dao.loadData(any())).thenReturn(load());

    List<String> paths = service.playGame(buildPerson("Rachel McAdams"), buildPerson("Kevin Bacon"));

    assertEquals(7, paths.size());
    assertEquals(List.of(
        "Rachel McAdams", "Spotlight", "Billy Crudup", "Eat Pray Love", "Julia Roberts", "Flatliners", "Kevin Bacon"),
      paths);
  }

  @Test
  @DisplayName("Play the game and find the target in two degrees")
  void shouldFindTheLowestPathThreeOneDegree() {
    Mockito.when(dao.loadData(anyInt(), anyInt())).thenReturn(load());
    Mockito.when(dao.loadData(any())).thenReturn(load());

    List<String> paths = service.playGame(buildPerson("Julia Roberts"), buildPerson("Kevin Bacon"));

    assertEquals(3, paths.size());
    assertEquals(
      List.of("Julia Roberts", "Flatliners", "Kevin Bacon"),
      paths);
  }

  @Test
  @DisplayName("Should throw NodeNotFoundException when the source node is not found")
  void shouldThrowNodeNotFoundExceptionWithUnknownSourceNode() {
    Mockito.when(dao.loadData(anyInt(), anyInt())).thenReturn(load());
    Mockito.when(dao.loadData(any())).thenReturn(load());
    String person = "Fred Oliveira";

    final var exception = assertThrows(NodeNotFoundException.class,
      () -> service.playGame(buildPerson(person), buildPerson("Kevin Bacon"))
    );

    load();

    assertEquals(String.format("%s was not found!", person), exception.getMessage());
  }

  @Test
  @DisplayName("Should throw NodeNotFoundException when the target node is not found")
  void shouldThrowNodeNotFoundExceptionWithUnknownTargetNode() {
    Mockito.when(dao.loadData(anyInt(), anyInt())).thenReturn(load());
    Mockito.when(dao.loadData(any())).thenReturn(load());
    String person = "Julia Roberts";

    final var exception = assertThrows(NodeNotFoundException.class,
      () -> service.playGame(buildPerson(person), buildPerson("Fred Oliveira"))
    );

    load();

    assertEquals(String.format("%s was not found!", person), exception.getMessage());
  }


  //TODO Test cases with more than 6 degrees. Should it throw an exception?


}
