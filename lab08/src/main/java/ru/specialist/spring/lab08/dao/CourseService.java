package ru.specialist.spring.lab08.dao;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course findById(int id);

    Course save(Course course);

    void delete(int id);

}
