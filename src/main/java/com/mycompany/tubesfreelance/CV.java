/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

/**
 *
 * @author rezai
 */
public class CV {
    private String nama;
    private String keahlian;
    private int pengalaman;

    public CV(String nama, String keahlian, int pengalaman) {
        this.nama = nama;
        this.keahlian = keahlian;
        this.pengalaman = pengalaman;
    }

    public void tampilkanCV() {
        System.out.println("Nama: " + nama);
        System.out.println("Keahlian: " + keahlian);
        System.out.println("Pengalaman: " + pengalaman + " tahun");
    }

    public String getNama() {
        return nama;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public int getPengalaman() {
        return pengalaman;
    }

    @Override
    public String toString() {
        return "CV{" + "nama=" + nama + ", keahlian=" + keahlian + ", pengalaman=" + pengalaman + '}';
    }
}
