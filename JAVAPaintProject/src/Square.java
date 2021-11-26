import java.awt.Color;

public class Square extends Rectangle {
    public Square(int px, int py, Color color) {
        super(px, py, color);
        this.setBoundingBox(0, 0);
    }

    public String toString() {
        return "Carré: origine=" + this.origin + "couleur:" + this.c + "width= " + this.width + "length= " + this.length;
    }

    protected void setBoundingBox(int heightBB, int widthBB) {
        super.setBoundingBox(heightBB, widthBB);
        if (heightBB < widthBB) {
            this.length = widthBB;
            this.width = widthBB;
        } else {
            this.length = heightBB;
            this.width = heightBB;
        }

    }
}



