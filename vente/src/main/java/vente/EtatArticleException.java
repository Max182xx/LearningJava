package vente;

public class EtatArticleException extends Exception {
    private Article article;
 
    public EtatArticleException(Article article, String message) {
       super(message);
       this.article = article;
    }
 
    public Article article() {
       return this.article;
    }
 }
 
