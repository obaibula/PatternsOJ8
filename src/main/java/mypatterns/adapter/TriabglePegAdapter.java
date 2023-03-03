package mypatterns.adapter;

public class TriabglePegAdapter extends RoundPeg{
    TrianglePeg trianglePeg;

    public TriabglePegAdapter(TrianglePeg trianglePeg) {
        this.trianglePeg = trianglePeg;
    }

    @Override
    public double getRadius() {
        return trianglePeg.getSide();
    }
}
