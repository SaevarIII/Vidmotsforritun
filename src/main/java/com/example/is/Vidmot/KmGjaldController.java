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
    private void onFlokkur(ActionEvent event) {
        String flokkur = fxFlokkur.getText().trim().toUpperCase();
        if (!vinnsla.erLoglegt(flokkur)) {
            fxKmGjald.setText("Villa. Reyndu aftur");
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
            vinnsla.skraManud(upphaf, lok, flokkur);
            fxManKm.setText(String.valueOf(km));
            fxManGjald.setText(String.valueOf(vinnsla.reiknaManGjald(km, flokkur)));
            fxHeildKm.setText(String.valueOf(vinnsla.getHeildEknirKm()));
        }
        catch (NumberFormatException e) {
            fxManKm.setText("Villa. Reyndu aftur");
            fxManGjald.setText("Villa. Reyndu aftur");
        }

    }
}








