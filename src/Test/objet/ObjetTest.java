package Test.objet;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.objet.Objet;
import jeu.personnages.*;

class ObjetTest {

	@Test
    void testAjoutObjetInventaire() {
        Personnage joueur = new Guerrier("Arthur");
        Objet potion = new Objet("Potion de soin",20);
        
        assertEquals(0, joueur.inventaire.size());
        joueur.ajouterObjet(potion);
        assertEquals(1, joueur.inventaire.size());
        assertEquals("Potion de soin", joueur.inventaire.get(0).getNom());
    }
}
