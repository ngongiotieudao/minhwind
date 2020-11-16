/*
 * Cake.java
 * All Rights Reserved
 * Copyright (c) 2020 FPT University
 */
package entity;

import java.util.Date;

/**
 * Cake <br>
 * 
 * <pre>
 * 1. Define attributes of Digital object
 * 2. Create getter and setter
 * </pre>
 * 
 * @author nghialdnse05508
 * @version 1.0
 */
public class Cake {
    /** Store ID */
    private int id;
    /** Store name */
    private String name,picture,shortDescription,detailDescription;
    /** Store price */
    private float price;
    /** Store dateCreated */
    private Date dateCreated;

    /** 
     * Constructor <br>
     */
    public Cake() {
    }

    /** 
     * Constructor <br>
     * @param id
     * @param name
     * @param picture
     * @param shortDescription
     * @param detailDescription
     * @param price
     * @param dateCreated
     */
    public Cake(int id, String name, String picture, String shortDescription, String detailDescription, float price, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
        this.price = price;
        this.dateCreated = dateCreated;
    }
    
    /** 
     * Get id.<br>
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /** 
     * Set id.<br>
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * Get name.<br>
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** 
     * Set name.<br>
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Get picture.<br>
     * 
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /** 
     * Set picture.<br>
     * 
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /** 
     * Get shortDescription.<br>
     * 
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /** 
     * Set shortDescription.<br>
     * 
     * @param shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /** 
     * Get detailDescription.<br>
     * 
     * @return the detailDescription
     */
    public String getDetailDescription() {
        return detailDescription;
    }

    /** 
     * Set detailDescription.<br>
     * 
     * @param detailDescription
     */
    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    /** 
     * Get price.<br>
     * 
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /** 
     * Set price.<br>
     * 
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /** 
     * Get dateCreated.<br>
     * 
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /** 
     * Set dateCreated.<br>
     * 
     * @param dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    
}
