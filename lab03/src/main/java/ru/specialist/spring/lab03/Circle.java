package ru.specialist.spring.lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle extends Shape {
    private Coords center;

    private int radius;

    @Autowired
    public Circle(Coords center) {
        this.center = center;
    }

    @Override
    @Value("${circle.color}")
    public void setColor(String color) {
        super.setColor(color);
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

    @Value("${circle.radius}")
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return getCenter().getX();
    }

    @Value("${circle.x}")
    public void setX(int x) {
        getCenter().setX(x);
    }

    public int getY() {
        return getCenter().getY();
    }

    @Value("${circle.y}")
    public void setY(int y) {
        getCenter().setY(y);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Draw Circle: color - %s, coordinates - %d, %d, radius - %d", getColor(), getX(), getY(), getRadius()));
    }
}
