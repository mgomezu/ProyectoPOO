
package controlador;

import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.Vista;
import vista.VistaInicioAdmin;


public class ControladorInicioAdmin {

    VistaInicioAdmin vista;

    public ControladorInicioAdmin() {
        vista = new VistaInicioAdmin();
        vista.getInventario().setOnAction(new EventoInventario());
        vista.getDisponibles().setOnAction(new EventoReponer());
        vista.getAñadir().setOnAction(new EventoAnadir());
        vista.getCerrar().setOnAction(new EventoCerrar());
    }

    public VistaInicioAdmin getVista() {
        return vista;
    }

    private class EventoCerrar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {

            ControladorLogin controlador;
            try {
                controlador = new ControladorLogin();
                Vista vista = controlador.getVista();
                Singleton singleton
                        = Singleton.getSingleton();
                Stage stage = singleton.getStage();
                stage.setScene(vista.getScena());
                stage.setTitle("Te lo presto");
                stage.show();
            } catch (FileNotFoundException ex) {

            }
        }
    }

    private class EventoInventario implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            ControladorInventario controlador = new ControladorInventario();
            Vista vista = controlador.getVista();
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            stage.setScene(vista.getScena());
            stage.setTitle("Inventario");
            stage.show();

        }
    }

    private class EventoReponer implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            ControladorVistaReponer controlador = new ControladorVistaReponer();
            Vista vista = controlador.getVista();
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            stage.setScene(vista.getScena());
            stage.setTitle("Reponer auto");
            stage.show();
        }
    }

    private class EventoAnadir implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            ControladorAdminAuto controlador = new ControladorAdminAuto();
            Vista vista = controlador.getVista();
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            stage.setScene(vista.getScena());
            stage.setTitle("Añadir auto");
            stage.show();

        }
    }

}
