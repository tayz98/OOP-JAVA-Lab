package labor04.points;

public class Points {

    public static void main(String[] args) {
        
        // creating new points(objects) and a track from p1 to p2.
        Point p1 = new Point(3.0, 5.0);
        Point p2 = new Point(2.0, 6.0);
        track t1 = new track(p1, p2);
        System.out.println(t1.getLength());
    }

}
