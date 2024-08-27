package exmvn;

import java.util.Arrays;

public class TraiterDuTexte {

  public static void main(String[] args) {
    var fruits =
      "Citron, Kiwi, Mandarine, Orange, Noix, Pommes, Châtaigne, Dattes";
    var liste = fruits.split(",");

    Arrays.sort(liste);
    for (var f : liste) {
    //  System.out.println(f.toUpperCase());
    }

    // Bonne pratique pour créer une chaîne de caractères en utilisant peu de mémoire
    var tri = new StringBuilder();
    var sep = "";

    for (var f : liste ){
        tri.append(sep);
        tri.append(f);
        sep = ", ";
    }
    System.err.println(tri.toString());
  }
}
