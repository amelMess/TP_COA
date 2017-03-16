package sample;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by boussalia on 22/02/17.
 */
public class EpoqueDiffusion implements AlgoDeDiffusion {

    private Capteur capteur;

    private TimerTask task;

    private Timer timer;


    public EpoqueDiffusion(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public void diffuser() {
       /* timer = new Timer();
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
        timer.scheduleAtFixedRate(task, new Date(), (long) capt.getDelai());*/
    }
}
