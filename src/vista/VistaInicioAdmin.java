package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

public class VistaInicioAdmin implements Vista {

    private Scene escena;
    private Label inicio;
    private Button inventario;
    private Button estadisticas;
    private Button disponibles;
    private Label administrador;
    private Button cerrar;
    private Button añadir;

    public VistaInicioAdmin() {
        inicio = new Label("Inicio");
        inicio.setFont(new Font("Arial", 40));
        try {
            FileInputStream imagen = new FileInputStream("src/Images/LogoNombre.png");
            Image input = new Image(imagen);
            ImageView image = new ImageView(input);
            image.setFitHeight(60);
            image.setFitWidth(80);
            inicio = new Label("  Inicio", image);
            inicio.setFont(new Font("Arial", 35));
        } catch (Exception e) {

        }
        inventario = new Button("Inventario");
        estadisticas = new Button("Estadisticas");
        disponibles = new Button("Hacer disponible");
        administrador = new Label("Administrador");

        try {
            FileInputStream imagen = new FileInputStream("src/Images/imagenadmin.png");
            Image input2 = new Image(imagen);
            ImageView image45 = new ImageView(input2);
            image45.setFitHeight(30);
            image45.setFitWidth(30);
            administrador = new Label("Administrador", image45);
            administrador.setFont(new Font("Arial", 15));
        } catch (Exception e) {

        }
        cerrar = new Button("Cerrar Sesion");
        try {
            FileInputStream archivo = new FileInputStream("src/Images/bottonAdd.jpeg");
            Image imagenañadir = new Image(archivo);
            ImageView imagencita = new ImageView(imagenañadir);
            imagencita.autosize();
            imagencita.fitHeightProperty().set(30);
            imagencita.fitWidthProperty().set(30);
            añadir = new Button("Nuevo auto", imagencita);

        } catch (FileNotFoundException ex) {
        }
        HBox linea1 = new HBox();
        linea1.setSpacing(8);
        linea1.getChildren().add(inventario);
        linea1.getChildren().add(estadisticas);
        linea1.getChildren().add(disponibles);
        HBox linea2 = new HBox();
        linea2.setSpacing(70);
        linea2.getChildren().add(inicio);
        linea2.getChildren().add(administrador);
        VBox layout = new VBox();
        layout.setSpacing(100);
        layout.getChildren().add(linea2);
        layout.getChildren().add(linea1);
        layout.getChildren().add(añadir);
        layout.getChildren().add(cerrar);
        BorderPane panel = new BorderPane();
        panel.setTop(linea2);
        panel.setAlignment(inicio, Pos.TOP_CENTER);
        panel.setMargin(inicio, new Insets(5));
        panel.setCenter(layout);
        panel.setAlignment(layout, Pos.TOP_CENTER);
        panel.setMargin(layout, new Insets(8));
        panel.setBottom(cerrar);
        panel.setAlignment(cerrar, Pos.TOP_CENTER);
        panel.setMargin(cerrar, new Insets(5));
        panel.setMargin(panel, new Insets(40, 40, 40, 40));
        this.escena = new Scene(panel, 400, 300);

    }

    @Override
    public Scene getScena() {
        return escena;
    }

    public Label getInicio() {
        return inicio;
    }

    public Button getInventario() {
        return inventario;
    }

    public Button getEstadisticas() {
        return estadisticas;
    }

    public Button getDisponibles() {
        return disponibles;
    }

    public Label getAdministrador() {
        return administrador;
    }

    public Button getAñadir() {
        return añadir;
    }

    public Button getCerrar() {
        return cerrar;
    }

}
