import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private static Scanner scanner = new Scanner(System.in);
    private static Salle[][] donjon;
    private static int tailleDonjon = 5; // Taille du donjon (5x5)
    private static int positionX = 0; // Position initiale du joueur (X)
    private static int positionY = 0; // Position initiale du joueur (Y)

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le Donjon!");
        Personnage joueur = creerPersonnage();
        joueur.afficherStatistiques();

        genererDonjon();
        explorerDonjon(joueur);
    }

    public static Personnage creerPersonnage() {
        String nom;
        while (true) {
            System.out.print("Entrez le nom de votre personnage (au moins 4 caractères et 22 au maximum) : ");
            nom = scanner.nextLine();

            if (verifierNom(nom)) {
                break;
            } else {
                System.out.println("Nom invalide. Assurez-vous qu'il contient au moins 4 caractères et 22 au maximum.");
            }
        }

        System.out.println("Choisissez une classe : ");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Voleur");
        int choixClasse = scanner.nextInt();
        scanner.nextLine();

        String classe;
        int force, defense, sante, mana;

        switch (choixClasse) {
            case 1:
                classe = "Guerrier";
                force = 10;
                defense = 8;
                sante = 100;
                mana = 5;
                break;
            case 2:
                classe = "Mage";
                force = 4;
                defense = 5;
                sante = 80;
                mana = 20;
                break;
            case 3:
                classe = "Voleur";
                force = 7;
                defense = 6;
                sante = 90;
                mana = 10;
                break;
            default:
                System.out.println("Choix invalide, un Guerrier a été sélectionné par défaut.");
                classe = "Guerrier";
                force = 10;
                defense = 8;
                sante = 100;
                mana = 5;
        }

        return new Personnage(nom, classe, force, defense, sante, mana);
    }

    private static boolean verifierNom(String nom) {
        return nom.length() >= 4 && nom.length() < 23;
    }

    private static void genererDonjon() {
        donjon = new Salle[tailleDonjon][tailleDonjon];
        Random random = new Random();

        for (int i = 0; i < tailleDonjon; i++) {
            for (int j = 0; j < tailleDonjon; j++) {
                int evenement = random.nextInt(3); // 0: vide, 1: monstre, 2: trésor
                donjon[i][j] = new Salle(evenement);
            }
        }
        System.out.println("Le donjon a été généré !");
    }

    private static void explorerDonjon(Personnage joueur) {
        while (true) {
            System.out.println("\nVous êtes dans la salle [" + positionX + ", " + positionY + "].");
            Salle salleActuelle = donjon[positionX][positionY];
            salleActuelle.afficherEvenement();

            if (salleActuelle.getEvenement() == 1) {
                Monstre monstre = new Monstre("Gobelin", 50, 8, 3);
                lancerCombat(joueur, monstre);
            }

            System.out.println("Déplacez-vous : ");
            System.out.println("1. Nord");
            System.out.println("2. Sud");
            System.out.println("3. Est");
            System.out.println("4. Ouest");
            System.out.println("5. Quitter le donjon");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    if (positionX > 0) positionX--;
                    else System.out.println("Vous ne pouvez pas aller plus au nord.");
                    break;
                case 2:
                    if (positionX < tailleDonjon - 1) positionX++;
                    else System.out.println("Vous ne pouvez pas aller plus au sud.");
                    break;
                case 3:
                    if (positionY < tailleDonjon - 1) positionY++;
                    else System.out.println("Vous ne pouvez pas aller plus à l'est.");
                    break;
                case 4:
                    if (positionY > 0) positionY--;
                    else System.out.println("Vous ne pouvez pas aller plus à l'ouest.");
                    break;
                case 5:
                    System.out.println("Vous quittez le donjon. Merci d'avoir joué !");
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private static void lancerCombat(Personnage joueur, Monstre monstre) {
        System.out.println("Un combat commence contre " + monstre.getNom() + " !");
        while (monstre.getSante() > 0 && joueur.getSante() > 0) {
            System.out.println("\n=== Tour du joueur ===");
            System.out.println("1. Attaquer");
            System.out.println("2. Se défendre");
            System.out.println("3. Utiliser un objet");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    int degats = joueur.getForce();
                    monstre.reduireSante(degats);
                    System.out.println("Vous infligez " + degats + " dégâts au " + monstre.getNom());
                    break;
                case 2:
                    System.out.println("Vous vous défendez, réduisant les dégâts reçus au prochain tour.");
                    joueur.augmenterDefense(5);
                    break;
                case 3:
                    joueur.utiliserObjet();
                    break;
                default:
                    System.out.println("Action invalide.");
            }

            if (monstre.getSante() > 0) {
                System.out.println("\n=== Tour du monstre ===");
                int degatsMonstre = Math.max(monstre.getForce() - joueur.getDefense(), 0);
                joueur.reduireSante(degatsMonstre);
                System.out.println("Le " + monstre.getNom() + " vous inflige " + degatsMonstre + " dégâts.");
            }
        }

        if (joueur.getSante() > 0) {
            System.out.println("Vous avez vaincu le " + monstre.getNom() + " !");
            joueur.ajouterObjet("Potion de soin");
        } else {
            System.out.println("Vous êtes mort. Fin du jeu.");
            System.exit(0);
        }
    }
}
