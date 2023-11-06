package ru.Hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Hogwards.school.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findAllByColor(String color);

    Collection<Faculty> findAllByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

}
