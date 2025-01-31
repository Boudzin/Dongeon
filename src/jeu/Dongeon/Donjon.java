package jeu.Dongeon;
import java.util.Random;
import java.util.Scanner;

import jeu.personnages.Personnage;

public class Donjon {
    private Salle[][] salles;
    private int taille;
    private int joueurX;
    private int joueurY;

    public Donjon(int taille) {
        this.taille = taille;
        this.salles = new Salle[taille][taille];
        genererDonjon();
        joueurX = taille / 2;
        joueurY = taille / 2;
    }

    private void genererDonjon() {
        Random rand = new Random();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                salles[i][j] = new Salle(rand.nextInt(3));
            }
        }
    }

    public void explorer(Personnage joueur, Scanner scanner) {
        while (true) {
            System.out.println("Vous êtes dans une nouvelle salle.");
            salles[joueurX][joueurY].interaction(joueur, scanner);
            System.out.println("Où voulez-vous aller ? (nord, sud, est, ouest, quitter)");
            String direction = scanner.nextLine();
            if (direction.equals("quitter")) break;
            deplacer(direction);
        }
    }

    private void deplacer(String direction) {
        switch (direction) {
            case "nord": if (joueurY > 0) joueurY--; break;
            case "sud": if (joueurY < taille - 1) joueurY++; break;
            case "est": if (joueurX < taille - 1) joueurX++; break;
            case "ouest": if (joueurX > 0) joueurX--; break;
            default: System.out.println("Mouvement invalide");
        }
    }
    
    public boolean deplacerJoueur(int x, int y, String direction) {
        switch (direction) {
            case "nord": return y > 0;
            case "sud": return y < taille - 1;
            case "est": return x < taille - 1;
            case "ouest": return x > 0;
            default: return false;
        }
    }
    
    public int getTaille() {
        return taille;
    }
    
    public boolean verifierConnexionsValides() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if ((i > 0 && salles[i - 1][j] == null) ||
                    (i < taille - 1 && salles[i + 1][j] == null) ||
                    (j > 0 && salles[i][j - 1] == null) ||
                    (j < taille - 1 && salles[i][j + 1] == null)) {
                    return false;
                }
            }
        }
        return true;
    }
}