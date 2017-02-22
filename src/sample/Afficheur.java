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

    public Afficheur(ControllerIHM controllerIHM, Capteur capteur, ScheduledExecutorService scheduler) {
        this.controllerIHM = controllerIHM;
        this.canal = new Canal(capteur,this,scheduler);
        this.capteur = capteur;

    }

    public void update()  {
        //text.setText((int) newVal.doubleValue() + "");
       // c.getValue();
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
        Platform.runLater(() -> {

           // System.out.println(this.controllerIHM);
            this.controllerIHM.getAfficheur1().setText(String.valueOf(finalValeur));
            this.controllerIHM.getAfficheur2().setText(String.valueOf(finalValeur));
            this.controllerIHM.getCapteur().setText(String.valueOf(valeurCapteur));

        });

    }

    public Capteur.TypeDiffusion getTypeDeDiffusion(){
        return controllerIHM.getType();
    }

}
