package sample;

import java.util.Observable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by messadene on 17/01/17.
 */
public class Canal implements CapteurAsynch, ObserverDeCapteurAsynch{

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

    @Override
    public Future<Integer> update(Capteur capteur) {
        this.capteur = capteur;
        Update update = new Update(afficheur);
        return scheduler.schedule(update,500, TimeUnit.MILLISECONDS);
    }


    @Override
    public Future<Integer> getValue() {
        GetValue getValue = new GetValue(capteur);
        return scheduler.schedule(getValue,500,TimeUnit.MILLISECONDS);
    }


}
