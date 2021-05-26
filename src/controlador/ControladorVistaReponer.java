package controlador;

import Modelo.Auto;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import vista.Vista;
import vista.VistaReponer;

public class ControladorVistaReponer {

    VistaReponer vista;
    ArrayList<Auto> autos = new ArrayList<>();

    public ControladorVistaReponer() {
        this.vista = new VistaReponer();
        this.vista.getBtbuscar().setOnAction(new EventoBuscar());
        this.vista.getBtvolver().setOnAction(new EventoVolver());
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

    private class EventoBuscar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            String retorno = vista.getTfbuscar().getText();
            String info = null;
            try {
                File arch = new File("Autos.txt");
                Scanner entrada = new Scanner(arch);
                String linea;
                String palabras[];

                while (entrada.hasNextLine()) {
                    linea = entrada.nextLine();
                    palabras = linea.split(" ");
                    if (retorno.equals(palabras[0])) {
                        info = palabras[1] + " " + palabras[2] + " "
                                + palabras[3] + " " + "disponible" + " ";
                    }

                }
                vista.setLinfo(info);
                JOptionPane.showMessageDialog(null, info);

            } catch (Exception e) {
            }
            try {
                boolean disponible;
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
                FileWriter fw = new FileWriter("Autos.txt");
                PrintWriter pw = new PrintWriter(fw);
                for (Auto carros : autos) {
                    if (carros.isDisponible() == true) {
                        pw.print(carros.getID() + " " + carros.getMarca() + " " + carros.getModelo()
                                + " " + carros.getTipo() + " " + carros.getPrecio() + " " + "disponible" + " "
                                + carros.getImagen() + " " + carros.getNRentado() + "\n");
                    } else if (carros.getID() == Integer.parseInt(retorno)) {
                        pw.print(carros.getID() + " " + carros.getMarca() + " " + carros.getModelo()
                                + " " + carros.getTipo() + " " + carros.getPrecio() + " " + "disponible" + " "
                                + carros.getImagen() + " " + carros.getNRentado() + "\n");
                    } else {
                        pw.print(carros.getID() + " " + carros.getMarca() + " " + carros.getModelo()
                                + " " + carros.getTipo() + " " + carros.getPrecio() + " " + "nodisponible" + " "
                                + carros.getImagen() + " " + carros.getNRentado() + "\n");
                    }
                }
                pw.flush();
                pw.close();
                autos = new ArrayList<>();
            } catch (Exception e) {
            }

        }
    }

    public VistaReponer getVista() {
        return vista;
    }

}
