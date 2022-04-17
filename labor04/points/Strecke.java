/**
 * @name points/Strecke
 * @package labor04
 * @file Strecke.java
 * @authors Veronica Zylla, Sören Zacharias, Alexander Nachtigal
 * @email veronica.zylla@student.fh-kiel.de, soeren.zacharias@student.fh-kiel.de, alexander.nachtigal@student.fh-kiel.de
 * @description "Strecke"-class to create a track between two points from class "Punkt"
 */

package labor04.points;

import java.util.Scanner;

public class Strecke {
    private Punkt p;
    private Punkt q;

    // constructor
    public Strecke(Punkt p, Punkt q) {
        this.p = p;
        this.q = q;
    }

    // getter and setter for the methods in class "Strecke".
    public Punkt getP() {
        return p;
    }

    public void setP(Punkt p) {
        this.p = p;
    }

    public Punkt getQ() {
        return q;
    }

    public void setQ(Punkt q) {
        this.q = q;
    }

    // This method assigns the X and Y coordinates to the two points based on the user input.
    public void read() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Erster Punkt");
            System.out.println("-------------------");
            p.read();
            System.out.println("Zweiter Punkt");
            System.out.println("-------------------");
            q.read();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // returns the absolute length between the two points.
    public double getLength() {
        return Math.sqrt(Math.pow((q.getX() - p.getX()), 2) + Math.pow((q.getY() - p.getY()), 2));
    }

    // returns the p and q points to a string in format "pStr_qStr".
    @Override
    public String toString() {
        return p.toString() + "_" + q.toString();
    }
}