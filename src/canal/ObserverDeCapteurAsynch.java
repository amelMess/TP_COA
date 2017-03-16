package canal;

import model.Capteur;

import java.util.concurrent.Future;

/**
 * Created by messadene on 17/01/17.
 */
public interface ObserverDeCapteurAsynch {


    Future<Integer> update(Capteur capteur);
}
