package nl.oliveira.rest.movie.rating;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.oliveira.movie.rating.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/ratings")
public class RatingController {

  private final RatingService service;

  @ApiOperation(value = "List the top 10 rated filtered by a genre.")
  @GetMapping(value = "/{genre}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<RatingResponse>> find(final @PathVariable String genre) {
    log.debug("Request to get ratings: {}.", genre);

    List<RatingResponse> topRated = service.findTopRatedBy(genre).stream()
      .map(RatingResponse::from)
      .collect(Collectors.toList());

    return topRated.isEmpty()
      ? notFound().build()
      : ok().body(topRated);
  }

}
