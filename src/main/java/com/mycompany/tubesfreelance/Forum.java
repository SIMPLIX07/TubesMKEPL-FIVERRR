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
public class Forum {
    private ArrayList<String> percakapan;
    private ArrayList<String> from;

    // Konstruktor untuk menginisialisasi ArrayList
     public Forum() {
        percakapan = new ArrayList<>();
        from = new ArrayList<>();
    }

    public ArrayList<String> getPercakapan(){
            return percakapan;
    }
   
    public void setPercakapan(ArrayList<String> percakapan) {
        this.percakapan = percakapan;
    }

    public ArrayList<String> getFrom() {
        return from;
    }

    public void setFrom(ArrayList<String> from) {
        this.from = from;
    }

    public void tambahPercakapan(String dari, String pesan) {
        // pesan tidak boleh kosong
        if (pesan != null && !pesan.trim().isEmpty()) {
            percakapan.add(pesan);
            from.add(dari);
            System.out.println("Pesan berhasil ditambahkan: " + pesan);
        } else {
            System.out.println("Pesan tidak valid. Tidak ada yang ditambahkan.");
        }
    }

    public void tampilkanPercakapan() {
        System.out.println("Daftar Percakapan:");
         // Looping berdasarkan ukuran ArrayList percakapan
        for (int i = 0; i < percakapan.size(); i++) {
            System.out.println(from.get(i) + ": " + percakapan.get(i));
        }
    }
}
    

