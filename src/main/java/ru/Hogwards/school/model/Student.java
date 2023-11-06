package ru.Hogwards.school.model;

import java.util.Objects;

public class Student {

    private Long id;
    private String Name;
    private int age;

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
}
