package mypatterns.adapter;

public class TrianglePeg {
    private double height;
    private double side;

    public TrianglePeg(double height, double side) {
        this.height = height;
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public double getSide() {
        return side;
    }

    public double getTriangle(){
        double result;
        result = (height * side) / 2;
        return result;
    }
}
