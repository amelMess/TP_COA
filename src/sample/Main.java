package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = loader.load(getClass().getClassLoader().getResource("resources/sample.fxml").openStream());
        ControllerIHM controllerIHM = loader.getController();
        Capteur capteur = new CapteurImpl();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        controllerIHM.initialize(capteur,scheduler);

       // Afficheur afficheur1 = new Afficheur(controllerIHM,capteur,scheduler);
        //Afficheur afficheur2 = new Afficheur(controllerIHM,capteur,scheduler);
       // Afficheur afficheur1 = controllerIHM.getAfficheur();
       // Afficheur afficheur2 = controllerIHM.getAfficheur();
        /*capteur.attach(afficheur1.getCanal());
        capteur.attach(afficheur2.getCanal());*/
      //  Canal canal1 =  new Canal(capteur,afficheur1,scheduler);
       // Canal canal2 =  new Canal(capteur,afficheur2,scheduler);
        //canal1.update(capteur);
        //canal2.update(capteur);

        //capteur.tick();
       TypeDiffusion type = TypeDiffusion.Sequentiel;
       capteur.setStrategy(type);
        primaryStage.setOnCloseRequest(x -> System.exit(0));
        primaryStage.setTitle("Hello MINA");
        primaryStage.setScene(new Scene(root, 450, 475));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
