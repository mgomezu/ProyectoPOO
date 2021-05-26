package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import vista.Vista;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Rentar implements Vista {

    Label medidatiempo;
    Label cantidadtiempo;
    Label valor;
    RadioButton rbhoras;
    RadioButton rbdias;
    RadioButton rbsemanas;
    Button rentar;
    Scene escena;
    Button volver;
    Button consultar;
    TextField tfCantTiempo;
    Label tfValor;
    double ValorFinal;
    double Precio;
    double PrecioFinal;

    public Rentar(double Precio) {

        this.Precio = Precio;
        medidatiempo = new Label("Medida de tiempo: ");
        cantidadtiempo = new Label("Cantidad de tiempo: ");
        valor = new Label("Valor");
        rbhoras = new RadioButton("Horas");
        rbdias = new RadioButton("Dias");
        rbsemanas = new RadioButton("Semanas");
        rentar = new Button("Rentar");
        volver = new Button("Volver");
        consultar = new Button("Consultar precio");
        tfCantTiempo = new TextField();
        tfValor = new Label();
        ToggleGroup grupo = new ToggleGroup();
        rbhoras.setToggleGroup(grupo);
        rbdias.setToggleGroup(grupo);
        rbsemanas.setToggleGroup(grupo);
        VBox layout = new VBox();
        HBox linea1 = new HBox();
        HBox linea2 = new HBox();
        HBox linea3 = new HBox();
        GridPane gp = new GridPane();
        gp.setHgap(5.5);
        gp.setVgap(5.5);
        linea1.getChildren().add(rbhoras);
        linea1.getChildren().add(rbdias);
        linea1.getChildren().add(rbsemanas);
        gp.add(medidatiempo, 0, 0);
        gp.add(linea1, 1, 0);
        gp.add(cantidadtiempo, 0, 1);
        gp.add(tfCantTiempo, 1, 1);
        gp.add(valor, 0, 2);
        gp.add(tfValor, 1, 2);
        gp.add(rentar, 1, 4);
        gp.add(consultar, 2, 1);
        gp.add(volver, 5, 5);
        BorderPane bp = new BorderPane();
        bp.setCenter(gp);
        bp.setAlignment(gp, Pos.CENTER);
        bp.setMargin(gp, new Insets(8));
        this.escena = new Scene(bp, 480, 140);
    }

    public Rentar(double tfValor, double Precio) {

        this.Precio = Precio;
        medidatiempo = new Label("Medida de tiempo: ");
        cantidadtiempo = new Label("Cantidad de tiempo: ");
        valor = new Label("Valor");
        rbhoras = new RadioButton("Horas");
        rbdias = new RadioButton("Dias");
        rbsemanas = new RadioButton("Semanas");
        rentar = new Button("Rentar");
        volver = new Button("Volver");
        consultar = new Button("Consultar");
        tfCantTiempo = new TextField();
        ValorFinal = tfValor;
        this.tfValor = new Label(String.valueOf(tfValor));
        ToggleGroup grupo = new ToggleGroup();
        rbhoras.setToggleGroup(grupo);
        rbdias.setToggleGroup(grupo);
        rbsemanas.setToggleGroup(grupo);
        VBox layout = new VBox();
        HBox linea1 = new HBox();
        HBox linea2 = new HBox();
        HBox linea3 = new HBox();
        GridPane gp = new GridPane();
        gp.setHgap(5.5);
        gp.setVgap(5.5);
        linea1.getChildren().add(rbhoras);
        linea1.getChildren().add(rbdias);
        linea1.getChildren().add(rbsemanas);
        gp.add(medidatiempo, 0, 0);
        gp.add(linea1, 1, 0);
        gp.add(cantidadtiempo, 0, 1);
        gp.add(tfCantTiempo, 1, 1);
        gp.add(valor, 0, 2);
        gp.add(this.tfValor, 1, 2);
        gp.add(rentar, 1, 4);
        gp.add(consultar, 2, 1);
        gp.add(volver, 5, 5);
        BorderPane bp = new BorderPane();
        bp.setCenter(gp);
        bp.setAlignment(gp, Pos.CENTER);
        bp.setMargin(gp, new Insets(8));
        this.escena = new Scene(bp, 480, 140);
    }

    public RadioButton getRbhoras() {
        return rbhoras;
    }

    public RadioButton getRbdias() {
        return rbdias;
    }

    public RadioButton getRbsemanas() {
        return rbsemanas;
    }

    public Button getVolver() {
        return volver;
    }

    public Button getConsultar() {
        return consultar;
    }

    public TextField getTfCantTiempo() {
        return tfCantTiempo;
    }

    public double getPrecioFinal() {
        return PrecioFinal;
    }

    public double getValorFinal() {
        return ValorFinal;
    }

    public Button getRentar() {
        return rentar;
    }

    @Override
    public Scene getScena() {
        return escena;
    }

}
