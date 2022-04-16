/**
 * @name points/TestStrecke
 * @package labor04
 * @file TestStrecke.java
 * @authors Veronica Zylla, Sören Zacharias, Alexander Nachtigal
 * @email veronica.zylla@student.fh-kiel.de, soeren.zacharias@student.fh-kiel.de, alexander.nachtigal@student.fh-kiel.de
 * @description a class to test the classes "Punkt" and "Strecke" and their methods
 */

package labor04.points;

public class TestStrecke {
    public static void main(String[] args) {
        // this simple program calculates the length of the track between the points "ursprung" and "endpunkt".
        Punkt ursprung = new Punkt(0.0, 0.0);
        Punkt endpunkt = new Punkt(4.0, 3.0);
        Strecke s = new Strecke(ursprung, endpunkt);
        System.out.println("Die Laenge der Strecke " + s + " betraegt " + s.getLength() + ".");
        System.out.println();
        System.out.println("Strecke s eingeben:");
        s.read();
        System.out.println();
        System.out.println("Die Laenge der Strecke " + s + " betraegt " + s.getLength() + ".");
    }
}
