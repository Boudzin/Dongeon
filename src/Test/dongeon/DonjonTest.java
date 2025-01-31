package Test.dongeon;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.Dongeon.Donjon;
import jeu.personnages.*;

class DonjonTest {

	@Test
    void testGenerationDonjon() {
        Donjon donjon = new Donjon(5);
        assertNotNull(donjon);
        assertEquals(5, donjon.getTaille());
        assertTrue(donjon.verifierConnexionsValides());
    }
	
	@Test
    void testDeplacementJoueur() {
        Donjon donjon = new Donjon(5);
        Personnage joueur = new Guerrier("Arthur");
        
        int x = 2, y = 2;
        assertTrue(donjon.deplacerJoueur(x, y, "nord"));
        assertTrue(donjon.deplacerJoueur(x, y, "sud"));
        assertTrue(donjon.deplacerJoueur(x, y, "est"));
        assertTrue(donjon.deplacerJoueur(x, y, "ouest"));
        
        assertFalse(donjon.deplacerJoueur(0, 0, "ouest"));
        assertFalse(donjon.deplacerJoueur(0, 0, "nord"));
        assertFalse(donjon.deplacerJoueur(4, 4, "est"));
        assertFalse(donjon.deplacerJoueur(4, 4, "sud"));
    }

}
