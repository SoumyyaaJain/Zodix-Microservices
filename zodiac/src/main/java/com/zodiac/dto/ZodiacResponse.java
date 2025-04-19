package com.zodiac.dto;

public class ZodiacResponse {

    private String sign;
    private String element;
    private String color;
    private String compatibleSign;

    // Constructors
    public ZodiacResponse() {}

    public ZodiacResponse(String sign, String element, String color, String compatibleSign) {
        this.sign = sign;
        this.element = element;
        this.color = color;
        this.compatibleSign = compatibleSign;
    }

    // Getters & Setters
    public String getSign() { return sign; }
    public void setSign(String sign) { this.sign = sign; }

    public String getElement() { return element; }
    public void setElement(String element) { this.element = element; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getCompatibleSign() { return compatibleSign; }
    public void setCompatibleSign(String compatibleSign) { this.compatibleSign = compatibleSign; }
}