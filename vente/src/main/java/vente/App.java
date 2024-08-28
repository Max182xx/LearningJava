package vente;

import java.time.Clock;
import java.time.Instant;

public class App {
   public App() {
   }

   public static void main(String[] args) {
      Clock horloge = Clock.systemUTC();
      double tva = 0.2;
      Article article = new Article("Skateboard", 39.9);

      try {
         article.abandonner(Instant.now(horloge));
         System.out.println(article);
         System.out.printf("%s : %.2f euros TTC\n", article.nom(), article.prixTTC(tva));
      } catch (EtatArticleException var10) {
         System.err.printf("Mauvaise gestion de l'\u00e9tat de l'article %s.\n", var10.article());
      } catch (IllegalArgumentException var11) {
         System.err.println("Bug non g\u00e9r\u00e9.");
         var11.printStackTrace();
      } finally {
         System.out.println("Fin de l'application");
      }

   }
}
