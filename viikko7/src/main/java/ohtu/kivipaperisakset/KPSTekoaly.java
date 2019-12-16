package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS {
    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String annaSiirto() {
        return tekoaly.annaSiirto();
    }

    @Override
    protected void asetaSiirto(String siirto) {
        tekoaly.asetaSiirto(siirto);
    }
}