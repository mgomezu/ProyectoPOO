package vista;

import Modelo.Auto;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class VistaInventario implements Vista {

    Scene escena;
    Label titulo;
    ArrayList<Auto> autos = new ArrayList<>();
    TableView tabla;
    Button volver;

    public VistaInventario() {
        try {
            File archivo = new File("Autos.txt");
            Scanner leer = new Scanner(archivo);
            while (leer.hasNext()) {

                int ID = leer.nextInt();
                String marca = leer.next();
                String modelo = leer.next();
                String tipo = leer.next();
                double Precio = Double.parseDouble(leer.next());
                boolean disponible;
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
        titulo = new Label("INVENTARIO");
        tabla = new TableView();
        TableColumn marca = new TableColumn("Marca");
        TableColumn modelo = new TableColumn("Modelo");
        TableColumn tipo = new TableColumn("Tipo");
        TableColumn ID = new TableColumn("ID");
        marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tabla.getColumns().addAll(marca, modelo, tipo, ID);
        for (int i = 0; i < autos.size(); i++) {
                    Auto autoNuevo = autos.get(i);
                    tabla.getItems().add(autoNuevo);
                }
        
        
        volver = new Button("Volver");
        tabla.getItems().add("ID | MARCA | MODELO | DISPONIBILIDAD");
        for (int i = 0; i < autos.size(); i++) {
            tabla.getItems().add(autos.get(i).getID() + " | " + autos.get(i).getMarca()
                    + " | " + autos.get(i).getModelo() + " | " + autos.get(i).isDisponible());
        }
        BorderPane panel = new BorderPane();
        panel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        panel.setMargin(titulo, new Insets(8));
        panel.setAlignment(titulo, Pos.TOP_CENTER);
        panel.setTop(titulo);
        panel.setCenter(tabla);
        panel.setMargin(tabla, new Insets(8));
        panel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        panel.setMargin(volver, new Insets(8));
        panel.setAlignment(volver, Pos.TOP_CENTER);
        panel.setBottom(volver);
        escena = new Scene(panel, 500, 500);

    }

    @Override
    public Scene getScena() {
        return escena;
    }

    public TableView getTabla() {
        return tabla;
    }

    public Button getVolver() {
        return volver;
    }

}
