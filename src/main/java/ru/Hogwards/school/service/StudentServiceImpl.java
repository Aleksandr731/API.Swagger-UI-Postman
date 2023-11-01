package ru.Hogwards.school.service;

import org.springframework.stereotype.Service;
import ru.Hogwards.school.Exception.StudentAlreadyExistsException;
import ru.Hogwards.school.Exception.StudentNotFoundException;
import ru.Hogwards.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> repository = new HashMap<>();

    private Long idCounter = 0L;
@Override
    public Student create(Student student) {
        if (repository.containsValue(student)) {
            throw new StudentAlreadyExistsException
                    ("Студент " + student + " уже есть в списке");
        }

        long id = ++idCounter;
        student.setId(id);

        return repository.put(id, student);
    }
@Override
    public Student read(long id) {
        Student student = repository.get(id);

        if (student == null) {
            throw new StudentNotFoundException
                    ("Студент с id " + student + " не найдено в списке");
        }
        return student;
    }
@Override
    public Student update(Student student) {
        if (!repository.containsKey(student.getId())) {
            throw new StudentNotFoundException
                    ("Студент с id " + student + " не найдено в списке");
        }
        return repository.put(student.getId(), student);
    }
@Override
    public Student delete(long id) {
        Student student = repository.remove(id);
        if (student == null) {
            throw new StudentNotFoundException
                    ("Студент с id " + student + " не найдено в списке");
        }
        return student;
    }

    @Override
    public Collection<Student> readByAge(int age) {
        return repository.values().stream()
                .filter(s -> s.getAge() == age)
                .toList();
    }
}
