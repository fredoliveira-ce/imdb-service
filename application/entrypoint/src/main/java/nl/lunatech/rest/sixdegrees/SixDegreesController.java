package nl.lunatech.rest.sixdegrees;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.lunatech.sixdegrees.SixDegreesService;
import nl.lunatech.sixdegrees.SixDegreesValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/six-degrees")
public class SixDegreesController {

  private static final String MAIN_GAME_ACTOR = "Kevin Bacon";

  private final SixDegreesValidator validator;
  private final SixDegreesService service;

  @GetMapping(value = "/{actorName}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<SixDegreesResponse> find(final @PathVariable String actorName) {
    log.info("Request to get the degree of separation between {} and {}.", actorName, MAIN_GAME_ACTOR);
    var stopWatch = new StopWatch();
    stopWatch.start();

    var source = validator.validateActor(actorName);
    var target = validator.validateActor(MAIN_GAME_ACTOR);

    final var nodes = service.playGame(source, target);

    stopWatch.stop();

    log.info("Degrees: {}, Path: {}", nodes.size() - 1, String.join(" -> ", nodes));
    log.info("The process took = {}ms", stopWatch.getTotalTimeMillis());
    return ok().body(
      SixDegreesResponse.builder()
        .elapsedTime(stopWatch.getTotalTimeSeconds())
        .degrees(nodes.size() - 1)
        .nodes(nodes)
        .build()
    );
  }

}
