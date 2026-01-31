package com.example.is.Vidmot;

import com.example.is.vinnsla.KmGjaldVinnsla;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;


public class KmGjaldController {
    @FXML
    private TextField fxFlokkur;
    @FXML
    private Label fxKmGjald;
    @FXML
    private Label fxManGjald;
    @FXML
    private Label fxManKm;
    @FXML
    private TextField fxUpphaf;
    @FXML
    private TextField fxLoka;
    @FXML
    private Label fxHeildKm;

    @FXML
    private Label fxHeildGjald;
    @FXML private Label fxFjManada;




    @FXML
    private void onFlokkur(ActionEvent event) {
        fxKmGjald.setStyle("-fx-text-fill: black;");
        String flokkur = fxFlokkur.getText().trim().toUpperCase();
        if (!vinnsla.erLoglegt(flokkur)) {
            fxKmGjald.setText("Villa. Reyndu aftur");
            fxKmGjald.setStyle("-fx-text-fill: red;");
            return;
        }
        fxKmGjald.setText(String.valueOf(vinnsla.getGjaldKilometra(flokkur)));
    }

    @FXML
    void onUpphaf(ActionEvent event){

    }

    @FXML
    void onLoka(ActionEvent event){

    }


    @FXML
    void onHreinsa(ActionEvent event){
        fxKmGjald.setText("");
        fxManKm.setText("");
        fxManGjald.setText("");
        fxUpphaf.clear();
        fxLoka.clear();
        fxFlokkur.clear();
        fxHeildKm.setText("");


    }
    KmGjaldVinnsla vinnsla = new KmGjaldVinnsla();

    @FXML
    public void onSkraManud(ActionEvent event) {
        try {
            int upphaf = Integer.parseInt(fxUpphaf.getText().trim());
            int lok = Integer.parseInt(fxLoka.getText().trim());
            String flokkur = fxFlokkur.getText().trim().toUpperCase();
            int km = lok - upphaf;
            if (km < 0) {
                fxManKm.setText("Villa");
                return;

            }
            int manGjald = vinnsla.reiknaManGjald(km, flokkur);
            vinnsla.skraManud(upphaf, lok, flokkur);
            fxManKm.setText(String.valueOf(km));

            fxManGjald.setText(String.valueOf(manGjald));
            fxHeildKm.setText(String.valueOf(vinnsla.getHeildEknirKm()));
            fxHeildGjald.setText(String.valueOf(vinnsla.getHeildarGreidsla()));
            fxFjManada.setText(String.valueOf(vinnsla.getFjoldiManada()));

        }
        catch (NumberFormatException e) {
            fxManKm.setText("Villa. Reyndu aftur");
            fxManGjald.setText("Villa. Reyndu aftur");
        }

    }
}








