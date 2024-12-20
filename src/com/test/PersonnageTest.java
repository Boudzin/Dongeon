package com.test;


import org.junit.Before;
import org.junit.Test;

import com.jeu.Personnage;

import static org.junit.Assert.*;

public class PersonnageTest {
    private Personnage joueur;

    @Before
    public void setUp() {
        joueur = new Personnage("Arthur", "Guerrier", 10, 8, 100, 5);
    }

    @Test
    public void testReductionSante() {
        joueur.reduireSante(20);

        assertEquals(80, joueur.getSante());

        joueur.reduireSante(100);

        assertEquals(0, joueur.getSante());
    }

    @Test
    public void testAjouterObjet() {
        joueur.ajouterObjet("Potion de soin");


        assertEquals(1, joueur.objets.size());
        assertTrue(joueur.objets.contains("Potion de soin"));
    }

    @Test
    public void testUtiliserObjet() {
        joueur.ajouterObjet("Potion de soin");

        joueur.utiliserObjet();

        assertEquals(0, joueur.objets.size());
    }

    @Test
    public void testAugmenterDefense() {
        joueur.augmenterDefense(5);

        assertEquals(13, joueur.getDefense());
    }

    @Test
    public void testGetters() {
        assertEquals("Arthur", joueur.getNom());
        assertEquals("Guerrier", joueur.getClasse());
        assertEquals(10, joueur.getForce());
        assertEquals(8, joueur.getDefense());
        assertEquals(100, joueur.getSante());
        assertEquals(5, joueur.getMana());
    }
}

