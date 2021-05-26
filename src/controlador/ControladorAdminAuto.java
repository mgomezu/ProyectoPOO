package controlador;

import Modelo.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import vista.*;

public class ControladorAdminAuto {

    ArrayList<Auto> autos = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    private VistaAdminAuto vista;
    int correcta;
    int id;

    public ControladorAdminAuto() {
        this.vista = new VistaAdminAuto();
        vista.getExaminar().setOnAction(new EventoExaminar());
        vista.getGuardar().setOnAction(new EventoGuardar());
        vista.getVolver().setOnAction(new EventoVolver());
    }

    public VistaAdminAuto getVista() {
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

    private class EventoExaminar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            fc.setTitle("Escoja una imagen");
            File pepito = fc.showOpenDialog(null);
            String ruta;
            if (pepito != null) {
                ruta = pepito.getPath();
                vista.setRuta(ruta);

            }

        }

    }

    private class EventoGuardar implements EventHandler<ActionEvent> {

        public int comprobarid(ArrayList<Integer> id) {
            int aleatorio;
            aleatorio = (int) (Math.random() * 10000);
            for (int i = 0; i < id.size(); i++) {
                while (aleatorio == id.get(i)) {
                    aleatorio = (int) (Math.random() * 10000);
                }
            }

            return aleatorio;
        }

        @Override
        public void handle(ActionEvent t) {

            boolean disponible = true;
            try {
                File arch = new File("Autos.txt");
                Scanner entrada = new Scanner(arch);
                String linea;
                String palabras[];

                while (entrada.hasNextLine()) {
                    linea = entrada.nextLine();
                    palabras = linea.split(" ");
                    id = Integer.parseInt(palabras[0]);
                    ids.add(id);
                    correcta = comprobarid(ids);

                }

            } catch (Exception e) {

            }

            try {

                File archivo = new File("Autos.txt");
                Scanner leer = new Scanner(archivo);
                while (leer.hasNextLine()) {
                    int ID = leer.nextInt();
                    String marca = leer.next();
                    String modelo = leer.next();
                    String tipo = leer.next();
                    double Precio = Double.parseDouble(leer.next());

                    if (leer.next().equals("disponible")) {
                        disponible = true;
                    } else {
                        disponible = false;
                    }
                    String ruta = leer.next();
                    int numero = Integer.parseInt(leer.next());

                    Auto auto = new Auto(ID, marca, modelo, tipo, Precio, disponible, ruta, numero);
                    autos.add(auto);

                }

            } catch (Exception e) {

            }
            try {
                if (vista.getTfMarca().contains(" ") || vista.getTfMarca().equals("")
                        || vista.getTfModelo().contains(" ") || vista.getTfModelo().equals("")
                        || vista.getTfTipo().contains(" ") || vista.getTfTipo().equals("")
                        || vista.getRuta().getText().equals("")) {

                    throw new Exception();
                } else {

                    Auto auto = new Auto(correcta, vista.getTfMarca(), vista.getTfModelo(), vista.getTfTipo(),
                            vista.getTfPrecioHora(), disponible, vista.getRuta().getText(), 0);
                    autos.add(auto);
                    JOptionPane.showMessageDialog(null, "Auto registrado ");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error,algún campo está vacio o está mal diligenciado");
            }
            try {
                FileWriter arch = new FileWriter("Autos.txt");
                PrintWriter pw = new PrintWriter(arch);
                for (Auto coches : autos) {
                    pw.print(coches.getID() + " " + coches.getMarca() + " " + coches.getModelo() + " "
                            + coches.getTipo() + " " + coches.getPrecio() + " "
                            + "disponible" + " " + coches.getImagen() + " " + coches.getNRentado() + "\n");

                }
                pw.flush();
                pw.close();
                ids = new ArrayList<>();
                autos = new ArrayList<>();

            } catch (Exception e) {
            }

            ControladorInicioAdmin controlador = new ControladorInicioAdmin();
            Vista vista = controlador.getVista();
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            stage.setTitle("Inicio");
            stage.setScene(vista.getScena());
            stage.show();
        }

    }
}
