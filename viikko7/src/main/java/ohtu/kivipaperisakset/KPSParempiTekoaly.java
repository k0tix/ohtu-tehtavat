package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPS {
    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String annaSiirto() {
        return tekoaly.annaSiirto();
    }

    @Override
    protected void asetaSiirto(String siirto) {
        tekoaly.asetaSiirto(siirto);
    }
}
