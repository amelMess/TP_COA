package sample;


/**
 * Created by messadene on 17/01/17.
 */
public interface Capteur{

    void attach(ObserverDeCapteurAsynch o);
    void detach(ObserverDeCapteurAsynch o);
    int getValue();
    void tick();

    void setTypeDeDiffusion(TypeDiffusion type);


}
