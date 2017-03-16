package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import static jdk.nashorn.internal.runtime.Context.printStackTrace;

/**
 * Created by messadene on 17/01/17.
 */
public class Afficheur {

    private ControllerIHM controllerIHM;

    private CapteurAsynch canal;

    private Capteur capteur;

    /**
     * constructeur
     * @param controllerIHM controlleur de la vue
     * @param capteur
     * @param scheduler
     */
    public Afficheur(ControllerIHM controllerIHM, Capteur capteur, ScheduledExecutorService scheduler) {
        this.controllerIHM = controllerIHM;
        this.canal = new Canal(capteur,this,scheduler);
        this.capteur = capteur;

    }

    /**
     * met a jour la valeur dans les labels
     */
    public void update()  {


        Future<Integer> value = this.canal.getValue();
        int valeur = 0;
        try {
             valeur = value.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int finalValeur = valeur;
        int valeurCapteur = capteur.getValue();
        //System.out.println("final "+finalValeur);
        System.out.println("valeur dans afficheur "+valeur);
        System.out.println("valeur actuelle du capteur "+valeurCapteur);
        Label capteur = this.controllerIHM.getCapteur();
        Platform.runLater(() -> {
            capteur.setText(String.valueOf(valeurCapteur));

        });
        Platform.runLater(() -> {

           // System.out.println(this.controllerIHM.getCapteur());

            this.controllerIHM.getAfficheur1().setText(String.valueOf(finalValeur));
            System.out.println("je l'ai affiche");

        });
        Platform.runLater(() ->{
            this.controllerIHM.getAfficheur2().setText(String.valueOf(finalValeur));
            this.controllerIHM.getAfficheur3().setText(String.valueOf(finalValeur));


        });

    }


}
