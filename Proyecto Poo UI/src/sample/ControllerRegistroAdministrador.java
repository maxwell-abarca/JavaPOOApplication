package sample;

import com.jfoenix.controls.*;
import cr.ac.JuanMaswell.ucenfotec.tl.ControllerAdministrador;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerRegistroAdministrador implements Initializable {
    @FXML
    private ImageView btn_salir, btn_minimizar;

    @FXML
    private JFXTextField txt_nombre, txt_apellido1, txt_apellido2, txt_edad, txt_cedula, txt_correo;
    @FXML
    private JFXComboBox cmb_nacionalidad;
    @FXML
    private JFXPasswordField txt_contrasenia;

    @FXML
    private TextArea txt_area_detalleDireccion;

    @FXML
    private JFXDatePicker date_fechaNacimiento;

    @FXML
    private JFXRadioButton radio_masculino, radio_femenino;


    @FXML
    private Button btn_registrarAdmin;

    String genero;

    static ControllerAdministrador gestorAdministrador = new ControllerAdministrador();
    ObservableList<String> listaDePaises = FXCollections.observableArrayList(
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Anguilla", "Antigua & Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas"
            , "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia &amp; Herzegovina", "Botswana", "Brazil", "British Virgin Islands"
            , "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Chad", "Chile", "China", "Colombia", "Congo", "Cook Islands", "Costa Rica"
            , "Cote D Ivoire", "Croatia", "Cruise Ship", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea"
            , "Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "French Polynesia", "French West Indies", "Gabon", "Gambia", "Georgia", "Germany", "Ghana"
            , "Gibraltar", "Greece", "Greenland", "Grenada", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India"
            , "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kuwait", "Kyrgyz Republic", "Laos", "Latvia"
            , "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Mauritania"
            , "Mauritius", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Namibia", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia"
            , "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal"
            , "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Pierre &amp; Miquelon", "Samoa", "San Marino", "Satellite", "Saudi Arabia", "Senegal", "Serbia", "Seychelles"
            , "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "South Africa", "South Korea", "Spain", "Sri Lanka", "St Kitts &amp; Nevis", "St Lucia", "St Vincent", "St. Lucia", "Sudan"
            , "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor L'Este", "Togo", "Tonga", "Trinidad &amp; Tobago", "Tunisia"
            , "Turkey", "Turkmenistan", "Turks &amp; Caicos", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay"
            , "Uzbekistan", "Venezuela", "Vietnam", "Virgin Islands (US)", "Yemen", "Zambia", "Zimbabwe"
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_registrarAdmin.setOnAction(registrarAdmin);
        btn_salir.setOnMouseClicked(this::exitButton);
        btn_minimizar.setOnMouseClicked(this::minimizeButton);
        date_fechaNacimiento.setOnAction(this::calcularEdad);
        cmb_nacionalidad.setItems(listaDePaises);
    }

    public void exitButton(MouseEvent exit) {
        Platform.exit();
        System.exit(0);
    }

    public void minimizeButton(MouseEvent minimize) {
        Stage stage = (Stage) ((Node) minimize.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public boolean validarRegistro() {
        boolean error = false;
        if (txt_nombre.getText().isEmpty()) {
            error = true;
            txt_nombre.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombre.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombre.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombre.setStyle("-jfx-unfocus-color:#4d4d4d");
        }

        if (txt_apellido1.getText().isEmpty()) {
            error = true;
            txt_apellido1.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_apellido1.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_apellido1.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_apellido1.setStyle("-jfx-unfocus-color:#4d4d4d");
        }

        if (txt_apellido2.getText().isEmpty()) {
            error = true;
            txt_apellido2.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_apellido2.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_apellido2.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_apellido2.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (cmb_nacionalidad.getSelectionModel().isEmpty()) {
            error = true;
            cmb_nacionalidad.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_nacionalidad.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (date_fechaNacimiento.getValue() == null) {
            error = true;
            date_fechaNacimiento.setStyle("-jfx-default-color:red");
        } else {
            error = false;
            date_fechaNacimiento.setStyle("-jfx-default-color:#4d4d4d");
        }

        if (txt_edad.getText().isEmpty()) {
            error = true;
            txt_edad.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_edad.getText().matches("[0-9]{1,99}"))) {
            error = true;
            txt_edad.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_edad.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (!(radio_femenino.isSelected() || radio_masculino.isSelected())) {
            error = true;
        } else {
            error = false;
        }
        if (radio_masculino.isSelected()) {
            genero = radio_masculino.getText();
        } else if (radio_femenino.isSelected()) {
            genero = radio_femenino.getText();
        }
        if (txt_cedula.getText().isEmpty()) {
            error = true;
            txt_cedula.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_cedula.getText().matches("[0-9]{9}"))) {
            error = true;
            txt_cedula.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_cedula.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_area_detalleDireccion.getText().isEmpty()) {
            error = true;
            txt_area_detalleDireccion.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_area_detalleDireccion.setStyle("-jfx-unfocus-color:#4d4d4d");
        }

        if (txt_correo.getText().isEmpty()) {
            error = true;
            txt_correo.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_correo.getText().contains("@") && txt_correo.getText().contains(".com"))) {
            error = true;
            txt_correo.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_correo.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_contrasenia.getText().isEmpty()) {
            error = true;
            txt_contrasenia.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_contrasenia.getText().matches("\\w{8,20}"))) {
            error = true;
            txt_contrasenia.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_contrasenia.setStyle("-jfx-unfocus-color:#4d4d4d");
        }

        return error;
    }

    EventHandler<ActionEvent> registrarAdmin = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (validarRegistro() == false) {
                if (gestorAdministrador.validarAdministrador(txt_correo.getText()) != null) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("Ya el usuario ha sido registrado anteriormente");
                    alerta.showAndWait();
                } else {
                    gestorAdministrador.registrarAdministrador(txt_nombre.getText(), txt_apellido1.getText(), txt_apellido2.getText(), cmb_nacionalidad.getValue().toString(), LocalDate.parse(date_fechaNacimiento.getValue().toString()), Integer.parseInt(txt_edad.getText()), genero, txt_cedula.getText(), txt_area_detalleDireccion.getText(), txt_correo.getText(), txt_contrasenia.getText());
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Administrador Registrado con éxito");
                    alerta.setContentText("Bienvenido a la aplicación");
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("vistaAdministrador.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
                alertaRegistro.setHeaderText("Error");
                alertaRegistro.setContentText("Revise los campos e intentelo nuevamente");
                alertaRegistro.show();
            }
        }
    };

    public void calcularEdad(ActionEvent calcular) {
        LocalDate fechaNacimiento = LocalDate.parse(date_fechaNacimiento.getValue().toString());
        LocalDate fechaAhora = LocalDate.now();
        int calculo = fechaAhora.getYear() - fechaNacimiento.getYear();
        txt_edad.setText(Integer.toString(calculo));
    }

}

