import java.awt.*;

public abstract class Figure {
    protected Color c;
    protected Point origin;

    public Figure(Color color, Point point) {
        this.c = color;
        this.origin = point;
    }

    public Figure() {
        this.c = null;
        this.origin = null;
    }

    protected abstract void setBoundingBox(int heightBB, int widthBB);

    protected abstract void draw(Graphics g);

    public Color getC() {
        return this.c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public String toString() {
        return "Figure{Color=" + this.c + "}";
    }
}
