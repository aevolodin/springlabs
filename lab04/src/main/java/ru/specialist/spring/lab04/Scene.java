package ru.specialist.spring.lab04;

import java.util.Collection;

public class Scene {
    private Collection<Shape> shapes;

    public Scene(Collection<Shape> shapes) {
        this.shapes = shapes;
    }

    public Collection<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(Collection<Shape> shapes) {
        this.shapes = shapes;
    }

    public void draw() {
        for (Shape shape : getShapes()) {
            shape.draw();
        }
    }
}
