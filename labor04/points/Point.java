package labor04.points;

import java.util.Scanner;

public class Point {
    private double x;
    private double y;

    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // getter and setter for the methods in class 'point'
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

    // returns the x and y coordinates to a new string.
    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
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
