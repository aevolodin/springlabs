package ru.specialist.spring.lab07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.specialist.spring.lab07.dao.TeacherEntity;
import ru.specialist.spring.lab07.dao.TeacherService;

public class App {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DaoConfig.class)) {
            var teacherService = context.getBean("teacherService", TeacherService.class);

            var teacher = teacherService.getById(1);
            if (!teacher.isEmpty()) {
                System.out.println(teacher.get());
            }

            var count = teacherService.getCountByName("Иван");
            System.out.println(count);

            for (TeacherEntity entity : teacherService.getAll()) {
                System.out.println(entity);
            }
        }
    }
}
