package com.mycompany.tubesfreelance;

import java.util.ArrayList;

/**
 * Class Admin untuk mengelola pengguna dan pengumuman.
 */
public class Admin implements User {
    private String Id;
    private String username;
    private String password;
    private ArrayList<String> UserBan = new ArrayList<>();
    private ArrayList<Freelance> freelancers = new ArrayList<>();
    private Pengumuman pengumuman = new Pengumuman(); // Pengumuman sebagai atribut admin

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin(String Id) {
        this.Id = Id;
    }

    // Membuat pengumuman baru
    public void buatPengumuman(String isi) {
        pengumuman.setIsiPengumuman(isi);
        System.out.println("Pengumuman berhasil dibuat!");
    }

    // Mengubah pengumuman yang ada
    public void ubahPengumuman(String isiBaru) {
        pengumuman.setIsiPengumuman(isiBaru);
        System.out.println("Pengumuman berhasil diubah!");
    }

    // Menampilkan pengumuman
    public void tampilkanPengumuman() {
        System.out.println(pengumuman);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void laporkanPelanggar(String pelanggar) {
        UserBan.add(pelanggar); // Menambahkan nama pelanggar ke dalam array UserBan
        System.out.println("Freelancer " + pelanggar + " berhasil dilaporkan.");
    }

    public ArrayList<String> getUserBan() {
        return UserBan;
    }

    public void deleteAkunFreelancer(String username) {
        for (int i = 0; i < freelancers.size(); i++) {
            Freelance freelancer = freelancers.get(i);
            if (freelancer.getUsername().equals(username)) {
                freelancer.ban();
                freelancers.remove(i);
                System.out.println("Akun freelancer " + username + " telah dibanned dan dihapus.");
                return;
            }
        }
        System.out.println("Freelancer dengan username " + username + " tidak ditemukan.");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
