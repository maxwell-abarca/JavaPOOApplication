package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.LineaAerea;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete.Tiquete;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.Vuelo;
import cr.ac.JuanMaswell.ucenfotec.tl.ControllerLineaAerea;
import cr.ac.JuanMaswell.ucenfotec.tl.ControllerTiquete;
import cr.ac.JuanMaswell.ucenfotec.tl.ControllerVuelo;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerVistaUsuario implements Initializable {

    @FXML
    private ImageView btn_salir, btn_minimizar;
    /*Panel principal*/
    @FXML
    private AnchorPane panel_principal;
    /**/

    /*panel de inicio*/
    @FXML
    private AnchorPane panel_bienvenidaUsuario;
    @FXML
    private ImageView btn_cerrarSesion, btn_modificarInformacion;

    /**/
    /*panel acceder*/
    @FXML
    private ImageView btn_accederInicio, btn_accederSalidas, btn_accederLlegadas, btn_accederTiquetes;

    /**/

    /*Panel vuelos salida*/
    @FXML
    private AnchorPane panel_vueloSalidaUsuario;
    @FXML
    private TableView<Vuelo> tbl_vueloSalidaUsuario;
    @FXML
    private TableColumn<Vuelo, String> clm_lineaAerea, clm_aeropuertoLlegada, clm_horaSalida, clm_sala, clm_aeropuertoDestino, clm_horaLlegada, clm_estado;
    @FXML
    private TextField txt_busquedaVueloSalida;
    @FXML
    private ImageView btn_buscarVueloSalida;
    /**/


    /*Panel de tiquetes*/
    @FXML
    private AnchorPane panel_tiquetesUsuario;
    @FXML
    private TableView<Tiquete> tbl_tiquetesUsuario;
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

    @FXML
    private Button btn_comprarTiquete;
    /*Panel de modificar informacion*/
    @FXML
    private AnchorPane panel_modificarInformacion;
    @FXML
    private JFXTextField txt_nombreModificar, txt_apellido1Modificar, txt_apellido2Modificar, txt_correoElectronicoModificar, txt_contraseniaModificar;
    @FXML
    private JFXComboBox cmb_provinciaModificar, cmb_cantonModificar, cmb_distritoModificar;
    @FXML
    private TextArea txt_areaDetalleModificar;
    /**/

    static ControllerVuelo gestorVuelo = new ControllerVuelo();
    static ControllerTiquete gestorTiquete = new ControllerTiquete();
    static ControllerLineaAerea gestorLinea=new ControllerLineaAerea();
    @FXML private ImageView btn_accederAerolineas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_salir.setOnMouseClicked(this::exitButton);
        btn_minimizar.setOnMouseClicked(this::minimizeButton);
        btn_cerrarSesion.setOnMouseClicked(evento);

        agregarDatosAVuelo();
        agregarDatosTiquete();

    }

    public void exitButton(MouseEvent evento) {
        Platform.exit();
        System.exit(0);
    }



    public void minimizeButton(MouseEvent minimize) {
        Stage stage = (Stage) ((Node) minimize.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void agregarDatosTiquete() {
        ObservableList<Tiquete> tiquetes = FXCollections.observableArrayList();
        tiquetes.addAll(gestorTiquete.listarTiquete());
        clm_fechaTiquete.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        clm_aeropuertoOrigenTiquete.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        clm_aeropuertoDestinoTiquete.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        clm_numeroAsientoTiquete.setCellValueFactory(new PropertyValueFactory<>("numeroAsiento"));
        clm_precioTiquete.setCellValueFactory(new PropertyValueFactory<>("precio"));
        clm_numeroVueloTiquete.setCellValueFactory(new PropertyValueFactory<>("numeroDeVuelo"));
        clm_tipoAsientoTiquete.setCellValueFactory(new PropertyValueFactory<>("tipoAsiento"));
        clm_impuestoTiquete.setCellValueFactory(new PropertyValueFactory<>("impuesto"));
        tbl_tiquetesUsuario.setItems(tiquetes);
    }

    public void agregarDatosAVuelo() {
        ObservableList<Vuelo> vuelos = FXCollections.observableArrayList();
        vuelos.addAll(gestorVuelo.listarVuelo());
        clm_lineaAerea.setCellValueFactory(new PropertyValueFactory<>("lineaAerea"));
        clm_aeropuertoLlegada.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        clm_aeropuertoDestino.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        clm_horaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        clm_sala.setCellValueFactory(new PropertyValueFactory<>("sala"));
        clm_horaLlegada.setCellValueFactory(new PropertyValueFactory<>("horaLlegada"));
        clm_estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tbl_vueloSalidaUsuario.setItems(vuelos);

    }

    public void presionarInicio() {

        panel_bienvenidaUsuario.setVisible(true);
        panel_vueloSalidaUsuario.setVisible(false);
        panel_tiquetesUsuario.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarSalidas() {
        panel_bienvenidaUsuario.setVisible(false);
        panel_vueloSalidaUsuario.setVisible(true);
        panel_tiquetesUsuario.setVisible(false);
        panel_modificarInformacion.setVisible(false);
    }

    public void presionarTiquetes() {

        panel_bienvenidaUsuario.setVisible(false);
        panel_vueloSalidaUsuario.setVisible(false);
        panel_tiquetesUsuario.setVisible(true);
        panel_modificarInformacion.setVisible(false);
    }

    public void modificarInformacion() {

        panel_bienvenidaUsuario.setVisible(false);
        panel_vueloSalidaUsuario.setVisible(false);
        panel_tiquetesUsuario.setVisible(false);
        panel_modificarInformacion.setVisible(true);
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
