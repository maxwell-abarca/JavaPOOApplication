package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerVistaInicial implements Initializable {
    @FXML
    private ImageView btn_salir, btn_minimizar;
    private JFXButton btn_iniciarSesion, btn_registrar;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_salir.setOnMouseClicked(this::exitButton);
        btn_minimizar.setOnMouseClicked(this::minimizeButton);
    }

    @FXML
    public void exitButton(MouseEvent evento) {
        Platform.exit();
        System.exit(0);
    }

    public void minimizeButton(MouseEvent minimize) {
        Stage stage = (Stage) ((Node) minimize.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    private double xOffset; /*cuando clickeo la interfaz obtiene las coordenadas x y y*/

    private double yOffset;

    public void enviarAInicio(ActionEvent evento) {
        /*hago el try por el exception porque sin el catch(exception e no me funcionaria el fxmlloader)*/
        try {

            Parent root = FXMLLoader.load(getClass().getResource("inicioSesion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
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
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarARegistro(ActionEvent evento) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("registroAdministrador.fxml"));
            Scene scene = new Scene(root);
            /*con esto me daria la ventana con la barra de cerrar y minimizar propia*/
            Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
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
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}