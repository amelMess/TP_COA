package sample;

import java.util.concurrent.Callable;

/**
 * Created by messadene on 17/01/17.
 */
public class Update implements Callable {

   private Afficheur afficheur;


    public Update(Afficheur afficheur){

        this.afficheur = afficheur;
        System.out.println(" jai initialise mon afficheur ");
    }

    @Override
    public Object call() {
        //System.out.println("u");
        System.out.println("call de update");
        this.afficheur.update();
        return null;
    }
}
