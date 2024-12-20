package com.test;

import org.junit.Before;
import org.junit.Test;

import com.jeu.Jeu;
import com.jeu.Personnage;

import static org.junit.Assert.*;

public class JeuTest {
    private Jeu jeu;

    @Before
    public void setUp() {
        // Given a new instance of Jeu
        jeu = new Jeu();
    }

    @Test
    public void testCreerPersonnage() {
        // When a personnage is created
        Personnage joueur = jeu.creerPersonnage();

        // Then the personnage should have a valid name and class
        assertNotNull(joueur);
        assertTrue(joueur.getNom().length() >= 4 && joueur.getNom().length() < 23);
        assertTrue(joueur.getClasse().equals("Guerrier") || joueur.getClasse().equals("Mage") || joueur.getClasse().equals("Voleur"));
    }
}
