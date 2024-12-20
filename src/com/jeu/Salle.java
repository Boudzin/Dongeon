package com.jeu;

public class Salle {
    private int evenement; // 0: vide, 1: monstre, 2: trésor

    public Salle(int evenement) {
        this.evenement = evenement;
    }

    public int getEvenement() {
        return evenement;
    }

    public void afficherEvenement() {
        switch (evenement) {
            case 0:
                System.out.println("La salle est vide.");
                break;
            case 1:
                System.out.println("Un monstre vous attend dans cette salle !");
                break;
            case 2:
                System.out.println("Vous trouvez un trésor !");
                break;
        }
    }
}
