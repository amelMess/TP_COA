package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Observable;

/**
 * Created by messadene on 17/01/17.
 */
public class Afficheur implements ObserverDeCapteurAsynch {

    @FXML
    private Label text;

    @Override
    public void update(Capteur c) {
        //text.setText((int) newVal.doubleValue() + "");
        c.getValue();
    }


}
