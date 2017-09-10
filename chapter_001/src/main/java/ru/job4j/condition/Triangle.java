package ru.job4j.condition;

import sun.nio.cs.ext.MacHebrew;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean exists()
    {
        if (a.getX() + b.getX() )
    }

    public double distance(Point left, Point right)
    {
        return Math.sqrt(Math.pow(left.getX() - right.getX(), 2) + Math.pow(left.getY() - right.getY(), 2));
    }

    public double getArea(Triangle abc)
    {
        double ab = distance(abc.a, abc.b);
        double bc = distance(abc.b, abc.c);
        double ac = distance(abc.a, abc.c);

        if ((ab + bc > ac) && (ab + ac > bc) && (ac + bc > ab))
        {
            double pp = (ab + bc + ac) / 2;
            return Math.sqrt(pp * (pp-ab) * (pp-ac) * (pp-bc));
        }
        else
        {
            System.out.println("Такого треугольника не может быть");
            return 0;
        }
    }



}
