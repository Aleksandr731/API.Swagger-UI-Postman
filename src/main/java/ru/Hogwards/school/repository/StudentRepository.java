package ru.Hogwards.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Hogwards.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findAllByAge(int age);

    Collection<Student> findByAgeBetween(int minAge, int maxAge);

    Collection<Student> findByFaculty_id(long facultyId);
}
