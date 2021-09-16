import java.util.Scanner170;

public class Person // in file Person.java
{
    private String name = ""; // one of the attributes of the Person class, their name
    // this is initialized to the empty string to show that we have no information yet
    private int age; // the other attribute of the Person class, their age in years
     
    public void readInput() // a void method that does not return a value
    {
        final int MIN_AGE = 0, MAX_AGE = 130; // constants for age validation
		Scanner170 keyboard = new Scanner170(System.in);
        System.out.println("Please enter the person's name: ");
        name = keyboard.nextLine();
        System.out.println("Please enter the person's age in years: ");
        age = keyboard.nextInt();
        if (age < MIN_AGE || age > MAX_AGE)
        {
            System.out.println("That age is not valid, this program is ending");
            System.exit(0); // ends the program immediately
        }
    }

    public void writeOutput() // another void method
    {
        if (name.equals("")) // only true if no input information yet
        {
            System.out.println("no information yet - no name, no age");
        }
        else
        {
            System.out.println("name: " + name + ", age: " + age);
        }
    }
}