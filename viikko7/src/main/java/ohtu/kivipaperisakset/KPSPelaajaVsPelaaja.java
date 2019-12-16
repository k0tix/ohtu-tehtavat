package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPS {

    @Override
    protected String annaSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    @Override
    protected void asetaSiirto(String siirto) {
        return;
    }
}