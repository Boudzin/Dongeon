package Test.personnage;
import static org.junit.jupiter.api.Assertions.*;
import jeu.personnages.*;

import org.junit.jupiter.api.Test;

class PersonnageTest {
	
    @Test
    void testCreationGuerrier() {
        Personnage guerrier = new Guerrier("Arthur");
        assertEquals("Arthur", guerrier.nom);
        assertEquals(10, guerrier.force);
        assertEquals(8, guerrier.defense);
        assertEquals(100, guerrier.sante);
        assertEquals(2, guerrier.mana);
    }
    
    @Test
    void testCreationMage() {
    	Personnage mage = new Mage("Merlin");
        assertEquals("Merlin", mage.nom);
        assertEquals(4, mage.force);
        assertEquals(4, mage.defense);
        assertEquals(60, mage.sante);
        assertEquals(20, mage.mana);
    }
    
    @Test
    void testCreationVoleur() {
        Personnage voleur = new Voleur("Robin");
        assertEquals("Robin", voleur.nom);
        assertEquals(7, voleur.force);
        assertEquals(5, voleur.defense);
        assertEquals(80, voleur.sante);
        assertEquals(10, voleur.mana);
    }
    
    @Test
    void testValidationNomPersonnage() {
        assertThrows(IllegalArgumentException.class, () -> new Guerrier("A"));
        assertThrows(IllegalArgumentException.class, () -> new Mage("SuperLongNomDePersonnage"));
        assertDoesNotThrow(() -> new Voleur("ValidNom"));
    }
    
   
}

