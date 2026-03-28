package com.example.samochod;

public class Sprzeglo extends Komponent {
    public Sprzeglo(int sprzeglowaga_) {
        stanSprzegla=false;
        setWaga(sprzeglowaga_);
        setCena(1000);
        setNazwa("Sprzęgło");
    }
    public boolean stanSprzegla=false;
    public Sprzeglo() {}
    public void wcisnij() {
        this.stanSprzegla=true;
        System.out.println("sprzeglo jest wcisniete.");
    }
    public void zwolnij() {
        this.stanSprzegla=false;
        System.out.println("sprzeglo jest zwolnione.");
    }


    public String getStan() {
        if(!stanSprzegla){
            return "Zwolnione";
        }else{
            return "Wcisniete";
        }
    }
}
