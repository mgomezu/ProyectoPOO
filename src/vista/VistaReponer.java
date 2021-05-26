package vista;

import java.io.File;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

public class VistaReponer implements Vista {

    private Label titulo;
    private Label buscar;
    private TextField tfbuscar;
    private Button btbuscar;
    private Button btvolver;
    private Scene escena;
    private Label linfo;
    private Label lmostrar;
    private ListView tabla = new ListView();

    public VistaReponer() {
        titulo = new Label("REINGRESAR AUTO");
        buscar = new Label("Ingrese el id del auto: ");
        tfbuscar = new TextField();
        btbuscar = new Button("Cambiar estado");
        linfo = new Label();
        btvolver = new Button("Volver");
        lmostrar = new Label("Autos en renta:");
        lmostrar.setFont(new Font("Arial", 17));

        try {
            File archivo = new File("Autos.txt");
            Scanner leer = new Scanner(archivo);
            Scanner leer2 = new Scanner(archivo);
            //indicador cuenta la cantidad de autos que hay en renta
            int indicador = 0;
            while (leer.hasNext()) {
                String linea;
                String palabras[];
                linea = leer.nextLine();
                palabras = linea.split(" ");
                if (palabras[5].equals("nodisponible")) {
                    indicador++;
                }

            }
            if (indicador > 0) {
                tabla.getItems().add("ID | MARCA | MODELO | TIPO ");
                while (leer2.hasNext()) {

                    String linea;
                    String palabras[];
                    linea = leer2.nextLine();
                    palabras = linea.split(" ");

                    if (palabras[5].equals("nodisponible")) {
                        tabla.getItems().add(palabras[0] + "  " + palabras[1]
                                + "  " + palabras[2] + "  " + palabras[3]);
                    }
                }
            } else if (indicador == 0) {
                JOptionPane.showMessageDialog(null, "No hay autos en renta");
            }
        } catch (Exception e) {
        }
        HBox linea = new HBox();
        linea.setSpacing(5);
        linea.getChildren().add(buscar);
        linea.getChildren().add(tfbuscar);
        linea.getChildren().add(btbuscar);
        VBox columna = new VBox();
        columna.setSpacing(5);
        columna.getChildren().add(linea);
        columna.getChildren().add(lmostrar);
        columna.getChildren().add(tabla);
        columna.getChildren().add(linfo);
        BorderPane panel = new BorderPane();
        panel.setMargin(titulo, new Insets(8));
        panel.setAlignment(titulo, Pos.TOP_CENTER);
        panel.setTop(titulo);
        panel.setMargin(columna, new Insets(8));
        panel.setCenter(columna);
        panel.setMargin(btvolver, new Insets(8));
        panel.setBottom(btvolver);
        panel.setAlignment(btvolver, Pos.TOP_CENTER);
        escena = new Scene(panel, 500, 500);

    }

    public TextField getTfbuscar() {
        return tfbuscar;
    }

    public Button getBtbuscar() {
        return btbuscar;
    }

    public Button getBtvolver() {
        return btvolver;
    }

    public void setLinfo(String info) {
        linfo.setText(info);
    }

    @Override
    public Scene getScena() {
        return escena;
    }

}
