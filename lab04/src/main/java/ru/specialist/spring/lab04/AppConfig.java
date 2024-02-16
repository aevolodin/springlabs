package ru.specialist.spring.lab04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    private final String DEFAULT_COLOR = "White";
    @Autowired
    private Environment environment;

    @Bean
    @Lazy
    public Coords pointCoords() {
        Integer x = environment.getProperty("point.x", Integer.class, 0);
        Integer y = environment.getProperty("point.y", Integer.class, 0);
        return new Coords(x, y);
    }

    @Bean
    @Lazy
    public Coords circleCenter() {
        Integer x = environment.getProperty("circle.x", Integer.class, 0);
        Integer y = environment.getProperty("circle.y", Integer.class, 0);
        return new Coords(x, y);
    }

    @Bean
    @Lazy
    public int circleRadius() {
        return environment.getProperty("circle.radius", Integer.class, 0);
    }

    @Bean
    @Lazy
    public String pointColor() {
        return environment.getProperty("point.color", String.class, DEFAULT_COLOR);
    }

    @Bean
    @Lazy
    public String circleColor() {
        return environment.getProperty("circle.color", String.class, DEFAULT_COLOR);
    }

    @Bean
    @Lazy
    public Point point() {
        return new Point(pointColor(), pointCoords());
    }

    @Bean
    @Lazy
    public Circle circle() {
        return new Circle(circleColor(), circleCenter(), circleRadius());
    }

    @Bean
    @Lazy
    public Scene scene() {
        var shapes = new ArrayList<Shape>();
        shapes.add(point());
        shapes.add(circle());
        return new Scene(shapes);
    }
}
