import java.util.Scanner;

public class Rectangle2
{
    private int width;
    private int height; 

    public void setDimensions(int newWidth, int newHeight)
    {
        width = newWidth;
        height = newHeight;
    }

    public int getArea()
    {
		return width * height;
    }
}
