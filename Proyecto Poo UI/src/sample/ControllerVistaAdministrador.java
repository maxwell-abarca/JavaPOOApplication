package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.LineaAerea;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.Sala;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete.Tiquete;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.Usuario;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.Vuelo;
import cr.ac.JuanMaswell.ucenfotec.tl.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerVistaAdministrador implements Initializable {
    /*Panel Principal*/
    @FXML
    private
    AnchorPane panel_principal;
    /**/
    /*Botones de cerrar y minimizar*/
    @FXML
    private ImageView btn_salir, btn_minimizar;
    @FXML
    private ImageView btn_cerrarSesion;
    /**/
    /*Panel de bienvenida admin*/
    @FXML
    private AnchorPane panel_bienvenidaAdmin;
    @FXML
    private Button btn_listarAeropuerto, btn_listarAerolinea,
            btn_listarUsuario, btn_listarVuelo, btn_listarSalas, btn_listarTiquete;
    /**/
    /*panel de tareas admin*/
    @FXML

    private AnchorPane panel_tareasAdmin;
    @FXML
    private ImageView btn_accederInicio, btn_accederAeropuerto, btn_accederLinea,
            btn_accederMiembro, btn_accederVuelo, btn_accederSala, btn_accederTiquete, btn_accederPais;
    /**/
    /*Panel de registrar país*/
    @FXML
    private AnchorPane panel_registrarPais;
    @FXML
    private JFXTextField txt_nombrePais, txt_abreviaturaPais, txt_codigoPais;
    @FXML
    private Button btn_registrarPais;

    /**/

    /*panel registrar aeropuerto*/
    @FXML
    AnchorPane panel_registrarAeropuerto;
    @FXML
    private JFXTextField txt_nombreAeropuerto, txt_codigoAeropuerto, txt_codigoPaisAeropuerto;
    @FXML
    JFXComboBox cmb_nombrePaisAeropuerto;
    @FXML
    private
    Button btn_registrarAeropuerto;
    /**/
    /*Panel registrar Linea*/
    @FXML
    private AnchorPane panel_registrarLinea;
    @FXML
    private
    JFXTextField txt_nombreComercialLinea, txt_cedulaJuridicaLinea, txt_empresaDuenaLinea;
    @FXML
    private JFXComboBox cmb_paisLinea;
    @FXML
    private ImageView img_logoLinea;
    @FXML
    private Button btn_seleccionarLogoLinea;
    @FXML
    private Button btn_registrarLinea;
    /**/

    /*panel registrar miembro*/
    @FXML
    private
    AnchorPane panel_registrarMiembro;
    @FXML
    private
    JFXTextField txt_nombreMiembro, txt_apellido1Miembro, txt_apellido2Miembro, txt_correoMiembro;
    @FXML
    private
    RadioButton radio_masculino, radio_femenino;
    @FXML
    private
    Button btn_siguiente;
    /*panel informacion adicional miembro*/
    @FXML
    private
    AnchorPane panel_informacionAdicionalMiembro;
    @FXML
    private
    JFXTextField txt_identificacionMiembro, txt_numeroLicenciaMiembro,
            txt_puestoMiembro, txt_anniosExperienciaMiembro,
            txt_telefonoMiembro;
    @FXML
    private
    DatePicker date_fechaGraduacionMiembro;
    @FXML
    private
    TextArea txt_area_detalleDireccionMiembro;
    @FXML
    private Button btn_registrarMiembro;
    /**/
    /**/

    /*Panel registrar vuelos*/
    @FXML
    private AnchorPane panel_registrarVuelo;
    @FXML
    private ComboBox cmb_lineaAereaVuelo, cmb_aeropuertoOrigenVuelo, cmb_aeropuertoDestinoVuelo,
            cmb_estadoVuelo, cmb_salaAeropuertoVuelo;
    @FXML
    private
    JFXTimePicker time_horaSalidaVuelo, time_horaLlegadaVuelo;
    @FXML
    private Button btn_registrarVuelo;
    /**/
    /*Panel registrar Sala*/
    @FXML
    private AnchorPane panel_registrarSala;
    @FXML
    private JFXTextField txt_nombreSala, txt_codigoSala, txt_nombreUbicacionSala;
    @FXML
    private Button btn_registrarSala;
    /**/
    /*Panel registrar tiquete*/
    @FXML
    private AnchorPane panel_registrarTiquete;
    @FXML
    private ComboBox cmb_aeropuertoSalidaTiquete, cmb_aeropuertoLlegadaTiquete, cmb_tipoAsientoTiquete;
    @FXML
    private DatePicker date_fechaTiquete;
    @FXML
    private JFXTextField txt_numeroAsientoTiquete, txt_numeroVueloTiquete, txt_precioTiquete, txt_impuestoTiquete;
    @FXML
    private Button btn_registrarTiquete;

    /**/
    /*Panel modificar informacion*/
    @FXML
    private AnchorPane panel_modificarInformacion;

    /**/
    ColorAdjust colorActivo = new ColorAdjust();
    ColorAdjust colorInactivo = new ColorAdjust();
    /**/

    File archivoAEscoger;

    /*panel listar vuelos vuelos*/
    @FXML
    private AnchorPane panel_listarVuelos;
    @FXML
    private TableView<Vuelo> tbl_vuelo;
    @FXML
    private TableColumn<Vuelo, String> clm_lineaAerea, clm_aeropuertoLlegada, clm_horaSalida, clm_sala, clm_aeropuertoDestino, clm_horaLlegada, clm_estado;
    @FXML
    private TextField txt_busqueda_vuelo;
    @FXML
    private
    ImageView btn_buscarVuelo;
    /**/

    /*panel listar tiquetes*/
    @FXML
    private AnchorPane panel_listarTiquetes;
    @FXML
    private TableView<Tiquete> tbl_tiquetes;
    @FXML
    private TableColumn<Tiquete, String> clm_fechaTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_paisOrigenTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_aeropuertoOrigenTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_aeropuertoDestinoTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_paisDestinoTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_numeroAsientoTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_precioTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_numeroVueloTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_tipoAsientoTiquete;
    @FXML
    private TableColumn<Tiquete, String> clm_impuestoTiquete;
    /**/

    /*panel listar aeropuertos*/
    @FXML
    private AnchorPane panel_listarAeropuertos;
    @FXML
    private TableView<Aeropuerto> tbl_aeropuertos;
    @FXML
    private TableColumn<Aeropuerto, String> clm_nombreAeropuerto;
    @FXML
    private TableColumn<Aeropuerto, String> clm_codigoAeropuerto;
    @FXML
    private TableColumn<Aeropuerto, String> clm_paisAeropuerto;
    @FXML
    private TableColumn<Aeropuerto, String> clm_codigoPaisAeropuerto;
    /**/
    /*Panel listar usuarios*/
    @FXML
    private AnchorPane panel_listarUsuarios;
    @FXML
    private TableView<Usuario> tbl_usuarios;
    @FXML
    private TableColumn<Usuario, String> clm_nombre;
    @FXML
    private TableColumn<Usuario, String> clm_apellido1;
    @FXML
    private TableColumn<Usuario, String> clm_apellido2;
    @FXML
    private TableColumn<Usuario, String> clm_correo;
    @FXML
    private TableColumn<Usuario, String> clm_genero;
    @FXML
    private TableColumn<Usuario, String> clm_cedula;
    @FXML
    private TableColumn<Usuario, String> clm_provincia;
    @FXML
    private TableColumn<Usuario, String> clm_canton;
    @FXML
    private TableColumn<Usuario, String> clm_distrito;
    @FXML
    private TableColumn<Usuario, String> clm_detalleDireccion;
    @FXML
    private TableColumn<Usuario, String> clm_nacionalidad;
    @FXML
    private TableColumn<Usuario, String> clm_fechaNacimiento;
    @FXML
    private TableColumn<Usuario, String> clm_edad;
    /**/

    /*Panel listar aerolinea*/
    @FXML
    private AnchorPane panel_listarAerolinea;
    @FXML
    private TableView<LineaAerea> tbl_aerolineas;
    @FXML
    private TableColumn<LineaAerea, String> clm_nombreComercial, clm_cedulaJuridica, clm_empresaDuena, clm_pais, clm_logo;
    /**/
    /*Panel listar Sala*/
    @FXML
    private AnchorPane panel_listarSala;
    @FXML
    private TableView<Sala> tbl_sala;

    @FXML
    private TableColumn<Sala, String> clm_nombreSala;
    @FXML
    private TableColumn<Sala, String> clm_codigoSala;
    @FXML
    private TableColumn<Sala, String> clm_ubicacionSala;


    static ControllerPais gestorPais = new ControllerPais();
    static ControllerAeropuerto gestorAeropuerto = new ControllerAeropuerto();
    static ControllerMiembro gestorMiembro = new ControllerMiembro();
    static ControllerLineaAerea gestorLinea = new ControllerLineaAerea();
    static ControllerVuelo gestorVuelo = new ControllerVuelo();
    static ControllerSala gestorSala = new ControllerSala();
    static ControllerTiquete gestorTiquete = new ControllerTiquete();
    static ControllerUsuario gestorUsuario = new ControllerUsuario();
    String genero;

    String contraseniaMiembro;


    ObservableList<String> comboEstadoVueloContent = FXCollections.observableArrayList(
            "Atrasado",
            "A tiempo",
            "Llegó",
            "Cancelado",
            "Registrado",
            "En sala"
    );
    ObservableList<String> comboTipoAsientoContent = FXCollections.observableArrayList(
            "Ventana",
            "Medio",
            "Pasillo"
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmb_estadoVuelo.setItems(comboEstadoVueloContent);
        cmb_tipoAsientoTiquete.setItems(comboTipoAsientoContent);
        ToggleGroup group = new ToggleGroup();
        radio_masculino.setToggleGroup(group);
        radio_femenino.setToggleGroup(group);
        btn_registrarPais.setOnAction(registrarPais);
        btn_registrarAeropuerto.setOnAction(registrarAeropuerto);
        btn_registrarLinea.setOnAction(registrarLinea);
        btn_seleccionarLogoLinea.setOnAction(seleccionarImagenLinea);
        btn_siguiente.setOnAction(validarPrimerPanel);
        btn_registrarMiembro.setOnAction(registrarMiembro);
        btn_registrarVuelo.setOnAction(registrarVuelo);
        btn_registrarSala.setOnAction(registrarSala);
        btn_registrarTiquete.setOnAction(registrarTiquete);
        btn_salir.setOnMouseClicked(this::exitButton);
        btn_minimizar.setOnMouseClicked(this::minimizeButton);
        cmb_nombrePaisAeropuerto.setOnMouseClicked(this::agregarPaisAeropuerto);
        cmb_paisLinea.setOnMouseClicked(this::agregarPaisLinea);
        cmb_lineaAereaVuelo.setOnMouseClicked(this::agregarLineaVuelo);
        panel_registrarAeropuerto.setOnMouseEntered(this::agregarContenidoCodigo);
        cmb_salaAeropuertoVuelo.setOnMouseClicked(this::agregarSalaVuelo);
        cmb_aeropuertoOrigenVuelo.setOnMouseClicked(this::agregarAeropuertoVuelo);
        panel_registrarTiquete.setOnMouseEntered(this::agregarAeropuertoTiquete);
        btn_listarAeropuerto.setOnAction(this::agregarDatosAListarAeropuerto);
        btn_listarUsuario.setOnAction(this::agregarDatosAListarUsuarios);
        btn_listarSalas.setOnAction(this::agregarDatosAListarSala);
        btn_listarTiquete.setOnAction(this::agregarDatosAListarTiquete);
        btn_listarAerolinea.setOnAction(this::agregarDatosAeroLinea);
        btn_listarVuelo.setOnAction(this::agregarDatosVuelo);
        btn_cerrarSesion.setOnMouseClicked(evento);

        colorActivo.setSaturation(0.48);
        colorActivo.setContrast(1.0);
        colorActivo.setHue(1.0);
        colorInactivo.setSaturation(0.0);

    }

    public void exitButton(MouseEvent onClose) {
        Platform.exit();
        System.exit(0);
    }

    public void minimizeButton(MouseEvent minimize) {
        Stage stage = (Stage) ((Node) minimize.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void agregarLineaVuelo(MouseEvent event) {
        ObservableList<String> lineasVuelo = FXCollections.observableArrayList(
                gestorLinea.listarPorNombre()
        );
        cmb_lineaAereaVuelo.setItems(lineasVuelo);
    }

    public void agregarDatosVuelo(ActionEvent evento) {
        ObservableList<Vuelo> vuelos = FXCollections.observableArrayList();
        vuelos.addAll(gestorVuelo.listarVuelo());
        clm_lineaAerea.setCellValueFactory(new PropertyValueFactory<>("lineaAerea"));
        clm_aeropuertoLlegada.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        clm_aeropuertoDestino.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        clm_horaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        clm_sala.setCellValueFactory(new PropertyValueFactory<>("sala"));
        clm_horaLlegada.setCellValueFactory(new PropertyValueFactory<>("horaLlegada"));
        clm_estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tbl_vuelo.setItems(vuelos);
    }

    public void agregarDatosAeroLinea(ActionEvent Event) {
        ObservableList<LineaAerea> lineaAereas = FXCollections.observableArrayList();
        lineaAereas.addAll(gestorLinea.listarLineas());
        clm_nombreComercial.setCellValueFactory(new PropertyValueFactory<>("nombreComercial"));
        clm_cedulaJuridica.setCellValueFactory(new PropertyValueFactory<>("cedulaJuridica"));
        clm_empresaDuena.setCellValueFactory(new PropertyValueFactory<>("nombreEmpresaDuena"));
        clm_pais.setCellValueFactory(new PropertyValueFactory<>("nombrePais"));
        clm_logo.setCellValueFactory(new PropertyValueFactory<>("logo"));
        tbl_aerolineas.setItems(lineaAereas);

    }

    public void agregarDatosAListarTiquete(ActionEvent event) {

        ObservableList<Tiquete> tiquetesATabla = FXCollections.observableArrayList();
        tiquetesATabla.addAll(gestorTiquete.listarTiquete());
        clm_fechaTiquete.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        clm_aeropuertoOrigenTiquete.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        clm_aeropuertoDestinoTiquete.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        clm_numeroAsientoTiquete.setCellValueFactory(new PropertyValueFactory<>("numeroAsiento"));
        clm_precioTiquete.setCellValueFactory(new PropertyValueFactory<>("precio"));
        clm_numeroVueloTiquete.setCellValueFactory(new PropertyValueFactory<>("numeroDeVuelo"));
        clm_tipoAsientoTiquete.setCellValueFactory(new PropertyValueFactory<>("tipoAsiento"));
        clm_impuestoTiquete.setCellValueFactory(new PropertyValueFactory<>("impuesto"));
        tbl_tiquetes.setItems(tiquetesATabla);
    }

    public void agregarDatosAListarAeropuerto(ActionEvent event) {
        ObservableList<Aeropuerto> aeropuertosATabla = FXCollections.observableArrayList(
        );
        aeropuertosATabla.addAll(gestorAeropuerto.listarAeropuerto());
        clm_nombreAeropuerto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        clm_codigoAeropuerto.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clm_paisAeropuerto.setCellValueFactory(new PropertyValueFactory<>("nombrePais"));
        clm_codigoPaisAeropuerto.setCellValueFactory(new PropertyValueFactory<>("codigoPais"));
        tbl_aeropuertos.setItems(aeropuertosATabla);
    }

    public void agregarDatosAListarUsuarios(ActionEvent event) {
        ObservableList<Usuario> usuariosATabla = FXCollections.observableArrayList();
        usuariosATabla.addAll(gestorUsuario.listarUsuario());
        clm_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        clm_apellido1.setCellValueFactory(new PropertyValueFactory<>("apellido1"));
        clm_apellido2.setCellValueFactory(new PropertyValueFactory<>("apellido2"));
        clm_correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        clm_genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        clm_cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        clm_provincia.setCellValueFactory(new PropertyValueFactory<>("provincia"));
        clm_canton.setCellValueFactory(new PropertyValueFactory<>("canton"));
        clm_distrito.setCellValueFactory(new PropertyValueFactory<>("distrito"));
        clm_detalleDireccion.setCellValueFactory(new PropertyValueFactory<>("detalleDireccion"));
        clm_nacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        clm_fechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        clm_edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tbl_usuarios.setItems(usuariosATabla);
    }

    public void agregarDatosAListarSala(ActionEvent event) {
        ObservableList<Sala> salasATabla = FXCollections.observableArrayList();
        salasATabla.addAll(gestorSala.listarSalas());
        clm_nombreSala.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        clm_codigoSala.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clm_ubicacionSala.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        tbl_sala.setItems(salasATabla);
    }


    public void presionarListarSala(MouseEvent open) {
        panel_listarSala.setVisible(true);
        panel_listarAerolinea.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarListarAerolinea(MouseEvent open) {
        panel_listarSala.setVisible(false);
        panel_listarAerolinea.setVisible(true);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarListarUsuario(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(true);
        panel_listarAeropuertos.setVisible(false);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarListarAeropuerto(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(true);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarListarTiquete(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);

        panel_listarTiquetes.setVisible(true);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarListarVuelo(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(true);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarCasa(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorActivo);
        btn_accederPais.setEffect(colorInactivo);
        btn_accederAeropuerto.setEffect(colorInactivo);
        btn_accederLinea.setEffect(colorInactivo);
        btn_accederMiembro.setEffect(colorInactivo);
        btn_accederVuelo.setEffect(colorInactivo);
        btn_accederSala.setEffect(colorInactivo);
        btn_accederTiquete.setEffect(colorInactivo);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(true);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);

    }

    public void presionarPais() {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorInactivo);
        btn_accederPais.setEffect(colorActivo);
        btn_accederAeropuerto.setEffect(colorInactivo);
        btn_accederLinea.setEffect(colorInactivo);
        btn_accederMiembro.setEffect(colorInactivo);
        btn_accederVuelo.setEffect(colorInactivo);
        btn_accederSala.setEffect(colorInactivo);
        btn_accederTiquete.setEffect(colorInactivo);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(true);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarAeropuerto(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorInactivo);
        btn_accederPais.setEffect(colorInactivo);
        btn_accederAeropuerto.setEffect(colorActivo);
        btn_accederLinea.setEffect(colorInactivo);
        btn_accederMiembro.setEffect(colorInactivo);
        btn_accederVuelo.setEffect(colorInactivo);
        btn_accederSala.setEffect(colorInactivo);
        btn_accederTiquete.setEffect(colorInactivo);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(true);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);


    }

    public void presionarLinea(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorInactivo);
        btn_accederPais.setEffect(colorInactivo);
        btn_accederAeropuerto.setEffect(colorInactivo);
        btn_accederLinea.setEffect(colorActivo);
        btn_accederMiembro.setEffect(colorInactivo);
        btn_accederVuelo.setEffect(colorInactivo);
        btn_accederSala.setEffect(colorInactivo);
        btn_accederTiquete.setEffect(colorInactivo);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarLinea.setVisible(true);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarMiembro(MouseEvent open) {
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorInactivo);
        btn_accederPais.setEffect(colorInactivo);
        btn_accederAeropuerto.setEffect(colorInactivo);
        btn_accederLinea.setEffect(colorInactivo);
        btn_accederMiembro.setEffect(colorActivo);
        btn_accederVuelo.setEffect(colorInactivo);
        btn_accederSala.setEffect(colorInactivo);
        btn_accederTiquete.setEffect(colorInactivo);
        panel_listarTiquetes.setVisible(false);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarMiembro.setVisible(true);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarPais.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void pasarSiguientePanel() {
        if (!(validarMiembro())) {
            panel_informacionAdicionalMiembro.setVisible(true);
            panel_bienvenidaAdmin.setVisible(false);
            panel_registrarAeropuerto.setVisible(false);
            panel_registrarLinea.setVisible(false);
            panel_registrarMiembro.setVisible(false);
            panel_registrarVuelo.setVisible(false);
            panel_registrarPais.setVisible(false);
            panel_registrarSala.setVisible(false);
            panel_registrarTiquete.setVisible(false);
            panel_modificarInformacion.setVisible(false);
        } else {
            Alert alertaMiembro = new Alert(Alert.AlertType.ERROR);
            alertaMiembro.setHeaderText("Error");
            alertaMiembro.setContentText("Revise los campos e intentelo nuevamente");
            alertaMiembro.showAndWait();
        }

    }

    public void presionarVuelo(MouseEvent open) {
        panel_listarVuelos.setVisible(false);
        panel_listarTiquetes.setVisible(false);
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorInactivo);
        btn_accederPais.setEffect(colorInactivo);
        btn_accederAeropuerto.setEffect(colorInactivo);
        btn_accederLinea.setEffect(colorInactivo);
        btn_accederMiembro.setEffect(colorInactivo);
        btn_accederVuelo.setEffect(colorActivo);
        btn_accederSala.setEffect(colorInactivo);
        btn_accederTiquete.setEffect(colorInactivo);

        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarVuelo.setVisible(true);
        panel_registrarPais.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarSala(MouseEvent open) {

        panel_listarTiquetes.setVisible(false);
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorInactivo);
        btn_accederPais.setEffect(colorInactivo);
        btn_accederAeropuerto.setEffect(colorInactivo);
        btn_accederLinea.setEffect(colorInactivo);
        btn_accederMiembro.setEffect(colorInactivo);
        btn_accederVuelo.setEffect(colorInactivo);
        btn_accederSala.setEffect(colorActivo);
        btn_accederTiquete.setEffect(colorInactivo);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(true);
        panel_registrarPais.setVisible(false);
        panel_registrarTiquete.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarTiquete(MouseEvent open) {
        panel_listarTiquetes.setVisible(false);
        panel_listarAerolinea.setVisible(false);
        panel_listarSala.setVisible(false);
        panel_listarUsuarios.setVisible(false);
        panel_listarAeropuertos.setVisible(false);
        btn_accederInicio.setEffect(colorInactivo);
        btn_accederPais.setEffect(colorInactivo);
        btn_accederAeropuerto.setEffect(colorInactivo);
        btn_accederLinea.setEffect(colorInactivo);
        btn_accederMiembro.setEffect(colorInactivo);
        btn_accederVuelo.setEffect(colorInactivo);
        btn_accederSala.setEffect(colorInactivo);
        btn_accederTiquete.setEffect(colorActivo);
        panel_listarVuelos.setVisible(false);
        panel_bienvenidaAdmin.setVisible(false);
        panel_registrarAeropuerto.setVisible(false);
        panel_registrarLinea.setVisible(false);
        panel_registrarMiembro.setVisible(false);
        panel_informacionAdicionalMiembro.setVisible(false);
        panel_registrarVuelo.setVisible(false);
        panel_registrarSala.setVisible(false);
        panel_registrarTiquete.setVisible(true);
        panel_modificarInformacion.setVisible(false);
        panel_registrarPais.setVisible(false);
    }

    public boolean validarPais() {
        boolean error = false;
        if (txt_nombrePais.getText().isEmpty()) {
            error = true;
            txt_nombrePais.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombrePais.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombrePais.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombrePais.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_abreviaturaPais.getText().isEmpty()) {
            error = true;
            txt_abreviaturaPais.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_abreviaturaPais.getText().matches("[a-zA-Z]{3}"))) {
            error = true;
            txt_abreviaturaPais.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_abreviaturaPais.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_codigoPais.getText().isEmpty()) {
            error = true;
            txt_codigoPais.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_codigoPais.getText().matches("\\d{4}"))) {
            error = true;
            txt_codigoPais.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_codigoPais.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        return error;
    }

    public boolean validarAeropuerto() {
        boolean error = false;
        if (txt_nombreAeropuerto.getText().isEmpty()) {
            error = true;
            txt_nombreAeropuerto.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombreAeropuerto.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombreAeropuerto.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombreAeropuerto.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_codigoAeropuerto.getText().isEmpty()) {
            txt_codigoAeropuerto.setStyle("-jfx-unfocus-color:red");
            error = true;
        } else if (!(txt_codigoAeropuerto.getText().matches("\\d{4}"))) {
            txt_codigoAeropuerto.setStyle("-jfx-unfocus-color:red");
            error = true;
        } else {
            error = false;
            txt_codigoAeropuerto.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (cmb_nombrePaisAeropuerto.getSelectionModel().isEmpty()) {
            error = true;
            cmb_nombrePaisAeropuerto.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_nombrePaisAeropuerto.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_codigoPaisAeropuerto.getText().isEmpty()) {
            error = true;
            txt_codigoPaisAeropuerto.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_codigoPaisAeropuerto.getText().matches("\\d{4}"))) {
            error = true;
            txt_codigoPaisAeropuerto.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_codigoPaisAeropuerto.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        return error;
    }

    public boolean validarAerolinea() {
        boolean error = false;
        if (txt_nombreComercialLinea.getText().isEmpty()) {
            error = true;
            txt_nombreComercialLinea.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombreComercialLinea.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombreComercialLinea.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombreComercialLinea.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_cedulaJuridicaLinea.getText().isEmpty()) {
            error = true;
            txt_cedulaJuridicaLinea.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_cedulaJuridicaLinea.getText().matches("\\d{9}"))) {
            error = true;
            txt_cedulaJuridicaLinea.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_cedulaJuridicaLinea.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_empresaDuenaLinea.getText().isEmpty()) {
            error = true;
            txt_empresaDuenaLinea.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_empresaDuenaLinea.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_empresaDuenaLinea.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_empresaDuenaLinea.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (cmb_paisLinea.getSelectionModel().isEmpty()) {
            error = true;
            cmb_paisLinea.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_paisLinea.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        return error;
    }


    public boolean validarMiembro() {
        boolean error;

        if (txt_nombreMiembro.getText().isEmpty()) {
            error = true;
            txt_nombreMiembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombreMiembro.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombreMiembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombreMiembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_apellido1Miembro.getText().isEmpty()) {
            error = true;
            txt_apellido1Miembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_apellido1Miembro.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_apellido1Miembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_apellido1Miembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_apellido2Miembro.getText().isEmpty()) {
            error = true;
            txt_apellido2Miembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_apellido2Miembro.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_apellido2Miembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_apellido2Miembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (!(radio_masculino.isSelected() || radio_femenino.isSelected())) {
            error = true;
        } else {
            error = false;
        }
        if (radio_masculino.isSelected()) {
            genero = radio_masculino.getText();
        } else if (radio_femenino.isSelected()) {
            genero = radio_femenino.getText();
        }
        if (txt_correoMiembro.getText().isEmpty()) {
            error = true;
            txt_correoMiembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_correoMiembro.getText().contains("@") && txt_correoMiembro.getText().contains(".com"))) {
            error = true;
            txt_correoMiembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_correoMiembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }

        return error;
    }


    public boolean validarInformacionAdicionalMiembro() {
        boolean error = false;

        if (txt_identificacionMiembro.getText().isEmpty()) {
            error = true;
            txt_identificacionMiembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_identificacionMiembro.getText().matches("[0-9]{9}"))) {
            error = true;
            txt_identificacionMiembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_identificacionMiembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_numeroLicenciaMiembro.getText().isEmpty()) {
            error = true;
            txt_numeroLicenciaMiembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_numeroLicenciaMiembro.getText().matches("[0-9]{6,15}"))) {
            error = true;
            txt_numeroLicenciaMiembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_numeroLicenciaMiembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_puestoMiembro.getText().isEmpty()) {
            error = true;
            txt_puestoMiembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_puestoMiembro.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_puestoMiembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_puestoMiembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (date_fechaGraduacionMiembro.getValue() == null) {
            error = true;
            date_fechaGraduacionMiembro.setStyle("-jfx-default-color:red");
        } else {
            error = false;
            date_fechaGraduacionMiembro.setStyle("-jfx-default-color:#4059a9");
        }
        if (txt_anniosExperienciaMiembro.getText().isEmpty()) {
            error = true;
            txt_anniosExperienciaMiembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_anniosExperienciaMiembro.getText().matches("[0-9]{1,99}"))) {
            error = true;
            txt_anniosExperienciaMiembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_anniosExperienciaMiembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }

        if (txt_telefonoMiembro.getText().isEmpty()) {
            error = true;
            txt_telefonoMiembro.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_telefonoMiembro.getText().matches("[0-9]{8}"))) {
            error = true;
            txt_telefonoMiembro.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_telefonoMiembro.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_area_detalleDireccionMiembro.getText().isEmpty()) {
            error = true;
        } else {
            error = false;
        }
        return error;
    }


    public boolean validarVuelo() {
        boolean error = false;
        if (cmb_lineaAereaVuelo.getSelectionModel().isEmpty()) {
            error = true;
            cmb_lineaAereaVuelo.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_lineaAereaVuelo.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (cmb_aeropuertoOrigenVuelo.getSelectionModel().isEmpty()) {
            error = true;
            cmb_aeropuertoOrigenVuelo.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_aeropuertoOrigenVuelo.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (time_horaSalidaVuelo.getValue() == null) {
            error = true;
            time_horaSalidaVuelo.setStyle("-jfx-default-color:red");
        } else {
            error = false;
            time_horaSalidaVuelo.setStyle("-jfx-default-color:#4d4d4d");
        }
        if (cmb_salaAeropuertoVuelo.getSelectionModel().isEmpty()) {
            error = true;
            cmb_salaAeropuertoVuelo.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_salaAeropuertoVuelo.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (cmb_aeropuertoDestinoVuelo.getSelectionModel().isEmpty()) {
            error = true;
            cmb_aeropuertoDestinoVuelo.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_aeropuertoDestinoVuelo.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (time_horaLlegadaVuelo.getValue() == null) {
            error = true;
            time_horaLlegadaVuelo.setStyle("-jfx-default-color:red");
        } else {
            error = false;
            time_horaLlegadaVuelo.setStyle("-jfx-default-color:#4d4d4d");
        }
        if (cmb_estadoVuelo.getSelectionModel().isEmpty()) {
            error = true;
            cmb_estadoVuelo.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_estadoVuelo.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        return error;
    }

    public boolean validarSala() {
        boolean error = false;
        if (txt_nombreSala.getText().isEmpty()) {
            error = true;
            txt_nombreSala.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombreSala.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombreSala.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombreSala.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_codigoSala.getText().isEmpty()) {
            error = true;
            txt_codigoSala.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_codigoSala.getText().matches("\\d{4}"))) {
            error = true;
            txt_codigoSala.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_codigoSala.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_nombreUbicacionSala.getText().isEmpty()) {
            error = true;
            txt_nombreUbicacionSala.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_nombreUbicacionSala.getText().matches("[a-zA-Z\\s']+"))) {
            error = true;
            txt_nombreUbicacionSala.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_nombreUbicacionSala.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        return error;
    }

    public boolean validarTiquete() {
        boolean error = false;
        if (date_fechaTiquete.getValue() == null) {
            error = true;
            date_fechaTiquete.setStyle("-jfx-default-color:red");
        } else {
            error = false;
            date_fechaTiquete.setStyle("-jfx-default-color:#4d4d4d");
        }
        if (cmb_aeropuertoSalidaTiquete.getSelectionModel().isEmpty()) {
            error = true;
            cmb_aeropuertoSalidaTiquete.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_aeropuertoSalidaTiquete.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (cmb_aeropuertoLlegadaTiquete.getSelectionModel().isEmpty()) {
            error = true;
            cmb_aeropuertoLlegadaTiquete.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_aeropuertoLlegadaTiquete.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_numeroAsientoTiquete.getText().isEmpty()) {
            error = true;
            txt_numeroAsientoTiquete.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_numeroAsientoTiquete.getText().matches("[0-9]{1,99}"))) {
            error = true;
            txt_numeroAsientoTiquete.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (cmb_tipoAsientoTiquete.getSelectionModel().isEmpty()) {
            error = true;
            cmb_tipoAsientoTiquete.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            cmb_tipoAsientoTiquete.setStyle("-jfx-unfocus-color:#4d4d4d");
        }
        if (txt_numeroVueloTiquete.getText().isEmpty()) {
            error = true;
            txt_numeroVueloTiquete.setStyle("-jfx-unfocus-color:red");
        } else if (!(txt_numeroVueloTiquete.getText().matches("[0-9]{1,99}"))) {
            error = true;
            txt_numeroVueloTiquete.setStyle("-jfx-unfocus-color:red");
        } else {
            error = false;
            txt_numeroVueloTiquete.setStyle("-jfx-unfocus-color:#4d4d4d");
        }

        return error;
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
        String cuerpo = "Saludos! " + txt_nombreMiembro.getText() + " del equipo de software de aerodynamic, su contraseña es: " + contraseniaMiembro;
        try {

            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(txt_correoMiembro.getText()));
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

    public void vaciarCamposAeroLinea() {
        txt_nombreComercialLinea.setText(" ");
        txt_cedulaJuridicaLinea.setText(" ");
        txt_empresaDuenaLinea.setText(" ");
        cmb_paisLinea.getSelectionModel().isEmpty();
        img_logoLinea.setImage(null);
    }

    public void vaciarCamposPais() {
        txt_nombrePais.setText(" ");
        txt_abreviaturaPais.setText(" ");
        txt_codigoPais.setText(" ");
    }

    public void vaciarCamposAeropuerto() {
        txt_nombreAeropuerto.setText(" ");
        txt_codigoAeropuerto.setText(" ");
        cmb_nombrePaisAeropuerto.getSelectionModel().isEmpty();
        txt_codigoPais.setText(" ");
    }

    public void vaciarCamposMiembro() {
        txt_nombreMiembro.setText(" ");
        txt_apellido1Miembro.setText(" ");
        txt_apellido2Miembro.setText(" ");
        radio_masculino.setSelected(false);
        radio_femenino.setSelected(false);
        txt_correoMiembro.setText(" ");
        txt_identificacionMiembro.setText(" ");
        txt_numeroLicenciaMiembro.setText(" ");
        txt_puestoMiembro.setText(" ");
        date_fechaGraduacionMiembro.setValue(null);
        txt_anniosExperienciaMiembro.setText(" ");
        txt_telefonoMiembro.setText(" ");
        txt_area_detalleDireccionMiembro.setText(" ");
    }

    public void vaciarCamposSala() {
        txt_nombreSala.setText(" ");
        txt_codigoSala.setText(" ");
        txt_nombreUbicacionSala.setText(" ");
    }

    EventHandler<ActionEvent> registrarPais = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            if (validarPais() == false) {
                if (gestorPais.validarPaisRepetido(txt_nombrePais.getText(), txt_codigoPais.getText()) != null) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("El pais ya existe");
                    alerta.showAndWait();
                } else {
                    gestorPais.registrarPais(txt_nombrePais.getText(), txt_abreviaturaPais.getText(), txt_codigoPais.getText());
                    Alert alertaPaisRegistrado = new Alert(Alert.AlertType.INFORMATION);
                    alertaPaisRegistrado.setHeaderText("País registrado con éxito");
                    alertaPaisRegistrado.setContentText("La información que digitó fue registrada con éxito");
                    alertaPaisRegistrado.showAndWait();
                    vaciarCamposPais();
                }
            } else {
                Alert alertaPais = new Alert(Alert.AlertType.ERROR);
                alertaPais.setHeaderText("Error");
                alertaPais.setContentText("Revise los campos e intentelo nuevamente");
                alertaPais.showAndWait();
            }
        }
    };
    EventHandler<ActionEvent> registrarAeropuerto = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            if (validarAeropuerto() == false) {
                if (gestorAeropuerto.validarAeropuerto(txt_codigoAeropuerto.getText()) != null) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("El aeropuerto ya ha sido registrado");
                    alerta.showAndWait();
                } else {
                    gestorAeropuerto.registrarAeropuerto(txt_nombreAeropuerto.getText(), txt_codigoAeropuerto.getText(), cmb_nombrePaisAeropuerto.getValue().toString(), txt_codigoPaisAeropuerto.getText());
                    Alert alertaAeropuertoRegistrado = new Alert(Alert.AlertType.INFORMATION);
                    alertaAeropuertoRegistrado.setHeaderText("Aeropuerto registrado con éxito");
                    alertaAeropuertoRegistrado.setContentText("La informacion que digitó fue registrada con éxito");
                    alertaAeropuertoRegistrado.showAndWait();
                    vaciarCamposAeropuerto();
                }
            } else {
                Alert alertaAeropuerto = new Alert(Alert.AlertType.ERROR);
                alertaAeropuerto.setHeaderText("Error");
                alertaAeropuerto.setContentText("Revise los campos e intentelo nuevamente");
                alertaAeropuerto.showAndWait();

            }
        }
    };
    EventHandler<ActionEvent> registrarLinea = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (validarAerolinea() == false) {
                if (gestorLinea.validarLinea(txt_cedulaJuridicaLinea.getText()) != null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Error");
                    alert.setContentText("La linea aerea ya ha sido registrada previamente");
                    alert.show();
                } else {
                    gestorLinea.registrarLineaAerea(txt_nombreComercialLinea.getText(), txt_cedulaJuridicaLinea.getText(), txt_empresaDuenaLinea.getText(), cmb_paisLinea.getValue().toString(), archivoAEscoger.getPath());
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setHeaderText("Se registro la aerolinea");
                    alerta.setContentText("Se registro la aerolinea de manera correcta");
                    alerta.show();
                    vaciarCamposAeroLinea();
                }
            } else {
                Alert alertaLinea = new Alert(Alert.AlertType.ERROR);
                alertaLinea.setHeaderText("Error");
                alertaLinea.setContentText("Revise los campos e intentelo nuevamente");
                alertaLinea.showAndWait();
            }
        }
    };
    EventHandler<ActionEvent> seleccionarImagenLinea = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            FileChooser escogerArchivo = new FileChooser();
            escogerArchivo.setTitle("Escoger logo de aerolínea");
            archivoAEscoger = escogerArchivo.showOpenDialog(stage);
            try {
                BufferedImage bufferedImage = ImageIO.read(archivoAEscoger);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                img_logoLinea.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    EventHandler<ActionEvent> validarPrimerPanel = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            boolean errorMiembro = validarMiembro();
            if (errorMiembro) {
                Alert alertaMiembro = new Alert(Alert.AlertType.ERROR);
                alertaMiembro.setHeaderText("Error");
                alertaMiembro.setContentText("Revise los campos e intentelo nuevamente");
                alertaMiembro.showAndWait();
            } else {
                pasarSiguientePanel();
            }
        }
    };
    EventHandler<ActionEvent> registrarMiembro = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            if (validarInformacionAdicionalMiembro() == false) {
                if (gestorMiembro.validarMiembroRepetido(txt_correoMiembro.getText()) != null) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("El miembro fué registrado anteriormente");
                    alerta.showAndWait();
                } else {
                    randomContrasennia();
                    enviarCorreo();
                    gestorMiembro.registrarMiembro(txt_nombreMiembro.getText(), txt_apellido1Miembro.getText(), txt_apellido2Miembro.getText(), txt_correoMiembro.getText(), genero, contraseniaMiembro, txt_identificacionMiembro.getText(), txt_numeroLicenciaMiembro.getText(), txt_puestoMiembro.getText(), date_fechaGraduacionMiembro.getValue(), txt_anniosExperienciaMiembro.getText(), txt_telefonoMiembro.getText(), txt_area_detalleDireccionMiembro.getText());
                    Alert alertaMiembroRegistrado = new Alert(Alert.AlertType.INFORMATION);
                    alertaMiembroRegistrado.setHeaderText("Miembro registrado con éxito");
                    alertaMiembroRegistrado.setContentText("La informacion que digitó fue registrada con éxito");
                    alertaMiembroRegistrado.showAndWait();
                    vaciarCamposMiembro();
                }
            } else {
                Alert alertaMiembroTodo = new Alert(Alert.AlertType.ERROR);
                alertaMiembroTodo.setHeaderText("Error");
                alertaMiembroTodo.setContentText("Revise los campos e intentelo nuevamente");
                alertaMiembroTodo.showAndWait();
            }
        }
    };
    EventHandler<ActionEvent> registrarVuelo = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (validarVuelo() == false) {
                if (gestorVuelo.validarVuelo(cmb_salaAeropuertoVuelo.getValue().toString()) != null) {
                    Alert alertaVuelo = new Alert(Alert.AlertType.ERROR);
                    alertaVuelo.setHeaderText("Error");
                    alertaVuelo.setContentText("El vuelo fue registrado anteriormente");
                    alertaVuelo.showAndWait();
                } else {
                    gestorVuelo.registrarVuelo(cmb_lineaAereaVuelo.getValue().toString(), cmb_aeropuertoOrigenVuelo.getValue().toString(), time_horaLlegadaVuelo.getValue().toString(), time_horaSalidaVuelo.getValue().toString(), cmb_estadoVuelo.getValue().toString(), cmb_aeropuertoDestinoVuelo.getValue().toString(), cmb_salaAeropuertoVuelo.getValue().toString());
                    Alert alertaVuelo = new Alert(Alert.AlertType.INFORMATION);
                    alertaVuelo.setHeaderText("Datos registrados con éxito");
                    alertaVuelo.setContentText("El vuelo fue registrado correctamente");
                    alertaVuelo.showAndWait();
                    vaciarCamposVuelo();
                }
            } else {
                Alert alertaVuelo = new Alert(Alert.AlertType.ERROR);
                alertaVuelo.setHeaderText("Error");
                alertaVuelo.setContentText("Revise los campos e intentelo nuevamente");
                alertaVuelo.showAndWait();
            }
        }
    };
    EventHandler<ActionEvent> registrarSala = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            if (validarSala() == false) {
                if (gestorSala.validarSala(txt_codigoSala.getText()) != null) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("La sala ya fué registrada anteriormente");
                    alerta.show();
                } else {
                    gestorSala.registrarSala(txt_nombreSala.getText(), txt_codigoSala.getText(), txt_nombreUbicacionSala.getText());
                    Alert alertaSalaRegistrada = new Alert(Alert.AlertType.INFORMATION);
                    alertaSalaRegistrada.setHeaderText("Sala registrada con éxito");
                    alertaSalaRegistrada.setContentText("La informacion que digito fue registrada con éxito");
                    alertaSalaRegistrada.showAndWait();
                    vaciarCamposSala();
                }
            } else {
                Alert alertaSala = new Alert(Alert.AlertType.ERROR);
                alertaSala.setHeaderText("Error");
                alertaSala.setContentText("Revise los campos e intentelo nuevamente");
                alertaSala.showAndWait();
            }
        }
    };
    EventHandler<ActionEvent> registrarTiquete = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (validarTiquete() == false) {
                if (gestorTiquete.validarTiqueteRepetido(Integer.parseInt(txt_numeroVueloTiquete.getText())) != 0) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("El tiquete ya ha sido registrado anteriormente");
                    alerta.show();
                } else {
                    gestorTiquete.registrarTiquete(date_fechaTiquete.getValue(), cmb_aeropuertoSalidaTiquete.getValue().toString(), cmb_aeropuertoLlegadaTiquete.getValue().toString(), Integer.parseInt(txt_numeroAsientoTiquete.getText()), Double.parseDouble(txt_precioTiquete.getText()), Integer.parseInt(txt_numeroVueloTiquete.getText()), cmb_tipoAsientoTiquete.getValue().toString(), Double.parseDouble(txt_impuestoTiquete.getText()));
                    Alert alertaTiqueteRegistrado = new Alert(Alert.AlertType.INFORMATION);
                    alertaTiqueteRegistrado.setHeaderText("Sala registrada con éxito");
                    alertaTiqueteRegistrado.setContentText("La informacion que digito fue registrada con éxito");
                    alertaTiqueteRegistrado.showAndWait();
                    vaciarCamposTiquete();
                }
            } else {
                Alert alertaSala = new Alert(Alert.AlertType.ERROR);
                alertaSala.setHeaderText("Error");
                alertaSala.setContentText("Revise los campos e intentelo nuevamente");
                alertaSala.showAndWait();
            }
        }
    };


    public void agregarPaisAeropuerto(MouseEvent event) {
        ObservableList<String> paises = FXCollections.observableArrayList(
                gestorPais.listarNombrePais()
        );
        cmb_nombrePaisAeropuerto.setItems(paises);

    }

    public void agregarPaisLinea(MouseEvent event) {
        ObservableList<String> paises = FXCollections.observableArrayList(
                gestorPais.listarNombrePais()
        );
        cmb_paisLinea.setItems(paises);
    }

    public void agregarSalaVuelo(MouseEvent evento) {
        ObservableList<String> lineas = FXCollections.observableArrayList(
                gestorSala.listarNombreSala()
        );
        cmb_salaAeropuertoVuelo.setItems(lineas);
    }

    public void agregarAeropuertoVuelo(MouseEvent event) {
        ObservableList<String> aeropuertos = FXCollections.observableArrayList(
                gestorAeropuerto.listarNombreAeropuerto()
        );
        cmb_aeropuertoOrigenVuelo.setItems(aeropuertos);
        cmb_aeropuertoDestinoVuelo.setItems(aeropuertos);
    }

    public void agregarAeropuertoTiquete(MouseEvent event) {
        ObservableList<String> aeropuerto = FXCollections.observableArrayList(
                gestorAeropuerto.listarNombreAeropuerto()
        );
        cmb_aeropuertoLlegadaTiquete.setItems(aeropuerto);
        cmb_aeropuertoSalidaTiquete.setItems(aeropuerto);
    }


    public void agregarContenidoCodigo(MouseEvent evento) {
        String nombrePais = (String) cmb_nombrePaisAeropuerto.getSelectionModel().getSelectedItem();
        txt_codigoPaisAeropuerto.setText(gestorPais.buscarPaisPorNombre(nombrePais));
    }

    public void vaciarCamposTiquete() {
        date_fechaTiquete.setValue(null);
        cmb_aeropuertoSalidaTiquete.getSelectionModel().isEmpty();
        cmb_aeropuertoSalidaTiquete.getSelectionModel().isEmpty();
        txt_numeroAsientoTiquete.setText(" ");
        cmb_tipoAsientoTiquete.getSelectionModel().isEmpty();
        txt_numeroVueloTiquete.setText(" ");
        txt_precioTiquete.setText(" ");
        txt_impuestoTiquete.setText(" ");
    }

    public void vaciarCamposVuelo() {
        cmb_lineaAereaVuelo.getSelectionModel().isEmpty();
        cmb_aeropuertoOrigenVuelo.getSelectionModel().isEmpty();
        time_horaSalidaVuelo.setValue(null);
        time_horaLlegadaVuelo.setValue(null);
        cmb_salaAeropuertoVuelo.getSelectionModel().isEmpty();
        cmb_aeropuertoDestinoVuelo.getSelectionModel().isEmpty();
        cmb_estadoVuelo.getSelectionModel().isEmpty();
    }


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
        contraseniaMiembro = String.copyValueOf(almacenador);
    }

    EventHandler<MouseEvent> evento = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("inicioSesion.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}

