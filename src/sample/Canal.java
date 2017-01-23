package sample;

/**
 * Created by messadene on 17/01/17.
 */
public class Canal implements CapteurAsynch, ObserverDeCapteurAsynch {

    SchedulerExecutorService s = new SchedulerExecutorServiceImpl();

    @Override
    public void update(Capteur o) {
        Update update = new Update();
        s.schedule(update,500);
    }

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void tick() {

    }
}
