package ru.specialist.spring.lab04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * lab04
 */
public class App {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            context.getBean(Scene.class).draw();
        }
    }
}
