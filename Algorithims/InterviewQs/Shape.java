/*package InterviewQs;
Hackerrank question
Shapes 
/**
 * Shape
 */
interface Shape {
    public abstract int GetArea();
}
class Rectangle implements Shape{
    private int h; int w;
    public Rectangle(int h,int w) {
        this.h = h;
        this.w = w;
    }
    @Override
    public int GetArea() {
        int res = Math.round(h*w);
        return res;
    }    
}
class Triangle implements Shape {
    private int h;
    int w;

    public Triangle(int h,int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int GetArea() {
        int res = Math.round((h * w)/2);
        return res;
    }
}
class Circle implements Shape {
    private int r;
    public Circle(int r) {
        this. r = r;
    }
    @Override
    public int GetArea() {
        double res = Math.round(3.14*r*r);
        return (int)res;
    }
}