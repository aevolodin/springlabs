package ru.specialist.spring.lab07.dao;

public interface TeacherRepositoryCustomized<T> {
    /*
     * Количество учителей
     */
    int getCountByName(String name);
}
