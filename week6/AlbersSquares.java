import java.awt.Color;
public class AlbersSquares {

    public static void main(final String[] args) {
    	//colour red = 255 (,0 ,0)
    	//colour green = (0,) 255 (,0)
    	//colour blue = (0,0,)255

        StdDraw.setCanvasSize(800, 800);
        
        final int red1 = Integer.parseInt(args[0]);
        final int green1 = Integer.parseInt(args[1]);
        final int blue1 = Integer.parseInt(args[2]);
        final Color c1 = new Color(red1, green1, blue1);

        final int red2 = Integer.parseInt(args[3]);
        final int green2 = Integer.parseInt(args[4]);
        final int blue2 = Integer.parseInt(args[5]);
        final Color c2 = new Color(red2, green2, blue2);

        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.25, .5, .2);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.25, .5, .1);


        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.75, .5, .2);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.75, .5, .1);
    } 
} 