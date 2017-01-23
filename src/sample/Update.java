package sample;

import java.util.concurrent.Callable;

/**
 * Created by messadene on 17/01/17.
 */
public class Update implements Callable {

    Afficheur afficheur = new Afficheur();

    @Override
    public Object call() throws Exception {
        //afficheur.update();
        return null;
    }
}
