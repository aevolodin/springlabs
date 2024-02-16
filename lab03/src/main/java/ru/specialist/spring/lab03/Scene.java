package ru.specialist.spring.lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Scene {
    private Collection<Shape> shapes;

    @Autowired
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
