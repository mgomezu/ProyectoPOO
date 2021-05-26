package vista;

import Modelo.Auto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaInfo implements Vista {

    private Scene escena;
    private Label lInfoVehiculo;
    private FileInputStream lImagen;
    private Image Iimagen;
    private ImageView imagencita;
    private Label lmarca;
    private ImageView imagen;
    private Label lInfoMarca;
    private Label lModelo;
    private Label lInfoModelo;
    private Label lTipo;
    private Label lInfoTipo;
    private Label lPrecioXHora;
    private Label InfoPrecio;
    private Button siguiente;
    private Button volver;
    private Auto auto;

    public VistaInfo(Auto auto) throws FileNotFoundException {
        this.auto = auto;
        String precioPorHora = String.valueOf(auto.getPrecio() + " Por hora");
        lInfoVehiculo = new Label("INFORMACION DEL VEHICULO");
        lImagen = new FileInputStream(auto.getImagen());
        Iimagen = new Image(lImagen);
        imagencita = new ImageView(Iimagen);
        imagencita.autosize();
        imagencita.fitHeightProperty().set(150);
        imagencita.fitWidthProperty().set(260);
        lmarca = new Label("Marca: ");
        lInfoMarca = new Label(auto.getMarca());
        lModelo = new Label("Modelo: ");
        lInfoModelo = new Label(auto.getModelo());
        lTipo = new Label("Tipo: ");
        lInfoTipo = new Label(auto.getTipo());
        lPrecioXHora = new Label("Precio por hora: $");
        InfoPrecio = new Label(precioPorHora);
        siguiente = new Button("Siguiente");
        volver = new Button("Volver");
        HBox linea1 = new HBox();
        HBox linea2 = new HBox();
        HBox linea3 = new HBox();
        linea1.getChildren().add(lmarca);
        linea1.getChildren().add(lInfoMarca);
        linea2.getChildren().add(lModelo);
        linea2.getChildren().add(lInfoModelo);
        linea3.getChildren().add(lTipo);
        linea3.getChildren().add(lInfoTipo);
        VBox columna = new VBox();
        columna.getChildren().add(linea1);
        columna.getChildren().add(linea2);
        columna.getChildren().add(linea3);
        HBox lineaimagen = new HBox();
        lineaimagen.getChildren().add(imagencita);
        HBox botones = new HBox();
        botones.getChildren().add(volver);
        botones.setSpacing(255);
        botones.getChildren().add(siguiente);
        botones.setAlignment(Pos.TOP_RIGHT);
        BorderPane panel = new BorderPane();
        panel.setMargin(lineaimagen, new Insets(8));
        panel.setLeft(lineaimagen);
        panel.setCenter(columna);
        panel.setMargin(columna, new Insets(8));
        panel.setTop(lInfoVehiculo);
        panel.setMargin(lInfoVehiculo, new Insets(8));
        panel.setBottom(botones);
        panel.setMargin(botones, new Insets(8));
        panel.setAlignment(lInfoVehiculo, Pos.TOP_CENTER);
        escena = new Scene(panel, 400, 220);

    }

    @Override
    public Scene getScena() {
        return escena;
    }

    public Button getSiguiente() {
        return siguiente;
    }

    public Button getVolver() {
        return volver;
    }

}
