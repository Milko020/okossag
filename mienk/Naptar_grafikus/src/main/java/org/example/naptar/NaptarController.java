package org.example.naptar;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class NaptarController {

    @FXML
    private ListView<Esemeny> listView;
    @FXML
    private TextArea reszletekArea;
    @FXML
    private Button torlesBtn;
    @FXML
    private TextField nevField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Spinner<Integer> oraSpinner;
    @FXML
    private Spinner<Integer> percSpinner;
    @FXML
    private TextField megjegyzesField;
    @FXML
    private Button hozzaadBtn;
    @FXML
    private MenuItem betoltes;

    private List<Esemeny> esemenyek = new ArrayList<>();

    @FXML
    public void initialize() {
        // Fájl beolvasás RandomAccessFile-lal a legelején
        try (RandomAccessFile raf = new RandomAccessFile("Naptar_grafikus.txt", "r")) {
            String sor;
            while ((sor = raf.readLine()) != null) {
                sor = new String(sor.getBytes("ISO-8859-1"), "UTF-8");
                esemenyek.add(new Esemeny(sor));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nem található a fájl: Naptar_grafikus.txt");
        } catch (EOFException e) {
            // fájlvég, nem probléma
        } catch (IOException e) {
            e.printStackTrace();
        }

        listView.getItems().setAll(esemenyek);
        reszletekArea.clear();

        // Spinner beállítások (ha nem FXML-ben állítod)
        if (oraSpinner.getValueFactory() == null) {
            oraSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 12));
        }
        if (percSpinner.getValueFactory() == null) {
            percSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        }

        // Menü betöltés gomb frissítheti az eseményeket újra
        betoltes.setOnAction(e -> {
            esemenyek.clear();
            try (RandomAccessFile raf = new RandomAccessFile("Naptar_grafikus.txt", "r")) {
                String sor;
                while ((sor = raf.readLine()) != null) {
                    sor = new String(sor.getBytes("ISO-8859-1"), "UTF-8");
                    esemenyek.add(new Esemeny(sor));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            listView.getItems().setAll(esemenyek);
            reszletekArea.clear();
        });

        // ListView kiválasztás figyelése
        listView.getSelectionModel().selectedItemProperty().addListener((obs, regi, uj) -> {
            if (uj != null) {
                reszletekArea.setText(uj.reszletek());
            } else {
                reszletekArea.clear();
            }
        });

        // Törlés gomb esemény
        torlesBtn.setOnAction(e -> {
            Esemeny kijelolt = listView.getSelectionModel().getSelectedItem();
            if (kijelolt != null) {
                esemenyek.remove(kijelolt);
                listView.getItems().setAll(esemenyek);
                reszletekArea.clear();
            }
        });

        // Hozzáadás gomb esemény
        hozzaadBtn.setOnAction(e -> {
            String nev = nevField.getText().trim();
            LocalDate datum = datePicker.getValue();
            int ora = oraSpinner.getValue();
            int perc = percSpinner.getValue();
            String megj = megjegyzesField.getText().trim();

            if (!nev.isEmpty() && datum != null && !megj.isEmpty()) {
                Esemeny uj = new Esemeny(nev, datum, LocalTime.of(ora, perc), megj);
                esemenyek.add(uj);
                listView.getItems().setAll(esemenyek);

                nevField.clear();
                megjegyzesField.clear();
                datePicker.setValue(null);
            }
        });
    }
}
