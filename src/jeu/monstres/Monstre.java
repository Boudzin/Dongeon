package jeu.monstres;

import jeu.personnages.*;

public class Monstre {
    private String nom;
    private int force;
    private int defense;
    private int sante;

    public Monstre(String nom, int force, int defense, int sante) {
        this.nom = nom;
        this.force = force;
        this.defense = defense;
        this.setSante(sante);
    }

    public void attaquer(Personnage joueur) {
        joueur.recevoirDegats(force);
    }

    public boolean estVivant() { return getSante() > 0; }

    public String getNom() {
        return nom;
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

    public void recevoirDegats(int degats) {
        setSante(getSante() - degats);
    }

	public void setSante(int sante) {
		this.sante = sante;
	}
}
