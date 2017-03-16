package model;

import canal.ObserverDeCapteurAsynch;
import model.AlgoDeDiffusion;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * algorithme de diffusion atomique
 */
public class AtomiqueDiffusion implements AlgoDeDiffusion {


    private Capteur capteur;

    /**
     * constructor
     */
    public AtomiqueDiffusion(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    /**
     * algo
     * @param observersC
     */
    @Override
    public void diffuser(List<ObserverDeCapteurAsynch> observersC) {

        Capteur capt = this.capteur;
        try {
            wait(this.capteur.getDelai());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dans la strategie "+capt.getObservers().size());
        for(ObserverDeCapteurAsynch c : capt.getObservers()) {
             c.update(capt);
        }
    }


}
