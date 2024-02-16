package ru.specialist.spring.lab05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.specialist.spring.lab05.dao.Course;
import ru.specialist.spring.lab05.dao.CourseDAO;

public class App {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DaoConfig.class)) {
            CourseDAO courseDao = context.getBean(CourseDAO.class);

            Course newCourse = new Course();
            newCourse.setTitle("Spring");
            newCourse.setLength(40);
            newCourse.setDescription("Spring framework");

            System.out.println(newCourse); // id == 0
            courseDao.insert(newCourse);
            System.out.println(newCourse); // id == ???

            Course oldCourse = courseDao.findById(newCourse.getId());
            oldCourse.setLength(42);
            courseDao.update(oldCourse);

            courseDao.delete(newCourse.getId());

//            for (Course c : courseDao.findByTitle("web"))
//                System.out.println(c);

            for (Course c : courseDao.findAll())
                System.out.println(c);
        }
    }
}
