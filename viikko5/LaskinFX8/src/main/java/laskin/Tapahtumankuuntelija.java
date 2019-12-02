package laskin;

import java.util.HashMap;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private Button undo;
    private Komento edellinen;
    private HashMap<Button, Komento> komennot;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        edellinen = null;
        Sovelluslogiikka sovellus = new Sovelluslogiikka();

        this.komennot = new HashMap<>();
        komennot.put(plus, new Summa(sovellus, tuloskentta, syotekentta, nollaa, undo));
        komennot.put(miinus, new Erotus(sovellus, tuloskentta, syotekentta, nollaa, undo));
        komennot.put(nollaa, new Nollaa(sovellus, tuloskentta, syotekentta, nollaa, undo));
    }
    
    @Override
    public void handle(Event event) {
        if (event.getTarget() == undo) {
            edellinen.peru();
            edellinen = null;
        } else {
            Komento k = komennot.get(event.getTarget());
            k.suorita();
            edellinen = k;
        }
    }

}
