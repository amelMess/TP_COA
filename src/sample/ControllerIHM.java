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
     * afficheur 3
     */
    @FXML
    private Label afficheur3;

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

    private Capteur mcapteur;
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
        this.mcapteur = capteur;
        this.afficheur = new Afficheur(this,capteur,scheduler);
        this.capteurM = capteur;
        typeDiffusion.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {

            if (typeDiffusion.getSelectedToggle() != null) {
                if (sequentiel.isSelected()) {
                    this.mcapteur.setStrategy(TypeDiffusion.Sequentiel);
                } else if (atomique.isSelected()) {
                    this.mcapteur.setStrategy(TypeDiffusion.Atomique);

                } else if (epoque.isSelected()) {
                    this.mcapteur.setStrategy(TypeDiffusion.Epoque);

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
     * retourne le label du 3eme afficheur
     * @return afficheur3
     */
    public Label getAfficheur3() {
        return afficheur3;
    }


    /**
     * retourne le label du 1capteur
     * @return capteur
     */
    public Label getCapteur() {return capteur; }



}
