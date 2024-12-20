package com.test;


import org.junit.Before;
import org.junit.Test;

import com.jeu.Salle;

import static org.junit.Assert.*;

public class SalleTest {
    private Salle salle;

    @Before
    public void setUp() {
        salle = new Salle(1);
    }

    @Test
    public void testGetEvenement() {
        assertEquals(1, salle.getEvenement());

        salle = new Salle(2);
        assertEquals(2, salle.getEvenement());

        salle = new Salle(0);
        assertEquals(0, salle.getEvenement());
    }
}

