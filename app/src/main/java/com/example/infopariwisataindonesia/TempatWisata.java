package com.example.infopariwisataindonesia;

import java.io.Serializable;

public class TempatWisata implements Serializable {

    private String nama;
    private String deskripsiSingkat;
    private double rating;
    private int imageUrl;
    private String deskripsiPanjang;
    private String waktuTerbaik;
    private String alamat;
    private String nomorTelepon;
    private String mapUrl;

    public TempatWisata(String nama, String deskripsiSingkat, double rating, int imageUrl, String deskripsiPanjang, String waktuTerbaik, String alamat, String nomorTelepon, String mapUrl) {
        this.nama = nama;
        this.deskripsiSingkat = deskripsiSingkat;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.deskripsiPanjang = deskripsiPanjang;
        this.waktuTerbaik = waktuTerbaik;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.mapUrl = mapUrl;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsiSingkat() {
        return deskripsiSingkat;
    }

    public double getRating() {
        return rating;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getDeskripsiPanjang() {
        return deskripsiPanjang;
    }

    public String getWaktuTerbaik() {
        return waktuTerbaik;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getMapUrl() {
        return mapUrl;
    }
}