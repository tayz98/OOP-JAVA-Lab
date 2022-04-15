package labor04.points;

public class Points {

    public static void main(String[] args) {
        
        // creating new points(objects) and a track from p1 to p2.
        Punkt p1 = new Punkt(3.0, 5.0);
        Punkt p2 = new Punkt(2.0, 6.0);
        Strecke t1 = new Strecke(p1, p2);
        System.out.println(t1.getLength());
    }

}
