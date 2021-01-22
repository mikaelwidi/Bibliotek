package com.mikaelwidi.bibliotek;

public class BukuHelper {

    public BukuHelper() {
    }

    public BukuHelper(String kd_buku, String jdl_buku, String pengar, String kd_rak) {
        this.kd_buku = kd_buku;
        this.jdl_buku = jdl_buku;
        this.pengar = pengar;
        this.kd_rak = kd_rak;
    }

    public String getKd_buku() {
        return kd_buku;
    }

    public void setKd_buku(String kd_buku) {
        this.kd_buku = kd_buku;
    }

    public String getJdl_buku() {
        return jdl_buku;
    }

    public void setJdl_buku(String jdl_buku) {
        this.jdl_buku = jdl_buku;
    }

    public String getPengar() {
        return pengar;
    }

    public void setPengar(String pengar) {
        this.pengar = pengar;
    }

    public String getKd_rak() {
        return kd_rak;
    }

    public void setKd_rak(String kd_rak) {
        this.kd_rak = kd_rak;
    }

    public String toString(){
        return this.kd_buku + "  -  " + jdl_buku + "  -  " + kd_rak;
    }
    String kd_buku, jdl_buku, pengar, kd_rak;
}
