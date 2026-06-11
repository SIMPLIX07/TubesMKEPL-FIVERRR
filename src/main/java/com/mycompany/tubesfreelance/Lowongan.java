/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

import java.util.ArrayList;

/**00000
 *
 * @author rezai
 */
public class Lowongan {
    private String judul;
    private String deskripsi;
    private String client;
    private int harga;
//    private ArrayList<Freelance> freelancersMelamar;

    public Lowongan(String judul, String deskripsi, String client, int harga) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.client = client;
        this.harga = harga;
//        this.freelancersMelamar = new ArrayList<>();
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getClient() {
        return client;
    }

    public int getHarga() {
        return harga;
    }
    
//    public void addFreelancerMelamar(Freelance freelancer) {
//        freelancersMelamar.add(freelancer);
//    }
//    
//    public ArrayList<Freelance> getFreelancersMelamar() {
//        return freelancersMelamar;
//    }

    @Override
    public String toString() {
        return "Lowongan: " + judul + "\nDeskripsi: " + deskripsi + "\nBudget: Rp " + harga + "\nDibuat oleh: " + client;
    }
}
