// Superclass Shape
public class Shape {
    private String color = "red";
    private boolean filled = true;

    // No-arg constructor
    public Shape() {
        color = "green";
        filled = true;
    }

    // Constructor dengan parameter color dan filled
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // getter dan setter untuk filled
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "A Shape with color of " + color
                + " and " + (filled ? "filled" : "Not filled");
    }
}
