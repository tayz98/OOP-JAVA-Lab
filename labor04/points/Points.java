package labor04.points;

public class Points {

    public static void main(String[] args) {
        Punkt p1 = new Punkt(3.0, 5.0);
        Punkt p2 = new Punkt(2.0, 6.0);
        Strecke s1 = new Strecke(p1, p2);
        System.out.println(s1.getLaenge());
    }

}
