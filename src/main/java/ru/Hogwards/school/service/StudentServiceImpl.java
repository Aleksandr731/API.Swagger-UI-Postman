package ru.Hogwards.school.service;

import org.springframework.stereotype.Service;
import ru.Hogwards.school.Exception.AlreadyExistsException;
import ru.Hogwards.school.Exception.NotFoundException;
import ru.Hogwards.school.model.Student;
import ru.Hogwards.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student create(Student student) {
        return  repository.save(student);
    }

@Override
    public Student read(long id) {
        return repository.findById(id)
                .orElseThrow(()-> new NotFoundException
                ("Студент с id " + id + " не найдено в списке"));
    }
@Override
        public Student update(Student student) {
        read(student.getId());
        return repository.save(student);
    }
@Override
    public Student delete(long id) {
        Student student = read(id);
        repository.delete(student);
        return student;
    }

    @Override
    public Collection<Student> readByAge(int age) {
        return repository.findAllByAge(age);
    }
}
