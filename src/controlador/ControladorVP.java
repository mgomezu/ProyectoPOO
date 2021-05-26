package controlador;

import Modelo.Auto;
import Modelo.ControlAutos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import vista.VentPrestar;
import vista.Vista;

public class ControladorVP {

    private VentPrestar vista;

    public ControladorVP() {
        this.vista = new VentPrestar();
        this.vista.getFiltrar()
                .setOnAction(new EventoListarAutos());
        this.vista.getCerrarSesion().setOnAction(new EventoCerrar());
    }

    public ControladorVP(TableView tablaAutos, String marcaSeleccionada,
            String modeloSeleccionado, String tipoSeleccionado) {
        this.vista = new VentPrestar(tablaAutos, marcaSeleccionada, modeloSeleccionado, tipoSeleccionado);
        this.vista.getFiltrar().setOnAction(new EventoListarAutos());
        this.vista.getMarcamodelotipo().setOnMouseClicked(new EventoMostrarInfo());
        this.vista.getCerrarSesion().setOnAction(new EventoCerrar());
    }

    public VentPrestar getVista() {
        return vista;
    }

    private class EventoListarAutos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();

            TableView marcamodelotipo = new TableView();
            Button Seleccionar = new Button("Seleccionar");

            TableColumn TCmarca = new TableColumn("Marca");
            TableColumn TCmodelo = new TableColumn("Modelo");
            TableColumn TCtipo = new TableColumn("Tipo");
            TableColumn TCID = new TableColumn("ID");
            TableColumn TCSeleccionar = new TableColumn();
            TCmarca.setSortable(false);
            TCmodelo.setSortable(false);
            TCtipo.setSortable(false);
            TCID.setSortable(false);

            File lectura = new File("AutosDisponibles.txt");
            Scanner flujoEntrada = null;

            String marca = vista.getCbmarca().getValue().toString();
            String modelo = vista.getCbmodelo().getValue().toString();
            String tipo = vista.getCbtipo().getValue().toString();

            try {
                ControlAutos control = new ControlAutos();
                ArrayList<Auto> autosDisponibles = control.ListaAutosDisponibles(marca, modelo, tipo);
                TCmarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
                TCmodelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                TCtipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
                TCID.setCellValueFactory(new PropertyValueFactory<>("ID"));
                TCID.setVisible(false);
                marcamodelotipo.getColumns().addAll(TCmarca, TCmodelo, TCtipo, TCID);

                for (int i = 0; i < autosDisponibles.size(); i++) {
                    Auto autoNuevo = autosDisponibles.get(i);
                    marcamodelotipo.getItems().add(autoNuevo);

                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorVP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorVP.class.getName()).log(Level.SEVERE, null, ex);
            }

            ControladorVP controlador = new ControladorVP(marcamodelotipo, marca, modelo, tipo);
            Vista vista = controlador.getVista();
            stage.setTitle("Busqueda");

            stage.setScene(vista.getScena());
            stage.show();
        }
    }

    private class EventoCerrar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {

            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            ControladorLogin controlador;
            try {
                controlador = new ControladorLogin();
                Vista vista1 = controlador.getVista();
                stage.setScene(vista1.getScena());
                stage.setTitle("Iniciar sesion");
                stage.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorVP.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("no sirve we");
            }

        }

    }

    private class EventoMostrarInfo implements EventHandler<MouseEvent> {

        Singleton singleton = Singleton.getSingleton();
        Stage stage = singleton.getStage();

        private EventoMostrarInfo() {

        }

        @Override
        public void handle(MouseEvent t) {

            int fila = vista.getMarcamodelotipo().getSelectionModel().getSelectedIndex();

            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();

            ControlAutos control;
            String marca = vista.getMarcaS();
            String modelo = vista.getModeloS();
            String tipo = vista.getTipoS();
            try {
                control = new ControlAutos();
                ArrayList<Auto> autosDisponibles = control.ListaAutosDisponibles(marca, modelo, tipo);

                if (fila != -1) {
                    ControladorVistaInfo controlador = new ControladorVistaInfo(autosDisponibles.get(fila));
                    Vista vista1 = controlador.getVista();
                    stage.setScene(vista1.getScena());
                    stage.setTitle("Información");
                    stage.show();
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorVP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorVP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
