package ohtu.verkkokauppa;

public class Viitegeneraattori implements ViitegeneraattoriInterface {    
    private int seuraava;
    
    public Viitegeneraattori(){
        this.seuraava = 1;    
    }
    
    public int uusi(){
        return this.seuraava++;
    }
}
