package com.example.grafikus_bevasarlolista_0306;

public class Termek {
    private String nev;
    private Integer azonosito;
    private String kiszereles;
    private Integer ar;

    public Termek(String nev, Integer azonosito, String kiszereles, Integer ar) {
        this.nev = nev;
        this.azonosito = azonosito;
        this.kiszereles = kiszereles;
        this.ar = ar;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(Integer azonosito) {
        this.azonosito = azonosito;
    }

    public String getKiszereles() {
        return kiszereles;
    }

    public void setKiszereles(String kiszereles) {
        this.kiszereles = kiszereles;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return nev + "\t" + azonosito + "\t" + kiszereles + "\t" + ar;
    }
}
