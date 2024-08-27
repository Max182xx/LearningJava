package exmvn;

import java.util.regex.Pattern;

public class ExpressionsReguliers {

  public static void main(String[] args) {
    String texte =
      "\"Il y a 2 sortes d'amour : l'amour insatisfait, qui vous rend odieux, l'amour satisfait, qui vous rend idiot.\" Colette (1873-1954)";

    // Citation : "[A-Z].*\." \w+ \([-0-9]+\)

    // Valider
    var citation = Pattern.compile("\"[A-Z].*\\.\" \\w+ \\([-0-9]+\\)");
    if (citation.matcher(texte).matches()) {
      System.out.println("C'est une citation");
    } else {
      System.out.println("Ce n'est pas une citation");
    }
    // Trouver
    var nombre = Pattern.compile("\\d+");
    var occurenceNombre = nombre.matcher(texte);
    var compteur = 0;

    while (occurenceNombre.find()) {
      compteur++;
    }

    //System.out.printf("%d nombres ont été trouvés. \n", compteur);

    // Extraire
    var construction = Pattern.compile("l'amour (\\w+), qui vous rend (\\w+)");
    var occurrence = construction.matcher(texte);

    while (occurrence.find()) {
      System.out.printf(
        "%s : %s/%s. \n",
        occurrence.group(0),
        occurrence.group(1),
        occurrence.group(2)
      );
    }
  }
}
