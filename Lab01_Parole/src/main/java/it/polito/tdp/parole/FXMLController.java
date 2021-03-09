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
    	// mettiamo questo long per segnalare il tempo di esecuzione in questo punto
    	long startTime = System.nanoTime();  
    	// questo comando prendiamo la parola dal campo di testo
    	parola=txtParola.getText();
    	if(parola.isEmpty()) {
    		txtResult.setText("Inserire una parola ");
    		return;
    		}
    	// utilizziamo la funzione in Parole
    	elenco.addParola(parola);
    	// calcoliamo e stampiamo la differenza che è il tempo di esecuzione di queste istruzion
    	
    	txtPrestazioni.setText("Insert "+Long.toString((System.nanoTime()-startTime))+" nanosecondi");
    	// stampiamo l'elenco utilizzando la propriata delle List toString (in teoria può essere seguito meglio)
    	// per implementare una stampa diversa vedere Libretto del progetto librettovoti
    	
    	//txtResult.setText(elenco.getElenco().toString());
    	// per farlo più elegante basta guardare qua sotto i due metodi implementati
    	// il primo le ordina e il secondo stampa con degli accapo
    	elenco.getElenco();
    	txtResult.setText(elenco.toString());

    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime(); 
    	// usiamo reset, metodo della classe parole
    	elenco.reset();
    	// puliamo l'area di testo
    	txtPrestazioni.setText("Reset "+Long.toString((System.nanoTime()-startTime))+" nanosecondi");
    	txtResult.setText("");
    }

    @FXML
    void handleCancella(ActionEvent event) {
    	long startTime = System.nanoTime();    
    	String pdacancellare;
    	// con questa istruzione stiamo prendendo la parola evidenziata nell'area di testo
    	pdacancellare= txtResult.getSelectedText();
    	elenco.cancella(pdacancellare);
    	//txtResult.setText("");
    	txtPrestazioni.setText("Cancella "+Long.toString(System.nanoTime()-startTime)+" nanosecondi");
    	elenco.getElenco();
    	txtResult.setText(elenco.toString());
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
