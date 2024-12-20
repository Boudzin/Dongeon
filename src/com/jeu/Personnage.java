package com.jeu;

import java.util.ArrayList;
import java.util.List;

public class Personnage {
    private String nom;
    private String classe;
    private int force;
    private int defense;
    private int sante;
    private int mana;
    public List<String> objets;

    public Personnage(String nom, String classe, int force, int defense, int sante, int mana) {
        this.nom = nom;
        this.classe = classe;
        this.force = force;
        this.defense = defense;
        this.sante = sante;
        this.mana = mana;
        this.objets = new ArrayList<>();
    }

    public void afficherStatistiques() {
        System.out.println("Nom: " + nom);
        System.out.println("Classe: " + classe);
        System.out.println("Force: " + force);
        System.out.println("Défense: " + defense);
        System.out.println("Santé: " + sante);
        System.out.println("Mana: " + mana);
    }

    public int getForce() {
        return force;
    }

    public int getDefense() {
        return defense;
    }

    public int getSante() {
        return sante;
    }

    public void reduireSante(int degats) {
        sante -= degats;
        if (sante < 0) sante = 0;
    }

    public void augmenterDefense(int valeur) {
        defense += valeur;
    }

    public void utiliserObjet() {
        if (objets.isEmpty()) {
            System.out.println("Vous n'avez aucun objet à utiliser.");
            return;
        }

        String objet = objets.remove(0);
        System.out.println("Vous utilisez " + objet + " !");
        // Ajout des effets de l'objet ici
    }

    public void ajouterObjet(String objet) {
        objets.add(objet);
        System.out.println("Vous avez trouvé " + objet + " !");
    }
}
