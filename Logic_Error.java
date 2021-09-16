// this Java program demonstrates a logic error
// the javac command compiles it to a .class file, and it runs, but produces the wrong result

public class Logic_Error
{
	public static void main(String[] args)
	{
		System.out.println("The Fahrenheit temperature corresponding to 100 degrees Celsius is:");
		// the following line has a logic error - it should print 212, but it adds 23 instead of 32
		System.out.println(100 * 9 / 5 + 23);
	}
}