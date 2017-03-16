package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Capteur;
import model.CapteurImpl;
import model.TypeDiffusion;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * classe principale
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = loader.load(getClass().getClassLoader().getResource("resources/sample.fxml").openStream());
        ControllerIHM controllerIHM = loader.getController();
        Capteur capteur = new CapteurImpl();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(20);

        controllerIHM.initialize(capteur,scheduler);



        //capteur.tick();

        TypeDiffusion type = TypeDiffusion.Sequentiel;
        //capteur.setStrategy(type);
        capteur.setTypeDeDiffusion(type);

        primaryStage.setOnCloseRequest(x -> System.exit(0));
        primaryStage.setTitle("Hello");
        primaryStage.setScene(new Scene(root, 450, 475));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
