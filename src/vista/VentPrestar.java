package vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class VentPrestar implements Vista {

    private Label encontrar;
    private Label marca;
    private Label modelo;
    private Label filtro;
    private Label tipo;
    private ComboBox cbmarca;
    private ComboBox cbmodelo;
    private ComboBox cbtipo;
    private Button seleccionar;
    private Button cerrarSesion;
    private Button filtrar;
    private String modeloS;
    private String marcaS;
    private String TipoS;
    private TableView marcamodelotipo;
    private Scene escena;

    public VentPrestar() {
        encontrar = new Label("ENCUENTRA TU AUTO IDEAL");
        encontrar.setAlignment(Pos.CENTER);
        marca = new Label("Marca");
        modelo = new Label("Modelo");
        tipo = new Label("Tipo");
        filtro = new Label("Filtro");
        marcamodelotipo = new TableView();
        cbmarca = new ComboBox();
        cbmodelo = new ComboBox();
        cbtipo = new ComboBox();
        seleccionar = new Button("Seleccionar");
        cerrarSesion = new Button("Cerrar Sesion");
        filtrar = new Button("Filtrar");
        HBox lineaMarca = new HBox();
        HBox lineaModelo = new HBox();
        HBox lineaTipo = new HBox();
        cbmarca.setValue("Todos");
        cbmodelo.setValue("Todos");
        cbtipo.setValue("Todos");
        ObservableList marcas = FXCollections.observableArrayList();
        ObservableList modelos = FXCollections.observableArrayList();
        ObservableList tipos = FXCollections.observableArrayList();
        marcas.add("Todos");
        modelos.add("Todos");
        tipos.add("Todos");
        marcas.add("toyota");
        marcas.add("mazda");
        tipos.add("automatico");
        tipos.add("manual");
        for (int i = 1995; i <= 2020; i++) {
            modelos.add(i);
        }
        cbmarca.setItems(marcas);
        cbmodelo.setItems(modelos);
        cbtipo.setItems(tipos);
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(filtro, 0, 0);
        pane.add(marca, 0, 1);
        pane.add(cbmarca, 1, 1);
        pane.add(modelo, 0, 2);
        pane.add(cbmodelo, 1, 2);
        pane.add(tipo, 0, 3);
        pane.add(cbtipo, 1, 3);
        pane.add(filtrar, 0, 4);
        TableColumn marca = new TableColumn("Marca");
        TableColumn modelo = new TableColumn("Modelo");
        TableColumn tipo = new TableColumn("Tipo");
        marcamodelotipo.getColumns().addAll(marca, modelo, tipo);
        HBox vdual = new HBox();
        vdual.getChildren().add(pane);
        vdual.getChildren().add(marcamodelotipo);
        BorderPane layout = new BorderPane();
        layout.setAlignment(encontrar, Pos.TOP_CENTER);
        layout.setMargin(encontrar, new Insets(8));
        layout.setTop(encontrar);
        layout.setLeft(pane);
        layout.setMargin(marcamodelotipo, new Insets(8));
        layout.setCenter(marcamodelotipo);
        layout.setAlignment(cerrarSesion, Pos.TOP_RIGHT);
        layout.setMargin(cerrarSesion, new Insets(8));
        layout.setBottom(cerrarSesion);
        escena = new Scene(layout, 580, 500);

    }

    public VentPrestar(TableView tablaAutos, String marcaSeleccionada,
                        String modeloSeleccionado, String tipoSeleccionado) {
        encontrar = new Label("ENCUENTRA TU AUTO IDEAL");
        encontrar.setAlignment(Pos.CENTER);
        marca = new Label("Marca");
        modelo = new Label("Modelo");
        tipo = new Label("Tipo");
        filtro = new Label("Filtro");
        marcamodelotipo = tablaAutos;
        //marcamodelotipo.setManaged(false);
        cbmarca = new ComboBox();
        cbmodelo = new ComboBox();
        cbtipo = new ComboBox();
        seleccionar = new Button("Seleccionar");
        cerrarSesion = new Button("Cerrar Sesion");
        filtrar = new Button("Filtrar");
        HBox lineaMarca = new HBox();
        HBox lineaModelo = new HBox();
        HBox lineaTipo = new HBox();
        marcaS = marcaSeleccionada;
        modeloS = modeloSeleccionado;
        TipoS = tipoSeleccionado;
        cbmarca.setValue(marcaSeleccionada);
        cbmodelo.setValue(modeloSeleccionado);
        cbtipo.setValue(tipoSeleccionado);
        ObservableList marcas = FXCollections.observableArrayList();
        ObservableList modelos = FXCollections.observableArrayList();
        ObservableList tipos = FXCollections.observableArrayList();
        marcas.add("Todos");
        modelos.add("Todos");
        tipos.add("Todos");
        marcas.add("toyota");
        marcas.add("mazda");
        tipos.add("automatico");
        tipos.add("manual");
        for (int i = 1995; i <= 2020; i++) {
            modelos.add(i);

        }
        cbmarca.setItems(marcas);
        cbmodelo.setItems(modelos);
        cbtipo.setItems(tipos);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(filtro, 0, 0);
        pane.add(marca, 0, 1);
        pane.add(cbmarca, 1, 1);
        pane.add(modelo, 0, 2);
        pane.add(cbmodelo, 1, 2);
        pane.add(tipo, 0, 3);
        pane.add(cbtipo, 1, 3);
        pane.add(filtrar, 0, 4);
        HBox vdual = new HBox();
        vdual.getChildren().add(pane);
        vdual.getChildren().add(marcamodelotipo);
        BorderPane layout = new BorderPane();
        layout.setAlignment(encontrar, Pos.TOP_CENTER);
        layout.setTop(encontrar);
        layout.setMargin(encontrar, new Insets(8));
        layout.setLeft(pane);
        layout.setCenter(marcamodelotipo);
        layout.setMargin(marcamodelotipo, new Insets(8));
        layout.setAlignment(cerrarSesion, Pos.TOP_RIGHT);
        layout.setMargin(cerrarSesion, new Insets(8));
        layout.setBottom(cerrarSesion);
        escena = new Scene(layout, 580, 500);

    }

    public Label getEncontrar() {
        return encontrar;
    }

    public ComboBox getCbmarca() {
        return cbmarca;
    }

    public ComboBox getCbmodelo() {
        return cbmodelo;
    }

    public ComboBox getCbtipo() {
        return cbtipo;
    }

    public Button getSeleccionar() {
        return seleccionar;
    }

    public Button getCerrarSesion() {
        return cerrarSesion;
    }

    public Button getFiltrar() {
        return filtrar;
    }

    public TableView getMarcamodelotipo() {
        return marcamodelotipo;
    }

    public String getModeloS() {
        return modeloS;
    }

    public String getMarcaS() {
        return marcaS;
    }

    public String getTipoS() {
        return TipoS;
    }

    @Override
    public Scene getScena() {
        return escena;
    }

}
