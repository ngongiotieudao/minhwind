/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kynhanht
 */
public class Information {
    private String shortDescription,address,tel,email,openingHours,signature;

    public Information() {
    }

    public Information(String shortDescrption, String address, String tel, String email, String openingHours, String signature) {
        this.shortDescription = shortDescrption;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.openingHours = openingHours;
        this.signature = signature;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescrption) {
        this.shortDescription = shortDescrption;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    
}
