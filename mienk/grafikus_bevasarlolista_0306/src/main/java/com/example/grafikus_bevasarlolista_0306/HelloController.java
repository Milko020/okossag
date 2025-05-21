package com.example.grafikus_bevasarlolista_0306;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button btnMasol;

    @FXML
    private Button btnPieChartMegjelenit;

    @FXML
    private Button btnTorol;

    @FXML
    private PieChart pieChart;

    @FXML
    private ListView<String> listView1;

    @FXML
    private ListView<String> listView2;

    @FXML
    private MenuItem menuItemBeolvas;

    @FXML
    private RadioButton rbButtonArMegjelenit;

    @FXML
    private RadioButton tbButtonErtekMegjelenit;

    private ArrayList<Termek> termekek;

    @FXML
    void btnPieChartMegjelenit(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Termek termek : termekek) {
            pieChartData.add(new PieChart.Data(termek.getNev(), termek.getAr()));
        }
        pieChart.setData(pieChartData);
    }

    @FXML
    void btnTorol(ActionEvent event) {
        String line = listView1.getSelectionModel().getSelectedItem();
        listView1.getItems().remove(line);
        listView2.getItems().remove(line);
    }

    @FXML
    void menuItemBeolvasOnAction(ActionEvent event) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("bevasarloLista.txt", "r");
        String line;
        raf.readLine();
        termekek = new ArrayList<>();
        while ((line = raf.readLine()) != null) {
            // ISO-8859-1 karakterek átalakítása UTF-8-ra
            String[] adatok = new String(line.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

            String nev = adatok[0];
            Integer azonosito = Integer.parseInt(adatok[1]);
            String kisze = adatok[2];
            Integer ar = Integer.parseInt(adatok[3]);

            Termek termek = new Termek(nev, azonosito, kisze, ar);
            termekek.add(termek);
        }

        listView1.getItems().clear();
        for (Termek termek : termekek) {
            listView1.getItems().add(termek.toString());
        }
    }

    @FXML
    void rbButtonArMegjelenit(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Termek termek : termekek) {
            pieChartData.add(new PieChart.Data(termek.getNev(), termek.getAr()));
        }
        pieChart.setData(pieChartData);
    }

    @FXML
    void rbButtonErtekMegjelenit(ActionEvent event) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Termek termek : termekek) {
            pieChartData.add(new PieChart.Data(termek.getNev(), termek.getAzonosito()));
        }
        pieChart.setData(pieChartData);
    }
    @FXML
    void masol(ActionEvent event) {
        listView2.getItems().add(listView1.getSelectionModel().getSelectedItem());
        // Ha az összeset kell: listView2.getItems().addAll(listView1.getItems());
    }


}
