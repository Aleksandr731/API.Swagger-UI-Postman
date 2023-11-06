package ru.Hogwards.school.service;

import ru.Hogwards.school.Exception.AlreadyExistsException;
import ru.Hogwards.school.Exception.NotFoundException;
import ru.Hogwards.school.model.Faculty;
import ru.Hogwards.school.repository.FacultyRepository;

import java.util.Collection;

public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;

    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Faculty create(Faculty faculty) {
        return repository.save(faculty);
        }
    @Override
    public Faculty read(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException
                        ("Факультета с id " + id + " не найдено в списке"));

    }
    @Override
    public Faculty update(Faculty faculty) {
        read(faculty.getId());
        return repository.save(faculty);
    }
    @Override
    public Faculty delete(long id) {
        Faculty faculty = read(id);
        repository.delete(faculty);
        return  faculty;
    }

    @Override
    public Collection<Faculty> readByAge(String color) {
        return repository.findAllByColor(color);
    }
}