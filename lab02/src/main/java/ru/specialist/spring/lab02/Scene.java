package ru.specialist.spring.lab02;

import java.util.Collection;

public class Scene {
    private static Scene instance;

    private Collection<Shape> object;

    private Scene() {
    }

    public static Scene getInstance() {
        if (instance == null) {
            synchronized (Scene.class) {
                if (instance == null) {
                    instance = new Scene();
                }
            }
        }
        return instance;
    }

    public Collection<Shape> getObject() {
        return object;
    }

    public void setObject(Collection<Shape> object) {
        this.object = object;
    }

    public void draw() {
        for (Shape shape : getObject()) {
            shape.draw();
        }
    }
}
