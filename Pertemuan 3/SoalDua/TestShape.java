public class TestShape {
    public static void main(String[] args) {

        // ===== Test Shape =====
        System.out.println("===== Shape =====");
        Shape s1 = new Shape();
        System.out.println(s1);
        Shape s2 = new Shape("blue", false);
        System.out.println(s2);

        // ===== Test Circle =====
        System.out.println("\n===== Circle =====");
        Circle c1 = new Circle();
        System.out.println(c1);
        System.out.printf("Area=%.2f, Perimeter=%.2f%n", c1.getArea(), c1.getPerimeter());

        Circle c2 = new Circle(5.0, "yellow", true);
        System.out.println(c2);
        System.out.printf("Area=%.2f, Perimeter=%.2f%n", c2.getArea(), c2.getPerimeter());

        // ===== Test Rectangle =====
        System.out.println("\n===== Rectangle =====");
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        System.out.printf("Area=%.2f, Perimeter=%.2f%n", r1.getArea(), r1.getPerimeter());

        Rectangle r2 = new Rectangle(4.0, 6.0, "red", false);
        System.out.println(r2);
        System.out.printf("Area=%.2f, Perimeter=%.2f%n", r2.getArea(), r2.getPerimeter());

        // ===== Test Square =====
        System.out.println("\n===== Square =====");
        Square sq1 = new Square();
        System.out.println(sq1);
        System.out.printf("Area=%.2f, Perimeter=%.2f%n", sq1.getArea(), sq1.getPerimeter());

        Square sq2 = new Square(5.0, "purple", true);
        System.out.println(sq2);
        System.out.printf("Area=%.2f, Perimeter=%.2f%n", sq2.getArea(), sq2.getPerimeter());

        // Test setWidth / setLength pada Square
        System.out.println("\n--- Tes setSide pada Square ---");
        sq2.setWidth(10.0);
        System.out.println("After setWidth(10): width=" + sq2.getWidth() + " length=" + sq2.getLength());
        sq2.setLength(7.0);
        System.out.println("After setLength(7): width=" + sq2.getWidth() + " length=" + sq2.getLength());
    }
}
