import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Vasarlas> vasarlasok = new ArrayList<>();

        try (RandomAccessFile raf = new RandomAccessFile("vasarlasok.txt", "r")) {
            raf.readLine();
            String line;
            while ((line = raf.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    vasarlasok.add(new Vasarlas(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        }

        Scanner sc = new Scanner(System.in);

        // 2. feladat: dátum bekérése
        System.out.print("Kérem a dátumot (ÉÉÉÉ.HH.NN): ");
        String inputDatumStr = sc.nextLine().replace('.', '-');
        LocalDate inputDatum = LocalDate.parse(inputDatumStr);

        int talalatokSzama = 0;
        for (Vasarlas v : vasarlasok) {
            if (v.getDatum().equals(inputDatum)) {
                talalatokSzama++;
            }
        }

        if (talalatokSzama > 0) {
            System.out.println("Vásárlás " + inputDatum + " napján: volt");
        } else {
            System.out.println("Vásárlás " + inputDatum + " napján: nem volt");
        }

        // 3. legkorábbi és legkésőbbi vásárlás
        Vasarlas legkorabbi = vasarlasok.get(0);
        Vasarlas legkesobbi = vasarlasok.get(0);
        for (Vasarlas v : vasarlasok) {
            if (v.getDatum().isBefore(legkorabbi.getDatum())) legkorabbi = v;
            if (v.getDatum().isAfter(legkesobbi.getDatum())) legkesobbi = v;
        }
        System.out.println("Legkorábbi vásárlás: " + legkorabbi.getDatum());
        System.out.println("Legkésőbbi vásárlás: " + legkesobbi.getDatum());

        // 4. szombati vásárlások fájlba írása RandomAccessFile-lal
        try (RandomAccessFile raf = new RandomAccessFile("szombatok.txt", "rw")) {
            raf.setLength(0);
            for (Vasarlas v : vasarlasok) {
                if (v.getDatum().getDayOfWeek() == DayOfWeek.SATURDAY) {
                    String sor = v.getDatum() + ";" + v.getIdopont() + ";" + v.getErtek() + ";" + v.getAruhaz() + "\n";
                    raf.write(sor.getBytes());
                }
            }
        }

        // 5. hány napon történt vásárlás
        List<LocalDate> napok = new ArrayList<>();
        for (Vasarlas v : vasarlasok) {
            if (!napok.contains(v.getDatum())) {
                napok.add(v.getDatum());
            }
        }
        System.out.println("Összesen vásárlás történt " + napok.size() + " napon.");

        // 6. átlagos költés
        int osszeg = 0;
        int db = 0;
        for (int i = 0; i < vasarlasok.size(); i++) {
            osszeg += vasarlasok.get(i).getErtek();
            db++;
        }
        double atlag = 0;
        if (db > 0) {
            atlag = (double) osszeg / db;
        }
        System.out.printf("Átlagosan %.2f Ft-ot költöttünk egy vásárlás alkalmával.%n", atlag);

        // 7. hány különböző áruház
        List<String> aruhazak = new ArrayList<>();
        for (Vasarlas v : vasarlasok) {
            if (!aruhazak.contains(v.getAruhaz())) {
                aruhazak.add(v.getAruhaz());
            }
        }
        System.out.println("Különböző áruházak száma: " + aruhazak.size());
    }
}