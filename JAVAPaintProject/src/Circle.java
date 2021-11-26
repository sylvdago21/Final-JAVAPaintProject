import java.awt.Color;

public class Circle extends Ellipse {
    public Circle(int px, int py, Color c) {
        super(px, py, c);
        this.setBoundingBox(0, 0);
    }

    public String toString() {
        return "Circle{semiAxisX=" + this.semiAxisX + " semiAxisY= " + this.semiAxisY + " Color:" + this.c + "origin" + this.origin + "}";
    }

    protected void setBoundingBox(int heightBB, int widthBB) {
        super.setBoundingBox(heightBB, widthBB);
        if (heightBB < widthBB) {
            this.semiAxisX = heightBB / 2;
            this.semiAxisY = heightBB / 2;
        } else {
            this.semiAxisX = widthBB / 2;
            this.semiAxisY = widthBB / 2;
        }

    }
}
