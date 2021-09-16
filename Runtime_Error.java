// this Java program demonstrates a runtime error
// the javac command compiles it to a .class file, but will give an error message at runtime

public class Runtime_Error
{
	public static void main(String[] args)
	{
		int x = 42;
		int y = 0;
		// the following line has a runtime error - it tries to divide by 0
		System.out.println(x / y);
	}
}