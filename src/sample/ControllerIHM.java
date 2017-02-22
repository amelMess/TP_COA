package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

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


    public Label getAfficheur1() {
        return afficheur1;
    }

    public Label getAfficheur2() {
        return afficheur2;
    }

    public Label getCapteur() {return capteur; }

}
