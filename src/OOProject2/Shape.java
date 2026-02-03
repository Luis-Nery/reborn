package OOProject2;

public abstract class Shape {
    abstract double calculateArea();

    abstract double calculatePerimeter();

    public void display() {
        System.out.println("The area is " + calculateArea() + " and the Perimeter is " + calculatePerimeter());
    }
}
