package sample;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import cr.ac.JuanMaswell.ucenfotec.tl.ControllerUsuario;
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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;


public class ControllerRegistroUsuario implements Initializable {
    @FXML
    private
    AnchorPane panel_registroUsuario;
    @FXML
    private
    AnchorPane panel_fondoRegistro;
    @FXML
    private
    ImageView btn_salir;
    @FXML
    private
    ImageView btn_minimizar;
    @FXML
    private
    JFXTextField txt_nombreUsuario;
    @FXML
    private
    JFXTextField txt_primerApellidoUsuario;
    @FXML
    private JFXTextField txt_segundoApellidoUsuario;
    @FXML
    private
    JFXTextField txt_correoElectronicoUsuario;

    @FXML
    private RadioButton radio_masculinoUsuario, radio_femeninoUsuario;
    @FXML
    Button btn_siguiente;
    @FXML
    private
    AnchorPane panel_informacionAdicional;
    @FXML
    private
    JFXTextField txt_cedula;
    @FXML
    private
    JFXComboBox cmb_provincia;
    @FXML
    private
    JFXComboBox cmb_canton;
    @FXML
    private
    JFXComboBox cmb_distrito;
    @FXML
    private
    TextArea txt_areaDetalle;
    @FXML
    private
    JFXComboBox cmb_nacionalidad;
    @FXML
    private
    DatePicker date_fechaNacimiento;

    @FXML
    private
    JFXTextField txt_edad;
    @FXML
    private Button btn_registrar;
    private Provincias manejadorDeProvincias;


    private double xOffset; /*cuando clickeo la interfaz obtiene las coordenadas x y y*/
    private double yOffset;

    String contraseniaUsuario;
    static ControllerUsuario gestorUsuario = new ControllerUsuario();
    String genero;

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
        manejadorDeProvincias = new Provincias();
        btn_registrar.setOnAction(registrarUsuario);
        ToggleGroup group = new ToggleGroup();
        radio_masculinoUsuario.setToggleGroup(group);
        radio_femeninoUsuario.setToggleGroup(group);
        btn_salir.setOnMouseClicked(this::exitButton);
        btn_minimizar.setOnMouseClicked(this::minimizeButton);
        date_fechaNacimiento.setOnAction(this::calcularEdad);
        cmb_nacionalidad.setItems(listaDePaises);
        cmb_provincia.setItems(manejadorDeProvincias.provincias);
        cmb_provincia.setOnAction(escogerProvincia);
        cmb_canton.setOnAction(escogerDistrito);


    }

    public void exitButton(MouseEvent onClose) {
        Platform.exit();
        System.exit(0);
    }

    public void minimizeButton(MouseEvent minimize) {
        Stage stage = (Stage) ((Node) minimize.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public boolean validar() {

        boolean error = false;
        if (txt_nombreUsuario.getText().isEmpty()) {
            error = true;
            txt_nombreUsuario.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombreUsuario.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombreUsuario.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombreUsuario.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_primerApellidoUsuario.getText().isEmpty()) {
            error = true;
            txt_primerApellidoUsuario.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_primerApellidoUsuario.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_primerApellidoUsuario.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_primerApellidoUsuario.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_segundoApellidoUsuario.getText().isEmpty()) {
            error = true;
            txt_segundoApellidoUsuario.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_segundoApellidoUsuario.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_segundoApellidoUsuario.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_segundoApellidoUsuario.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_correoElectronicoUsuario.getText().isEmpty()) {
            error = true;
            txt_correoElectronicoUsuario.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_correoElectronicoUsuario.getText().contains("@") && txt_correoElectronicoUsuario.getText().contains(".com"))) {
            error = true;
            txt_correoElectronicoUsuario.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_correoElectronicoUsuario.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (!(radio_masculinoUsuario.isSelected() || radio_femeninoUsuario.isSelected())) {
            error = true;
        } else if (radio_masculinoUsuario.isSelected() || radio_femeninoUsuario.isSelected()) {
            error = false;
        }
        if (radio_masculinoUsuario.isSelected()) {
            genero = radio_masculinoUsuario.getText();
        } else if (radio_femeninoUsuario.isSelected()) {
            genero = radio_femeninoUsuario.getText();
        }

        return error;
    }

    public void pasarAlSiguientePanel() {
        if (validar() == false) {
            panel_informacionAdicional.setVisible(true);
            panel_fondoRegistro.setVisible(false);
            panel_registroUsuario.setVisible(false);
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Error");
            alerta.setContentText("Revise los campos nuevamente e intentelo de nuevo");
            alerta.show();
        }

    }

    public boolean validarPanel2() {
        boolean error = false;
        if (txt_cedula.getText().isEmpty()) {
            error = true;
            txt_cedula.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_cedula.getText().matches("\\d{9}"))) {
            error = true;
            txt_cedula.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_cedula.setStyle("-jfx-unfocus-color:#4d4d4d");
        }


        if (cmb_provincia.getSelectionModel().isEmpty()) {
            error = true;
            cmb_provincia.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_provincia.setStyle("-jfx-unfocus-color:#4d4d4d");
        }


        if (cmb_canton.getSelectionModel().isEmpty()) {
            error = true;
            cmb_canton.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_canton.setStyle("-jfx-unfocus-color:#4d4d4d");
        }


        if (cmb_distrito.getSelectionModel().isEmpty()) {
            error = true;
            cmb_distrito.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_distrito.setStyle("-jfx-unfocus-color:#4d4d4d");
        }


        if (txt_areaDetalle.getText().isEmpty()) {
            error = true;
            txt_areaDetalle.setStyle("-jfx-border-color:red");
        } else {
            error = false;
            txt_areaDetalle.setStyle("-jfx-border-color:transparent");
        }


        if (cmb_nacionalidad.getSelectionModel().isEmpty()) {
            error = true;
            cmb_nacionalidad.setStyle("-jfx-unfocus-color:red");
        } else {
            cmb_nacionalidad.setStyle("-jfx-unfocus-color:#4d4d4d");
        }


        if (date_fechaNacimiento.getValue() == null) {
            error = true;
            date_fechaNacimiento.setStyle("-jfx-default-color:red");
        } else {
            error = false;
            date_fechaNacimiento.setStyle("-jfx-default-color:#4059a9");
        }


        if (txt_edad.getText().isEmpty()) {
            error = true;
            txt_edad.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_edad.getText().matches("\\d{2}"))) {
            error = true;
            txt_edad.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_edad.setStyle("-jfx-unfocus-color:#4d4d4d");
        }


        return error;
    }

    public void calcularEdad(ActionEvent calcular) {
        LocalDate fechaNacimiento = LocalDate.parse(date_fechaNacimiento.getValue().toString());
        LocalDate fechaAhora = LocalDate.now();
        int calculo = fechaAhora.getYear() - fechaNacimiento.getYear();
        txt_edad.setText(Integer.toString(calculo));
    }

    EventHandler<ActionEvent> registrarUsuario = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (validarPanel2() == false) {
                if (gestorUsuario.validarRepetido(txt_correoElectronicoUsuario.getText()) != null) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("El usuario ya existe");
                    alerta.show();
                }else {
                    randomContrasennia();
                    enviarCorreo();

                    gestorUsuario.registrarUsuario(txt_nombreUsuario.getText(), txt_primerApellidoUsuario.getText(), txt_segundoApellidoUsuario.getText(), txt_correoElectronicoUsuario.getText(), genero, txt_cedula.getText(), cmb_provincia.getValue().toString(), cmb_canton.getValue().toString(), cmb_distrito.getValue().toString(), txt_areaDetalle.getText(), cmb_nacionalidad.getValue().toString(), LocalDate.parse(date_fechaNacimiento.getValue().toString()), Integer.parseInt(txt_edad.getText()), contraseniaUsuario);
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("vistaUsuario.fxml"));

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
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
                        stage.setTitle("Bienvenido Usuario");
                        stage.show();
                    } catch (Exception excep) {
                        excep.printStackTrace();
                    }
                }

            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Error");
                alerta.setContentText("Revise los campos nuevamente e intentelo de nuevo");
                alerta.showAndWait();
            }
        }
    };

    public void randomContrasennia() {
        int maximoValores = 8;
        String mayusculas = "BCDF";
        String minusculas = "bcdf";
        String numeros = "0123456789";
        String caracteres = "~`!@#$%^&*";
        String patronPw = mayusculas + minusculas + caracteres + numeros;
        char[] almacenador = new char[maximoValores];
        Random random = new Random();
        for (int i = 0; i < maximoValores; i++) {
            almacenador[i] = patronPw.charAt(random.nextInt(patronPw.length()));
        }
        contraseniaUsuario = String.copyValueOf(almacenador);
    }

    public void enviarCorreo() {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        Session sesion = Session.getDefaultInstance(propiedad);
        String mensaje;
        MimeMessage mail = new MimeMessage(sesion);
        String correoEnvia = "equipodesoftwareaerodynamic";
        String contraseniaCorreo = "ubbcloohnbviepdn";
        String asunto = "Contraseña de seguridad";
        String cuerpo = "Saludos! " + txt_nombreUsuario.getText() + " del equipo de software de aerodynamic, su contraseña es: " + contraseniaUsuario;
        try {

            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(txt_correoElectronicoUsuario.getText()));
            mail.setSubject(asunto);
            mail.setText(cuerpo);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contraseniaCorreo);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }

    EventHandler<ActionEvent> escogerProvincia = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            switch (cmb_provincia.getValue().toString()) {
                case "Alajuela":
                    cmb_canton.setItems(manejadorDeProvincias.cantonesDeAlajuela);
                    break;
                case "Cartago":
                    cmb_canton.setItems(manejadorDeProvincias.cantonesDeCartago);
                    break;
                case "Guanacaste":
                    cmb_canton.setItems(manejadorDeProvincias.cantonesDeGuanacaste);
                    break;
                case "Heredia":
                    cmb_canton.setItems(manejadorDeProvincias.cantonesDeHeredia);
                    break;
                case "Limón":
                    cmb_canton.setItems(manejadorDeProvincias.cantonesDeLimon);
                    break;
                case "Puntarenas":
                    cmb_canton.setItems(manejadorDeProvincias.cantonesDePuntarenas);
                    break;
                case "San José":
                    cmb_canton.setItems(manejadorDeProvincias.cantonesDeSanJose);
                    break;
                default:
                    break;
            }
        }
    };
    EventHandler<ActionEvent> escogerDistrito = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            switch (cmb_canton.getValue().toString()) {
                case "Atenas":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeAtenas);
                    break;
                case "Grecia":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeGrecia);
                    break;
                case "Guatuso":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeGuatuso);
                    break;
                case "Los Chiles":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeLosChiles);
                    break;
                case "Naranjo":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeNaranjo);
                    break;
                case "Orotina":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeOrotina);
                    break;
                case "Palmares":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDePalmares);
                    break;
                case "Poás":
                    cmb_distrito.setItems(manejadorDeProvincias.distritoDePoas);
                    break;
                case "San Carlos":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSanCarlos);
                    break;
                case "San Mateo":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSanMateo);
                    break;
                case "San Ramón":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSanRamon);
                    break;
                case "Upala":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeUpala);
                    break;
                case "Alvarado":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeAlvarado);
                    break;
                case "Cartago Central":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeCartagoCentral);
                    break;
                case "El Guarco":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeElGuarco);
                    break;
                case "Jiménez":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeJimenez);
                    break;
                case "La Unión":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeLaUnion);
                    break;
                case "Oreamuno":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeOreamuno);
                    break;
                case "Paraíso":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeParaiso);
                    break;
                case "Turrialba":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeTurrialba);
                    break;
                case "Abangares":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeAbangares);
                    break;
                case "Bagaces":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeBagaces);
                    break;
                case "Cañas":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeCanas);
                    break;
                case "Carrillo":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeCarrillos);
                    break;
                case "Nicoya":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeNicoya);
                    break;
                case "Hojancha":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeHojancha);
                    break;
                case "La Cruz":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeLaCruz);
                    break;
                case "Liberia":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeLiberia);
                    break;
                case "Nandayure":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeNandayure);
                    break;
                case "Santa Crúz":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSantaCruz);
                    break;
                case "Tilarán":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeTilaran);
                    break;
                case "Barva":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeBarva);
                    break;
                case "Belén":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeBelen);
                    break;
                case "Flores":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeFlores);
                    break;
                case "Heredia Central":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeHerediaCentral);
                    break;
                case "San Isidro":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSanIsidro);
                    break;
                case "San Pablo":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSanPablo);
                    break;
                case "San Rafael":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSanRafael);
                    break;
                case "Santa Bárbara":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSantaBarbara);
                    break;
                case "Santo Domingo":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSantoDomingo);
                    break;
                case "Sarapiquí":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSarapiqui);
                    break;
                case "Guácimo":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeGuacimo);
                    break;
                case "Limón":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeLimonCentral);
                    break;
                case "Matina":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeMatina);
                    break;
                case "Pococí":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDePococi);
                    break;
                case "Siquirres":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSiquirres);
                    break;
                case "Talamanca":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeTalamanca);
                    break;
                case "Buenos Aires":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeBuenosAires);
                    break;
                case "Corredores":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeCorredores);
                    break;
                case "Coto Brus":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeCotoBrus);
                    break;
                case "Esparza":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeEsparza);
                    break;
                case "Garabito":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeGarabito);
                    break;
                case "Golfito":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeGolfito);
                    break;
                case "Montes de Oro":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeMontesDeOro);
                    break;
                case "Osa":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeOsa);
                    break;
                case "Parrita":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeParrita);
                    break;
                case "Puntarenas Central":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDePuntarenasCentral);
                    break;
                case "Quepos":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeQuepos);
                    break;
                case "Acosta":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeAcosta);
                    break;
                case "Alajuelita":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeAlajuelita);
                    break;
                case "Aserrí":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeAserri);
                    break;
                case "Curridabat":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeCurridabat);
                    break;
                case "Desamparados":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeDesamparados);
                    break;
                case "Dota":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeDota);
                    break;
                case "Escazú":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeEscazu);
                    break;
                case "Goicoechea":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeGoicoechea);
                    break;
                case "León Cortés Castro":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeLeonCortesCastro);
                    break;
                case "Montes de Oca":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeMontesDeOca);
                    break;
                case "Mora":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeMora);
                    break;
                case "Moravia":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeMoravia);
                    break;
                case "Puriscal":
                    cmb_distrito.setItems(manejadorDeProvincias.distritoaDePuriscal);
                    break;
                case "San José Central":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeSanJoseCentral);
                    break;
                case "Tarrazú":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeTarrazu);
                    break;
                case "Tibás":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeTibas);
                    break;
                case "Turrubares":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeTurrubares);
                    break;
                case "Vázquez de Coronado":
                    cmb_distrito.setItems(manejadorDeProvincias.distritosDeVasquezDeCoronado);
                    break;


                default:
                    break;
            }
        }
    };

}

