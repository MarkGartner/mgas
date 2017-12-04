package ru.job4j.start;

public abstract class BaseAction implements UserAction {

     String name;
     int key;
    public BaseAction(String name, int key) {
        this.key = key;
        this.name = name;
    }

    public String info() {
        return String.format("%s. %s.", this.key(), this.name);
    }
}
