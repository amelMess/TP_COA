package model;

import canal.ObserverDeCapteurAsynch;
import model.AlgoDeDiffusion;
import model.Capteur;
import model.CapteurImpl;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *Algorithme de diffusion sequentiel
 */
public class SequentielDiffusion implements AlgoDeDiffusion {


    private Capteur capteur;

    private TimerTask task;

    private Timer timer;

    /**
     * constructor
     * @param capteur
     */
    public SequentielDiffusion(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    /**
     * alog
     * @param observersC
     */
    @Override
    public void diffuser(List<ObserverDeCapteurAsynch> observersC) {
        timer = new Timer();
        Capteur capt = this.capteur;


        System.out.println("dans la strategie "+capt.getObservers().size());
        task = new TimerTask() {
            public void run() {
                capt.setCompteur();
                for(ObserverDeCapteurAsynch c : capt.getObservers()) {
                    c.update(capt);
                }
            }
        };
        timer.scheduleAtFixedRate(task, new Date(), (long) capt.getDelai());
    }
}