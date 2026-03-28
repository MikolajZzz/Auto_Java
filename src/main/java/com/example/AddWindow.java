package com.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddWindow {
    public Button zatwierdz;
    public Button anuluj;
    public TextField skrzynia_waga;
    public TextField sprzeglo_waga;
    public TextField ilosc_biegow;
    public TextField max_predkosc;
    public TextField nr_rejestracyjny;
    public TextField nazwa_auta;


    public String model;
    public String registration;
    public boolean isSubmitted;
    public int maxpredkosc;
    public int iloscbiegow;
    public int weight_sk;
    public int weight_sp;
    @FXML
    public void initialize() {
    }

    public void dodajSam(ActionEvent actionEvent) {

        try {
            model = nazwa_auta.getText();
            registration = nr_rejestracyjny.getText();
            maxpredkosc=Integer.parseInt(max_predkosc.getText());
            iloscbiegow=Integer.parseInt(ilosc_biegow.getText());
            weight_sk=Integer.parseInt(skrzynia_waga.getText());
            weight_sp=Integer.parseInt(sprzeglo_waga.getText());

            if (model.isEmpty() || registration.isEmpty()) {
                return;
            }

            isSubmitted = true;

            Stage stage = (Stage) zatwierdz.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawny format danych!");
        }

    }

    public void anuluj(ActionEvent actionEvent) {
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}