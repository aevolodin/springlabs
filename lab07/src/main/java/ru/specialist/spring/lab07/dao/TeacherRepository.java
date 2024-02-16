package ru.specialist.spring.lab07.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer>, TeacherRepositoryCustomized<TeacherEntity> {
    Optional<TeacherEntity> findById(int id);
}
