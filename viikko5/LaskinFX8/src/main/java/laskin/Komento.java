package laskin;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public abstract class Komento {
    protected Sovelluslogiikka sovellus;
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;

    public Komento(Sovelluslogiikka sovellus, TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    protected void paivita() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());

        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    public abstract void suorita();
    public abstract void peru();
}