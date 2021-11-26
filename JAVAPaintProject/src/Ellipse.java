import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Figure {
    protected int semiAxisX;
    protected int semiAxisY;

    public Ellipse(int px, int py, Color color) {
        super(color, new Point(px, py));
        this.c = this.c;
        this.setBoundingBox(0, 0);
    }

    protected void setBoundingBox(int heightBB, int widthBB) {
        this.semiAxisX = widthBB / 2;
        this.semiAxisY = heightBB / 2;
    }

    protected void draw(Graphics g) {
        g.setColor(this.c);
        g.drawOval(this.origin.getX(), this.origin.getY(), this.semiAxisX * 2, this.semiAxisY * 2);
    }

    public String toString() {
        return "Ellipse{semiAxisX=" + this.semiAxisX + "; semiAxisY=" + this.semiAxisY + "; c=" + this.c + "; origin=" + this.origin + "}";
    }
}
