package com.mikaelwidi.bibliotek;

public class PeminjamanHelper {

    public PeminjamanHelper() {
    }

    public PeminjamanHelper(String kd_pinjam, String id_anggota, String kd_buku) {
        this.kd_pinjam = kd_pinjam;
        this.id_anggota = id_anggota;
        this.kd_buku = kd_buku;
    }

    public String getKd_pinjam() {
        return kd_pinjam;
    }

    public void setKd_pinjam(String kd_pinjam) {
        this.kd_pinjam = kd_pinjam;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getKd_buku() {
        return kd_buku;
    }

    public void setKd_buku(String kd_buku) {
        this.kd_buku = kd_buku;
    }

    public String toString(){
        return this.kd_pinjam + "  -  " + id_anggota + "  -  " + kd_buku;
    }

    String kd_pinjam, id_anggota, kd_buku;
}
