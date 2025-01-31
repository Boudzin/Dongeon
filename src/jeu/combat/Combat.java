package jeu.combat;
import java.util.Scanner;

import jeu.monstres.Monstre;
import jeu.personnages.Personnage;

public class Combat {
	public Combat() {}
    public static void combattre(Personnage joueur, Monstre monstre, Scanner scanner) {
        while (joueur.estVivant() && monstre.estVivant()) {
            System.out.println("1. Attaquer  2. Défendre  3. Utiliser un objet");
            int choix = scanner.nextInt();
            scanner.nextLine();
            
            switch (choix) {
                case 1: joueur.attaquer(monstre); break;
                case 2: joueur.defendre(monstre); break;
                case 3: joueur.utiliserObjet(); break;
                default: System.out.println("Choix invalide");
            }
            
            if (monstre.estVivant()) monstre.attaquer(joueur);
        }
        System.out.println(joueur.estVivant() ? "Vous avez vaincu le monstre !" : "Vous êtes mort...");
    }
}