package sample;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by boussalia on 22/02/17.
 */
public class SequentielDiffusion implements AlgoDeDiffusion {


    private Capteur capteur;

    private TimerTask task;

    private Timer timer;


    public SequentielDiffusion(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public void diffuser() {
        timer = new Timer();

        Capteur capt = this.capteur;
        System.out.println("dans la strategie seq "+capt.getValue());
        int delai = ThreadLocalRandom.current().nextInt(100, 1000 + 1);

        task = new TimerTask() {

            public void run() {
                //System.out.println("capt "+capt.getValue());
                for(ObserverDeCapteurAsynch c : capt.getObservers()) {
                    System.out.println("appel update");
                    c.update(capt);

                }
                capt.setCompteur();


            }

        };
        timer.scheduleAtFixedRate(task, new Date(), (long) delai);

    }
}
