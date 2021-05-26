package proyecto;


import controlador.ControladorLogin;
import controlador.Singleton;
import java.io.FileNotFoundException;
import vista.Vista;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Proyecto extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Singleton singleton = Singleton.getSingleton();
        singleton.setStage(primaryStage);
        ControladorLogin controlador = new ControladorLogin();
        Vista vista = controlador.getVista();
        primaryStage.setScene(vista.getScena());
        Image icon = new Image(getClass().getResourceAsStream("/Images/Imagen2.png"));
        primaryStage.setTitle("Te lo presto");
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
