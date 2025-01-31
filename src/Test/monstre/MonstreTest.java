package Test.monstre;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.monstres.Monstre;
import jeu.Dongeon.*;
import jeu.personnages.*;

class MonstreTest {
	

    @Test
    void testRencontreMonstre() {
        Personnage joueur = new Guerrier("Arthur");
        Monstre monstre = new Monstre("Gobelin", 5, 2, 20);
        Salle salleAvecMonstre = new Salle(monstre);
        
        assertTrue(salleAvecMonstre.contientMonstre());
        assertFalse(salleAvecMonstre.peutQuitterSalleSansCombat());
        
        joueur.attaquer(monstre);
        while (monstre.estVivant()) {
            joueur.attaquer(monstre);
        }
        
        assertFalse(monstre.estVivant());
        assertTrue(salleAvecMonstre.peutQuitterSalleSansCombat());
    }
	 
	@Test
    void testAttaqueJoueur() {
        Personnage joueur = new Guerrier("Arthur");
        Monstre monstre = new Monstre("Gobelin", 5, 2, 20);
        
        int santeInitiale = monstre.getSante();
        joueur.attaquer(monstre);
        
        assertTrue(monstre.getSante() < santeInitiale);
        assertEquals(santeInitiale - Math.max(joueur.force - monstre.getDefense(), 1), monstre.getSante());
    }
	 
    @Test
    void testDefenseJoueur() {
        Personnage joueur = new Guerrier("Arthur");
        Monstre monstre = new Monstre("Gobelin", 10, 2, 20);
        
        int santeInitiale = joueur.sante;
        joueur.defendre(monstre);
        
        assertTrue(joueur.sante > santeInitiale - monstre.getForce());
        assertTrue(joueur.sante <= santeInitiale);
    }
    
    @Test
    void testVictoireDefaite() {
        Personnage joueur = new Guerrier("Arthur");
        Monstre monstre = new Monstre("Gobelin", 5, 2, 15);
        
        while (monstre.estVivant()) {
            joueur.attaquer(monstre);
        }
        assertFalse(monstre.estVivant(), "Le monstre doit être vaincu");
        
        joueur.sante = 10;
        while (joueur.sante > 0) {
            monstre.recevoirDegats(-5); // Simulation d'attaque du monstre sur le joueur
        }
        assertFalse(joueur.estVivant(), "Le joueur doit être vaincu");
    }
}
