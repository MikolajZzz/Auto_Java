/*
package com.example.samochod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkrzyniaBiegowTest {
SkrzyniaBiegow skrzyniaBiegow;
    @Before
    public void setUp() throws Exception {
        skrzyniaBiegow=new SkrzyniaBiegow(6,400,200);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void zwiekszbieg() {
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        assertTrue(skrzyniaBiegow.aktualnyBieg==2);
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        assertTrue(skrzyniaBiegow.aktualnyBieg==4);
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        assertTrue(skrzyniaBiegow.aktualnyBieg==skrzyniaBiegow.iloscBiegow);
    }

    @Test
    public void zmiejszbieg() {
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zmiejszbieg();
        assertTrue(skrzyniaBiegow.aktualnyBieg==1);
        skrzyniaBiegow.zmiejszbieg();
        skrzyniaBiegow.zmiejszbieg();
        assertTrue(skrzyniaBiegow.aktualnyBieg==-1);
        skrzyniaBiegow.zmiejszbieg();
        assertTrue(skrzyniaBiegow.aktualnyBieg==-1);


    }

    @Test
    public void getAktualnePrzelozenie() {
    }

    @Test
    public void getAktualnyBieg() {
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        assertEquals(4,skrzyniaBiegow.getAktualnyBieg());
        skrzyniaBiegow.zwiekszbieg();
        skrzyniaBiegow.zwiekszbieg();
        assertEquals(6,skrzyniaBiegow.getAktualnyBieg());
        skrzyniaBiegow.zmiejszbieg();
        assertEquals(5,skrzyniaBiegow.getAktualnyBieg());

    }

    @Test
    public void setAktualnePrzelozenie() {
    }
}*/
