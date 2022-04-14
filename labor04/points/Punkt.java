package labor04.points;

import java.util.Scanner;

public class Punkt {
    private double x;
    private double y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

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

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.printf("Wert fuer x eingeben: ");
            this.x = sc.nextDouble();
            System.out.printf("Wert fuer y eingeben: ");
            this.y = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
