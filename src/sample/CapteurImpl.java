package sample;


import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by messadene on 17/01/17.
 */
public class CapteurImpl implements Capteur {

    private Canal canal;

    private TimerTask task;

    private Timer timer;

    /**
     * The compteur
     */
    private int compteur;

    /**
     * Le délai d'incrémentation
     */
    private int delai;

    /**
     * liste des observer de capteurs asynchrones
     */
    private List<ObserverDeCapteurAsynch> observersC;
    private TypeDiffusion typeDeDiff;


    public CapteurImpl(){
        this.compteur = 0;
        this.delai = 1000 ;
        this.observersC = new ArrayList<>();
        timer = new Timer();
    }

    @Override
    public void attach(ObserverDeCapteurAsynch o) {
        observersC.add(o);
    }

    @Override
    public void detach(ObserverDeCapteurAsynch o) {
        observersC.remove(o);
    }

    @Override
    public int getValue() {
       // System.out.println(compteur);
       // System.out.println("type "+typeDeDiff);
        return compteur;
    }




    @Override
    public void tick() {
        Capteur capt = this;
        task = new TimerTask() {
            public void run() {
                compteur ++;
                for(ObserverDeCapteurAsynch c : observersC) {
                    //System.out.println("c "+c);
                    c.update(capt);
                }
            }
        };
        timer.scheduleAtFixedRate(task, new Date(), (long) delai);

    }

    @Override
    public void setTypeDeDiffusion(TypeDiffusion type) {
        this.typeDeDiff = type;
        System.out.println(type.toString());
    }

}
