import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personnage {
    private String nom;
    private String classe;
    private int force;
    private int defense;
    private int sante;
    private int mana;
    private List<String> inventaire;

    // Constructeur
    public Personnage(String nom, String classe, int force, int defense, int sante, int mana) {
        this.nom = nom;
        this.classe = classe;
        this.force = force;
        this.defense = defense;
        this.sante = sante;
        this.mana = mana;
        this.inventaire = new ArrayList<>();
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public String getClasse() { return classe; }
    public int getForce() { return force; }
    public int getDefense() { return defense; }
    public int getSante() { return sante; }
    public int getMana() { return mana; }
    public List<String> getInventaire() { return inventaire; }

    // Méthode d'affichage du personnage
    public void afficherStatistiques() {
        System.out.println("Nom : " + nom);
        System.out.println("Classe : " + classe);
        System.out.println("Force : " + force);
        System.out.println("Défense : " + defense);
        System.out.println("Santé : " + sante);
        System.out.println("Mana : " + mana);
        System.out.println("Inventaire : " + inventaire);
    }
}
