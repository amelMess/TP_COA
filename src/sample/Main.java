package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        ControllerIHM controllerIHM = loader.getController();
        Capteur capteur = new CapteurImpl();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        Afficheur afficheur1 = new Afficheur(controllerIHM,capteur,scheduler);
        Afficheur afficheur2 = new Afficheur(controllerIHM,capteur,scheduler);
        /*capteur.attach(afficheur1.getCanal());
        capteur.attach(afficheur2.getCanal());*/
        Canal canal1 =  new Canal(capteur,afficheur1,scheduler);
        Canal canal2 =  new Canal(capteur,afficheur2,scheduler);
        //canal1.update(capteur);
        //canal2.update(capteur);

        capteur.tick();
        primaryStage.setOnCloseRequest(x -> System.exit(0));
        primaryStage.setTitle("Hello MINA");
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}