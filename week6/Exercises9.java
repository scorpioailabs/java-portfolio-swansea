public class AlbersSquares {

    public static void main(final String[] args) {

        StdDraw.setCanvasSize(800, 800);

        // first color
        final int r1 = Integer.parseInt(args[0]);
        final int g1 = Integer.parseInt(args[1]);
        final int b1 = Integer.parseInt(args[2]);
        final Color c1 = new Color(r1, g1, b1);

        // second color
        final int r2 = Integer.parseInt(args[3]);
        final int g2 = Integer.parseInt(args[4]);
        final int b2 = Integer.parseInt(args[5]);
        final Color c2 = new Color(r2, g2, b2);

        // first Albers square
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.25, .5, .2);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.25, .5, .1);

        // second Albers square
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.75, .5, .2);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.75, .5, .1);
    } 
} 