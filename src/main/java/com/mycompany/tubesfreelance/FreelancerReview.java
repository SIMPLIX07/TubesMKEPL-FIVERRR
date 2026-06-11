/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesfreelance;

/**
 *
 * @author sxpix
 */
public class FreelancerReview extends ReviewSystem {
    private String clientName;

    public FreelancerReview(int rating, String review, String clientName) {
        super(rating, review);
        this.clientName = clientName;
    }

    public void displayReview() {
        System.out.println("Review dari Freelancer untuk Klien: " + clientName);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Ulasan: " + review);
    }

    public String getClientName() {
        return clientName;
    }
}
