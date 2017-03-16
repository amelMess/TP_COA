package sample;

import java.util.concurrent.*;

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

        int delai = 100 + (int)(Math.random()*1000);
        this.capteur = capteur;
        System.out.println("je suis dans canal "+capteur.getValue()+" delai "+delai);
        Update update = new Update(this.afficheur);
        return scheduler.schedule(update,delai, TimeUnit.MILLISECONDS);
    }


    @Override
    public Future<Integer> getValue() {
       // int delai = 100 + (int)(Math.random()*100);
        int delai = ThreadLocalRandom.current().nextInt(100, 1000 + 1);
        System.out.println("canal get value");
        GetValue getValue = new GetValue(capteur);
        return scheduler.schedule(getValue,delai,TimeUnit.MILLISECONDS);
    }



}
