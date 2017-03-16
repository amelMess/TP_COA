package canal;

import model.Capteur;

import java.util.concurrent.Callable;

/**
 * Created by messadene on 17/01/17.
 */
public class GetValue implements Callable {

    private Capteur capteur;

    public GetValue(Capteur capteur){
        this.capteur = capteur;
        System.out.println("constructeur getvalue");

    }

    @Override
    public Object call() throws Exception {
        System.out.println("call get value "+capteur.getValue());
        return capteur.getValue();
    }
}
