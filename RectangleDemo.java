import java.util.Scanner;
public class RectangleDemo
{
    public static void main(String[] args)
    {
        Rectangle box = new Rectangle( );
        box.setDimensions(10, 5); // sets the rectangle's width, height, & area
        System.out.println("The area of our rectangle is " + box.getArea( ));
    }
}