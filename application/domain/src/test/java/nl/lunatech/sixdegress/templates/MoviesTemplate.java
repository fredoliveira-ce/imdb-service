package nl.lunatech.sixdegress.templates;

import nl.lunatech.movie.cast.usecase.Cast;
import nl.lunatech.movie.person.usecase.Person;
import nl.lunatech.movie.title.usecase.Title;

import java.util.List;

public class MoviesTemplate {

  public static List<Title> load() {
    return List.of(
      Title.builder().id("Diner")
        .cast(
          List.of(
            buildCast("Steve Guttenberg"),
            buildCast("Daniel Stern"),
            buildCast("Mickey Rourke"),
            buildCast("Kevin Bacon"),
            buildCast("Tim Daly"),
            buildCast("Ellen Barkin"),
            buildCast("Paul Reiser"),
            buildCast("Kathryn Dowling"),
            buildCast("Michael Tucker"),
            buildCast("Jessica James"),
            buildCast("Colette Blonigan"),
            buildCast("Kelle Kipp"),
            buildCast("Clement Fowler"),
            buildCast("Claudia Cron"))
        ).build(),
      Title.builder().id("Footloose")
        .cast(
          List.of(
            buildCast("Kevin Bacon"),
            buildCast("Lori Singer"),
            buildCast("Dianne Wiest"),
            buildCast("John Lithgow"),
            buildCast("Sarah Jessica Parker"),
            buildCast("Chris Penn"),
            buildCast("Frances Lee McCain"),
            buildCast("Jim Youngs"),
            buildCast("John Laughlin"),
            buildCast("Lynne Marta"),
            buildCast("Douglas Dirkson"))
        ).build(),
      Title.builder().id("Flatliners")
        .cast(
          List.of(
            buildCast("Kiefer Sutherland"),
            buildCast("Julia Roberts"),
            buildCast("Kevin Bacon"),
            buildCast("William Baldwin"),
            buildCast("Oliver Platt"),
            buildCast("Kimberly Scott"),
            buildCast("Joshua Rudoy"),
            buildCast("Benjamin Mouton"),
            buildCast("Hope Davis"),
            buildCast("Patricia Belcher"),
            buildCast("Beth Grant"))
        ).build(),
      Title.builder().id("Eat Pray Love")
        .cast(
          List.of(
            buildCast("Julia Roberts"),
            buildCast("Javier Bardem"),
            buildCast("Billy Crudup"),
            buildCast("Richard Jenkins"),
            buildCast("Viola Davis"),
            buildCast("James Franco"),
            buildCast("Sophie Thompson"),
            buildCast("Mike O 'Malley"),
            buildCast("Christine Hakim"),
            buildCast("Arlene Tur"),
            buildCast("Hadi Subiyanto"),
            buildCast("Gita Reddy"),
            buildCast("Tuva Novotny"),
            buildCast("Luca Argentero"),
            buildCast("Rushita Singh"))
        ).build(),
      Title.builder().id("Spotlight")
        .cast(
          List.of(
            buildCast("Mark Ruffalo"),
            buildCast("Michael Keaton"),
            buildCast("Rachel McAdams"),
            buildCast("Liev Schreiber"),
            buildCast("John Slattery"),
            buildCast("Brian d'Arcy James"),
            buildCast("Stanley Tucci"),
            buildCast("Gene Amoroso"),
            buildCast("Jamey Sheridan"),
            buildCast("Billy Crudup"),
            buildCast("Maureen Keiller"),
            buildCast("Richard Jenkins"),
            buildCast("Paul Guilfoyle"),
            buildCast("Len Cariou"),
            buildCast("Neal Huff"),
            buildCast("Michael Cyril Creighton"),
            buildCast("Laurie Heineman"),
            buildCast("Tim Progosh"))
        ).build()
    );
  }

  public static Person buildPerson(String s) {
    return Person.builder().id(s).build();
  }

  public static Cast buildCast(String s) {
    return Cast.builder().personId(s).build();
  }
}
