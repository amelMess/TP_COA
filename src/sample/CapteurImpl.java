package sample;


/**
 * Created by messadene on 17/01/17.
 */
public class CapteurImpl implements Capteur {

    Canal canal = new CanalImpl();

    public CapteurImpl(){
        canal.update(this);
    }

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public int getValue() {
        GetValue gv = new GetValue();
        return 0;
    }

    @Override
    public void tick() {

    }
}
