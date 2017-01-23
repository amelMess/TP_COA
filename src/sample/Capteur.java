package sample;


/**
 * Created by messadene on 17/01/17.
 */
public interface Capteur{

    void attach(Observer o);
    void detach(Observer o);
    int getValue();
    void tick();
}
