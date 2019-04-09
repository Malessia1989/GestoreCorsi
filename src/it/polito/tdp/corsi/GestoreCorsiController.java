/**
 * Sample Skeleton for 'GestoreCorsi.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestoreCorsi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class GestoreCorsiController {

	private GestoreCorsi model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnStatCorsi"
    private Button btnStatCorsi; // Value injected by FXMLLoader

    @FXML
    void doCalcolaStatCorsi(ActionEvent event) {
    	String pd=txtPeriodo.getText();
    	if(pd != null && !pd.isEmpty()) {
    		if(GestoreCorsi.isDigit(pd)) {
    			String numeroIscritti=model.getNumIScrittibyPeriodo(pd);
    			txtResult.setText(numeroIscritti);
    		}else showAlert("Inserisci periodo didattico: 1 o 2 ");
    	}else  showAlert("campo non valido: inserisci 1 o 2 ");
    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	String pd=txtPeriodo.getText();
    	if(pd != null && !pd.isEmpty()) {
    		if(GestoreCorsi.isDigit(pd)) {
    			String elencoCorsi=model.getCorsiByPeriodo(pd);
    			txtResult.setText(elencoCorsi);
    		}else showAlert("Inserisci periodo didattico: 1 o 2 ");
    	}else showAlert("campo non valido: inserisci 1 o 2 ");
    	
    }

    private void showAlert(String message) {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(message);
		alert.show();
		
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

    }
    
    public void setModel(GestoreCorsi model) {
    	this.model = model;
    }
    
}
