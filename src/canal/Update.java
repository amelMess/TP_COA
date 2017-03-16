package canal;

import sample.Afficheur;

import java.util.concurrent.Callable;

/**
 * Created by messadene on 17/01/17.
 */
public class Update implements Callable {

   private Afficheur afficheur;


    public Update(Afficheur afficheur){
        this.afficheur = afficheur;
    }

    @Override
    public Object call() throws Exception {
        //System.out.println("u");

        this.afficheur.update();
        return null;
    }
}
