package com.mikaelwidi.bibliotek;

public class AnggotaHelper {

    public AnggotaHelper() {
    }

    public AnggotaHelper(String id_anggota, String nama, String no_hp) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.no_hp = no_hp;
    }

    public String getIdAnggota() {
        return id_anggota;
    }

    public void setIdAnggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNohp() {
        return no_hp;
    }

    public void setNohp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String toString(){
        return this.id_anggota + "  -  " + nama;
    }
    String id_anggota, nama, no_hp;
}
