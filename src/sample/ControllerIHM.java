package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Capteur;
import model.TypeDiffusion;

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
     * delai
     */
    @FXML
    private Slider delai;

    /**
     * textField du delai
     */
    @FXML
    private TextField delaiVue;

    /**
     * capteur model
     */
    private Capteur capteurM;

    /**
     * initialize
     * @param capteur
     * @param scheduler
     */
    public void initialize(Capteur capteur, ScheduledExecutorService scheduler) {
        this.afficheur = new Afficheur(this,capteur,scheduler);
        this.capteurM = capteur;
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
       //
        delaiVue.setText(this.capteurM.getDelai()+"");

        delai.setValue(this.capteurM.getDelai());

        delai.valueProperty().addListener((ov, oldVal, newVal) -> {
            delai.setValue(newVal.intValue());

            delaiVue.setText((int) newVal.doubleValue() + "");
            capteurM.setDelai((int)delai.getValue());

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
