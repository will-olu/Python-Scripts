/**
 Reads temperatures from the user and shows which are above 
 and which are below the average of all the temperatures.
*/
import java.util.Scanner;

public class ArrayOfTemperatures2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
		System.out.println("How many temperatures do you have?");
		int size = keyboard.nextInt( );
		double[] temperature = new double[size];
		
        // Read temperatures and compute their average:
        System.out.println("Enter " + temperature.length + " temperatures:");
		double sum = 0;
        for (int index = 0; index < temperature.length; index++)
        {
			temperature[index] = keyboard.nextDouble( );
            sum = sum + temperature[index];
        }
        double average = sum / temperature.length;
        System.out.println("The average temperature is " + average);
		
		// Display each temperature and its relation to the average:
        System.out.println("The temperatures are");
        for (int index = 0; index < temperature.length; index++)
        {
            System.out.print(temperature[index]);
            if (temperature[index] < average)
                System.out.println(" below average");
            else if (temperature[index] > average)
                System.out.println(" above average");
            else //temperature[index] == average
                System.out.println(" the average");
        }
        System.out.println("Have a nice week.");
    }
}

