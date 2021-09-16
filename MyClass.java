public class MyClass // example class showing static and instance methods
{
	private int x;
	private double y;

	public MyClass(int x, double y) // a constructor!
	{
	    this.x = x; // initialize x and y from the
	    this.y = y; // constructor's parameters
	}

	public static void show() // a static method
	{
		System.out.println("Hello, world, from show!");
	}

	public void print() // an instance method
	{
		System.out.println("x: " + x + ", y: " + y);
		show();
	}

	@Override
	public String toString()
	{
		return "x: " + x + ", y: " + y;
	}

	public static void main(String[] args)
	{
		MyClass mc = new MyClass(42, 3.14159);
		MyClass.show(); // how to call a static method - use the class name
		mc.print(); // how to call an instance method - use an object reference
		String s = "here's mc: " + mc; // how to automatically call toString
		System.out.println(s);
	}
}