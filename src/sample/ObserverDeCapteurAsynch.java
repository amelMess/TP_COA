package sample;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by messadene on 17/01/17.
 */
public interface ObserverDeCapteurAsynch {


    Future<Integer> update(Capteur capteur);
}
