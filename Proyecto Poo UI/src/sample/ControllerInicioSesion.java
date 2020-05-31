package sample;

import cr.ac.JuanMaswell.ucenfotec.tl.ControllerIniciarSesion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerInicioSesion implements Initializable {

    @FXML
    private
    TextField txt_username;
    @FXML
    private
    PasswordField txt_password;
    @FXML
    private
    Button btn_iniciarSesion;
    @FXML
    private
    Button btn_accederARegistro;
    @FXML
    private
    ImageView btn_salir;
    @FXML
    private
    ImageView btn_minimizar;
    @FXML
    private
    AnchorPane panel_fondoInicio;


    private double xOffset; /*cuando clickeo la interfaz obtiene las coordenadas x y y*/
    private double yOffset;
    ControllerIniciarSesion gestorInicioSesion = new ControllerIniciarSesion();


    @Override

    public void initialize(URL location, ResourceBundle resources) {
        btn_salir.setOnMouseClicked(this::exitButton);
        btn_minimizar.setOnMouseClicked(this::minimizeButton);
        btn_iniciarSesion.setOnAction(iniciarSesion);
    }

    public void exitButton(MouseEvent onClose) {
        Platform.exit();
        System.exit(0);
    }

    public void minimizeButton(MouseEvent minimize) {
        Stage stage = (Stage) ((Node) minimize.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    public void enviarARegistro(ActionEvent evento) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("registroUsuario.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (evento.getSource())).getScene().getWindow();
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            stage.setScene(scene);
            stage.setTitle("Registrar Cuenta");
            stage.show();
        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }

    EventHandler<ActionEvent> iniciarSesion = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (gestorInicioSesion.iniciarSesionUsuario(txt_username.getText(), txt_password.getText()) != null) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("vistaUsuario.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("el usuario no existe");
            }
            if (gestorInicioSesion.iniciarSesionMiembro(txt_username.getText(), txt_password.getText()) != null) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("vistaMiembro.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("El usuario no existe");
            }
            if (gestorInicioSesion.iniciarSesionAdministrador(txt_username.getText(), txt_password.getText()) != null) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("vistaAdministrador.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("El usuario no existe");
            }
        }
    };
}
