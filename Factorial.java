public class Factorial 
{
	public static long factorial(int n) 
	// header line: long since factorials grow rapidly!
 	{
 		if (n == 1) // this tests to see if n is 1, the base case
 			return 1; // if so, the function returns 1
 		 
 		return n*factorial(n-1); // assumes n >= 1
		// recursive call – factorial calls itself!
 		// this second return executes if the if condition is false
 	}

	public static void main(String[] args)
	{
		System.out.println("testing the recursive factorial function:")
		System.out.println("5! should be 120: " + factorial(5));
		System.out.println("1! should be 1: " + factorial(1));
		System.out.println("7! should be 5040: " + factorial(7));
	}
}
