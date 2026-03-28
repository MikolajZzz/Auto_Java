package com.example.samochod;

public class Silnik extends Komponent{
    public final int maxObroty = 6000;
    public int obroty;
    public Silnik() {
        setWaga(1000);
        setCena(4000);
        setNazwa("Silnik");
    }
    public void uruchom() {
        obroty = 800; //bieg jałowy
        System.out.println("silnik uruchomiony.");
        System.out.println("obroty = " + obroty);
    }
    public void zatrzymaj() {
        obroty = 0; //stop
        System.out.println("silnik zatrzymany.");
        System.out.println("obroty = " + obroty);
    }
    public void zwiekszObroty() {
        obroty = obroty + 100;
        if (obroty > maxObroty) obroty = maxObroty;
        System.out.println("obroty = " + obroty);
    }
    public void zmniejszObroty() {
        obroty = obroty - 100;
        if (obroty < 800) obroty = 800;
        System.out.println("obroty = " + obroty);
    }

    public int getObroty() {
        return obroty;
    }
}