package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.lang.*;

public class FXMLController {
	
	Parole elenco ;
	String parola;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button btnCancella;
    @FXML
    private TextArea txtPrestazioni;


    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	parola=txtParola.getText();
    	elenco.addParola(parola);
    	txtResult.setText(elenco.getElenco().toString());
    	
    	txtPrestazioni.setText("Insert "+Long.toString(System.nanoTime())+" nanosecondi");
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.setText("");
    	txtPrestazioni.setText("Reset "+Long.toString(System.nanoTime())+" nanosecondi");
    }

    @FXML
    void handleCancella(ActionEvent event) {
    	String pdacancellare;
    	pdacancellare= txtResult.getSelectedText();
    	elenco.cancella(pdacancellare);
    	txtResult.setText("");
    	txtPrestazioni.setText("Cancella "+Long.toString(System.nanoTime())+" nanosecondi");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPrestazioni != null : "fx:id=\"txtPrestazioni\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
