package ru.specialist.spring.lab02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring-lab02
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Scene scene = context.getBean("sceneBean", Scene.class);
        scene.draw();

        context.close();
    }
}
