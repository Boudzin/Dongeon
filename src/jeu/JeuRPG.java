package jeu;
import java.util.Scanner;

import jeu.personnages.Personnage;
import jeu.personnages.PersonnageFactory;
import jeu.Dongeon.*;

public class JeuRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le RPG !");
        
        String nom;
        do {
            System.out.print("Entrez le nom de votre personnage (3-15 caractères) : ");
            nom = scanner.nextLine();
            if (nom.length() < 3 || nom.length() > 15) {
                System.out.println("Nom invalide. Il doit contenir entre 3 et 15 caractères.");
            }
        } while (nom.length() < 3 || nom.length() > 15);
        
        System.out.println("Choisissez votre classe : 1. Guerrier  2. Mage  3. Voleur");
        int choixClasse = scanner.nextInt();
        scanner.nextLine();
        
        PersonnageFactory personnageFactory = new PersonnageFactory();
        Personnage joueur = personnageFactory.creerPersonnage(nom, choixClasse);
        System.out.println("Personnage créé : " + joueur);
        
        Donjon donjon = new Donjon(5);
        while (true) {
            System.out.println("Que voulez-vous faire ? (1. Explorer 2. Voir l'inventaire 3. Quitter)");
            int choix = scanner.nextInt();
            scanner.nextLine();
            
            if (choix == 1) {
                donjon.explorer(joueur, scanner);
            } else if (choix == 2) {
                joueur.afficherInventaire();
            } else if (choix == 3) {
                break;
            } else {
                System.out.println("Choix invalide, réessayez.");
            }
        }
        
        scanner.close();
    }
}