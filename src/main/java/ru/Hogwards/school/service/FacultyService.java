package ru.Hogwards.school.service;

import ru.Hogwards.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty create(Faculty faculty);

    Faculty read(long id);

    Faculty update(Faculty faculty);

    Faculty delete(long id);

    Collection<Faculty> readByAge(String color);
}
