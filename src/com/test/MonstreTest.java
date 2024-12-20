package com.test;


import org.junit.Before;
import org.junit.Test;

import com.jeu.Monstre;

import static org.junit.Assert.*;

public class MonstreTest {
    private Monstre monstre;

    @Before
    public void setUp() {
        //Give
        monstre = new Monstre("Gobelin", 50, 8, 3);
    }

    @Test
    public void testReductionSante() {
        monstre.reduireSante(20);

        assertEquals(30, monstre.getSante());

        monstre.reduireSante(40);

        assertEquals(0, monstre.getSante());
    }

    @Test
    public void testGetters() {

        assertEquals("Gobelin", monstre.getNom());
        assertEquals(50, monstre.getSante());
        assertEquals(8, monstre.getForce());
    }
}


