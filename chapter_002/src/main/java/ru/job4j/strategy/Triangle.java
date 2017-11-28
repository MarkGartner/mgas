package ru.job4j.strategy;

public class Triangle implements Shape {
    public String draw() {

        StringBuilder pic = new StringBuilder();

        pic.append("  +  \n");
        pic.append(" +++ \n");
        pic.append("+++++");

        return pic.toString();
    }
}
