import java.util.Scanner;

public class Task1 {
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
        System.out.println("Simple numbers: ");

        for(int i = 0; i < massive.length; i++)
        {
            if(massive[i] > 0) {
                if (SimpleNumbers(massive[i])) {
                    System.out.print(massive[i] + " ");
                }
            }
        }
    }


    static boolean SimpleNumbers(int number)
    {
        if(number==1)
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


