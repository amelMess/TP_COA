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

        Platform.runLater(() -> {

           // System.out.println(this.controllerIHM);
            this.controllerIHM.getCapteur().setText(String.valueOf(valeurCapteur));
            this.controllerIHM.getAfficheur1().setText(String.valueOf(finalValeur));

        });
        Platform.runLater(() ->{
            this.controllerIHM.getAfficheur2().setText(String.valueOf(finalValeur));

        });

    }


    /**
     * recupere le type de diffusion selectionnée
     * @param typeDiffusion le type de diffusion
     */
    public void setTypeDiffusion(TypeDiffusion typeDiffusion) {
        System.out.println("dans afficheur "+typeDiffusion.toString());
        this.capteur.setTypeDeDiffu(typeDiffusion);
    }
}
