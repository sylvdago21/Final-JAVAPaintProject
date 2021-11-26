import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure {
    protected int length;
    protected int width;

    public Rectangle(int px, int py, Color color) {
        super(color, new Point(px, py));
        this.setBoundingBox(0, 0);
    }

    protected void setBoundingBox(int heightBB, int widthBB) {
        this.width = widthBB;
        this.length = heightBB;
    }

    protected void draw(Graphics g) {
        g.setColor(this.c);
        g.drawRect(this.origin.getX(), this.origin.getY(), this.width, this.length);
    }

    public String toString() {
        return "Rectangle{color=" + this.c + ", origin= " + this.origin + ", length=" + this.length + ", width=" + this.width + "}";
    }

    public int getWidth() {

        return this.width;
    }

    public int getLength() {

        return this.length;
    }

    public void setLength(int length) {

        this.length = length;
    }

    public void setWidth(int width) {

        this.width = width;
    }
}
