package controlador;

import Modelo.Auto;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.Vista;
import vista.VistaInfo;

public class ControladorVistaInfo {

    private VistaInfo vista;
    private Auto auto;

    public ControladorVistaInfo(Auto auto) throws FileNotFoundException {
        this.auto = auto;
        this.vista = new VistaInfo(auto);
        vista.getSiguiente().setOnAction(new EventoSiguiente());
        vista.getVolver().setOnAction(new EventoVolver());
    }

    public VistaInfo getVista() {
        return vista;
    }

    private class EventoSiguiente implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            ControladorRentar controlador = new ControladorRentar(auto);
            Vista vista = controlador.getVista();
            stage.setScene(vista.getScena());
            stage.setTitle("Renta");
            stage.show();
        }
    }

    private class EventoVolver implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            ControladorVP controlador = new ControladorVP();
            Vista vista = controlador.getVista();
            stage.setScene(vista.getScena());
            stage.setTitle("Busqueda");
            stage.show();
        }
    }
}
