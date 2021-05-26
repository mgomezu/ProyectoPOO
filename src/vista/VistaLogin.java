package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class VistaLogin implements Vista {

    private Scene escena;
    private TextField tfUser;
    private TextField tfContra;
    private Button btIngresar;
    private Button btRegistrar;
    private Button btSalir;

    public VistaLogin() throws FileNotFoundException {
        GridPane gp = new GridPane();
        gp.setGridLinesVisible(false);
        gp.setHgap(25);
        gp.setVgap(10);
        Label lbUser = new Label("Usuario: ");
        Label lbCotnra = new Label("Contraseña: ");
        FileInputStream input = new FileInputStream("src/Images/LogoNombre.png");
        Image imagen = new Image(input);
        Label lbImagen = new Label(" ", new ImageView(imagen));
        tfUser = new TextField();
        tfContra = new PasswordField();
        btIngresar = new Button("Ingresar");
        btRegistrar = new Button("Registrar");
        btSalir = new Button("Salir");
        gp.add(lbUser, 0, 0);
        gp.add(tfUser, 2, 0);
        gp.add(lbCotnra, 0, 1);
        gp.add(tfContra, 2, 1);
        gp.add(btRegistrar, 0, 2);
        gp.add(btIngresar, 2, 2);       
        BorderPane bp = new BorderPane();
        bp.setTop(lbImagen);
        bp.setMargin(lbImagen, new Insets(8));
        bp.setAlignment(lbImagen, Pos.CENTER);
        bp.setCenter(gp);
        bp.setMargin(gp, new Insets(8));
        bp.setBottom(btSalir);
        bp.setAlignment(btSalir, Pos.TOP_RIGHT);
        bp.setMargin(btSalir, new Insets(8));
        
        this.escena = new Scene(bp, 310, 320);
    }

    @Override
    public Scene getScena() {
        return this.escena;
    }

    public TextField getTfUser() {
        return tfUser;
    }

    public TextField getTfContra() {
        return tfContra;
    }

    public Button getBtIngresar() {
        return btIngresar;
    }

    public Button getBtRegistrar() {
        return btRegistrar;
    }

    public Button getBtSalir() {
        return btSalir;
    }

}
