package com.compatibility.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compatibility")
public class Compatibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sign1;

    @Column(nullable = false)
    private String sign2;

    @Column(nullable = false)
    private String compatibilityMessage;

    // Constructors
    public Compatibility() {}

    public Compatibility(String sign1, String sign2, String compatibilityMessage) {
        this.sign1 = sign1;
        this.sign2 = sign2;
        this.compatibilityMessage = compatibilityMessage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSign1() {
        return sign1;
    }

    public void setSign1(String sign1) {
        this.sign1 = sign1;
    }

    public String getSign2() {
        return sign2;
    }

    public void setSign2(String sign2) {
        this.sign2 = sign2;
    }

    public String getCompatibilityMessage() {
        return compatibilityMessage;
    }

    public void setCompatibilityMessage(String compatibilityMessage) {
        this.compatibilityMessage = compatibilityMessage;
    }
}