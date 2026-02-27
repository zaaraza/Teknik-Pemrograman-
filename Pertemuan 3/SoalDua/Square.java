//Square.java 
public class Square extends Rectangle {

    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth(); // width == length
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    // Override setWidth dan setLength agar width == length selalu terpenuhi
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    // getArea() dan getPerimeter() tidak perlu di-override,
    // karena sudah benar dari Rectangle (width == length)

    @Override
    public String toString() {
        return "A Square with side=" + getSide()
                + ", which is a subclass of " + super.toString();
    }
}
