/**
 * @name points/Punkt
 * @package labor04
 * @file Punkt.java
 * @authors Veronica Zylla, Sören Zacharias, Alexander Nachtigal
 * @email veronica.zylla@student.fh-kiel.de, soeren.zacharias@student.fh-kiel.de, alexander.nachtigal@student.fh-kiel.de
 * @description "Punkt"-class to create a point with x- and y-coordinate and methods
 */

package labor04.points;

import java.util.Scanner;

public class Punkt {
    private double x;
    private double y;

    // constructor
    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // getter and setter for the methods in class "Punkt".
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // returns the x and y coordinates to a string in format "(xStr,yStr)".
    @Override
    public String toString() {
        return "(x=" + x + ",y=" + y + ")";
    }

    // This method assigns the X and Y coordinates to the point based on the user input.
    public void read() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.printf("Enter a value for the x coordinate: ");
            this.x = sc.nextDouble();
            System.out.printf("Enter a value for the y coordinate: ");
            this.y = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
