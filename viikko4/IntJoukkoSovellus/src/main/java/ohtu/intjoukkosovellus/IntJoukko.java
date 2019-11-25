
package ohtu.intjoukkosovellus;

public class IntJoukko {
    public final static int KAPASITEETTI = 5;
    public final static int OLETUSKASVATUS = 5;
    private int kasvatuskoko;
    private int[] lukujono;
    private int koko;

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla pienempi kuin 0");
        }

        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvastukoko ei voi olla pienempi kuin 0");
        }

        lukujono = new int[kapasiteetti];
        koko = 0;
        
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }

        if (koko + 1 >= lukujono.length) {
            lukujono = kasvataKokoa(lukujono);
        }

        lukujono[koko++] = luku;
        return true;
    }

    public boolean kuuluu(int luku) {
        return etsiLuku(luku) > -1;
    }

    public int etsiLuku(int luku) {
        for (int i = 0; i < koko; i++) {
            if (luku == lukujono[i]) {
                return i;
            }
        }

        return -1;
    }

    public boolean poista(int luku) {
        int indeksi = etsiLuku(luku);

        if (indeksi == -1) {
            return false;
        } else if (--koko > 0) {
            System.arraycopy(lukujono, indeksi + 1, lukujono, indeksi, koko - indeksi);
        }

        return true;
    }

    private int[] kasvataKokoa(int[] taulukko) {
        int[] uusi = new int[taulukko.length + kasvatuskoko];

        for (int i = 0; i < taulukko.length; i++) {
            uusi[i] = taulukko[i];
        }

        return uusi;
    }

    public int mahtavuus() {
        return koko;
    }

    @Override
    public String toString() {
        StringBuilder tuotos = new StringBuilder("{");
        for (int i = 0; i < koko; i++) {
            if (i > 0) {
                tuotos.append(", ");
            }
            tuotos.append(lukujono[i]);
        }
        tuotos.append("}");
        return tuotos.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[koko];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
   
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
}
