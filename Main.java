import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        String [] names = new String[number];
        double [] weights = new double[number];
        double [] heights = new double[number];

        for (int i = 0; i < names.length; i++){
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        while(true){
            try{
                for (int i = 0; i < weights.length; i++){
                    System.out.print("\nEnter weight in kilograms(kg) " + (i + 1) + ": ");
                    weights[i] = scanner.nextDouble();
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter digits for weight.");
                scanner.nextLine();
            }
        }

        while(true){
            try{
                for (int i = 0; i < heights.length; i++) {
                    System.out.print("\nEnter height in meters " + (i + 1) + ": ");
                    heights[i] = scanner.nextDouble();
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter digits for height.");
                scanner.nextLine();
            }
        }

        for (int i = 0; i < weights.length && i < heights.length; i++){
            double bmi = weights[i] / Math.pow(heights[i], 2);
            bmi = Math.round(bmi *100.0)/100.0;

            System.out.println("\nDetails for person " +(i +1) + ": " + names[i] + " BMI: " + bmi);
            if (bmi < 18.5){
                System.out.print("(Underweight)");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                System.out.println("(Normal weight)");
            } else if (bmi >= 25 && bmi <= 29.9) {
                System.out.println("(Overweight)");
            }else {
                System.out.println("(Obese)");
            }
        }
    }
}