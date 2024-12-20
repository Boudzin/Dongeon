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

    public String getNom() {
        return nom;
    }

    public String getClasse() {
        return classe;
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

    public int getMana() {
        return mana;
    }

    public void reduireSante(int degats) {
        sante -= degats;
        if (sante < 0) sante = 0;
    }

    public void ajouterObjet(String objet) {
        objets.add(objet);
    }

    public void utiliserObjet() {
        if (!objets.isEmpty()) {
            objets.remove(0);
            System.out.println("Objet utilisé : " + objets.get(0));
        } else {
            System.out.println("Aucun objet à utiliser.");
        }
    }

    public void augmenterDefense(int valeur) {
        defense += valeur;
    }

    public void afficherStatistiques() {
        System.out.println("Nom : " + nom);
        System.out.println("Classe : " + classe);
        System.out.println("Force : " + force);
        System.out.println("Défense : " + defense);
        System.out.println("Santé : " + sante);
        System.out.println("Mana : " + mana);
        System.out.println("Objets : " + objets);
    }
}
