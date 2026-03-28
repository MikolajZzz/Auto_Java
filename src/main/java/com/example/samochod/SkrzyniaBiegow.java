package com.example.samochod;

public class SkrzyniaBiegow extends Komponent{
    public SkrzyniaBiegow(int iloscBiegow_,int skrzyniawaga_,int sprzeglowaga_) {
        iloscBiegow=iloscBiegow_;
        setWaga(skrzyniawaga_);
        setNazwa("Skrzynia Biegów");
        setCena(2000);
        Sprzeglo sprzeglo1 = new Sprzeglo(sprzeglowaga_);
        sprzeglo=sprzeglo1;
    }
    public int aktualnyBieg=0;
    public int iloscBiegow;
    public double aktualnePrzelozenie=0;
    public Sprzeglo sprzeglo;
    public void zwiekszbieg() throws SkrzyniaBiegowException {
        if(sprzeglo.stanSprzegla==false){
            throw new SkrzyniaBiegowException("Nie można zwiększyć biegu, sprzęgło nie zostało wciśnięte.");
        }else {
            if (aktualnyBieg < iloscBiegow) {
                aktualnyBieg++;
                System.out.println("aktualny bieg: " + aktualnyBieg);
            } else {
                System.out.println("nie mozna zwiekszyc biegu, bieg jest maxymalny");
            }
        }
    }
    public void setIloscBiegow(int iloscBiegow_) {
        iloscBiegow = iloscBiegow_;
    }
    public void zmiejszbieg() throws SkrzyniaBiegowException {
        if(sprzeglo.stanSprzegla==false){
            throw new SkrzyniaBiegowException("Nie można zmniejszyć biegu, sprzęgło nie zostało wciśnięte.");
        }else {
            if (aktualnyBieg > -1) {
                aktualnyBieg--;
                System.out.println("aktualny bieg: " + aktualnyBieg);
            } else {
                System.out.println("nie mozna zmiejszyc biegu wstecznego");
            }
        }
    }

    public double getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }
    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public void setAktualnePrzelozenie(double aktualnePrzelozenie) {
        this.aktualnePrzelozenie = aktualnePrzelozenie;
    }
}
