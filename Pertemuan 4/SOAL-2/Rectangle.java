//********************************************************************
// Rectangle.java
//
// Represents a rectangle shape.
//********************************************************************
public class Rectangle extends Shape {
    private double length;
    private double width;

    // -----------------------------------------------------------------
    // Constructor: Sets up the rectangle with given length and width.
    // -----------------------------------------------------------------
    public Rectangle(double l, double w) {
        super("Rectangle");
        length = l;
        width = w;
    }

    // -----------------------------------------------------------------
    // Returns the area of the rectangle (length x width).
    // -----------------------------------------------------------------
    public double area() {
        return length * width;
    }

    // -----------------------------------------------------------------
    // Returns the rectangle as a String.
    // -----------------------------------------------------------------
    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}