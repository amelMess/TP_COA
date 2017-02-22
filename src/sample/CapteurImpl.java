package sample;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private AlgoDeDiffusion strategy;

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
    public void setStrategy(TypeDiffusion typeDeDiff){
        System.out.println(" dans strategy "+typeDeDiff.toString());
        strategy  = null;
        switch (typeDeDiff){
            case Sequentiel: strategy = new SequentielDiffusion(this);
                            break;
            case Atomique:
                this.compteur =100;
                strategy = new SequentielDiffusion(this);
                            break;
            case Epoque:
                this.compteur = 1000;
                strategy = new SequentielDiffusion(this);
                break;
            default:
                    System.out.println("hello");
        }
        strategy.diffuser();
        System.out.println(" strategy "+strategy.toString());
    }

    @Override
    public void setTypeDeDiffusion(TypeDiffusion type) {

        this.typeDeDiff = type;
        setStrategy(this.typeDeDiff);
        System.out.println(type.toString());
    }

    @Override
    public void setCompteur() {
        this.compteur++;
    }

    @Override
    public int getDelai() {
        return this.delai;
    }

    @Override
    public TypeDiffusion getTypeDiffusion() {
        return typeDeDiff;
    }

    @Override
    public List<ObserverDeCapteurAsynch> getObservers() {
        return observersC;
    }

}
