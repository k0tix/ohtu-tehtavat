package laskin;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Erotus extends Komento {
    private int edellinen;

    public Erotus(Sovelluslogiikka sovellus, TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
        super(sovellus, tuloskentta, syotekentta, nollaa, undo);
    }

    @Override
    public void suorita() {
        try {
            edellinen = Integer.parseInt(syotekentta.getText());
            sovellus.miinus(edellinen);
            paivita();
        } catch (Exception e) {
        }        
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen);
        paivita();
        syotekentta.setText("" + edellinen);
        undo.disableProperty().set(true);
    }
}