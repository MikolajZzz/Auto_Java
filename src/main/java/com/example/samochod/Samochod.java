package com.example.samochod;

import com.example.HelloController;
import com.example.Listeners.Listener;
import javafx.application.Platform;
import java.util.ArrayList;
import java.util.List;

public class Samochod implements Runnable {
    private final String numerRejestracyjny;
    private final String model;
    public final int maxPredkosc;
    private double aktualnaPredkosc = 0;
    public final Pozycja aktualnaPozycja;
    private Pozycja pozcel;
    public final Silnik silnik;
    public final SkrzyniaBiegow skrzyniaBiegow;
    private boolean running = false;
    private Thread thread;
    private final List<Listener> listeners = new ArrayList<>();

    public Samochod(String model_, String numerRejestracyjny_, int maxPredkosc_, int iloscBiegow_, int skrzyniaWaga_, int sprzegloWaga_) {
        this.model = model_;
        this.numerRejestracyjny = numerRejestracyjny_;
        this.maxPredkosc = maxPredkosc_;
        this.skrzyniaBiegow = new SkrzyniaBiegow(iloscBiegow_, skrzyniaWaga_, sprzegloWaga_);
        this.silnik = new Silnik();
        this.aktualnaPozycja = new Pozycja(0, 0);

        skrzyniaBiegow.setAktualnePrzelozenie(
                maxPredkosc / (0.01 * silnik.maxObroty * 2 * Math.PI * 0.17 * iloscBiegow_)
        );
    }

    public Samochod(HelloController controller) {
        this("Domyślny", "BRAK", 120, 6, 120, 60);
    }

    public void addListener(Listener listener) {

        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public void wlacz() {
        silnik.uruchom();
        System.out.println("Auto jest włączone");
        notifyListeners();
    }

    public void wylacz() {
        silnik.zatrzymaj();
        System.out.println("Auto jest wyłączone");
        notifyListeners();
    }

    public double getAktualnaPredkosc() {
        return skrzyniaBiegow.aktualnePrzelozenie * skrzyniaBiegow.aktualnyBieg * 0.01 * silnik.obroty * 2 * Math.PI * 0.17;
    }

    @Override

    public void run() {
        running = true;
        while (running) {
            if (pozcel != null) {
                double dx = pozcel.getX() - aktualnaPozycja.getX();
                double dy = pozcel.getY() - aktualnaPozycja.getY();
                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance > getAktualnaPredkosc() * 0.1) {
                    double speedFactor = getAktualnaPredkosc() / 300;
                    double stepDistance = speedFactor * 10;
                    double stepX = (dx / distance) * stepDistance;
                    double stepY = (dy / distance) * stepDistance;

                    aktualnaPozycja.move(stepX, stepY);

                    notifyListeners();

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    running = false;
                    aktualnaPozycja.move(dx, dy);
                    notifyListeners();
                }
            }
        }
    }

    public int getWaga() {
        return skrzyniaBiegow.getWaga() + silnik.getWaga() + skrzyniaBiegow.sprzeglo.getWaga() + 500;
    }
    public String getNrRejestracyjny() {
        return numerRejestracyjny;
    }
    public String getModel() {
        return model;
    }
    public synchronized void jedzDo(Pozycja nowyPozcel) {
        if (nowyPozcel == null) return;
        this.pozcel = nowyPozcel;

        if (thread == null || !thread.isAlive()) {
            thread = new Thread(this);
            thread.start();
        }
        notifyListeners();
    }
    public String toString() {
        return this.model;
    }
    public synchronized void zatrzymaj() {
        running = false;
        if (thread != null) {
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        notifyListeners();
    }
}
