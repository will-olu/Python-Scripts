/**
 Reads 7 temperatures from the user and shows which are above 
 and which are below the average of the 7 temperatures.
*/
import java.util.Scanner;

public class ArrayOfTemperatures
{
	private static final int NUM_VALUES = 7; // constant
    public static void main(String[] args)
    {
        double[] temperature = new double[NUM_VALUES];
		// declare an array of doubles that can hold 7 values
		// the values are the elements of the array, and they
		// are indexed from 0 to 6 (temperature.length - 1)
		
        // Read temperatures and compute their average:
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter " + NUM_VALUES + " temperatures:");
        double sum = 0;
        for (int index = 0; index < NUM_VALUES; index++)
        {
			temperature[index] = keyboard.nextDouble( );
            sum = sum + temperature[index];
        }
        double average = sum / NUM_VALUES;
        System.out.println("The average temperature is " + average);
		
		// Display each temperature and its relation to the average:
        System.out.println("The temperatures are");
        for (int index = 0; index < NUM_VALUES; index++)
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

