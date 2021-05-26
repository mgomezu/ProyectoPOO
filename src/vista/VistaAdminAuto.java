package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class VistaAdminAuto implements Vista {

    Scene escena;
    Label titulo;
    Label marca;
    TextField tfMarca;
    Label Modelo;
    TextField tfModelo;
    Label Tipo;
    TextField tfTipo;
    Label PrecioHora;
    TextField tfPrecioHora;
    Button examinar;
    Label ruta;
    Label lexaminar;
    Button volver;
    ImageView ivimagen = new ImageView();
    Button guardar;

    public VistaAdminAuto() {
        titulo = new Label("Ingresar auto nuevo");
        marca = new Label("Marca: ");
        tfMarca = new TextField();
        Tipo = new Label("Tipo: ");
        tfTipo = new TextField();
        Modelo = new Label("Modelo: ");
        tfModelo = new TextField();
        PrecioHora = new Label("Precio por  hora:");
        tfPrecioHora = new TextField();
        lexaminar = new Label("Escoja una imagen: ");
        examinar = new Button("Examinar...");
        guardar = new Button("Guardar");
        ruta = new Label();
        volver = new Button("Volver");

        GridPane gp = new GridPane();
        gp.setVgap(5);
        gp.setHgap(10);
        gp.add(marca, 0, 0);
        gp.add(tfMarca, 1, 0);

        gp.add(Tipo, 0, 1);
        gp.add(tfTipo, 1, 1);
        gp.add(Modelo, 0, 2);
        gp.add(tfModelo, 1, 2);

        gp.add(PrecioHora, 0, 3);
        gp.add(tfPrecioHora, 1, 3);
        gp.add(lexaminar, 0, 4);
        gp.add(examinar, 1, 4);
        gp.add(ruta, 2, 4);
        HBox linea = new HBox();
        linea.setSpacing(140);
        linea.getChildren().add(volver);
        linea.getChildren().add(guardar);
        BorderPane panel = new BorderPane();
        panel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        panel.setAlignment(titulo, Pos.TOP_CENTER);
        panel.setTop(titulo);
        Pane panelcito = new Pane();
        panel.setAlignment(gp, Pos.TOP_CENTER);
        panel.setCenter(gp);
        gp.setMaxHeight(Double.MAX_VALUE);
        gp.setMaxWidth(Double.MAX_VALUE);
        panel.setAlignment(linea, Pos.TOP_LEFT);
        panel.setBottom(linea);
        panel.setMargin(titulo,new Insets(8) );
        panel.setMargin(gp,new Insets(10) );
        panel.setMargin(linea,new Insets(5) );
        escena = new Scene(panel, 400, 250);
        
    }

    public String getTfMarca() {
        return tfMarca.getText();
    }

    public String getTfModelo() {
        return tfModelo.getText();
    }

    public String getTfTipo() {
        return tfTipo.getText();
    }

    public double getTfPrecioHora() {
        String preciohora = tfPrecioHora.getText();
        return Double.parseDouble(preciohora);
    }

    public Button getExaminar() {
        return examinar;
    }

    public Button getGuardar() {
        return guardar;
    }
    public void setRuta(String ruta){
        this.ruta.setText(ruta);
    }

    public Label getRuta() {
        return ruta;
    }

    public Button getVolver() {
        return volver;
    }
    

    @Override
    public Scene getScena() {
        return escena;
    }

}
