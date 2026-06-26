/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements User {
    private String username;
    private String password;
    private double saldo = 1000000.0;
    private HashMap<String, Lowongan> daftarLowongan = new HashMap<>();
    private ArrayList<Freelance> hiredFreelancers = new ArrayList<>();
    private ArrayList<Lowongan> lowonganDihire = new ArrayList<>();

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void lihatPengumuman(Pengumuman pengumuman) {
        System.out.println(pengumuman);
    }

    public void tambahLowongan(String judul, String deskripsi, int harga) {
        // Generate ID secara otomatis menggunakan UUID
        String id = java.util.UUID.randomUUID().toString();
        Lowongan lowongan = new Lowongan(judul, deskripsi, username, harga);
        daftarLowongan.put(id, lowongan);
        System.out.println("Lowongan berhasil ditambahkan dengan ID: " + id);
}


    public void melihatLowongan() {
        if (daftarLowongan.isEmpty()) {
            System.out.println("Belum ada lowongan yang dibuat.");
        } else {
            System.out.println("Daftar Lowongan:");
            for (String id : daftarLowongan.keySet()) {
                System.out.println("ID: " + id);
                System.out.println(daftarLowongan.get(id));
                System.out.println("");
            }
        }
    }

    public void viewFreelancerPortofolio(Freelance freelancer) {
        System.out.println(username + freelancer.getUsername());
        freelancer.viewPortofolio();  // Memanggil metode viewPortofolio milik freelancer
    }

    public void melihatDaftarFreelance(ArrayList<Freelance> freelancers) {
        System.out.println("Daftar Freelancer:");
        for (int i = 0; i < freelancers.size(); i++) {
            System.out.println((i + 1) + ". " + freelancers.get(i).getCv().getNama()
                    + "\nKeahlian : " + freelancers.get(i).getCv().getKeahlian()
                    + "\nPengalaman : " + freelancers.get(i).getCv().getPengalaman()
            );
            System.out.println("Portofolio:");
            freelancers.get(i).viewPortofolio();
            System.out.println("");
        }
    }

    public void hireFreelancer(ArrayList<Freelance> freelancers, Scanner scanner) {
        if (daftarLowongan.isEmpty()) {
            System.out.println("Anda harus memiliki setidaknya satu proyek untuk dapat hire freelancer.");
            return;
        }

        System.out.println("Daftar Freelancer:");
        for (int i = 0; i < freelancers.size(); i++) {
            System.out.println((i + 1) + ". " + freelancers.get(i).getCv().getNama());
        }

        System.out.print("Pilih freelancer (masukkan nomor): ");
        int pilihanFreelancer;
        while (true) {
            try {
                pilihanFreelancer = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka!");
                System.out.print("Pilih freelancer (masukkan nomor): ");
                scanner.nextLine();
            }
        }

        if (pilihanFreelancer < 1 || pilihanFreelancer > freelancers.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Freelance selectedFreelancer = freelancers.get(pilihanFreelancer - 1);

        System.out.println("Pilih proyek untuk freelancer ini:");
        for (String id : daftarLowongan.keySet()) {
            System.out.println("ID: " + id + " - " + daftarLowongan.get(id).getJudul());
        }

        System.out.print("Masukkan ID proyek: ");
        String idProyek = scanner.nextLine();

        if (!daftarLowongan.containsKey(idProyek)) {
            System.out.println("ID proyek tidak valid.");
            return;
        }

        Lowongan selectedLowongan = daftarLowongan.get(idProyek);
        hiredFreelancers.add(selectedFreelancer);
        lowonganDihire.add(selectedLowongan);

        selectedFreelancer.addHiredProject(selectedLowongan, this);
        System.out.println("Freelancer " + selectedFreelancer.getUsername() + " berhasil di-hire untuk proyek: " + selectedLowongan.getJudul());
    }

    public void melihatFreelancerHired() {
        if (hiredFreelancers.isEmpty()) {
            System.out.println("Belum ada freelancer yang di-hire.");
        } else {
            System.out.println("Daftar Freelancer yang di-hire:");
            for (int i = 0; i < hiredFreelancers.size(); i++) {
                Freelance freelancer = hiredFreelancers.get(i);
                Lowongan proyek = lowonganDihire.get(i);
                System.out.println((i + 1) + ". " + freelancer.getCv().getNama() + " untuk proyek: " + proyek.getJudul());
            }
        }
    }
}


