package ru.Hogwards.school.service;

import ru.Hogwards.school.Exception.AlreadyExistsException;
import ru.Hogwards.school.Exception.NotFoundException;
import ru.Hogwards.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FacultyServiceImpl implements FacultyService {

    private final Map<Long, Faculty> repository = new HashMap<>();

    private Long idCounter = 0L;
    @Override
    public Faculty create(Faculty faculty) {
        if (repository.containsValue(faculty)) {
            throw new AlreadyExistsException
                    ("Факультет " + faculty + " уже есть в списке");
        }

        long id = ++idCounter;
        faculty.setId(id);

        return repository.put(id, faculty);
    }
    @Override
    public Faculty read(long id) {
        Faculty faculty = repository.get(id);

        if (faculty == null) {
            throw new NotFoundException
                    ("Факультета с id " + faculty + " не найдено в списке");
        }
        return faculty;
    }
    @Override
    public Faculty update(Faculty faculty) {
        if (!repository.containsKey(faculty.getId())) {
            throw new NotFoundException
                    ("Факультета с id " + faculty + " не найдено в списке");
        }
        return repository.put(faculty.getId(), faculty);
    }
    @Override
    public Faculty delete(long id) {
        Faculty faculty = repository.remove(id);
        if (faculty == null) {
            throw new NotFoundException
                    ("Факультета с id " + faculty + " не найдено в списке");
        }
        return faculty;
    }

    @Override
    public Collection<Faculty> readByAge(String color) {
        return repository.values().stream()
                .filter(s -> s.getColor() == color)
                .toList();
    }
}