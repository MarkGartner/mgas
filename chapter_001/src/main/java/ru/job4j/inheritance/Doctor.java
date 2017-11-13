package ru.job4j.inheritance;

public class Doctor extends Person {

    public String heal(Person person) {
        return "Доктор " + this.getName() + " лечит пациента " + person.getName();
    }
}
