package ru.specialist.spring.lab02;

public class Circle extends Shape {
    private Coords center;

    private int radius;

    public Circle(String color, Coords center, int radius) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    public Coords getCenter() {
        return center;
    }

    public void setCenter(Coords center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return getCenter().getX();
    }

    public void setX(int x) {
        getCenter().setX(x);
    }

    public int getY() {
        return getCenter().getY();
    }

    public void setY(int y) {
        getCenter().setY(y);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Draw Circle: color - %s, coordinates - %d, %d, radius - %d", getColor(), getX(), getY(), getRadius()));
    }
}
