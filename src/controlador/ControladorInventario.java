package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.Vista;
import vista.VistaInventario;

public class ControladorInventario {

    VistaInventario vista;

    public ControladorInventario() {
        vista = new VistaInventario();
        vista.getVolver().setOnAction(new EventoVolver());
    }

    public VistaInventario getVista() {
        return vista;
    }

    private class EventoVolver implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            ControladorInicioAdmin controlador = new ControladorInicioAdmin();
            Vista vista = controlador.getVista();
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            stage.setScene(vista.getScena());
            stage.setTitle("Inicio");
            stage.show();

        }
    }

}
