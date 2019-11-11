
package ohtu.verkkokauppa;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kirjanpito implements KirjanpitoInterface {
    private ArrayList<String> tapahtumat;

    @Autowired
    public Kirjanpito() {
        this.tapahtumat = new ArrayList<String>();
    }
    
    public void lisaaTapahtuma(String tapahtuma) {
        this.tapahtumat.add(tapahtuma);
    }

    public ArrayList<String> getTapahtumat() {
        return this.tapahtumat;
    }       
}
