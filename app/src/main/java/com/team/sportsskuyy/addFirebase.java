package com.team.sportsskuyy;

public class addFirebase {
    String id_latihan;
    String tanggal;
    String gerakan;
    int kalori;

    public addFirebase() {

    }

    public addFirebase(String id_latihan, String tanggal, String gerakan, int kalori) {
        this.id_latihan = id_latihan;
        this.tanggal = tanggal;
        this.gerakan = gerakan;
        this.kalori = kalori;
    }

    public String getId_latihan() {
        return id_latihan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getGerakan() {
        return gerakan;
    }

    public int getKalori() {
        return kalori;
    }
}
