import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("bejelentkezesek.txt", "r");
        List<LoginRecord> records = new ArrayList<>();

        raf.readLine();

        String line;
        while ((line = raf.readLine()) != null) {
            String[] parts = new String(line.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");
            if (parts.length == 4) {
                records.add(new LoginRecord(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]));
            }
        }
        raf.close();

        // 1. Hány felhasználó jelentkezett be összesen?
        List<String> uniqueUsers = new ArrayList<>();
        for (LoginRecord r : records) {
            if (!uniqueUsers.contains(r.id)) {
                uniqueUsers.add(r.id);
            }
        }
        System.out.println("1. Összes bejelentkezett felhasználó: " + uniqueUsers.size());

        // 2. Legkorábbi és legkésőbbi bejelentkező
        LoginRecord earliest = records.get(0);
        LoginRecord latest = records.get(0);

        for (LoginRecord r : records) {
            if (r.login.isBefore(earliest.login)) earliest = r;
            if (r.login.isAfter(latest.login)) latest = r;
        }

        System.out.println("2. Legkorábbi bejelentkező: " + earliest.id + " " + earliest.login);
        System.out.println("   Legkésőbbi bejelentkező: " + latest.id + " " + latest.login);


        // 3. Legrövidebb egyszeri bejelentkezés
        LoginRecord shortest = records.get(0);
        long minDuration = shortest.sessionDurationSeconds();

        for (LoginRecord r : records) {
            long dur = r.sessionDurationSeconds();
            if (dur < minDuration) {
                shortest = r;
                minDuration = dur;
            }
        }

        System.out.println("3. Legrövidebb egyszeri bejelentkezés: " + shortest.id +
                ", időtartam másodpercben: " + minDuration);

        // 4. Ki töltötte a legtöbb időt összesen?
        List<String> users = new ArrayList<>();
        List<Long> times = new ArrayList<>();

        for (LoginRecord r : records) {
            int index = users.indexOf(r.id);
            if (index == -1) {
                users.add(r.id);
                times.add(r.sessionDurationSeconds());
            } else {
                times.set(index, times.get(index) + r.sessionDurationSeconds());
            }
        }

        long maxTime = 0;
        String maxUser = null;
        for (int i = 0; i < users.size(); i++) {
            if (times.get(i) > maxTime) {
                maxTime = times.get(i);
                maxUser = users.get(i);
            }
        }

        System.out.println("4. Legtöbb időt a rendszerben töltötte: " + maxUser + ", összesen másodpercben: " + maxTime);

        // 5. Kérj be időpontot, írasd ki, ki volt akkor bejelentkezve
        Scanner sc = new Scanner(System.in);
        System.out.print("5. Kérem az időpontot (HH:mm:ss): ");
        String inputTimeStr = sc.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime inputTime = LocalTime.parse(inputTimeStr, fmt);

        List<String> loggedInUsers = new ArrayList<>();

        for (LoginRecord r : records) {
            if (!inputTime.isBefore(r.login) && !inputTime.isAfter(r.logoff)) {
                if (!loggedInUsers.contains(r.id)) {
                    loggedInUsers.add(r.id);
                }
            }
        }

        System.out.println("Az adott időpontban bejelentkezve voltak:");
        if (loggedInUsers.isEmpty()) {
            System.out.println("Senki");
        } else {
            for (String user : loggedInUsers) {
                System.out.println(user);
            }
        }


        // 6. Írd ki a delutan.txt fájlba az összes délután kezdődő bejelentkezést (12:00:00-tól)
        try (RandomAccessFile raf2 = new RandomAccessFile("delutan.txt", "rw")) {
            raf2.setLength(0);
            for (LoginRecord r : records) {
                if (!r.login.isBefore(LocalTime.NOON)) {
                    String line2 = r.id + ";" + r.terminal + ";" + r.login + ";" + r.logoff + "\n";
                    raf2.write(line2.getBytes());
                }
            }
        }

// 7. feladat
        try (RandomAccessFile taf3 = new RandomAccessFile("logins.txt", "rw")) {
            taf3.setLength(0);
            List<String> felhasznalok = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();

            for (LoginRecord r : records) {
                int index = felhasznalok.indexOf(r.id);
                if (index == -1) {
                    felhasznalok.add(r.id);
                    counts.add(1);
                } else {
                    counts.set(index, counts.get(index) + 1);
                }
            }

            for (int i = 0; i < felhasznalok.size(); i++) {
                String line3 = felhasznalok.get(i) + ";" + counts.get(i) + "\n";
                taf3.write(line3.getBytes());
            }
        }
    }
}