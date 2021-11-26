public class Point {
    private int X;
    private int Y;

    public Point(){
        int X = 0;
        int Y = 0;
    };
    public Point(int a, int b){
        this.X = a;
        this.Y = b;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "("+X+","+Y+")";

    }
}
