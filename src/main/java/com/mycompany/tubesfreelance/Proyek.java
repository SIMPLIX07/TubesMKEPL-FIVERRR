/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

/**
 *
 * @author afniazk
 */
public class Proyek {
        private String namaProyek;
        private boolean statusSelesai;

        public Proyek(String namaProyek, boolean statusSelesai) {
            this.namaProyek = namaProyek;
            this.statusSelesai = statusSelesai;
        }

        public String getNamaProyek() {
            return namaProyek;
        }

        public boolean isStatusSelesai() {
            return statusSelesai;
        }

        public void setStatusSelesai(boolean statusSelesai) {
            this.statusSelesai = statusSelesai;
        }
}
