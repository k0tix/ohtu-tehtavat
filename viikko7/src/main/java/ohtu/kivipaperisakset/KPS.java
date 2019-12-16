package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 * Kivi-Sakset-Paperi, jossa voidaan valita pelataanko vastustajaa
 * vastaan vai ei
 */
public abstract class KPS {
    protected static Scanner scanner = new Scanner(System.in);

    public static KPS kpsParempiTekoaly() {
        return new KPSParempiTekoaly();
    }

    public static KPS kpsPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KPS kpsTekoaly() {
        return new KPSTekoaly();
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = pyydaSiirto();
        String tokanSiirto = annaSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = pyydaSiirto();
            tokanSiirto = annaSiirto();
            asetaSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    private String pyydaSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    protected abstract String annaSiirto();

    protected abstract void asetaSiirto(String siirto);
}