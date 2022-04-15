package labor04.points;

public class TestTrack {
    public static void main(String[] args) {
        // calculates the length of the track. 
        Point origin = new Point(0.0, 0.0);
        Point end = new Point(4.0, 3.0);
        track t = new track(origin, end);
        System.out.println("Length of the Track: " + t + " is  " + t.getLength() + ".");
        System.out.println();
        System.out.println("Enter track t :");
        t.read();
        System.out.println();
        System.out.println("Length of the Track " + t + " is " + t.getLength() + ".");
    }
}
