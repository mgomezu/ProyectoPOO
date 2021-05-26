package controlador;

import Modelo.Auto;
import Modelo.Precio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import vista.*;

public class ControladorRentar {

    private Rentar vista;
    private Auto auto;
    ArrayList<Auto> autos;

    public ControladorRentar(Auto auto) {
        this.auto = auto;
        this.vista = new Rentar(auto.getPrecio());
        this.vista.getVolver().setOnAction(new EventoVolver());
        this.vista.getConsultar().setOnAction(new EventoConsultar());
    }

    public ControladorRentar(double tfValor, Auto auto) {
        this.auto = auto;
        this.vista = new Rentar(tfValor, auto.getPrecio());
        this.vista.getVolver().setOnAction(new EventoVolver());
        this.vista.getConsultar().setOnAction(new EventoConsultar());
        this.vista.getRentar().setOnAction(new EventoRentar());
    }

    private class EventoConsultar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();

            Precio ConsultarPrecio = new Precio();
            double Valor = 0;

            try {
                String TiempoString = vista.getTfCantTiempo().getText();
                double tiempo = Double.parseDouble(TiempoString);
                double precio = auto.getPrecio();
                if (vista.getRbhoras().isSelected()) {
                    Valor = ConsultarPrecio.PrecioRenta(tiempo, precio, "Horas");
                } else {
                    if (vista.getRbdias().isSelected()) {
                        Valor = ConsultarPrecio.PrecioRenta(tiempo, precio, "Dias");
                    } else {
                        if (vista.getRbsemanas().isSelected()) {
                            Valor = ConsultarPrecio.PrecioRenta(tiempo, precio, "Semanas");
                        }
                    }
                }

                ControladorRentar controlador = new ControladorRentar(Valor, auto);
                Vista vista = controlador.getVista();
                stage.setScene(vista.getScena());
                stage.show();

            } catch (NumberFormatException e) {

            }

        }
    }

    private class EventoRentar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            try {
                autos = new ArrayList<>();
                File archivo = new File("Autos.txt");
                Scanner leer = new Scanner(archivo);
                String linea;
                String palabras[];
                while (leer.hasNext()) {
                    linea = leer.nextLine();
                    palabras = linea.split(" ");
                    int id = Integer.parseInt(palabras[0]);
                    String marca = palabras[1];
                    String modelo = palabras[2];
                    String tipo = palabras[3];
                    double precioso = Double.parseDouble(palabras[4]);
                    double precio = precioso;
                    boolean disponible;
                    if (palabras[5].equals("disponible")) {
                        disponible = true;
                    } else {
                        disponible = false;
                    }
                    String ruta = palabras[6];
                    int numero = Integer.parseInt(palabras[7]);
                    Auto carro;

                    carro = new Auto(id, marca, modelo, tipo, precio, disponible, ruta, numero);

                    autos.add(carro);

                }
            } catch (Exception e) {
            }
            try {
                FileWriter fw = new FileWriter("Autos.txt");
                PrintWriter pw = new PrintWriter(fw);
                int idauto = auto.getID();
                //int i=0; i<autos.size();i++
                for (Auto autitos : autos) {
                    if (idauto == autitos.getID()) {
                        int numero = autitos.getNRentado() + 1;
                        pw.print(autitos.getID() + " " + autitos.getMarca() + " " + autitos.getModelo()
                                + " " + autitos.getTipo() + " " + autitos.getPrecio() + " "
                                + "nodisponible" + " " + autitos.getImagen() + " " + numero + "\n");
                    } else if (autitos.isDisponible()) {
                        pw.print(autitos.getID() + " " + autitos.getMarca() + " " + autitos.getModelo()
                                + " " + autitos.getTipo() + " " + autitos.getPrecio() + " "
                                + "disponible" + " " + autitos.getImagen() + " " + autitos.getNRentado() + "\n");
                    } else if (autitos.isDisponible() == false) {
                        pw.print(autitos.getID() + " " + autitos.getMarca() + " " + autitos.getModelo()
                                + " " + autitos.getTipo() + " " + autitos.getPrecio() + " "
                                + "nodisponible" + " " + autitos.getImagen() + " " + autitos.getNRentado() + "\n");
                    }
                }
                pw.flush();
                pw.close();
                autos = new ArrayList<>();
                JOptionPane.showMessageDialog(null, "Ha rentado un auto");
                Singleton singleton = Singleton.getSingleton();
                Stage stage = singleton.getStage();
                ControladorVP controlador = new ControladorVP();
                Vista vista = controlador.getVista();
                stage.setScene(vista.getScena());
                stage.show();
            } catch (Exception e) {
            }
        }

    }

    private class EventoVolver implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();

            ControladorVistaInfo controlador;
            try {
                controlador = new ControladorVistaInfo(auto);
                Vista vista = controlador.getVista();
                stage.setScene(vista.getScena());
                stage.setTitle("Información");
                stage.show();
            } catch (FileNotFoundException ex) {

            }

        }
    }

    public Rentar getVista() {
        return vista;
    }
}
