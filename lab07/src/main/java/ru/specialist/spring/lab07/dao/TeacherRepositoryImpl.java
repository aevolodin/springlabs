package ru.specialist.spring.lab07.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigInteger;

public class TeacherRepositoryImpl implements TeacherRepositoryCustomized<TeacherEntity> {
    @PersistenceContext
    private EntityManager entityManager;

    private final String SQL_COUNT_BY_NAME = "select count(*) from public.teachers where name ilike :name";

    @Override
    public int getCountByName(String name) {
        var query = entityManager.createNativeQuery(SQL_COUNT_BY_NAME);
        query.setParameter("name", "%" + name + "%");
        return ((BigInteger) query.getSingleResult()).intValue();
    }
}
