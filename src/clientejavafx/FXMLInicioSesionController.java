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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Andy
 */
public class FXMLInicioSesionController implements Initializable {

    @FXML
    private TextField tfCorreo;
    @FXML
    private PasswordField pfContraseña;
    @FXML
    private Label lberrorcorreo;
    @FXML
    private Label lberrorcontraseña;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickIngresar(ActionEvent event) {
        String correo = tfCorreo.getText();
        String contraseña =  pfContraseña.getText();
        if(validarCampos(correo,contraseña)){
            verificarCrendencialesSistema(correo,contraseña);
        }
    }
    
    private void verificarCrendencialesSistema(String correo, String contraseña){
    //TODO
    // Envio de credenciales  a Ws
      utilidades.mostrarAlertaSimple("Autentificacion correcta"
              ,"bienvido al sistema",Alert.AlertType.INFORMATION);
      irPantallaPrincipal();
    }
    
    
    
    
    private boolean validarCampos(String correo, String contraseña){
    boolean camposValidos = true;
    lberrorcorreo.setText("");
    lberrorcontraseña.setText("");
    if(correo.isEmpty()){
            camposValidos = false ;
            lberrorcorreo.setText("Correo obligatoria"); 
    
    }
    if(contraseña.isEmpty()){
        camposValidos = false ;
            lberrorcontraseña.setText("Contraseña obligatoria");
    }
    return camposValidos;
    
    }
    
    private void irPantallaPrincipal(){
        Stage escenarioBase = (Stage) tfCorreo.getScene().getWindow();
        
        Parent principal;
        try {
            principal = FXMLLoader. load(getClass().getResource("FXMLPrincipal.fxml"));
            
            Scene escenaPrincipal = new Scene(principal);
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("Menu Principal");
            escenarioBase.show();
        } catch (IOException ex) {
            utilidades.mostrarAlertaSimple("ERROR", "LO SENTIMOS NO SE PUEDE MOSTRAR LA PANTALLA PRINCIPAL", Alert.AlertType.ERROR);
        }
        
        
        
    }
          
}
