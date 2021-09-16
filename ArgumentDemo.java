import java.util.Scanner;

/**
 A demonstration of using indexed variables as arguments.
*/
public class ArgumentDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your score on exam 1:");
        int firstScore = keyboard.nextInt( );
        int[] nextScore = new int[3];
		
        for (int i = 0; i < nextScore.length; i++)
            nextScore[i] = firstScore + 5 * i;
		// elements: firstScore, firstScore + 5, firstScore + 10
			
        for (int i = 0; i < nextScore.length; i++)
        {
            double possibleAverage = getAverage(firstScore, nextScore[i]);
			// demonstrates passing an array element as a method argument
			// each element of nextScore is an int, and getAverage expects 
			// its second argument to be an int
            System.out.println("If your score on exam 2 is " +
                                nextScore[i]);
            System.out.println("your average will be " +
                                possibleAverage);
        }
    }

    public static double getAverage(int n1, int n2)
    {
        return (n1 + n2) / 2.0;
    }
}







