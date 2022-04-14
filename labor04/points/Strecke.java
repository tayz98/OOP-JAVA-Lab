package labor04.points;

import java.util.Scanner;

public class Strecke {
    private Punkt p;
    private Punkt q;

    public Strecke(Punkt p, Punkt q) {
        this.p = p;
        this.q = q;
    }

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

    public double getLaenge() {
        return Math.sqrt(Math.pow((q.getX() - p.getX()), 2) + Math.pow((q.getY() - p.getY()), 2));
    }

    @Override
    public String toString() {
        return p.toString() + "_" + q.toString();
    }
}
