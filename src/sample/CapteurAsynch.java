package sample;

/**
 * Created by messadene on 23/01/17.
 */
public interface CapteurAsynch {

    public void attach(Observer o);

    public void detach(Observer o);


    public int getValue();


    public void tick();
}
