package ru.specialist.spring.lab03;

public abstract class Shape {
    private String color;

    public abstract void draw();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
