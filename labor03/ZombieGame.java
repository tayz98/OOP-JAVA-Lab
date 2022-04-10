/**
 * @name ZombieGame
 * @package labor03
 * @file ZombieGame.java
 * @authors Veronica Zylla, Sören Zacharias, Alexander Nachtigal
 * @email veronica.zylla@student.fh-kiel.de, soeren.zacharias@student.fh-kiel.de, alexander.nachtigal@student.fh-kiel.de
 * @description Zombie Spiel: hier geht's ums nackte Überleben!
 */

package labor03;
import java.awt.Point;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ZombieGame {

    // hier werden Konstanten für die Spielfeldgröße definiert
    public static final int BOARD_HEIGHT = 12;
    public static final int BOARD_WIDTH = 36;

    public static void main(String[] args) throws Exception {

        Settings sett = new Settings();
        Scanner sc = new Scanner(System.in);
        String input; // Variable zum Verarbeiten der User-Eingabe
        int pickedRemedies = 0; // Variable zum tracken, wie viele Heilmittel aufgenommen wurden
        int steps = 0;
        boolean isValid; // Variabel zum Überprüfen, ob zugelassene Zeichen zum Bewegen etc. eingegeben wurden
        boolean hasRemedy = false; // Variable zum Überprüfen, ob das Heilmittel eingesammelt wurde
        boolean hasWon = false; // Variable zum Überprüfen, ob gewonnen wurde

        List<Point> objects = new ArrayList<>(); // Liste mit allen Objekten
        List<Point> zombies = new ArrayList<>(); // Liste mit Zombies
        List<Point> remedies = new ArrayList<>(); // Liste mit Heilmitteln
        List<Point> portals = new ArrayList<>(); // Liste mit Portalen

        Point survivor = new Point(5, 5);
        objects.add(survivor);
        Point exit = new Point(2, 2);
        objects.add(exit);

        for (int i = 0; i < sett.numZombies; i++) {
            Point tmp = new Point();
            objects.add(tmp);
            zombies.add(tmp);
        }

        for (int i = 0; i < sett.numRemedies; i++) {
            Point tmp = new Point();
            objects.add(tmp);
            remedies.add(tmp);
        }

        if (sett.hasPortals) {
            for (int i = 0; i < 2; i++) {
                Point tmp = new Point();
                portals.add(tmp);
                objects.add(tmp);
                setRandomLocation(tmp, objects);
            }
        }

        // Setzen von zufälligen Spawns
        if (settings == 2 || settings == 3) {
            for (Point p: objects) {
                setRandomLocation(p, objects);
            }
        } else {
            for (Point z: zombies) {
                z.setLocation(10, 10);
            }
            for (Point r: remedies) {
                r.setLocation(3, 3);
            }
        }

        do {
            drawBoard(BOARD_WIDTH, BOARD_HEIGHT, survivor, zombies, exit, remedies, portals, sett);
            // Hier wird geprüft, ob ein zugelassenes Zeichen eingegeben wurde -> falls nicht, nso lange wiederholen, bis was zugelassenes eingegeben wurde
            do {
                System.out.println("What is your next move? [w = move up | a = move left | s = move down | d = move right | q = exit | Confirm input with ENTER]");
                input = sc.nextLine();
                isValid = move(survivor, input);
            } while (!isValid);

            // falls das Heilmittel eingesammelt wird, "pickedRemedies" erhöhz
            for (Point r: remedies) {
                if (r.getLocation().equals(survivor.getLocation())) {
                    pickedRemedies++;
                    r.setLocation(-1, -1);
                }
            }

            if (sett.hasPortals) {
                if (survivor.getLocation().equals(portals.get(0).getLocation()) || survivor.getLocation().equals(portals.get(1).getLocation())) {
                    usePortal(survivor, portals);
                }
            }

            // falls alle Heilmittel eingesammelt wurden, wird "hasRemedy" auf "true" gesetzt
            if (pickedRemedies == numRemedies) {hasRemedy = true;}

            moveZombies(survivor, zombies);

            if (survivor.getLocation().equals(exit.getLocation()) && hasRemedy) { // Gewinnbedingung
                hasWon = true;
                drawBoard(BOARD_WIDTH, BOARD_HEIGHT, survivor, zombies, exit, remedies, portals, sett);
                printWinMessage();
            } else if (ateByZombies(survivor, zombies)) { // Verlieren-Bedingung
                drawBoard(BOARD_WIDTH, BOARD_HEIGHT, survivor, zombies, exit, remedies, portals, sett);
                printLoseMessage();
                System.exit(42);
            } else if (survivor.getLocation().equals(exit.getLocation()) && !hasRemedy) { // Ausgabe, falls Ausgang erreicht wird aber das Heilmittel nicht eingesammelt wurde
                System.out.println("Oh no, there's something missing...");
            }
        } while (!input.equals("q") && !hasWon);
    }

    // Methode zum Zeichnen des Spielbretts auf der Konsole
    public static void drawBoard(final int xAxis, final int yAxis, final Point survivor, final List<Point> zombies, final Point exit, final List<Point> remedies, final List<Point> portals, final Settings settings) {
        PrintStream printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8); // wird benötigt, um medizinisches Zeichen anzuzeigen
        String sign = "-";
        for (int i = 0; i < yAxis; i++) {
            for (int j = 0; j < xAxis; j++) {
                sign = "-";
                if (j == exit.getX() && i == exit.getY()) {
                    sign = "#";
                }
                for (Point r : remedies) {
                    if (r.getX() == j && r.getY() == i) {
                        sign = "\u2695";
                    }
                }
                if (settings.hasPortals) {
                    for (Point p : portals) {
                        if (p.getX() == j && p.getY() == i) {
                            sign = "o";
                        }
                    }
                }
                if (j == survivor.getX() && i == survivor.getY()) {
                    sign = "S";
                }
                for (Point z : zombies) {
                    if (z.getX() == j && z.getY() == i) {
                        sign = "Z";
                    }
                }
                printStream.print(sign);
            }
            System.out.println();
        }
    }

    // Methode zum Bewegen des Spielers
    public static boolean move (Point obj, String input){
        switch (input) {
            // Wenn der Survivor auf den Spielfeldrand trifft, bleibt er stehen (über Min- und Max-Methode!)
            case "a" -> obj.setLocation(Math.max(obj.getX() - 1, 0), obj.getY());
            case "s" -> obj.setLocation(obj.getX(), Math.min(obj.getY() + 1, BOARD_HEIGHT - 1));
            case "d" -> obj.setLocation(Math.min(obj.getX() + 1, BOARD_WIDTH - 1), obj.getY());
            case "w" -> obj.setLocation(obj.getX(), Math.max(obj.getY() - 1, 0));
            case "q" -> System.out.println("Exit game...");
            default -> {
                System.out.println("Wrong input");
                return false;
            }
        }
        return true;
    }

    // Methode zum Bewegen der Zombies
    public static void moveZombies (Point survivor, List<Point> zombies) {
        // Der Zombie bewegt sich immer in Richtung der x- und y-Koordinate des Spielers
        // da er diagonal gehen kann, werden beide Richtungen ausgewertet
        for (Point z: zombies) {
            int x = (int) z.getX();
            int y = (int) z.getY();

            // Bewegung in x-Richtung
            if (x < survivor.getX()) {
                x++;
            } else if (x > survivor.getX()) {
                x--;
            }
            // Bewegung in y-Richtung
            if (y < survivor.getY()) {
                y++;
            } else if (y > survivor.getY()) {
                y--;
            }
            z.setLocation(x, y);
        }

    }

    // Methode zur Ausgabe einer Gewinner-Nachricht
    public static void printWinMessage () {
        System.out.println("***********************************");
        System.out.println("*                                 *");
        System.out.println("*       CONGRATS! YOU WON!        *");
        System.out.println("*   YOU ESCAPED FROM THE ZOMBIE   *");
        System.out.println("*                                 *");
        System.out.println("***********************************");
    }

    // Methode zur Ausgabe einer Verlierer-Nachricht
    public static void printLoseMessage () {
        System.out.println("***********************************");
        System.out.println("*                                 *");
        System.out.println("*               OH NO!            *");
        System.out.println("* THE ZOMBIE HAS A DELICIOUS MEAL *");
        System.out.println("*                                 *");
        System.out.println("***********************************");
    }

    // Methode zum Setzen einer zufälligen Position, die noch nicht von einem anderen Objekt belegt ist
    public static void setRandomLocation (Point obj, List < Point > objects){
        int x, y;
        Random rand = new Random();
        boolean isValid = true;
        do {
            x = rand.nextInt(BOARD_WIDTH - 1);
            y = rand.nextInt(BOARD_HEIGHT - 1);
            obj.setLocation(x, y);
            for (Point p : objects) {
                if (p.equals(obj) && !(p == obj)) {
                    isValid = false;
                    break;
                }
            }
        } while (!isValid);
    }

    // Methode, die überprüft, ob man vom Zombie erwischt wurde
    public static boolean ateByZombies(final Point survivor, final List<Point> zombies) throws Exception {
        try {
            for (Point z : zombies) {
                if (z.getLocation().equals(survivor.getLocation())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }
        return false;
    }

    // Methode zum Benutzen eines Portals -> der Spieler wird beim Benutzen an die Location des anderen Portals gesetzt
    public static void usePortal(final Point survivor, final List<Point> portals) throws Exception {
        try {
            if (survivor.getLocation().equals(portals.get(0).getLocation())) {
                survivor.setLocation(portals.get(1));
            } else if (survivor.getLocation().equals(portals.get(1).getLocation())) {
                survivor.setLocation(portals.get(0));
            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }
    }

}

