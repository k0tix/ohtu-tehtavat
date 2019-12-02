package laskin;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Summa extends Komento {
    private int edellinen;

    public Summa(Sovelluslogiikka sovellus, TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
        super(sovellus, tuloskentta, syotekentta, nollaa, undo);
    }

    @Override
    public void suorita() {
        try {
            edellinen = Integer.parseInt(syotekentta.getText());
            sovellus.plus(edellinen);
            paivita();
        } catch (Exception e) {
        }        
    }

    @Override
    public void peru() {
        System.out.println(edellinen);
        sovellus.miinus(edellinen);
        paivita();
        syotekentta.setText("" + edellinen);
        undo.disableProperty().set(true);
    }
}