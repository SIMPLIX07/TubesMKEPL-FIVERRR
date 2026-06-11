package com.mycompany.tubesfreelance;

import java.util.ArrayList;

public class Freelance implements User {
    private String username;
    private String password;
    private double saldo = 0.0;
    private ArrayList<Lowongan> lowonganDilamar = new ArrayList<>();
    private ArrayList<String> projekDihire = new ArrayList<>();
    private ArrayList<Proyek> proyekList = new ArrayList<>();  // Menyimpan proyek yang di-hire dan statusnya
    private Portofolio portofolio = new Portofolio();
    private CV cv;
    private boolean ban = false;

    public Freelance(String username, String password, CV cv) {
        this.username = username;
        this.password = password;
        this.cv = cv;
    }
    
     public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void cekSaldo() {
        System.out.println("Saldo Anda Rp" + getSaldo());
    }

    public boolean isBanned() {
        return ban;
    }

    public void ban() {
        this.ban = true;
    }

    public void unban() {
        this.ban = false;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public CV getCv() {
        return cv;
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
     public void lihatPengumuman(Pengumuman pengumuman) {
        System.out.println(pengumuman);
    }
    
    public void addPortfolio(String project) {
        portofolio.tambahProyek(project);
    }
    
    public void viewPortofolio() {
        portofolio.lihatProyek();
    }

    public void melamarLowongan(Lowongan lowongan) {
        lowonganDilamar.add(lowongan);
        System.out.println("Berhasil melamar lowongan: " + lowongan.getJudul());
    }

    public void melihatLowongan(ArrayList<Lowongan> semuaLowongan) {
        if (semuaLowongan.isEmpty()) {
            System.out.println("Tidak ada lowongan tersedia.");
        } else {
            System.out.println("Daftar Lowongan:");
            for (Lowongan lowongan : semuaLowongan) {
                System.out.println(lowongan);
            }
        }
    }

    public void melihatLowonganDipilih() {
        if (lowonganDilamar.isEmpty()) {
            System.out.println("Belum ada lowongan yang dilamar.");
        } else {
            System.out.println("Lowongan yang dilamar:");
            for (Lowongan lowongan : lowonganDilamar) {
                System.out.println(lowongan);
            }
        }
    }

    public void addHiredProject(Lowongan lowongan, Client client) {
        String projectDetail = "Proyek: " + lowongan.getJudul() + " dari client: " + client.getUsername();
        projekDihire.add(projectDetail);
        proyekList.add(new Proyek(lowongan.getJudul(), false));  // Tambahkan proyek ke dalam daftar proyek
    }

    public void melihatProjekHire() {
        if (projekDihire.isEmpty()) {
            System.out.println("Belum ada projek hire.");
        } else {
            System.out.println("Daftar Projek Hire:");
            for (String projek : projekDihire) {
                System.out.println(projek);
            }
        }
    }

    public void tandaiPekerjaanSelesai(String namaProyek) {
        boolean proyekDitemukan = false;

        for (Proyek proyek : proyekList) {
            if (proyek.getNamaProyek().equalsIgnoreCase(namaProyek) && !proyek.isStatusSelesai()) {
                proyek.setStatusSelesai(true);
                System.out.println("Proyek '" + namaProyek + "' telah berhasil ditandai selesai.");
                proyekDitemukan = true;
                break;
            }
        }

        if (!proyekDitemukan) {
            System.out.println("Proyek '" + namaProyek + "' tidak ditemukan atau sudah selesai.");
        }
    }

}
