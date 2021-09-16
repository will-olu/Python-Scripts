import java.util.Scanner;

/**
 A demonstration of a method that returns an array.
*/
public class ReturnArrayDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your score on exam 1:");
        int firstScore = keyboard.nextInt( );
        int[] nextScore = new int[3];
        
        for (int i = 0; i < nextScore.length; i++)
            nextScore[i] = firstScore + 5 * i;
			
        double[] averageScore = getArrayOfAverages(firstScore, nextScore);
        for (int i = 0; i < nextScore.length; i++)
        {
            System.out.println("If your score on exam 2 is " +
                                nextScore[i]);
            System.out.println("your average will be " +
                                averageScore[i]);
        }
    }

	// this method takes an array parameter and also returns a (new) array
    public static double[] getArrayOfAverages(int firstScore, int[] nextScore)
    {
        double[] temp = new double[nextScore.length];
		// create a new array the same length as the scores array to hold
		// potential averages if the student gets those scores on the next exam
        for (int i = 0; i < temp.length; i++)
            temp[i] = getAverage(firstScore, nextScore[i]);
			
        return temp; // pass back an array reference to the calling program
    }

    public static double getAverage(int n1, int n2)
    {
       return (n1 + n2) / 2.0;
    }
}
