import java.util.Scanner170;

public class Input   
{   
	public static void main(String[] args)   
	{   
		Scanner170 keyboard = new Scanner170(System.in);   
		int age;   
		String name;   
		System.out.println("Enter your age.");   
		age = keyboard.nextInt();   
		System.out.println("Enter your full name.");   
		name = keyboard.nextLine();   
		name.toUpperCase();   
		System.out.println("Your name in uppercase is " + name +   
						   " and you are " + age + " years old.");   
	}   
}