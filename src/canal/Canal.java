package canal;

import model.Capteur;
import sample.*;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


/**
 * classe proxy
 * implement le capteurAsynch et ObserverDeCapteurAsynch
 */
public class Canal implements CapteurAsynch, ObserverDeCapteurAsynch {

    private Capteur capteur;
    ScheduledExecutorService scheduler;
    private Afficheur afficheur;

    /**
     * constructeur
     * @param capteur
     * @param afficheur
     */
    public Canal(Capteur capteur, Afficheur afficheur, ScheduledExecutorService scheduler){
        this.capteur = capteur;
        this.afficheur = afficheur;
        this.capteur.attach(this);
        this.scheduler = scheduler;
    }

    /**
     * update
     * @param capteur
     * @return
     */
    @Override
    public Future<Integer> update(Capteur capteur) {

        this.capteur = capteur;
        int delai = ThreadLocalRandom.current().nextInt(200, 1100);
        Update update = new Update(this.afficheur);
        return scheduler.schedule(update,delai, TimeUnit.MILLISECONDS);
    }

    /**
     * getValue
     * @return
     */
    @Override
    public Future<Integer> getValue() {

        GetValue getValue = new GetValue(capteur);
        int delai = ThreadLocalRandom.current().nextInt(200, 1100);
        return scheduler.schedule(getValue,delai,TimeUnit.MILLISECONDS);
    }



}
