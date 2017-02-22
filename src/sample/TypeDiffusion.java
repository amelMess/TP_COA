package sample;

/**
 * Created by messadene on 22/02/17.
 */
public enum TypeDiffusion {
    Sequentiel("seq"),
    Atomique("atom"),
    Epoque("epo");


    private String name = "";

    //Constructeur
    TypeDiffusion(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
