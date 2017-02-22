package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by messadene on 21/02/17.
 */
public class ControllerIHM {




    @FXML
    private Label afficheur1;

    @FXML
    private Label afficheur2;

    @FXML
    private Label capteur;

    @FXML
    private ToggleGroup typeDiffusion;

    @FXML
    private RadioButton sequenciel;

    @FXML
    private RadioButton atomique;

    @FXML
    private RadioButton epoque;

    private TypeDiffusion type;

    private Afficheur a;

    /**
     * 
     * @param capteur
     * @param scheduler
     */
    public void initialize(Capteur capteur, ScheduledExecutorService scheduler) {
        this.a = new Afficheur(this,capteur,scheduler);
        typeDiffusion.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {

            if (typeDiffusion.getSelectedToggle() != null) {
                if (sequenciel.isSelected()) {
                    a.setTypeDiffusion(TypeDiffusion.Sequentiel);
                    this.type = TypeDiffusion.Sequentiel;
                } else if (atomique.isSelected()) {
                    type = TypeDiffusion.Atomique;
                    a.setTypeDiffusion(TypeDiffusion.Atomique);

                } else if (epoque.isSelected()) {
                    a.setTypeDiffusion(TypeDiffusion.Epoque);
                    type = TypeDiffusion.Epoque;
                }
            }
            //System.out.println("le type dans controllerIHm "+type.toString());

        });
        //System.out.println(type.toString());
       // System.out.println(sequenciel.isSelected());
    }
    public Label getAfficheur1() {
        return afficheur1;
    }

    public Label getAfficheur2() {
        return afficheur2;
    }

    public Label getCapteur() {return capteur; }


    public TypeDiffusion getType(){
        return type;
    }

    public Afficheur getAfficheur() {
        return a;
    }
}
