package jeu.personnages;
import java.util.ArrayList;

import jeu.objet.*;
import jeu.monstres.*;
import java.util.List;

public abstract class Personnage {
    public String nom;
    public int force;
    public int defense;
    public int sante;
    public int mana;
    public List<Objet> inventaire;

    public Personnage(String nom, int force, int defense, int sante, int mana) {
		if (nom.length() < 3 || nom.length() > 15) {
	        throw new IllegalArgumentException("Le nom du personnage doit contenir entre 3 et 15 caractères.");
	    }
        this.nom = nom;
        this.force = force;
        this.defense = defense;
        this.sante = sante;
        this.mana = mana;
        this.inventaire = new ArrayList<>();
    }

    public void attaquer(Monstre monstre) {
        int degats = Math.max(force - monstre.getDefense(), 1);
        monstre.setSante(monstre.getSante() - degats);
        System.out.println(nom + " attaque et inflige " + degats + " dégâts au " + monstre.getNom());
    }

    public void defendre(Monstre monstre) {
        int degats = Math.max(monstre.getForce() - (defense * 2), 0);
        sante -= degats;
        System.out.println(nom + " se défend et réduit les dégâts à " + degats);
    }

    public void recevoirDegats(int degats) {
        sante -= degats;
    }

    public boolean estVivant() {
        return sante > 0;
    }

    public void ajouterObjet(Objet objet) {
        inventaire.add(objet);
        System.out.println(nom + " ajoute " + objet.getNom() + " à son inventaire.");
    }

    public void utiliserObjet() {
        if (!inventaire.isEmpty()) {
            Objet objet = inventaire.remove(0);
            sante += objet.getEffet();
            System.out.println(nom + " utilise " + objet.getNom() + " et récupère " + objet.getEffet() + " points de santé.");
        } else {
            System.out.println("Aucun objet à utiliser.");
        }
    }
    
    public void afficherInventaire() {
        if (inventaire.isEmpty()) {
            System.out.println("Inventaire vide.");
        } else {
            System.out.println("Inventaire de " + nom + " :");
            for (Objet objet : inventaire) {
                System.out.println("- " + objet.getNom());
            }
        }
    }
}
