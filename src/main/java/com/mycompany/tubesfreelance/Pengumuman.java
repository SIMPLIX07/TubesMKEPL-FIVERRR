/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

/**
 * Class Pengumuman untuk menyimpan pengumuman yang dibuat oleh admin.
 */
public class Pengumuman {
    private String isiPengumuman;

    public Pengumuman() {
        this.isiPengumuman = "Belum ada pengumuman saat ini.";
    }

    public String getIsiPengumuman() {
        return isiPengumuman;
    }

    public void setIsiPengumuman(String isiPengumuman) {
        this.isiPengumuman = isiPengumuman;
    }

    @Override
    public String toString() {
        return "Pengumuman: " + isiPengumuman;
    }
}
