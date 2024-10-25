import java.util.Scanner;

public class Jeu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le Donjon!");
        Personnage joueur = creerPersonnage();
        joueur.afficherStatistiques();
    }

    
    public static Personnage creerPersonnage() {
        System.out.print("Entrez le nom de votre personnage : ");
        String nom = scanner.nextLine();

        // Choisir une classe de personnage
        System.out.println("Choisissez une classe : ");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Voleur");
        int choixClasse = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

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
}
