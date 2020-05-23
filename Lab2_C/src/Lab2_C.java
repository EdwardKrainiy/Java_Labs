/**
 * Matrix and Det class.
 * @autor Krainiy Edvard
 * @version 1.3
 */
import java.util.Date;
import java.util.Scanner;

/**
 * Lab2_C constructor
 */
public class Lab2_C {
    /** Main class */

    public static void main(String[] args) {
        int n = 0;
        int det = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n.");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number, enter correctly again.");
            sc.next();
        }
        n = sc.nextInt();
        int matrix[][] = new int[n][n];
        System.out.println("Matrix: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                matrix[i][j] = (int) Math.round((Math.random() * 2*n) - n);
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("Determinant: " + CalculateMatrix(matrix));

        System.out.println("Student: Krainiy Edward");
        System.out.println("Taking task date: 15.02.2020");
        System.out.println("Taking task time: 10:40");
        System.out.println();

        System.out.print("Current date: ");
        Date date = new Date();
        System.out.println(date.toString());
    }

    /** Minor function */
    public static int[][] Minor(int[][] matrix, int row, int column){
        int len = matrix.length-1;
        int[][] minor = new int[len][len];
        int dI=0;
        int dJ=0;
        for(int i=0; i<=len; i++){
            dJ=0;
            for(int j=0; j<=len; j++){
                if(i==row){
                    dI=1;
                }
                else{
                    if(j==column){
                        dJ=1;
                    }
                    else{
                        minor[i-dI][j-dJ] = matrix[i][j];
                    }
                }
            }
        }
        return minor;
    }

    /**
     *CalculateMatrix function for Det calculating.
     */
    public static int CalculateMatrix(int[][] matrix){
        int calcResult=0;
        if (matrix.length==2){
            calcResult=matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
        }
        else{
            int koef=1;
            for(int i=0; i<matrix.length; i++){
                if(i%2==1){
                    koef=-1;
                }
                else{
                    koef=1;
                };
                calcResult += koef*matrix[0][i]* CalculateMatrix(Minor(matrix,0,i));
            }
        }
        return calcResult;
    }
}
