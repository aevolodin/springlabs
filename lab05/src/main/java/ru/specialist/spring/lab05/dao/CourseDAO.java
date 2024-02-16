package ru.specialist.spring.lab05.dao;

import java.util.List;

// interface Repository
public interface CourseDAO {
    Course findById(int id);

    List<Course> findAll();

    List<Course> findByTitle(String title);

    // CRUD
    void insert(Course course);

    void update(Course course);

    void delete(int id);
}
