package ru.Hogwards.school.Exception;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String messange) {
        super(messange);

    }
}
