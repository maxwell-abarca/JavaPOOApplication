package sample;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.Vuelo;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerVistaMiembro implements Initializable {

    @FXML
    private AnchorPane panel_bienvenidaMiembro;
    @FXML
    private AnchorPane panel_vuelosRealizados;
    @FXML
    private AnchorPane panel_vuelosProgramados;

    @FXML
    private ImageView btn_accederInicio;
    @FXML
    private ImageView btn_vuelosRealizados;
    @FXML
    ImageView btn_vuelosProgramados;
    @FXML
    private
    ImageView btn_salir;
    @FXML
    private ImageView btn_minimizar;

    @FXML
    private
    TableView<Vuelo> tbl_vuelosRealizados;
    @FXML
    private TableColumn<Vuelo, String> clm_lineaAerea, clm_aeropuertoLlegada, clm_horaSalida, clm_sala, clm_aeropuertoDestino, clm_horaLlegada, clm_estado;

    static ControllerVuelo gestorVuelo = new ControllerVuelo();

    @FXML
    private TableView<Vuelo> tbl_vuelosProgramados;

    @FXML
    private TableColumn<Vuelo, String> clm_lineaAerea1, clm_aeropuertoLlegada1, clm_horaSalida1, clm_sala1, clm_aeropuertoDestino1, clm_horaLlegada1, clm_estado1;
    @FXML
    private ImageView btn_cerrarSesion;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_minimizar.setOnMouseClicked(this::minimizeButton);
        btn_salir.setOnMouseClicked(this::onExitButton);
        btn_accederInicio.setOnMouseClicked(this::presionarCasa);
        btn_vuelosProgramados.setOnMouseClicked(this::presionarProgramados);
        btn_vuelosRealizados.setOnMouseClicked(this::presionarRealizados);
        btn_cerrarSesion.setOnMouseClicked(evento);
        agregarAVuelosRealizados();
        agregarAVuelosProgramados();
    }

    public void agregarAVuelosRealizados() {
        ObservableList<Vuelo> vuelos = FXCollections.observableArrayList();
        vuelos.addAll(gestorVuelo.listarVuelo());
        clm_lineaAerea.setCellValueFactory(new PropertyValueFactory<>("lineaAerea"));
        clm_aeropuertoLlegada.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        clm_aeropuertoDestino.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        clm_horaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        clm_sala.setCellValueFactory(new PropertyValueFactory<>("sala"));
        clm_horaLlegada.setCellValueFactory(new PropertyValueFactory<>("horaLlegada"));
        clm_estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tbl_vuelosRealizados.setItems(vuelos);
    }

    public void agregarAVuelosProgramados() {
        ObservableList<Vuelo> vuelos = FXCollections.observableArrayList();
        vuelos.addAll(gestorVuelo.listarVuelo());
        clm_lineaAerea1.setCellValueFactory(new PropertyValueFactory<>("lineaAerea"));
        clm_aeropuertoLlegada1.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        clm_aeropuertoDestino1.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        clm_horaSalida1.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        clm_sala1.setCellValueFactory(new PropertyValueFactory<>("sala"));
        clm_horaLlegada1.setCellValueFactory(new PropertyValueFactory<>("horaLlegada"));
        clm_estado1.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tbl_vuelosProgramados.setItems(vuelos);
    }

    public void onExitButton(MouseEvent minimize) {
        Platform.exit();
        System.exit(0);
    }

    public void presionarCasa(MouseEvent open) {
        panel_bienvenidaMiembro.setVisible(true);
        panel_vuelosProgramados.setVisible(false);
        panel_vuelosRealizados.setVisible(false);
    }

    public void presionarProgramados(MouseEvent open) {
        panel_bienvenidaMiembro.setVisible(false);
        panel_vuelosProgramados.setVisible(true);
        panel_vuelosRealizados.setVisible(false);
    }

    public void presionarRealizados(MouseEvent open) {
        panel_bienvenidaMiembro.setVisible(false);
        panel_vuelosProgramados.setVisible(false);
        panel_vuelosRealizados.setVisible(true);
    }

    public void minimizeButton(MouseEvent minimize) {
        Stage stage = (Stage) ((Node) minimize.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    EventHandler<MouseEvent> evento = new EventHandler<MouseEvent>() {
        @Override
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
