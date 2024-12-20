package com.jeu;

public class Monstre {
    private String nom;
    private int sante;
    private int force;
    private int defense;

    public Monstre(String nom, int sante, int force, int defense) {
        this.nom = nom;
        this.sante = sante;
        this.force = force;
        this.defense = defense;
    }

    public String getNom() {
        return nom;
    }

    public int getSante() {
        return sante;
    }

    public int getForce() {
        return force;
    }

    public void reduireSante(int degats) {
        sante -= degats;
        if (sante < 0) sante = 0;
    }
}
