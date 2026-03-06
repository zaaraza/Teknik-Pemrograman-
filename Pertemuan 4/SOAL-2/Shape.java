//********************************************************************
// Shape.java
//
// Abstract class representing a generic shape.
//********************************************************************
public abstract class Shape {
    private String shapeName;

    // -----------------------------------------------------------------
    // Constructor: Sets the name of the shape.
    // -----------------------------------------------------------------
    public Shape(String name) {
        shapeName = name;
    }

    // -----------------------------------------------------------------
    // Abstract method - each subclass must define how to compute area.
    // -----------------------------------------------------------------
    public abstract double area();

    // -----------------------------------------------------------------
    // Returns the name of the shape.
    // -----------------------------------------------------------------
    public String toString() {
        return shapeName;
    }
}