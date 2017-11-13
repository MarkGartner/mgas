package ru.job4j.inheritance;

public class Teacher extends Person {

    int classes;

    public String teaches(Person person) {
        return "Преподаватель " + this.getName() + " учит " + person.name;
    }
}
