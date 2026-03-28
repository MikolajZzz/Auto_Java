/*
package com.example.samochod;

import static org.junit.After.*;

public class SilnikTest {
Silnik silnik;
    @org.junit.Before
    public void setUp() throws Exception {
        silnik = new Silnik();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
@org.junit.Test
    public void uruchom() {
        silnik.uruchom();
    assertTrue(silnik.obroty==800);
    assertFalse(silnik.obroty==900);
    assertFalse(silnik.obroty==700);
    }

    @org.junit.Test
    public void zatrzymaj() {
        silnik.zatrzymaj();
        assertTrue(silnik.obroty==0);
        assertFalse(silnik.obroty==900);
        assertFalse(silnik.obroty==700);

    }

    @org.junit.Test
    public void zwiekszObroty() {
        silnik.zatrzymaj();
        assertTrue(silnik.obroty==0);
        silnik.uruchom();
        silnik.zwiekszObroty();
        assertTrue(silnik.obroty==900);
        assertFalse(silnik.obroty==700);
        silnik.zatrzymaj();
        silnik.zwiekszObroty();
        assertTrue(silnik.obroty==100);
    }

    @org.junit.Test
    public void zmniejszObroty() {
        silnik.zatrzymaj();
        assertTrue(silnik.obroty==0);
        silnik.uruchom();
        silnik.zmniejszObroty();
        assertFalse(silnik.obroty==900);
        assertTrue(silnik.obroty==800);
        silnik.zatrzymaj();
        silnik.zmniejszObroty();
        assertTrue(silnik.obroty==800);
    }
}*/
