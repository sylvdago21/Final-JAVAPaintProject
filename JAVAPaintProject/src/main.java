import java.awt.Color;

public class main {
    public main() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Point b = new Point(2, 3);
        Rectangle rect = new Rectangle(2, 3, Color.blue);
        Ellipse elli = new Ellipse(10, 16, Color.blue);
        Square carr = new Square(16, 15, Color.red);
        Circle circ = new Circle(16, 16, Color.green);
        System.out.println(b);
        System.out.println(rect);
        System.out.println(elli);
        System.out.println(carr);
        System.out.println(circ);
        new Window("Paint", 800, 600);
    }
}

