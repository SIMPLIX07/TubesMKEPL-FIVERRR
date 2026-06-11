
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

import java.util.Scanner;
/**
 *
 * @author sxpix
 */
public abstract class ReviewSystem {
    protected int rating;
    protected String review;

    public ReviewSystem(int rating, String ulasan) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating harus antara 1-5.");
        }
        this.rating = rating;
        this.review = ulasan != null ? ulasan : "Tidak ada ulasan.";
    }

    public int getRating() {
        return rating;
    }

    public String getUlasan() {
        return review;
    }

    @Override
    public String toString() {
        return "Ulasan: " + this.review + " dengan rating: " + this.rating + "/5.";
    }
}
