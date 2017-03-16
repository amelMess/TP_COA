package sample;


import java.util.List;
import java.util.Timer;

/**
 * Created by messadene on 17/01/17.
 */
public interface Capteur{

    void attach(ObserverDeCapteurAsynch o);
    void detach(ObserverDeCapteurAsynch o);
    int getValue();
    void tick();
    void setStrategy(TypeDiffusion type);



    void setCompteur();

    int getDelai();

    TypeDiffusion getTypeDiffusion();

    List<ObserverDeCapteurAsynch> getObservers();

    Timer getTimer();

}
