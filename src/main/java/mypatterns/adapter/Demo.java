package mypatterns.adapter;

/**
 * Somewhere in client code...
 */
public class Demo {
    public static void main(String[] args) {
        // Round fits round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }

        TrianglePeg trianglePeg1 = new TrianglePeg(0.44, 3);
        TrianglePeg trianglePeg2 = new TrianglePeg(244, 522);

        TriabglePegAdapter triabglePegAdapter1 = new TriabglePegAdapter(trianglePeg1);
        TriabglePegAdapter triabglePegAdapter2 = new TriabglePegAdapter(trianglePeg2);

        if(hole.fits(triabglePegAdapter1))
            System.out.println("tr fits");
        if(!hole.fits(triabglePegAdapter2))
            System.out.println("not fits");
    }
}