import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personnage {
    private String nom;
    private String classe;
    private int force;
    private int defense;
    private int sante;
    private int mana;
    private List<String> inventaire;
    private Scanner scanner = new Scanner(System.in);

    public Personnage(String nom, String classe, int force, int defense, int sante, int mana) {
        this.nom = nom;
        this.classe = classe;
        this.force = force;
        this.defense = defense;
        this.sante = sante;
        this.mana = mana;
        this.inventaire = new ArrayList<>();
    }

    public void afficherStatistiques() {
        System.out.println("=== Statistiques du personnage ===");
        System.out.println("Nom : " + nom);
        System.out.println("Classe : " + classe);
        System.out.println("Force : " + force);
        System.out.println("Défense : " + defense);
        System.out.println("Santé : " + sante);
        System.out.println("Mana : " + mana);
        System.out.println("Inventaire : " + inventaire);
    }

    public void ajouterObjet(String objet) {
        inventaire.add(objet);
        System.out.println("Vous avez trouvé : " + objet + ". Ajouté à l'inventaire !");
    }

    public void utiliserObjet() {
        if (inventaire.isEmpty()) {
            System.out.println("Votre inventaire est vide.");
            return;
        }

        System.out.println("=== Inventaire ===");
        for (int i = 0; i < inventaire.size(); i++) {
            System.out.println((i + 1) + ". " + inventaire.get(i));
        }
        System.out.print("Choisissez un objet à utiliser (numéro) : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consomme la ligne restante

        if (choix > 0 && choix <= inventaire.size()) {
            String objet = inventaire.get(choix - 1);
            switch (objet) {
                case "Potion de soin":
                    sante = Math.min(sante + 20, 100);
                    System.out.println("Vous utilisez une Potion de soin et récupérez 20 points de santé !");
                    break;
                default:
                    System.out.println("Cet objet ne peut pas être utilisé.");
            }
            inventaire.remove(objet);
        } else {
            System.out.println("Choix invalide.");
        }
    }

    public void reduireSante(int degats) {
        sante -= degats;
        if (sante < 0) sante = 0;
    }

    public void augmenterDefense(int valeur) {
        defense += valeur;
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
}
