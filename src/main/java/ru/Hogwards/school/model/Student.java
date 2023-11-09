package ru.Hogwards.school.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.Objects;
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
    public Student() {

    }

    public Student(Long id, String name, int age) {
        this.id = id;
        Name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(Name, student.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash( Name, age);
    }

    public Student(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Faculty getFaculty() {
        return faculty;

    }
}
