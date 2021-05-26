package controlador;

import Modelo.*;
import vista.Vista;
import vista.VistaRegistrar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ControladorRegistrar {

    ArrayList<Cuenta> cuentas;
    VistaRegistrar vista;
    private boolean flag, error;

    public ControladorRegistrar() {
        this.vista = new VistaRegistrar();
        this.vista.getBtValidar().setOnAction(new EventoValidar());
        this.vista.getBtRegresar().setOnAction(new EventoRegresar());
        flag = true;
        error = false;
    }

    public VistaRegistrar getVista() {
        return vista;
    }

    private class EventoValidar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                cuentas = new ArrayList<>();
                File archivo = new File("Registro.txt");
                Scanner entrada = new Scanner(archivo);
                while (entrada.hasNext()) {
                    String linea = entrada.nextLine();
                    String palabras[] = linea.split(" ");
//Formato archivo: nombre apellido correo id usuario contraseña
                    Cuenta cuenta = new Cuenta(palabras[0], palabras[1], palabras[2],
                            Integer.parseInt(palabras[3]), palabras[4], palabras[5]);
                    cuentas.add(cuenta);

                }

            } catch (Exception e) {

            }
            try {
                error = false;

                String nombre, apellido, usuario, contrasena, confcontra, correo;
                int id;
                nombre = vista.getTfNombres().getText();
                apellido = vista.getTfApellidos().getText();
                usuario = vista.getTfUser().getText();
                contrasena = vista.getTfContra().getText();
                confcontra = vista.getTfConfContra().getText();
                correo = vista.getTfCorreo().getText();
                id = Integer.parseInt(vista.getTfID().getText());

                if (nombre.equals("") || nombre.contains(" ") || apellido.equals("") || apellido.contains(" ")
                        || usuario.equals("") || usuario.contains(" ") || contrasena.equals("")
                        || contrasena.contains(" ") || confcontra.equals("")
                        || confcontra.contains(" ") || correo.equals("") || correo.contains(" ")) {
                    throw new Exception();
                }
                if (confcontra.equals(contrasena)) {
                    int it = 0;
                    for (int i = 0; i < cuentas.size(); i++) {

                        if (cuentas.get(i).getUsuario().equals(vista.getTfUser().getText())) {
                            error = true;
                            it = 1;
                        }
                        if (cuentas.get(i).getCorreo().equals(vista.getTfCorreo().getText())) {
                            error = true;
                            it = 2;
                        }
                        if (cuentas.get(i).getId() == Integer.parseInt(vista.getTfID().getText())) {
                            error = true;
                            it = 3;

                        }
                    }
                    if (!error) {
                        Cuenta cuenta2 = new Cuenta(nombre, apellido, correo, id, usuario, contrasena);
                        cuentas.add(cuenta2);

                        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");

                        ControladorLogin controlador = new ControladorLogin();
                        Vista vista = controlador.getVista();
                        Singleton singleton
                                = Singleton.getSingleton();
                        Stage stage = singleton.getStage();
                        stage.setScene(vista.getScena());
                        Image icon = new Image(getClass().getResourceAsStream("/Images/Imagen2.png"));
                        stage.getIcons().add(icon);
                        stage.show();
                        stage.setTitle("INICIAR SESION");
                    } else if (it == 1) {
                        JOptionPane.showMessageDialog(null, "El nombre de usuario"
                                + " ya está en uso, por favor intente de uevo :/");
                    } else if (it == 2) {
                        JOptionPane.showMessageDialog(null, "El correo ya está en uso, por favor intente de uevo :/");
                    } else if (it == 3) {
                        JOptionPane.showMessageDialog(null, "Laidentificación ya está en uso,"
                                + " por favor intente de uevo :/");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
                FileWriter fw = new FileWriter("Registro.txt");
                PrintWriter pw = new PrintWriter(fw);
                for (int j = 0; j < cuentas.size(); j++) {
                    pw.print(cuentas.get(j).getNombre() + " " + cuentas.get(j).getApellido()
                            + " " + cuentas.get(j).getCorreo() + " " + cuentas.get(j).getId()
                            + " " + cuentas.get(j).getUsuario() + " " + cuentas.get(j).getContraseña() + "\n");
                }
                pw.flush();
                pw.close();
                cuentas = new ArrayList<>();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Registro incompleto o error en el registro");
            }

        }

    }

    private class EventoRegresar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            ControladorLogin controlador;
            try {
                controlador = new ControladorLogin();
                Vista vista = controlador.getVista();
                Singleton singleton = Singleton.getSingleton();
                Stage stage = singleton.getStage();
                stage.setScene(vista.getScena());
                stage.setTitle("INICIAR SESION");
                stage.show();
            } catch (FileNotFoundException ex) {

            }

        }

    }
}
