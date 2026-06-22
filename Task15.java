interface Shape {
    double calculateArea ();
    double calculatePerimeter ();
}

abstract class AbstractShape implements Shape {
    String color;
    double length;
    double width;

    AbstractShape (String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
    }

}

class Circle extends AbstractShape {
    
    double radius;

    Circle (String color, double diameter) {
        super (color, diameter, diameter);
        radius = diameter/2;
    }

    public double calculateArea () {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter () {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends AbstractShape {
    
    Rectangle (String color, double length, double width) {
        super (color, length, width);
    }

    public double calculateArea () {
        return length * width;
    }

    public double calculatePerimeter () {
        return (2 * length) + (2 * width);
    }
    
}

public class Task15 {

    public static void main (String [] args) {

        //Edit the attributes of the circle here.
        Circle circle = new Circle("Blue", 20);

        //Edit the attributes of the rectangle here.
        Rectangle rectangle = new Rectangle("Red", 3, 5);


        System.out.println(circle.color + " Circle");
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter " + circle.calculatePerimeter());

        System.out.println();

        System.out.println(rectangle.color + " Rectangle");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter " + rectangle.calculatePerimeter());
    }

}
