package labor04.points;

import java.util.Scanner;

public class track {
    private Point p;
    private Point q;

    public track(Point p, Point q) {
        this.p = p;
        this.q = q;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public Point getQ() {
        return q;
    }

    public void setQ(Point q) {
        this.q = q;
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("First point");
            System.out.println("-------------------");
            p.read();
            System.out.println("Second point");
            System.out.println("-------------------");
            q.read();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public double getLength() {
        return Math.sqrt(Math.pow((q.getX() - p.getX()), 2) + Math.pow((q.getY() - p.getY()), 2));
    }

    @Override
    public String toString() {
        return p.toString() + "_" + q.toString();
    }
}
