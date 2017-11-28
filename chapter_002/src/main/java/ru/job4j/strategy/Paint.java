package ru.job4j.strategy;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {

        Shape triangle = new Triangle();
        Shape square = new Square();

        new Paint().draw(triangle);

        System.out.println();

        new Paint().draw(square);
    }

}
