package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements ViitegeneraattoriInterface {    
    private int seuraava;
    
    @Autowired
    public Viitegeneraattori(){
        this.seuraava = 1;    
    }
    
    public int uusi(){
        return this.seuraava++;
    }
}
