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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int settings;
        int numRemedies = 1;
        int numZombies = 1;

        // Abfrage wie gespielt werden soll: Festgelegt oder zufällige Spawns
        do {
            System.out.println("How do you wanna play?");
            System.out.println("[1] Fixed spawns");
            System.out.println("[2] Random spawns");
            System.out.println("[3] Random spawns and custom settings");
            settings = sc.nextInt();
            sc.nextLine(); // muss benutzt werden, damit der Scanner das nächste Zeichen einliest
        } while(settings != 1 && settings != 2 && settings != 3); // while-Schleife bis zur Eingabe eines richtigen Wertes

        if (settings == 3) {
            // Angabe über Anzahl Heilmittel
            do {
                if (numRemedies < 1 || numRemedies > 5) {
                    System.out.println("Wrong input! Go again!");
                }
                System.out.println("How much remedies does the player need? (1-5)");
                numRemedies = sc.nextInt();
                sc.nextLine();
            } while (numRemedies < 0 || numRemedies > 5); // while-Schleife bis zur Eingabe eines richtigen Wertes

            // Angabe über Anzahl Zombies
            do {
                if (numZombies < 1 || numZombies > 10) {
                    System.out.println("Wrong input! Go again!");
                }
                System.out.println("How much zombies do you want to escape? (1-10)");
                numZombies = sc.nextInt();
                sc.nextLine();
            } while (numZombies < 0 || numZombies > 10 ); // while-Schleife bis zur Eingabe eines richtigen Wertes
        }

        List<Point> objects = new ArrayList<>(); // Liste mit allen Objekten
        List<Point> zombies = new ArrayList<>(); // Liste mit Zombies
        List<Point> remedies = new ArrayList<>(); // Liste mit Heilmitteln

        Point survivor = new Point(5, 5);
        objects.add(survivor);
        Point exit = new Point(2, 2);
        objects.add(exit);

        for (int i = 0; i < numZombies; i++) {
            Point tmp = new Point();
            objects.add(tmp);
            zombies.add(tmp);
        }

        for (int i = 0; i < numRemedies; i++) {
            Point tmp = new Point();
            objects.add(tmp);
            remedies.add(tmp);
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

        boolean hasRemedy = false; // Variable zum Überprüfen, ob das Heilmittel eingesammelt wurde
        boolean hasWon = false; // Variable zum Überprüfen, ob gewonnen wurde
        boolean validInput; // Variabel zum Überprüfen, ob zugelassene Zeichen zum Bewegen etc. eingegeben wurden
        String input; // Variable zum Verarbeiten der User-Eingabe
        int pickedRemedies = 0; // Variable zum tracken, wieviele Heilmittel aufgenommen wurden

        do {
            drawBoardNEW(BOARD_WIDTH, BOARD_HEIGHT, survivor, zombies, exit, remedies);
            // Hier wird geprüft, ob ein zugelassenes Zeichen eingegeben wurde -> falls nicht, nso lange wiederholen, bis was zugelassenes eingegeben wurde
            do {
                System.out.println("What is your next move? [w = move up | a = move left | s = move down | d = move right | q = exit | Confirm input with ENTER]");
                input = sc.nextLine();
                validInput = move(survivor, input);
            } while(!validInput);

            // falls das Heilmittel eingesammelt wird, "pickedRemedies" erhöhz
            for (Point r: remedies) {
                if (r.getLocation().equals(survivor.getLocation())) {
                    pickedRemedies++;
                    r.setLocation(-1, -1);
                }
            }

            // falls alle Heilmittel eingesammelt wurden, wird "hasRemedy" auf "true" gesetzt
            if (pickedRemedies == numRemedies) {hasRemedy = true;}

            moveZombies(survivor, zombies);

            if (survivor.getLocation().equals(exit.getLocation()) && hasRemedy) { // Gewinnbedingung
                hasWon = true;
                drawBoardNEW(BOARD_WIDTH, BOARD_HEIGHT, survivor, zombies, exit, remedies);
                printWinMessage();
            } else if (ateByZombies(survivor, zombies)) { // Verlieren-Bedingung
                drawBoardNEW(BOARD_WIDTH, BOARD_HEIGHT, survivor, zombies, exit, remedies);
                printLoseMessage();
                System.exit(42);
            } else if (survivor.getLocation().equals(exit.getLocation()) && !hasRemedy) { // Ausgabe, falls Ausgang erreicht wird aber das Heilmittel nicht eingesammelt wurde
                System.out.println("Oh no, there's something missing...");
            }
        } while (!input.equals("q") && !hasWon);
    }

    // Methode zum Zeichnen des Spielbretts auf der Konsole
    public static void drawBoardNEW (int xAxis, int yAxis, Point survivor, List<Point> zombies, Point exit, List<Point> remedies) {
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

    // Methode zum Zeichnen des Spielbretts auf der Konsole
    // ALT
    public static void drawBoard (int xAxis, int yAxis, Point survivor, Point zombie, Point exit, Point remedy, boolean hasRemedy){
        PrintStream printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8); // wird benötigt, um medizinisches Zeichen anzuzeigen
        for (int i = 0; i < yAxis; i++) {
            for (int j = 0; j < xAxis; j++) {
                if (j == zombie.getX() && i == zombie.getY()) {
                    System.out.print("Z");
                } else if (j == survivor.getX() && i == survivor.getY()) {
                    System.out.print("S");
                } else if (j == exit.getX() && i == exit.getY()) {
                    System.out.print("#");
                } else if (j == remedy.getX() && i == remedy.getY() && !hasRemedy) { // Heilmittel wird über "hasRemedy" nur angezeigt, solange es nicht eingesammelt wurde
                    printStream.print("\u2695");
                } else {
                    System.out.print("-");
                }
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

    public static boolean ateByZombies(Point survivor, List<Point> zombies) {
        for (Point z: zombies) {
            if (z.getLocation().equals(survivor.getLocation())) {
                return true;
            }
        }
        return false;
    }
}

