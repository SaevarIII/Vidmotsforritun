package com.example.is.vinnsla;

public class KmGjaldVinnsla {

    private int heildKm = 0;
    private int heildarGreidsla = 0;
    private int fjoldiManada = 0;

    public int getHeildEknirKm() {
        return heildKm;
    }

    public int getHeildarGreidsla() {
        return heildarGreidsla;
    }

    public int getFjoldiManada() {
        return fjoldiManada;
    }

    public void skraManud(int upphaf, int lok, String flokkur) {
        if (!erLoglegt(flokkur))
            return;

        int km = lok - upphaf;
        if (km < 0) return;

        int manGjald = reiknaManGjald(km, flokkur);

        heildKm += km;
        heildarGreidsla += manGjald;
        fjoldiManada++;
    }

    public double getGjaldKilometra(String flokkur) {
        if (flokkur.equals("A") || flokkur.equals("C")) return 6.95;
        return 4.15;
    }

    public int reiknaManGjald(int km, String flokkur) {
        return (int) Math.round(km * getGjaldKilometra(flokkur));
    }

    public boolean erLoglegt(String flokkur) {
        if (flokkur == null) return false;
        flokkur = flokkur.trim().toUpperCase();
        return flokkur.equals("A") || flokkur.equals("B") || flokkur.equals("C");
    }
}