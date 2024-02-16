package ru.specialist.spring.lab07.dao;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    /*
     * Количество учителей
     */
    int getCountByName(String name);

    /*
     * Все учителя
     */
    List<TeacherEntity> getAll();

    /*
     * Все учителя по ИД
     */
    Optional<TeacherEntity> getById(int id);
}
