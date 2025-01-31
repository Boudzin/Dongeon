package jeu.objet;

public class Objet {
    private String nom;
    private int effet;

    public Objet(String nom, int effet) {
        this.nom = nom;
        this.effet = effet;
    }

    public String getNom() { return nom; }
    public int getEffet() { return effet; }
}