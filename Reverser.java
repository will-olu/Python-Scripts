public class Reverser
{
	// Demonstrate a method that returns an array
	
	public static int[] reverse(int[] a)
	{
		int[] newArray = new int[a.length];
		for (int i = 0; i < a.length; i++)
			newArray[(a.length-1) - i] = a[i]; 
			// fill newArray from end to beginning
		return newArray;
	}
			
	// TODO: write a void method reverse2 that reverses
	// an array in place by changing its contents
	// this can be done with a for loop or by reusing
	// the reverse method to create a new reversed
	// array and then copying its contents into the
	// original array; test that this works in main
	
	private static void display(String header, int[] a)
	{
		if (header.length() != 0)
			System.out.print(header + " ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println();
	}
	
    public static void main(String[] args)
	{		
		int[] example = { 0, 1, 2, 3, 4, 5 };
		display("Before reversing:", example);
		example = reverse(example); 
		// change the array that example refers to
		display("After reversing: ", example);
		
		// write a test for reverse2 here
	}
}