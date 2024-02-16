package ru.specialist.spring.lab07.dao;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public int getCountByName(String name) {
        return teacherRepository.getCountByName(name);
    }

    @Override
    public List<TeacherEntity> getAll() {
        return Streamable.of(teacherRepository.findAll()).toList();
    }

    @Override
    public Optional<TeacherEntity> getById(int id) {
        return teacherRepository.findById(id);
    }
}
