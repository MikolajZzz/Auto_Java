package com.example;

import com.example.Listeners.Listener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import com.example.samochod.Pozycja;
import com.example.samochod.Samochod;

public class HelloController implements Listener {
    public Button wlaczButton;
    public Button wylaczButton;
    public TextField model;
    public TextField NrRejestr;
    public TextField waga;
    public TextField V;
    public TextField silniknazwa;
    public TextField silnikCena;
    public TextField silnikWaga;
    public TextField bieg;
    public Button zwiekszBieg;
    public Button zmniejszBieg;
    public TextField obroty;
    public Button dodajGaz;
    public Button odejmijGaz;
    public TextField skrzynianazwa;
    public TextField skrzyniaCena;
    public TextField skrzyniaWaga;
    public TextField sprzegloNazwa;
    public TextField sprzegloCena;
    public TextField sprzegloWaga;
    public TextField sprzegloStan;
    public Button SzprzegloON;
    public Button SzprzegloOFF;
    public ImageView carImageView;
    public Button dodSam;
    public Button usSam;
    public ComboBox comboBox;
    public VBox mapa;
    private Samochod samochod;

    @FXML
    private Label welcomeText;

    private ObservableList<Samochod> samochody = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        samochod = new Samochod("Opel", "KR2332", 400, 6, 300, 100);
        samochod.addListener(this);
        samochody.add(samochod);
        comboBox.getItems().addAll(samochod.getModel());
        comboBox.setValue(samochod.getModel());
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        model.setText(auto.getModel());
        NrRejestr.setText(auto.getNrRejestracyjny());
        waga.setText(String.valueOf(auto.getWaga()));
        silniknazwa.setText(auto.silnik.getNazwa());
        silnikCena.setText(String.valueOf(auto.silnik.getCena()));
        silnikWaga.setText(String.valueOf(auto.silnik.getWaga()));
        V.setText(String.valueOf(auto.getAktualnaPredkosc() ));
        obroty.setText("0");
        skrzyniaWaga.setText(String.valueOf(auto.skrzyniaBiegow.getWaga()));
        skrzyniaCena.setText(String.valueOf(auto.skrzyniaBiegow.getWaga()));
        skrzynianazwa.setText(String.valueOf(auto.skrzyniaBiegow.getWaga()));
        bieg.setText("0");
        sprzegloCena.setText(String.valueOf(auto.skrzyniaBiegow.sprzeglo.getCena()));
        sprzegloNazwa.setText(String.valueOf(auto.skrzyniaBiegow.sprzeglo.getNazwa()));
        sprzegloWaga.setText(String.valueOf(auto.skrzyniaBiegow.sprzeglo.getWaga()));
        sprzegloStan.setText("OFF");
        Image carImage = new Image(getClass().getResource("/com/example/pngtree-vector-car-icon-png-image_3989845.jpg").toExternalForm());
        carImageView.setImage(carImage);
        carImageView.setFitHeight(32);
        carImageView.setFitWidth(32);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);
        onClick();
        comboBox.setOnAction(event -> {
            modelChanged();
        });
    }

    public void onClick() {
        mapa.setOnMouseClicked(event -> {
            String selectedModel = (String) comboBox.getValue();
            Samochod auto = znajdz(selectedModel);

            if (auto != null) {
                double x = event.getX() - 32;
                double y = event.getY() - 66;
                Pozycja nowaPozycja = new Pozycja(x, y);
                auto.jedzDo(nowaPozycja);
            }
        });
    }


    public void modelChanged() {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        updateData();
    }


    public void onWlacz(ActionEvent actionEvent) {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.wlacz();
        updateData();
    }

    public void onWylacz(ActionEvent actionEvent) {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.wylacz();
        updateData();
    }

    public void onZwBieg(ActionEvent actionEvent) throws Exception {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.skrzyniaBiegow.zwiekszbieg();
        updateData();

    }
    public void onZmBieg(ActionEvent actionEvent) throws Exception {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.skrzyniaBiegow.zmiejszbieg();;
        updateData();
    }

    public void onSprzengloON(ActionEvent actionEvent) {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.skrzyniaBiegow.sprzeglo.wcisnij();
        updateData();
    }

    public void onSprzengloOFF(ActionEvent actionEvent) {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.skrzyniaBiegow.sprzeglo.zwolnij();
        updateData();
    }

    public void dodajSamochod(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Add.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Dodaj samochód");

            AddWindow controller = loader.getController();
            stage.showAndWait();

            if (controller.isSubmitted) {
                String model = controller.model;
                String registration = controller.registration;
                int maxpredkosc = controller.maxpredkosc;
                int iloscbiegow = controller.iloscbiegow;
                int waga_sk = controller.weight_sk;
                int waga_sp = controller.weight_sp;

                Samochod nowySamochod = new Samochod(model, registration, maxpredkosc, iloscbiegow, waga_sk, waga_sp);
                samochody.add(nowySamochod);
                nowySamochod.addListener(this);
                updateComboBox();
                comboBox.setValue(nowySamochod.getModel());
                updateData();
            }
        } catch (Exception e) {
            System.err.println("Błąd podczas dodawania samochodu: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void usunSamochod(ActionEvent actionEvent) {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        if(samochody.size() > 1) {
            auto.zatrzymaj();
            auto.removeListener(this);
            samochody.remove(auto);
            updateComboBox();
        }
    }

    private void updateComboBox() {
        comboBox.getItems().clear();
        for (Samochod s : samochody) {
            comboBox.getItems().add(s.getModel());
        }
        if (!samochody.isEmpty()) {
            comboBox.setValue(samochody.get(0).getModel());
        }
    }

    public void moveCar() {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        carImageView.setTranslateX(auto.aktualnaPozycja.getX());
        carImageView.setTranslateY(auto.aktualnaPozycja.getY());
    }

    public void onDodajGaz(ActionEvent actionEvent) throws InterruptedException {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.silnik.zwiekszObroty();
        updateData();
    }

    public void onUjmijGaz(ActionEvent actionEvent) throws InterruptedException {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);
        auto.silnik.zmniejszObroty();
        updateData();
    }

    public Samochod znajdz(String model) {
        for (Samochod s : samochody) {
            if (s.getModel().equals(model)) {
                return s;
            }
        }
        return null;
    }
    public void update() {
        Platform.runLater(this::updateData);
    }
    public void updateData() {
        String selectedModel = (String) comboBox.getValue();
        Samochod auto = znajdz(selectedModel);

        if (auto == null) {
            System.err.println("Nie znaleziono samochodu dla wybranego modelu!");
            return;
        }

//        System.out.println("Aktualizacja danych dla: " + auto.getModel());
//        System.out.println("Numer rejestracyjny: " + auto.getNrRejestracyjny());
//        System.out.println("Maksymalna prędkość: " + auto.getAktualnaPredkosc());
//        System.out.println("Waga: " + auto.getWaga());
//        System.out.println("Silnik: " + (auto.silnik != null ? auto.silnik.getNazwa() : "Brak silnika"));
//        System.out.println("Skrzynia biegów: " + (auto.skrzyniaBiegow != null ? auto.skrzyniaBiegow.getWaga() : "Brak skrzyni"));

        model.setText(auto.getModel());
        NrRejestr.setText(auto.getNrRejestracyjny());
        waga.setText(String.valueOf(auto.getWaga()));
        V.setText(String.valueOf(auto.getAktualnaPredkosc()));
        bieg.setText(String.valueOf(auto.skrzyniaBiegow.aktualnyBieg));
        obroty.setText(String.valueOf(auto.silnik.obroty));
        sprzegloStan.setText(auto.skrzyniaBiegow.sprzeglo.stanSprzegla ? "ON" : "OFF");
        skrzyniaWaga.setText(String.valueOf(auto.skrzyniaBiegow.getWaga()));
        silnikWaga.setText(String.valueOf(auto.silnik.getWaga()));
        sprzegloWaga.setText(String.valueOf(auto.skrzyniaBiegow.sprzeglo.getWaga()));
        carImageView.setTranslateX(auto.aktualnaPozycja.getX());
        carImageView.setTranslateY(auto.aktualnaPozycja.getY());
    }
}