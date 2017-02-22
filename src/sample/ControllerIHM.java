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
 * controller du fxml
 */
public class ControllerIHM {

    /**
     * afficheur1
     */
    @FXML
    private Label afficheur1;

    /**
     * afficheur 2
     */
    @FXML
    private Label afficheur2;

    /**
     * capteur
     */
    @FXML
    private Label capteur;

    /**
     * toggle groupe du type de diffusion
     */
    @FXML
    private ToggleGroup typeDiffusion;

    /**
     * sequentiel
     */
    @FXML
    private RadioButton sequentiel;

    /**
     * diffusion atomaique
     */
    @FXML
    private RadioButton atomique;

    /**
     * diffusion epoque
     */
    @FXML
    private RadioButton epoque;


    /**
     * afficheur
     */
    private Afficheur afficheur;

    /**
     * initialize
     * @param capteur
     * @param scheduler
     */
    public void initialize(Capteur capteur, ScheduledExecutorService scheduler) {
        this.afficheur = new Afficheur(this,capteur,scheduler);
        typeDiffusion.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {

            if (typeDiffusion.getSelectedToggle() != null) {
                if (sequentiel.isSelected()) {
                    afficheur.setTypeDiffusion(TypeDiffusion.Sequentiel);
                } else if (atomique.isSelected()) {
                    afficheur.setTypeDiffusion(TypeDiffusion.Atomique);

                } else if (epoque.isSelected()) {
                    afficheur.setTypeDiffusion(TypeDiffusion.Epoque);
                }
            }

        });
    }

    /**
     * retourne le label du 1er afficheur
     * @return afficheur1
     */
    public Label getAfficheur1() {
        return afficheur1;
    }

    /**
     * retourne le label du 2eme afficheur
     * @return afficheur2
     */
    public Label getAfficheur2() {
        return afficheur2;
    }

    /**
     * retourne le label du 1capteur
     * @return capteur
     */
    public Label getCapteur() {return capteur; }



}
