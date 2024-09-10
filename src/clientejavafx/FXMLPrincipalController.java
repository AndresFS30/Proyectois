/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.utilidades.utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Andy
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Button btnCerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cerrarSesion(ActionEvent event) {
        Stage escenarioBase = (Stage) btnCerrar.getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLInicioSesion.fxml"));
             Scene scene = new Scene(root);
        
             escenarioBase.setScene(scene);
             escenarioBase.setTitle("Autentificacion");
             escenarioBase.show();
        } catch (IOException ex) {
            utilidades.mostrarAlertaSimple("ERROR", "LO SENTIMOS NO SE PUEDO CERRAR SESION", Alert.AlertType.ERROR);
        }
    }
    
}
