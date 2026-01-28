package com.example.is.Vidmot;

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
    private Label fxUpphaf;


    @FXML
    private void onFlokkur(ActionEvent event) {
        String flokkur = fxFlokkur.getText().trim().toUpperCase();
        double gjald = 0;


            if (flokkur.equals("A") || flokkur.equals("C")) {
                gjald = 6.95;
                fxKmGjald.setText(String.valueOf(gjald));
            } else if (flokkur.equals("B")) {
                gjald = 4.15;
                fxKmGjald.setText(String.valueOf(gjald));
            }
            else{
                fxKmGjald.setText("Villa. Reyndu aftur");
            }
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
        fxUpphaf.setText("");



    }

    @FXML
    void onSkraKmStodu(ActionEvent event){


    }
}








