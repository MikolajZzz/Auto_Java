package com.example.samochod;

public abstract class Komponent {
    private String nazwa;
    private int waga;
    private int cena;
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public int getWaga() {
        return waga;
    }
    public void setWaga(int waga) {
        this.waga = waga;
    }
    public int getCena() {
        return cena;
    }
    public void setCena(int cena) {
        this.cena = cena;
    }
}
