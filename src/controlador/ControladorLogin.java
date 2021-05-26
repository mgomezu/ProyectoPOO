package controlador;

import Modelo.Cuenta;
import vista.Vista;
import controlador.*;
import vista.VistaLogin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ControladorLogin {
        
    VistaLogin vista;
    private Cuenta administrador = new Cuenta("Administrador", "",
            "Administrador@telopresto.com", 0001, "administrador", "administradorcontraseña");
    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private boolean flag;

    public ControladorLogin() throws FileNotFoundException {
        this.vista = new VistaLogin();
        this.vista.getBtRegistrar()
                .setOnAction(new EventoRegistrar());
        this.vista.getBtSalir().setOnAction(new EventoSalir());
        this.vista.getBtIngresar().setOnAction(new EventoIngresar());
        flag = true;
    }

    public VistaLogin getVista() {
        return vista;
    }

    private class EventoRegistrar implements
            EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            ControladorRegistrar controlador
                    = new ControladorRegistrar();
            Vista vista = controlador.getVista();
            stage.setScene(vista.getScena());
            stage.setTitle("Registro");
            stage.show();
        }
    }

    private class EventoSalir implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
            ControladorLogin controlador;
            try {
                controlador = new ControladorLogin();
                Vista vista = controlador.getVista();
                stage.setScene(vista.getScena());
                stage.setTitle("Registro");
                stage.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class EventoIngresar implements
            EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                if (administrador.getUsuario().equals(vista.getTfUser().getText())) {
                    if (administrador.getContraseña().equals(vista.getTfContra().getText())) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + administrador.getNombre()
                                + " " + administrador.getApellido());
                        Singleton singleton = Singleton.getSingleton();
                        Stage stage = singleton.getStage();
                        ControladorInicioAdmin controlador = new ControladorInicioAdmin();
                        Vista vista1 = controlador.getVista();
                        stage.setScene(vista1.getScena());
                        stage.setTitle("Inicio");
                        stage.show();
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos, verifique por favor");
                    }
                } else {

                    File archivo = new File("Registro.txt");
                    Scanner entrada = new Scanner(archivo);
                    while (entrada.hasNext()) {
                        String linea = entrada.nextLine();
                        String[] palabras = linea.split(" ");
//Formato archivo: nombre apellido correo id usuario contraseña
                        Cuenta cuenta = new Cuenta(palabras[0], palabras[1],
                                palabras[2], Integer.parseInt(palabras[3]), palabras[4], palabras[5]);
                        cuentas.add(cuenta);
                    }
                    for (int i = 0; i < cuentas.size(); i++) {
                        if (cuentas.get(i).getUsuario().equals(vista.getTfUser().getText())) {
                            if (cuentas.get(i).getContraseña().equals(vista.getTfContra().getText())) {
                                JOptionPane.showMessageDialog(null, "Bienvenido "
                                        + cuentas.get(i).getNombre() + " " + cuentas.get(i).getApellido());

                                //La siguiente informacion debe ser la que lleva a la siguiente ventana
                                Singleton singleton = Singleton.getSingleton();
                                Stage stage = singleton.getStage();
                                ControladorVP controlador = new ControladorVP();
                                Vista vista1 = controlador.getVista();
                                stage.setTitle("Busqueda");
                                stage.setScene(vista1.getScena());
                                stage.show();
                                flag = false;
                                break;
                                // EN ESTE ESPACIO MANDA A LA SIGUIENTE ESCENA, LA PLATAFORMA DE RENTA
                            }
                        }
                    }
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos, verifique por favor");

                    }
                }

            } catch (Exception e) {
            }
        }

    }
}
