package nl.oliveira.rest.movie.title;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.oliveira.movie.title.usecase.TitleService;
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
@RequestMapping(path = "/api/titles")
public class TitleController {

  private final TitleService service;

  @ApiOperation(value = "List all titles filtered by primary or original title.")
  @GetMapping(value = "/{title}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TitleResponse>> find(final @PathVariable String title) {
    log.debug("Request to get a title: {}.", title);

    List<TitleResponse> titles = service.findByTitle(title).stream()
      .map(TitleResponse::from)
      .collect(Collectors.toList());

    return titles.isEmpty()
      ? notFound().build()
      : ok().body(titles);
  }

}
