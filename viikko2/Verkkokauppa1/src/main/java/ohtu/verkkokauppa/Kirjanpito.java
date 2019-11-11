
package ohtu.verkkokauppa;

import java.util.ArrayList;

public class Kirjanpito implements KirjanpitoInterface {
    private ArrayList<String> tapahtumat;

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
