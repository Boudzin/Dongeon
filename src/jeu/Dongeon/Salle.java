package jeu.Dongeon;
import java.util.Scanner;

import jeu.monstres.Monstre;
import jeu.objet.Objet;
import jeu.personnages.Personnage;
import jeu.combat.*;

public class Salle {
    private int type;
    private Monstre monstre;
    private Objet objet;

    public Salle(int type) {
        this.type = type;
        if (type == 1) this.monstre = new Monstre("Gobelin", 8, 3, 30);
        if (type == 2) this.objet = new Objet("Potion de soin", 20);
    }
    
    public Salle(Monstre monstre) {
        this.monstre = monstre;
    }
    
    public void interaction(Personnage joueur, Scanner scanner) {
        if (monstre != null) {
            System.out.println("Un " + monstre.getNom() + " apparaît !");
            Combat combat = new Combat();
            Combat.combattre(joueur, monstre, scanner);
        } else if (objet != null) {
            System.out.println("Vous trouvez une " + objet.getNom() + " !");
            joueur.ajouterObjet(objet);
        } else {
            System.out.println("La salle est vide.");
        }
    }
    
    public boolean contientMonstre() {
        return monstre != null && monstre.estVivant();
    }
    
    public boolean peutQuitterSalleSansCombat() {
        return monstre == null || !monstre.estVivant();
    }
}