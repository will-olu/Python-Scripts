public class Simple4
{
	private int x;
	private double y;
	public Simple4(int x, double y) // a constructor!
	{
	    this.x = x; // initialize x and y from the
	    this.y = y; // constructor’s parameters
	} 
	public Simple4(int x) // a second constructor!
	{
	    this(x, 0.0); // special call of the first constructor using this()
	} 
	public Simple4(double y) // a third constructor!
	{
	    this(0, y); // special call of the first constructor using this()
	} 
	public Simple4() // a fourth, default constructor!
	{
	    this(0, 0.0); // special call of the first constructor using this()
	}

	public void print()
	{
		System.out.println("x: " + x + ", y: " + y);
	}

	public static void main(String[] args)
	{
		Simple4 s41 = new Simple4(42, 3.14159);
		s41.print();
		System.out.println();
		Simple4 s42 = new Simple4();
		s42.print();
	}
} // Java knows which constructor to call based on the arguments we supply!