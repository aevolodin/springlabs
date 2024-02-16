package ru.specialist.spring.lab01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.specialist.spring.lab01");

        System.out.println(Person.getCount()); // Person создается при инициализации контекста

        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);

        System.out.println(Person.getCount()); // Person создается один раз
    }
}
