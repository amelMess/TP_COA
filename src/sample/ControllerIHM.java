package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

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

    private Capteur.TypeDiffusion type;

    public ControllerIHM(){
        typeDiffusion.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (typeDiffusion.getSelectedToggle() != null) {
                    if (sequenciel.isSelected()) {
                       setTypeDiffusion(Capteur.TypeDiffusion.sequentiel);
                    } else if (atomique.isSelected()) {
                        setTypeDiffusion(Capteur.TypeDiffusion.atomique);
                    } else if (epoque.isSelected()) {
                        setTypeDiffusion(Capteur.TypeDiffusion.epoque);
                    }
                }

            }
        });
    }
    public Label getAfficheur1() {
        return afficheur1;
    }

    public Label getAfficheur2() {
        return afficheur2;
    }

    public Label getCapteur() {return capteur; }

    public void setTypeDiffusion(Capteur.TypeDiffusion type){
        this.type = type;
    }

    public Capteur.TypeDiffusion getType(){
        return type;
    }

}
