package exmvn;

// Dans ce fichier, je manipule les dates pour me familiariser avec

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DTY {

  public static void main(String[] args) {
    // Pour simuler des dates
    var horloge = Clock.systemUTC();
    // Dates
    var aujourdhui = LocalDate.now(horloge);
    var apresDemain = aujourdhui.plusDays(2);
    var noel = LocalDate.of(2024, Month.DECEMBER, 25);

    // System.out.println(apresDemain);
    // System.out.println(noel);

    //  Formatages
    // System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate((FormatStyle.SHORT))));
    // System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate((FormatStyle.MEDIUM))));
    // System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate((FormatStyle.LONG))));
    // System.out.println(noel.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    // Lectures
    var printemps = LocalDate.parse(
      "20/03/2025",
      DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(
        Locale.FRANCE
      )
    );

    // System.out.println(printemps.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.FRANCE)));

    // Heures
    var maintenant = LocalTime.now(horloge);

    System.out.println(
      maintenant.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
    );
    System.out.println(
      maintenant.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
    );
    System.out.println(maintenant.format(DateTimeFormatter.ISO_TIME));

    // Date + heure / fuseaux
    var nouvelAn = LocalDateTime.of(2025, 1, 1, 0, 0, 0, 0);
    var nouvelAnParisIs = ZonedDateTime.of(nouvelAn, ZoneId.of("Europe/Paris"));
    var nouvelAnGreenwish = OffsetDateTime.of(nouvelAn, ZoneOffset.ofHours(0));

    if (nouvelAnParisIs.toInstant().isBefore(nouvelAnGreenwish.toInstant())) {
      System.out.println("Paris change d'année avant le méridine 0");
    } else {
      System.out.println("Paris change d'année après ou avec le méridine 0");
    }
  }
}
