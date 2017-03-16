package model;


import canal.Canal;
import canal.ObserverDeCapteurAsynch;

import java.util.*;

/**
 * classe implementant le capteur
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

    /**
     * getter de la valeur du capteur
     * @return
     */
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

    /**
     * lance la strategie demandee par l'utilisateur
     * @param typeDeDiff
     */
    @Override
    public void setStrategy(TypeDiffusion typeDeDiff){
        System.out.println(" dans strategy "+typeDeDiff.toString());
       // strategy  = null;
        switch (typeDeDiff){
            case Sequentiel:

                strategy = new SequentielDiffusion(this);
                //this.tick();
                            break;
            case Atomique:

                strategy = new SequentielDiffusion(this);
                            break;
            case Epoque:

                strategy = new SequentielDiffusion(this);
                break;
            default:
                    System.out.println("hello");
        }
        strategy.diffuser(this.observersC);
    }

    /**
     * set le type de diffusion
     * @param type recupere dans la vue
     */
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

    /**
     * set le delai recupere dans la vue
     * @param newValue
     */
    @Override
    public void setDelai(int newValue) {
        this.delai = newValue;
       // System.out.println(" nouvelle valeur, je recommence "+newValue);
        setStrategy(typeDeDiff);
    }

}
