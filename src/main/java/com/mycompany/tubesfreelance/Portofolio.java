/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

import java.util.ArrayList;

/**
 *
 * @author L E N O V O
 */
public class Portofolio {
    private ArrayList<String> daftarProyek;

    public Portofolio() {
        this.daftarProyek = new ArrayList<>();
    }
    
    public void tambahProyek(String proyek) {
        daftarProyek.add(proyek);
        System.out.println("Proyek \"" + proyek + "\" berhasil ditambahkan ke portofolio.");
    }

    public void lihatProyek() {
        if (daftarProyek.isEmpty()) {
            System.out.println("Belum ada proyek dalam portofolio.");
        } else {
            for (int i = 0; i < daftarProyek.size(); i++) {
                System.out.println("   " + (i + 1) + ". " + daftarProyek.get(i));
            }
        }
    }
}
