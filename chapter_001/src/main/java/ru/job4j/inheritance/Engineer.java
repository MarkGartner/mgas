package ru.job4j.inheritance;

public class Engineer extends Person {

    String build(Person person) {
        return "Инженер" + this.name + "по заказу клиента " + person.name + "собрал макет объекта.";
    }
}
