package sample;

import canal.Canal;
import canal.CapteurAsynch;
import javafx.application.Platform;
import javafx.scene.control.Label;
import model.Capteur;
import model.TypeDiffusion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Afficheur : le concrete component
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

        Label capteur = this.controllerIHM.getCapteur();
        Platform.runLater(() -> {
            capteur.setText(String.valueOf(valeurCapteur));

        });
        Platform.runLater(() -> {

           // System.out.println(this.controllerIHM.getCapteur());

            this.controllerIHM.getAfficheur1().setText(String.valueOf(finalValeur));

        });
        Platform.runLater(() ->{
            this.controllerIHM.getAfficheur2().setText(String.valueOf(finalValeur));
            this.controllerIHM.getAfficheur3().setText(String.valueOf(finalValeur));


        });

    }


}
