package ru.specialist.spring.lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Point extends Shape {
    private Coords coords;

    @Autowired
    public Point(Coords coords) {
        this.coords = coords;
    }

    @Override
    @Value("${point.color}")
    public void setColor(String color) {
        super.setColor(color);
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public int getX() {
        return getCoords().getX();
    }

    @Value("${point.x}")
    public void setX(int x) {
        getCoords().setX(x);
    }

    public int getY() {
        return getCoords().getY();
    }

    @Value("${point.y}")
    public void setY(int y) {
        getCoords().setY(y);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Draw Point: color - %s, coordinates - %d, %d", getColor(), getX(), getY()));
    }
}
