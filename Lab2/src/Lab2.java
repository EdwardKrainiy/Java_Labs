
import java.util.Date;
import java.util.Scanner;

/**
 * Simple and polyndrom numbers class.
 * @author Krainiy Edvard
 * @version 1.2
 */

/**
 * Class Lab2
 */
public class Lab2 {
    /**
     *Void main.
     */
    public static void main(String[] args) {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter amount of elements.");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number, enter correctly again.");
            sc.next();
        }
        number = sc.nextInt();

        int massive[] = new int[number];

        for (int i = 0; i < massive.length; i++) {
            System.out.println("Enter " + i + " massive element.");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number, enter correctly again.");
                sc.next();

            }
            massive[i] = sc.nextInt();
        }

        System.out.println("Massive: ");

        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + " ");
        }
        System.out.println();

        System.out.println("Polyndrom numbers: ");
        for (int i = 0; i < massive.length; i++) {
            System.out.print((PolyndromNumbers(Integer.toString(massive[i]))) ? massive[i]+ " ":"");
        }
        System.out.println();
        System.out.println();

        System.out.println("Student: Krainiy Edward");
        System.out.println("Taking task date: 15.02.2020");
        System.out.println("Taking task time: 10:40");
        System.out.println();

        System.out.print("Current date: ");
        Date date = new Date();
        System.out.println(date.toString());
    }

    /**
     * Boolean function for checking any number for polyndrom.
     */
    static boolean PolyndromNumbers(String src) {
        boolean result = true;
        for (int i = 0; i < src.length() / 2; i++) {
            if (src.charAt(i) != src.charAt(src.length() - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }
}


