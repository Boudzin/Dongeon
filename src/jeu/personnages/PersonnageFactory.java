package jeu.personnages;

public class PersonnageFactory {
	public PersonnageFactory() {}
    public static Personnage creerPersonnage(String nom, int choixClasse) {
        switch (choixClasse) {
            case 1: return new Guerrier(nom);
            case 2: return new Mage(nom);
            case 3: return new Voleur(nom);
            default: throw new IllegalArgumentException("Classe invalide");
        }
    }
}