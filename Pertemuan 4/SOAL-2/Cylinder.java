//********************************************************************
// Cylinder.java
//
// Represents a cylinder shape.
//********************************************************************
public class Cylinder extends Shape {
    private double radius;
    private double height;

    // -----------------------------------------------------------------
    // Constructor: Sets up the cylinder with given radius and height.
    // -----------------------------------------------------------------
    public Cylinder(double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }

    // -----------------------------------------------------------------
    // Returns the surface area of the cylinder (PI * radius^2 * height).
    // -----------------------------------------------------------------
    public double area() {
        return Math.PI * radius * radius * height;
    }

    // -----------------------------------------------------------------
    // Returns the cylinder as a String.
    // -----------------------------------------------------------------
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}