import java.util.*;
import java.util.function.*;

/**
 * This program provides nextInt, nextDouble, nextBoolean, next, and nextLine 
 * static methods like Scanner plus their corresponding has... methods, but 
 * avoids the problems caused by intermixing all of them. Keyboard's nextInt,
 * nextDouble, nextBoolean, and next consume all leading whitespace that's 
 * on the same line, including an initial newline (Enter) character if it 
 * follows only whitespace, and they implicitly consume a single whitespace
 * character that ends that token, including possibly a following newline.
 * The Keyboard class only connects to System.in.
 *
 * In addition, this program provides a nextChar function that expects to
 * receive a single non-newline character and returns it. Any following 
 * next... methods start reading at a point immediately after that character,
 * so, for example, entering two characters next to each other and using two
 * nextChar calls will return both of them. Also, if nextChar is preceded by
 * any next... method except nextChar and nextLine that previous method will
 * consume one whitespace character before nextChar starts reading.
 *
 * Finally, this program adds "aliases" nextString and nextWord / nextToken 
 * and their corresponding hasNext methods for consistency in method naming.
 *
 * This version of Keyboard uses Java 8 method references.
 * 
 * Also created a Scanner170 class that can process non-keyboard input (files, etc).
 * (The advantage of Keyboard is that no additional objects need to be created.)
 *
 * @author 		Dr. Robert Yacobellis
 * @date 		October 15, 2018
 * @version 	1.0 (initial version with just nextInt, nextDouble, next, and nextLine; buggy)
 * @version 	2.0 (added Boolean, String, and Word static functions; still buggy)
 * @version		3.0 (used default methods and method references, replaced nextChar; fixed bugs)
 * @version		3.1 (cleaned up and simplified the hasNext() method - it now just returns true)
 * @version		3.2 (fixed hasNext() and hasNextLine() methods, changed nextChar() to return newlines)
 * @version		3.3 (fixed some edge cases for hasNextChar and nextChar)
 * @version		3.4 (fixed an edge case for hasNext... followed by nextLine in a loop)
 */
 
public class Keyboard  
{   
	private static final Scanner keyboard = new Scanner(System.in); // the connection to the keyboard
	private static Scanner scanner = keyboard; // initially we're reading from the keyboard
	// note: if scanner is pointing to a String then it will scan the part of an input line that
	// remains after nextInt, etc, have run
	private static String remainder; // a String to hold whatever is left over, if scanner != keyboard
	private static boolean nextLineCalled = false; // indicates if the last next... call was nextLine
	
	/*
	 * Keyboard functions provided: 
	 * 		hasNextInt and nextInt, hasNextDouble and nextDouble,
	 *		hasNextBoolean and nextBoolean, hasNext and next, and 
	 *		hasNextLine and nextLine.
	 *		Beyond Scanner, hasNextChar and nextChar are also provided,
	 * 		as well as nextString and nextWord / nextToken and their
	 *		corresponding hasNext methods for naming consistency.
	 */
	
	private static boolean hasNextX(BooleanSupplier scannerHasNextMethod) // general hasNext... method
	{
		boolean result = scannerHasNextMethod.getAsBoolean(); // check if there's an appropriate value available
		// this checks either the keyboard or the remainder string, depending on what variable scanner refers to
		if (scanner == keyboard) // true if there was nothing left after a previous nextInt, etc, or first scan
		{			
			processRemainder(); // this will create a String Scanner if there's more on the line, and will
								// skip past any initial whitespace character that ended a previous next...
		}
		return result;
	}
	
	public static <T> T nextX(Supplier<T> scannerNextMethod) // general next... method
	{   
		T value = scannerNextMethod.get(); // read from keyboard or remainder string, depending on what scanner refers to
		if (scanner != keyboard) // there was something left after a previous nextInt, etc.
			adjustScanner(); // adjust the scanner along the remainder string as necessary, or reconnect to keyboard
		else // true if there was nothing left after a previous nextInt, etc, or this is the first scan
			processRemainder(); // this will create a String Scanner if there's more on the line, and will
								// skip past any initial whitespace character that ended a previous next...
		return value;
	}
	
	public static boolean hasNextInt() // check whether the user entered a valid int
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the int
		return hasNextX(scanner::hasNextInt);
	}
	
	public static int nextInt() // retrieve the next int value, if any, or else throw an exception
	{
		nextLineCalled = false;
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the int
		return nextX(scanner::nextInt); // returned Integer unboxed to int
	}
	
	public static boolean hasNextDouble() // check whether the user entered a valid double
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the double
		return hasNextX(scanner::hasNextDouble);
	}
	
	public static double nextDouble() // retrieve the next double value, if any, or else throw an exception
	{  
		nextLineCalled = false; 
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the double
		return nextX(scanner::nextDouble); // returned Double unboxed to double
	}
	
	public static boolean hasNextBoolean() // check whether the user entered a valid boolean
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the boolean
		return hasNextX(scanner::hasNextBoolean);
	}
	
	public static boolean nextBoolean() // retrieve the next boolean value, if any, or else throw an exception 
	{   
		nextLineCalled = false;
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the boolean
		return nextX(scanner::nextBoolean); // returned Boolean unboxed to boolean
	}
	
	public static boolean hasNextChar() // check whether the user entered a valid char
								 // a "valid" char is any single character, including a newline
	{
		if (scanner != keyboard && remainder.length() == 0)
		{
			if (keyboard.hasNextLine())
				return true; // the previous next... was ended by a newline character
			else
				return false; // hasNextLine should now return false
		}
		return scanner.hasNextLine(); // OK if we still have input left
	}
	
	public static char nextChar()   
	{   
		nextLineCalled = false;
		// note: using next...(), except nextChar(), followed by nextChar(), will skip over *one* whitespace
		// character if one was used to terminate the previous next...(), except for a single newline (nextLine())
		
		char value; // variable to hold the returned character
		if (scanner != keyboard && remainder.length() == 0) // only a newline character is left
		{
			value = '\n'; // return that at the end
			scanner = keyboard; // and move to the next line
		}
		else if (scanner != keyboard) // there was something left over (remainder is not empty)
		{
			value = remainder.charAt(0); // this covers all whitespace characters except newlines (handled above)
			remainder = remainder.substring(1); // remove the character
			scanner = new Scanner(remainder); // and retain what's left in scanner
		}
		else
		{
			remainder = keyboard.nextLine(); // move up next to the next input character, if any
			if (remainder.length() == 0) // if the line received is empty
				value = '\n'; // return the newline character there (next nextChar call will read the next input line)
			else
			{
				value = remainder.charAt(0); // get the initial character to return
				remainder = remainder.substring(1); // remove the character
				scanner = new Scanner(remainder); // and retain what's left in scanner
				// note: this allows two nextChar() calls in a row to read two characters next to one another
			}
		}
		return value;
	}
	
	public static boolean hasNext() // there is always a next token / word unless we are out of input
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the next token
		return hasNextX(scanner::hasNext);
	}
	
	public static boolean hasNextWord() // "alias" for hasNext()
	{
		return hasNext();
	}
	
	public static boolean hasNextToken() // another "alias" for hasNext()
	{
		return hasNext();
	}
	
	public static String next() // read the next token (a series of non-whitespace characters)
	{   
		nextLineCalled = false;
		skipWhiteSpace();
		return nextX(scanner::next);
	}
	
	public static String nextWord() // "alias" for next()
	{
		return next();
	}
	
	public static String nextToken() // another "alias" for next()
	{
		return next();
	}
	
	public static boolean hasNextLine() // there is always a next line unless we are out of input
	{
		return true;
	}
		
	public static boolean hasNextString() // "alias" for hasNextLine()
	{
		return hasNextLine();
	}
	
	public static String nextLine()
	{
		nextLineCalled = true;
		String value = scanner.nextLine(); // read from keyboard or remaining line
		if (scanner != keyboard)			
			// there was something left after a previous nextInt, etc.
			// in this case the read String might be empty or just whitespace ...
			scanner = keyboard; // revert to the keyboard, there's nothing left now
		return value;
	}
	
	public static String nextString() // "alias" for nextLine()
	{
		return nextLine();
	}
	
	/**
	 * This function checks whether there is anything left on the
	 * line that was just scanned, and if so creates a String Scanner
	 * that will be used to pick off parts of that remaining text.
	 */
	 
	private static void processRemainder() // only called if scanner == keyboard
	{
		// System.out.println("in processRemainder, scanner == keyboard: " + (scanner == keyboard)); // DEBUG
		if (!scanner.hasNextLine()) return; // if there's nothing left to process, stop
		remainder = scanner.nextLine(); // pick up the rest of the line, if anything remains
		// System.out.println("in processRemainder, remainder = \"" + remainder + "\""); // DEBUG
		if (remainder.length() == 0) return; // nothing left on the line, leave scanner pointing to keyboard
		// System.out.println("in processRemainder, remainder now = \"" + remainder + "\""); // DEBUG
		if (Character.isWhitespace(remainder.charAt(0))) 
			if (remainder.length() == 1)
				return; // nothing left on the line except a terminating whitespace character from a next... method
			else if (!nextLineCalled) // only do this if the last call wasn't nextLine
				remainder = remainder.substring(1); // skip past the terminating whitespace character
		// don't skip non-whitespace characters!
		
		// System.out.println("at end of processRemainder, creating a Scanner from remainder"); // DEBUG
		// System.out.println("at end of processRemainder, remainder now = \"" + remainder + "\""); // DEBUG
		scanner = new Scanner(remainder); // create a String Scanner to pick off remaining parts (int, double, etc)
	}
	
	/**
	 * This function checks whether there is anything left to scan
	 * in the future, and adjusts scanner to move down that
	 * remaining set of characters so it's positioned correctly for
	 * the next function call: nextInt, nextDouble, etc.
	 */
	 
	private static void adjustScanner() // only called if scanner != keyboard
	{
		// System.out.println("in adjustScanner, scanner == keyboard: " + (scanner == keyboard)); // DEBUG
		if (!scanner.hasNextLine()) // if there's nothing left to process, stop
		{
			scanner = keyboard; // revert to the keyboard, there's nothing left
			return;
		}
		remainder = scanner.nextLine(); // pick up the rest of the remainder
		// System.out.println("in adjustScanner, remainder = \"" + remainder + "\""); // DEBUG
		if (remainder.length() == 0) // if there's nothing left, stop
			scanner = keyboard; // revert to the keyboard
		else if (Character.isWhitespace(remainder.charAt(0))) // check if there's a whitespace char there
			if (remainder.length() == 1) // if the only thing left was a whitespace character, stop
				scanner = keyboard; // revert to the keyboard, there's nothing left
			else
			{
				// a whitespace character ended the previous next...
				remainder = remainder.substring(1); // remove that character ...
				scanner = new Scanner(remainder);  // and move the scanner down the remainder
			}
		// System.out.println("at end of adjustScanner, remainder = \"" + remainder + "\""); // DEBUG
		// System.out.println("at end of adjustScanner, scanner == keyboard: " + (scanner == keyboard)); // DEBUG
	}
	
	private static void skipWhiteSpace() // called by most next... methods: make sure we have a token to process
	{
		if (scanner != keyboard && trimLeft(remainder).isEmpty()) scanner = keyboard;
	}
	
	private static String trimLeft(String s) // remove any whitespace at the front of a string
	{
		if (s == null || s.length() == 0) return s; // no whitespace in this string!
		int index;
		for (index = 0; index < s.length() && Character.isWhitespace(s.charAt(index)); index++);
			// empty for loop - moves index down the String until we get to a non-whitespace character, if any
		return s.substring(index); // if s only contains whitespace characters this returns the empty String
	}
	
	public static String input()
	{
		return input("Enter a line of text: ");
	}
	
	public static String input(String prompt)
	{
		if (prompt == null)
			return input();
		int length = prompt.length();
		if (length == 0)
			return input();
		if (!Character.isWhitespace(prompt.charAt(length-1)))
			prompt += " ";
		System.out.print(prompt);
		return scanner.nextLine();
	}
	
}   