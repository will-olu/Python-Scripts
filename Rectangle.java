import java.util.Scanner;

public class Rectangle // nothing in here is marked static
{
	// instance variables - marked private to protect them from other classes
	private double length; // one instance variable or "attribute" or "field" of this class
	private double width; // another - these form a Rectangle object's state
	
	public double getLength() // a "getter" or "accessor method for instance variable length
	{
		return length;
	}
	
	public double getWidth() // another for instance variable width
	{
		return width;
	}
	
	public void setLength(double length) // a "setter" or mutator method for instance variable length
	{
		if (length >= 0) this.length = length; 
		// note the use of "this." to distinguish the instance variable from the
		// parameter with the same name - this.length always means the instance variable
	}
	
	public void setWidth(double width) // another for instance variable width
	{
		if (width >= 0) this.width = width;
	}
	
	// the setDimensions method can also change both of the
	// private instance variables above
    public void setDimensions(int newWidth, int newHeight)
    {
        width = newWidth;
        height = newHeight;
		area = width * height;
    }
	
	public double area()
	{
		return length * width;
	}
	
	public double perimeter()
	{
		return 2 * (length + width);
	}
} // end of class Rectangle