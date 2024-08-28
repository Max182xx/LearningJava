package vente;

import java.time.Instant;


public class Article {
   private final String nom;
   private final double prixHt;
   private Instant abandonne;

   public Article(String nom, double prixHt) {
      this.abandonne = Instant.MAX;
      if (nom == null) {
         throw new NullPointerException("Le nom de l'article doit \u00eatre renseign\u00e9.");
      } else if (nom.length() < 2) {
         throw new IllegalArgumentException("Le nom de l'article doit faire au moins 2 caract\u00e8res.");
      } else if (prixHt <= 0.0) {
         throw new IllegalArgumentException("Le prix doit \u00eatre strictement positif.");
      } else {
         this.nom = nom;
         this.prixHt = prixHt;
      }
   }

   public String nom() {
      return this.nom;
   }

   public boolean estAbandonne() {
      return this.abandonne != Instant.MAX;
   }

   public Instant abandonne() {
      return this.abandonne;
   }

   public void abandonner(Instant moment) {
      this.abandonne = moment;
   }

   public double prixHt() throws EtatArticleException {
      if (this.estAbandonne()) {
         throw new EtatArticleException(this, "Article abandonn\u00e9, pas de prix disponible.");
      } else {
         return this.prixHt;
      }
   }

   public double prixTTC(double tva) throws EtatArticleException {
      if (tva <= 0.0) {
         throw new IllegalArgumentException("Le taux de tva doit \u00eatre strictement positif.");
      } else {
         return this.prixHt() * (1.0 + tva);
      }
   }

   @Override
   public String toString() {
      return this.estAbandonne() ? String.format("%s (abandonn\u00e9)", this.nom()) : String.format("%s (%.2f)", this.nom(), this.prixHt);
   }
}
