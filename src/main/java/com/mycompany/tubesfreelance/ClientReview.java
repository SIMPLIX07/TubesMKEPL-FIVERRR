/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

/**
 *
 * @author sxpix
 */
    public class ClientReview extends ReviewSystem {
    private String freelancerName;

    public ClientReview(int rating, String review, String freelancerName) {
        super(rating, review);
        this.freelancerName = freelancerName;
    }

    public void displayReview() {
        System.out.println("Review dari Klien untuk Freelancer: " + freelancerName);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Ulasan: " + review);
    }

    public String getFreelancerName() {
        return freelancerName;
    }
}
