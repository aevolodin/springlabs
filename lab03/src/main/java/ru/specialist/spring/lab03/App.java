package ru.specialist.spring.lab03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * lab03
 */
@ComponentScan("ru.specialist.spring.lab03")
@PropertySource("application.properties")
public class App {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App.class)) {
            context.getBean(Scene.class).draw();
        }
    }
}
