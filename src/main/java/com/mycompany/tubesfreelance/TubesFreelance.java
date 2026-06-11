package com.mycompany.tubesfreelance;

import java.util.ArrayList;
import java.util.Scanner;

public class TubesFreelance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Freelance> freelancers = new ArrayList<>();
        ArrayList<Lowongan> semuaLowongan = new ArrayList<>();
        ArrayList<Pembayaran> pembayaranList = new ArrayList<>();
        ArrayList<ClientReview> clientReviews = new ArrayList<>();
        ArrayList<FreelancerReview> freelancerReviews = new ArrayList<>();
        Admin admin = new Admin("admin123", "admin123");
        Forum forum = new Forum();

        while (true) {
            System.out.println("\n========== Sistem Freelance ==========");
            System.out.println("1. Register Client");
            System.out.println("2. Register Freelancer");
            System.out.println("3. Login Client");
            System.out.println("4. Login Freelancer");
            System.out.println("5. Login Admin");
            System.out.println("6. Exit");
            System.out.println("=====================================");
            int pilihan = readInt(scanner, "Pilih menu: ");

            if (pilihan == 1) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                clients.add(new Client(username, password));
                System.out.println("Client berhasil didaftarkan!");

            } else if (pilihan == 2) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                
                System.out.print("Masukkan keahlian: ");
                String keahlian = scanner.nextLine();
                
                int pengalaman = readInt(scanner, "Masukkan pengalaman (tahun): ");
                CV cv = new CV(nama, keahlian, pengalaman);
                freelancers.add(new Freelance(username, password, cv));
                System.out.println("Freelancer berhasil didaftarkan!");

            } else if (pilihan == 3) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                Client loggedInClient = null;
                for (Client client : clients) {
                    if (client.getUsername().equals(username) && client.checkPassword(password)) {
                        loggedInClient = client;
                        break;
                    }
                }

                if (loggedInClient != null) {
                    System.out.println("Login berhasil!");
                    while (true) {
                        System.out.println("\n========= Menu Client ==========");
                        System.out.println("1. Tambah Lowongan");
                        System.out.println("2. Lihat Lowongan");
                        System.out.println("3. Daftar Freelancer");
                        System.out.println("4. Hire Freelancer");
                        System.out.println("5. Melihat daftar Freelance yang di-hire");
                        System.out.println("6. Melaporkan Freelancer");
                        System.out.println("7. Proses Pembayaran");
                        System.out.println("8. Berikan Review");
                        System.out.println("9. Lihat Review");
                        System.out.println("10. Lihat Pengumuman");
                        System.out.println("11. Logout");
                        System.out.println("===================================");
                        int menuClient = readInt(scanner, "Pilih menu: ");

                        if (menuClient == 1) {
                            System.out.print("Masukkan judul lowongan: ");
                            String judul = scanner.nextLine();
                            System.out.print("Masukkan deskripsi lowongan: ");
                            String deskripsi = scanner.nextLine();
                            int harga = readInt(scanner, "Masukkan budget/harga lowongan: ");
                            loggedInClient.tambahLowongan(judul, deskripsi, harga);
                            semuaLowongan.add(new Lowongan(judul, deskripsi, loggedInClient.getUsername(), harga));
                        } else if (menuClient == 2) {
                            loggedInClient.melihatLowongan();
                        } else if (menuClient == 3) {
                            loggedInClient.melihatDaftarFreelance(freelancers);
                        } else if (menuClient == 4) {
                            loggedInClient.hireFreelancer(freelancers, scanner);
                        } else if (menuClient == 5) {
                            loggedInClient.melihatFreelancerHired();
                        } else if (menuClient == 6) {
                            System.out.print("Masukkan nama pelanggar: ");
                            String pelanggar = scanner.nextLine();
                            admin.laporkanPelanggar(pelanggar);
                        } else if (menuClient == 7) {
                            System.out.print("Masukkan username freelancer: ");
                            String usernameFreelancer = scanner.nextLine();
                            double jumlahBayar = readDouble(scanner, "Masukkan jumlah pembayaran: ");
                            Freelance freelancerToPay = null;
                            for (Freelance freelancer : freelancers) {
                                if (freelancer.getUsername().equals(usernameFreelancer)) {
                                    freelancerToPay = freelancer;
                                    break;
                                }
                            }
                            if (freelancerToPay != null) {
                                Pembayaran pembayaran = new Pembayaran(loggedInClient, freelancerToPay, jumlahBayar);
                                pembayaran.prosesPembayaran(scanner);
                            } else {
                                System.out.println("Freelancer tidak ditemukan.");
                            }
                        } else if (menuClient == 8) {
                            System.out.print("Masukkan username freelancer: ");
                            String usernameFreelancer = scanner.nextLine();
                            int rating = readInt(scanner, "Masukkan rating (1-5): ");
                            System.out.print("Masukkan ulasan: ");
                            String ulasan = scanner.nextLine();
                            clientReviews.add(new ClientReview(rating, ulasan, usernameFreelancer));
                        } else if (menuClient == 9) {
                            for (ClientReview review : clientReviews) {
                                review.displayReview();
                            }
                        } else if (menuClient == 10) {
                            admin.tampilkanPengumuman();
                        } else if (menuClient == 11) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Username atau password salah.");
                }

            } else if (pilihan == 4) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                Freelance loggedInFreelancer = null;
                for (Freelance freelancer : freelancers) {
                    if (freelancer.getUsername().equals(username) && freelancer.checkPassword(password)) {
                        loggedInFreelancer = freelancer;
                        break;
                    }
                }

                if (loggedInFreelancer != null) {
                    System.out.println("Login berhasil!");
                    while (true) {
                        System.out.println("\n========== Menu Freelancer ==========");
                        System.out.println("1. Lihat Lowongan");
                        System.out.println("2. Lamar Lowongan");
                        System.out.println("3. Lihat Lowongan Dilamar");
                        System.out.println("4. Lihat Projek Hire");
                        System.out.println("5. Tambahkan Percakapan");
                        System.out.println("6. Tampilkan Forum");
                        System.out.println("7. Cek Saldo");
                        System.out.println("8. Tambah Portofolio");
                        System.out.println("9. Lihat Portofolio");
                        System.out.println("10. Tandai Pekerjaan Selesai");
                        System.out.println("11. Berikan Review untuk Client");
                        System.out.println("12. Tampilkan Review");
                        System.out.println("13. Lihat Pengumuman");
                        System.out.println("14. Logout");
                        System.out.println("======================================");
                        int menuFreelancer = readInt(scanner, "Pilih menu: ");

                        if (menuFreelancer == 1) {
                            loggedInFreelancer.melihatLowongan(semuaLowongan);

                        } else if (menuFreelancer == 2) {
                            System.out.print("Masukkan judul lowongan yang ingin dilamar: ");
                            String judul = scanner.nextLine();

                            Lowongan lowonganDipilih = null;
                            for (Lowongan lowongan : semuaLowongan) {
                                if (lowongan.getJudul().equalsIgnoreCase(judul)) {
                                    lowonganDipilih = lowongan;
                                    break;
                                }
                            }
                            try {
                                if (lowonganDipilih == null) {
                                    throw new Exception("Lowongan tidak ditemukan.");
                                }
                                loggedInFreelancer.melamarLowongan(lowonganDipilih);
                                semuaLowongan.remove(lowonganDipilih);
                                System.out.println("Berhasil melamar lowongan.");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (menuFreelancer == 3) {
                            loggedInFreelancer.melihatLowonganDipilih();
                        } else if (menuFreelancer == 4) {
                            loggedInFreelancer.melihatProjekHire();
                        }else if (menuFreelancer == 5){
                            System.out.print("Dari :  ");
                            String dari = scanner.nextLine();
                            System.out.print("Pesan : ");
                            String pesan = scanner.nextLine();
                            forum.tambahPercakapan(dari, pesan);
                        }else if (menuFreelancer == 6){
                            forum.tampilkanPercakapan();
                        }else if (menuFreelancer == 7){
                            loggedInFreelancer.cekSaldo();
                        } else if (menuFreelancer == 8){
                            System.out.print("Masukan portofolio");
                            String project = scanner.nextLine();
                            loggedInFreelancer.addPortfolio(project);
                        } else if(menuFreelancer == 9){
                            loggedInFreelancer.viewPortofolio();
                        } else if(menuFreelancer == 10){
                            System.out.println("\n=== Tandai Pekerjaan Selesai ===");
                            System.out.print("Masukkan nama proyek yang selesai: ");
                            String namaProyek = scanner.nextLine();
                            loggedInFreelancer.tandaiPekerjaanSelesai(namaProyek);
                        } else if(menuFreelancer == 11){
                            System.out.print("Masukkan username klien: ");
                            String usernameClient = scanner.nextLine();
                            Client client = null;
                            for (Client c : clients) {
                                if (c.getUsername().equals(usernameClient)) {
                                client = c;
                                break;
                                }
                            }
                            if (client != null) {
                                int rating = readInt(scanner, "Masukkan rating (1-5): ");
                                System.out.print("Masukkan ulasan: ");
                                String reviewText = scanner.nextLine();

                                try {
                                    FreelancerReview review = new FreelancerReview(rating, reviewText, client.getUsername());
                                    freelancerReviews.add(review);
                                    System.out.println("Review berhasil ditambahkan!");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                System.out.println("Klien tidak ditemukan.");
                            }
                        } else if(menuFreelancer == 12){
                            System.out.println("Review dari Freelancer:");
                            for (FreelancerReview review : freelancerReviews) {
                                review.displayReview();
                                System.out.println();
                            }
                        }else if (menuFreelancer == 13) {
                            admin.tampilkanPengumuman();
                        } else if (menuFreelancer == 14) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Username atau password salah.");
                }

            } else if (pilihan == 5) { // Login Admin
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                    System.out.println("Login berhasil!");
                    while (true) {
                        System.out.println("\n========== Sistem Admin ==========");
                        System.out.println("1. Lihat Laporan");
                        System.out.println("2. Ubah Username");
                        System.out.println("3. Ubah Password");
                        System.out.println("4. Buat Pengumuman");
                        System.out.println("5. Ubah Pengumuman");
                        System.out.println("6. Exit");
                        System.out.println("===================================");
                        int menuAdmin = readInt(scanner, "Pilih menu: ");

                        if (menuAdmin == 1) {
                            System.out.println("\n=== Daftar Pelanggar ===");
                            if (admin.getUserBan().isEmpty()) {
                            System.out.println("Tidak ada pelanggar yang dilaporkan.");
                            } else {
                                for (String pelanggar : admin.getUserBan()) {
                                    System.out.println(pelanggar);
                                }
                            }
                            System.out.println("Ingin melakukan Ban?: Y/N");
                            String banning = scanner.nextLine();

                            if (banning.equalsIgnoreCase("Y")) {
                                System.out.println("Masukkan nama Freelancer yang ingin Anda ban: ");
                                String freelancerNama = scanner.nextLine();
                                boolean found = false;
                                for (Freelance f : freelancers) {
                                    if (f.getCv().getNama().equalsIgnoreCase(freelancerNama)) { // Cek berdasarkan nama
                                        f.ban();
                                        freelancers.remove(f);
                                        System.out.println("Freelancer dengan nama " + freelancerNama + " telah dibanned dan dihapus.");
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Freelancer dengan nama " + freelancerNama + " tidak ditemukan.");
                                }
                            } else if (banning.equalsIgnoreCase("N")) {
                                System.out.println("Kembali ke menu admin...");
                                continue; // Kembali ke awal menu admin
                            }
                        } else if (menuAdmin == 2) {
                            System.out.print("Masukan Username Baru: ");
                            String usernameAdmin = scanner.nextLine();
                            admin.setUsername(usernameAdmin);
                            System.out.println("Username berhasil diubah");
                        } else if (menuAdmin == 3) {
                            System.out.print("Masukan Password Baru: ");
                            String usernamePassword = scanner.nextLine();
                            admin.setPassword(usernamePassword);
                        } else if (menuAdmin == 4) {
                            System.out.print("Masukkan pengumuman baru: ");
                            String pengumuman = scanner.nextLine();
                            admin.buatPengumuman(pengumuman);
                        } else if (menuAdmin == 5) {
                            System.out.print("Masukkan pengumuman yang baru: ");
                            String pengumumanBaru = scanner.nextLine();
                            admin.ubahPengumuman(pengumumanBaru);
                        } else if(menuAdmin == 6){
                            break;
                        }
                    }
                }
            } else if (pilihan == 6) {
                System.out.println("Terima kasih telah menggunakan sistem ini!");
                break;
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = scanner.nextInt();
                scanner.nextLine();
                return val;
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka!");
                scanner.nextLine();
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = scanner.nextDouble();
                scanner.nextLine();
                return val;
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka!");
                scanner.nextLine();
            }
        }
    }
}
