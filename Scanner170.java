import java.util.*;
import java.util.function.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

/**
 * This program provides nextInt, nextDouble, nextBoolean, next, and nextLine 
 * methods like Scanner plus their corresponding has... methods, but avoids
 * the problems caused by intermixing all of them. Scanner170's nextInt,
 * nextDouble, nextBoolean, and next consume all leading whitespace that's 
 * on the same line, including an initial newline (Enter) character if it 
 * follows only whitespace, and they implicitly consume a single whitespace
 * character that ends that token, including possibly a following newline.
 *
 * In addition, this program provides a nextChar function that expects to
 * receive a single character and returns it. Any following next... methods 
 * start reading at a point immediately after that character, so, for example, 
 * entering two characters next to each other and using two nextChar calls 
 * will return both of them in turn. Also, if nextChar is preceded by any
 * next... method except nextChar and nextLine that previous method will
 * consume one whitespace character before nextChar starts reading. If
 * nextChar is preceded by any hasNext... method except hasNextChar and
 * hasNextLine (and its aliases) then all initial whitespace in the remainder
 * will be skipped, even if that causes switching back to the base scanner.
 *
 * Finally, this program adds "aliases" nextString and nextWord / nextToken 
 * and their corresponding hasNext methods for consistency in method naming.
 *
 * This version of Scanner170 uses Java 8 method references.
 * 
 * To use this class, create a Scanner170 object by passing a String to its
 * constructor containing a filename to read from, preceded by "file:", or 
 * else pass InputStream System.in or call the no-parameter constructor to 
 * connect to the keyboard. If the String passed to the constructor is not
 * preceded by "file:" then it is processed directly as a Scanner String.
 * If that String has matching single or double quotes beginning and ending it
 * then those quotes are stripped before passing it to the Scanner constructor.
 * You can also pass any other valid InputStream to a Scanner170 constructor,
 * or any valid File or Path to a Scanner170 constructor. The InputStream, File,
 * and Path constructors optionally take either a String character set name or
 * a Charset object which are used for char translation. Finally, you can pass 
 * System.in as a String to the first constructor to connect to the keyboard.
 * 
 * If the Scanner170 reference variable is named sc then you call its methods
 * on its File/Path/InputStream/String by using sc.hasNext...() or sc.next...().
 *
 * @author 		Dr. Robert Yacobellis
 * @date 		August 4, 2018
 * @version 	1.0 (created from Keyboard.java)
 * @version		1.1 (modified nextChar to allow returning newline characters)
 * @version 	1.2 (added a close method, fixed hasNext & hasNextLine methods)
 * @version		1.3 (changed the String constructor to require file: before a file name)
 * @version		1.3 (otherwise the String is processed directly, unless it is System.in)
 * @version		1.3 (if the String has matching single/double quotes, they are stripped)
 * @version		1.3 (added File, Path, and InputStream constructors to match Scanner's)
 * @version		1.3 (fixed some edge cases for hasNextChar, nextChar, and empty Strings)
 */
 
public class Scanner170
{   
	private Scanner scanner170; // the connection to the input provided by the user/caller
	private Scanner scanner; // shows if we're connected to the input or (part of) a line from the input
	// note: if scanner is pointing to a String then it will scan the part of an input line 
	// that remains after nextInt, etc, have run
	private String remainder; // a String to hold whatever is left if scanner != scanner170
	private boolean stringScanner = false; // processing a String or a File/Path/InputStream?
	private boolean endingNewline = false; // if a scanned String ends in a newline char
	private boolean emptyString = false; // indicates if a scanned String is empty
	private boolean secondEmptyRead = false; // indicates if trying a second empty String read
	private String temp = null; 
	// used to move past scanner170 String's next line in nextLine and skipWhiteSpace
	private final boolean DEBUG = false; // turns on (lots of) debug printing
	
	// next 2 instance vars are for additional Scanner File, Path, & InputStream constructors
	private String charsetName = null; // no charset name String provided
	private Charset charset = null; // no Charset provided
	
	public Scanner170(String filename)
	// constructor for a new Scanner170 object to read from a file, System.in, or a String
	{
		if (filename == null)
		{
			System.out.println("Error: null input String reference");
			System.exit(0);
		}
		else if (filename.equals("System.in"))
		{
			processInputStream(System.in); // special case: connect to keyboard, not a file
		}
		
		if (filename.startsWith("file:"))
		{
			filename = filename.substring(5).trim();
			if (filename.length() == 0)
			{
				System.out.println("Error: empty filename provided");
				System.exit(0);
			}
			
			try {
				File file = new File(filename);
				if (!file.exists() || !file.canRead())
				{
					System.out.println("Error: filename " + filename + " does not exist or can't be read");
					System.exit(0);
				}
				processFile(file); // used by this and the fourth constructor
			}
			catch (Exception e) {
				System.out.println("could not create File object to connect Scanner170 to input file " + filename);
				System.exit(0);
			}
		}
		else
		{
			processString(filename); // process this as a String, not a file
		}		
	}
	
	public Scanner170(InputStream inputStream) 
	// second constructor - read from an InputStream like System.in
	{
		processInputStream(inputStream);
	}
	
	public Scanner170(InputStream inputStream, String charsetName) 
	// second constructor - read from an InputStream like System.in with a character set name
	{
		this.charsetName = charsetName;
		processInputStream(inputStream);
	}
	
	public Scanner170(InputStream inputStream, Charset charset) 
	// second constructor - read from an InputStream like System.in with a character set
	{
		this.charset = charset;
		processInputStream(inputStream);
	}
	
	public Scanner170() // third constructor - read from System.in (like Keyboard.java)
	{
		this(System.in);
	}
		
	public Scanner170(File file) // fourth constructor - read from a File object
	{
		processFile(file);
	}
		
	public Scanner170(File file, String charsetName) 
	// fourth constructor - read from a File object with a character set name
	{
		this.charsetName = charsetName;
		processFile(file);
	}
		
	public Scanner170(File file, Charset charset) 
	// fourth constructor - read from a File object with a character set
	{
		this.charset = charset;
		processFile(file);
	}
		
	public Scanner170(Path path) // fifth constructor - read from a Path object
	{
		processPath(path);
	}
		
	public Scanner170(Path path, String charsetName) 
	// fifth constructor - read from a Path object with a character set name
	{
		this.charsetName = charsetName;
		processPath(path);
	}	
	public Scanner170(Path path, Charset charset) 
	// fifth constructor - read from a Path object with a character set
	{
		this.charset = charset;
		processPath(path);
	}
	
	private void processFile(File file)
	{
		if (file == null)
		{
			System.out.println("Error: null File reference");
			System.exit(0);
		}
		try {
			// assume the File object points to some valid file
			if (charsetName == null && charset == null)
				scanner170 = new Scanner(file);
			else if (charsetName != null)
				scanner170 = new Scanner(file, charsetName);
			else
				scanner170 = new Scanner(file, charset);
			scanner = scanner170; 
			// initially we're reading from scanner170 - use that when we run out of data on an input line
		}			
		catch (Exception e) {
			System.out.println("could not connect Scanner170 to File type " + file.getClass().getName());
			System.exit(0);
		}
	}
	
	private void processPath(Path path)
	{
		if (path == null)
		{
			System.out.println("Error: null Path reference");
			System.exit(0);
		}
		try { 
			// assume the Path object points to some valid file
			if (charsetName == null && charset == null)
				scanner170 = new Scanner(path);
			else if (charsetName != null)
				scanner170 = new Scanner(path, charsetName);
			else
				scanner170 = new Scanner(path, charset);
			scanner = scanner170; 
			// initially we're reading from scanner170 - use that when we run out of data on an input line
		}			
		catch (Exception e) {
			System.out.println("could not connect Scanner170 to Path type " + path.getClass().getName());
			System.exit(0);
		}
	}
	
	private void processInputStream(InputStream inputStream)
	{
		if (inputStream == null)
		{
			System.out.println("Error: null InputStream reference");
			System.exit(0);
		}
		try { 
			// assume the InputStream object points to some valid InputStream
			if (charsetName == null && charset == null)
				scanner170 = new Scanner(inputStream);
			else if (charsetName != null)
				scanner170 = new Scanner(inputStream, charsetName);
			else
				scanner170 = new Scanner(inputStream, charset);
			scanner = scanner170; 
			// initially we're reading from scanner170 - use that when we run out of data on an input line
		}			
		catch (Exception e) {
			System.out.println("could not connect Scanner170 to InputStream type " + inputStream.getClass().getName());
			System.exit(0);
		}
	}
	
	private void processString(String inputString)
	{
		stringScanner = true; // this is a String, not an InputStream, File, or Path
		int length = inputString.length();
		if (length > 1) // the String might contain beginning and ending matching quote marks
		{
			char first = inputString.charAt(0);
			if (inputString.charAt(0) == '"' || inputString.charAt(0) == '\'')
				if (inputString.charAt(length-1) == first) // if matching quotes ...
				{
					inputString = inputString.substring(1, length-1); // strip quotes from String
					length -= 2; // and adjust the input String's length to match new version
				}
		}
		if (length > 0 && inputString.charAt(length - 1) == '\n')
			endingNewline = true; // record that this input String ends in a newline char
		if (length == 0)
			emptyString = true;
		if (DEBUG)
			System.out.println("emptyString: " + emptyString);
		scanner170 = new Scanner(inputString);
		scanner = scanner170;
	}
	
	public void close() // allows IO.java and other programs to close the Scanner
	{
		scanner170.close();
		stringScanner = false; // reset to normal File/InputStream-related behavior
		scanner170 = null; // assure future calls on this Scanner170 object throw exceptions
		scanner = scanner170;
	}
	
	/*
	 * Scanner170 methods provided: 
	 * 		hasNextInt and nextInt, hasNextDouble and nextDouble,
	 *		hasNextBoolean and nextBoolean, hasNext and next, and 
	 *		hasNextLine and nextLine, all of which match Scanner's.
	 *		Beyond Scanner, hasNextChar and nextChar are also provided,
	 * 		as well as nextString and nextWord / nextToken and their
	 *		corresponding hasNext methods for naming consistency.
	 */
	
	private boolean hasNextX(BooleanSupplier scannerHasNextMethod) // general hasNext... method
	{
		if (emptyString || secondEmptyRead) // there is no remaining input for these cases
		{
			scanner = scanner170;
			return false;
		}
		boolean result = scannerHasNextMethod.getAsBoolean(); 
		// check if there's an appropriate value available
		// this checks either the scanner170 or the remainder string, 
		// depending on what variable scanner refers to
		if (scanner == scanner170) 
		// true if there was nothing left after a previous nextInt, etc, or first scan
		{			
			processRemainder(); // this will create a String Scanner if there's more on the
								// line, and will skip past any initial whitespace character 
								// that ended a previous next...
		}
		return result; // true/false
	}
	
	public <T> T nextX(Supplier<T> scannerNextMethod) // general next... method
	{   
		T value = scannerNextMethod.get(); 
		// read from scanner170 or remainder string, depending on what scanner refers to
		if (DEBUG)
			System.out.println("in nextX scanner == scanner170: " + (scanner == scanner170)); // DEBUG
		if (scanner != scanner170) // there was something left after a previous nextInt, etc.
			adjustScanner(); 
			// adjust the scanner along remainder string as needed, or reconnect to scanner170
		else
		// true if there was nothing left after a previous nextInt, etc, or this is first scan
			processRemainder(); // this will create a String Scanner if there's more on the
								// line, and will skip past any initial whitespace character 
								// that ended a previous next...
		return value; // wrapper object to be autounboxed to required primative
	}
	
	public boolean hasNextInt() // check whether the user entered a valid int
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the int
		return hasNextX(scanner::hasNextInt);
	}
	
	public int nextInt() // retrieve the next int value, if any, or else throw an exception
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the int
		return nextX(scanner::nextInt); // returned Integer unboxed to int
	}
	
	public boolean hasNextDouble() // check whether the user entered a valid double
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the double
		return hasNextX(scanner::hasNextDouble);
	}
	
	public double nextDouble() // retrieve the next double value, if any, or else throw an exception
	{   
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the double
		return nextX(scanner::nextDouble); // returned Double unboxed to double
	}
	
	public boolean hasNextBoolean() // check whether the user entered a valid boolean
	{
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the boolean
		return hasNextX(scanner::hasNextBoolean);
	}
	
	public boolean nextBoolean() // retrieve the next boolean value, if any, or else throw an exception 
	{   
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the boolean
		return nextX(scanner::nextBoolean); // returned Boolean unboxed to boolean
	}
	
	public boolean hasNextChar() // check whether the user entered a valid char
								 // a "valid" char is any single character, including a newline
	{
		if (scanner != scanner170 && remainder.length() == 0)
		{
			if (scanner170.hasNextLine())
				return true; // the previous next... was ended by a newline character
			if (DEBUG)
				System.out.println("in hasNextChar endingNewline == " + endingNewline); // DEBUG
			if (endingNewline) // true if String scanner and String ended in a newline char
			{
				endingNewline = false; // we have consumed the input's ending newline char
				return true; // nextChar will return the consumed newline
			}
			else
				return false; // there is no remaining character to read
		}
		return scanner.hasNextLine(); // OK if we still have input left from remainder
	}
	
	public char nextChar()   
	{   	
		// note: using next...(), except nextChar(), followed by nextChar(), will skip over 
		// *one* whitespace character if one was used to terminate the previous next...(), 
		// except for a single newline (nextLine())
		
		char value; // variable to hold the returned character
		if (scanner != scanner170 && remainder.length() == 0) // only a newline char is left
		{
			if (DEBUG)
				System.out.println("in nextChar remainder.length() == 0"); // DEBUG
			value = '\n'; // return that at the end
			scanner = scanner170; // and move to the next line or part of the String
		}
		else if (scanner != scanner170) // there was something left over (remainder is not empty)
		{
			if (DEBUG)
				System.out.println("in nextChar scanner != scanner170"); // DEBUG
			value = remainder.charAt(0); 
			// this covers all whitespace characters except newlines (handled above)
			remainder = remainder.substring(1); // remove the character
			scanner = new Scanner(remainder); // and retain what's left in scanner
		}
		else
		{
			if (DEBUG)
				System.out.println("in nextChar reading scanner170 nextLine"); // DEBUG
			if (DEBUG)
				System.out.println("in nextChar about to call nextLine directly"); // DEBUG
			remainder = nextLine(); // move up next to the next input character, if any
			if (DEBUG)
				System.out.println("in nextChar remainder = \"" + remainder + "\""); // DEBUG
			if (remainder.length() == 0) // if the line received is empty
				value = '\n'; 
				// return the newline char there (next nextChar call will read the next char)
			else
			{
				value = remainder.charAt(0); // get the initial character to return
				if (DEBUG)
					System.out.println("in nextChar value = \"" + value + "\""); // DEBUG
				remainder = remainder.substring(1); // remove the character
				if (DEBUG)
					System.out.println("in nextChar remainder = \"" + remainder + "\""); // DEBUG
				scanner = new Scanner(remainder); // and retain what's left in scanner
				if (DEBUG)
					System.out.println("in nextChar scanner.hasNextLine == " + scanner.hasNextLine()); // DEBUG
				// note: this allows two nextChar() calls in a row to read two characters
				// next to one another
			}
		}
		if (DEBUG)
			System.out.println("at end of nextChar value = \"" + value + "\""); // DEBUG
		return value;
	}
	
	public boolean hasNext() // there is always a next token / word unless we are out of input
	{
		if (emptyString || secondEmptyRead) // there is no remaining token in those cases
		{
			scanner = scanner170;
			return false;
		}
		skipWhiteSpace(); // make sure we skip any whitespace before looking for the next token
		return hasNextX(scanner::hasNext);
	}
	
	public boolean hasNextWord() // "alias" for hasNext()
	{
		return hasNext();
	}
	
	public boolean hasNextToken() // another "alias" for hasNext()
	{
		return hasNext();
	}
	
	public String next() // read the next token (a series of non-whitespace characters)
	{   
		if (emptyString)
		{
			scanner = scanner170;
			emptyString = false;
			secondEmptyRead = true;
			return "";
		}
		else if (secondEmptyRead)
			return null;
		skipWhiteSpace();
		return nextX(scanner::next);
	}
	
	public String nextWord() // "alias" for next()
	{
		return next();
	}
	
	public String nextToken() // another "alias" for next()
	{
		return next();
	}
	
	public boolean hasNextLine() // there is always a next line unless we are out of input
	{
		if (secondEmptyRead)
			return false; // second and subsequent reads from an empty String should fail
		if (emptyString)
		{
			scanner = scanner170;
			return true; // there is a next line, and it's empty
		}
		return scanner.hasNextLine(); // do not skip over whitespace in this case!
	}
		
	public boolean hasNextString() // "alias" for hasNextLine()
	{
		return hasNextLine();
	}
	
	public String nextLine()
	{
		String value = null;
		if (emptyString)
		{
			value = "";
			emptyString = false;
			secondEmptyRead = true;
			scanner = scanner170;
		}
		else if (stringScanner && scanner.hasNextLine())
			value = scanner.nextLine(); // read from scanner170 or remaining line
		else if (scanner.hasNextLine()) // not a String Scanner
		{
			try {
				value = scanner.findWithinHorizon("^.*?\\R", Integer.MAX_VALUE); 
				// try to read through a newline char - so we can tell if there is one left!
				if (DEBUG)
					System.out.println("in nextLine value = \"" + value + "\""); // DEBUG
				if (value == null) // there wasn't a newline character left in the input
				{
					endingNewline = false;
					value = scanner.nextLine(); // read from scanner170 or remaining line
				}
				else
				{
					endingNewline = true;
					Scanner sc = new Scanner(value); // temp String Scanner for what we found
					value = sc.nextLine(); // remove ending newline (nextLine stops there) 
					sc.close();
					if (DEBUG)
						System.out.println("in nextLine value = \"" + value + "\""); // DEBUG
					if (DEBUG)
						System.out.println("in nextLine scanner.hasNextLine = " + scanner.hasNextLine()); // DEBUG
				}
			}
			catch (Exception e) // searching for missing final newline may throw an exception
			{
				value = scanner.nextLine(); // but in that case nextLine still works
			}
		}
		else if (scanner170.hasNextLine())
			value = "\n";
		else
			value = null;
		if (DEBUG)
			System.out.println("in nextLine value = \"" + value + "\""); // DEBUG
		if (scanner != scanner170)
		{
			if (DEBUG)
				System.out.println("in nextLine scanner != scanner170"); // DEBUG
			if (DEBUG)
				System.out.println("in nextLine moving past scanner170 nextLine"); // DEBUG
			// there was something left after a previous nextInt, etc.
			// in this case the read String might be empty or just whitespace ...
			if (stringScanner) // if this Scanner is reading from a String
				temp = scanner170.nextLine(); // move past the previously processed line
			scanner = scanner170; // revert to the scanner170, there's nothing left now
		}
		return value;
	}
	
	public String nextString() // "alias" for nextLine()
	{
		return nextLine();
	}
	
	/**
	 * This function checks whether there is anything left on the
	 * line that was just scanned, and if so creates a String Scanner
	 * that will be used to pick off parts of that remaining text.
	 */
	 
	private void processRemainder() // should only be called if scanner == scanner170
	{
		if (DEBUG)
			System.out.println("in processRemainder, scanner == scanner170: " + (scanner == scanner170)); // DEBUG
		if (!scanner.hasNextLine()) return; // if there's nothing left to process, stop
		remainder = scanner.nextLine(); // pick up the rest of the line, if anything remains
		if (DEBUG)
			System.out.println("in processRemainder, remainder = \"" + remainder + "\""); // DEBUG
		if (remainder.length() == 0) return; // nothing left on the line, leave scanner pointing to scanner170
		if (DEBUG)
			System.out.println("in processRemainder, remainder now = \"" + remainder + "\""); // DEBUG
		if (Character.isWhitespace(remainder.charAt(0))) 
			if (remainder.length() == 1)
				return; // nothing left on the line except a terminating whitespace character from a next... method
			else
				remainder = remainder.substring(1); // skip past the terminating whitespace character
		// don't skip non-whitespace characters!
		
		if (DEBUG)
			System.out.println("at end of processRemainder, remainder now = \"" + remainder + "\""); // DEBUG
		if (DEBUG)
			System.out.println("at end of processRemainder, creating a Scanner from remainder"); // DEBUG
		scanner = new Scanner(remainder); 
		// create a String Scanner to pick off remaining parts (int, double, etc)
	}
	
	/**
	 * This function checks whether there is anything left to scan
	 * in the future, and adjusts scanner to move down that
	 * remaining set of characters so it's positioned correctly for
	 * the next function call: nextInt, nextDouble, etc.
	 */
	 
	private void adjustScanner() // should only be called if scanner != scanner170
	{
		if (DEBUG)
			System.out.println("in adjustScanner, scanner == scanner170: " + (scanner == scanner170)); // DEBUG
		if (!scanner.hasNextLine()) // if there's nothing left to process, stop
		{
			scanner = scanner170; // revert to the scanner170, there's nothing left
			return;
		}
		remainder = scanner.nextLine(); // pick up the rest of the remainder
		if (DEBUG)
			System.out.println("in adjustScanner, remainder = \"" + remainder + "\""); // DEBUG
		if (remainder.length() == 0) // if there's nothing left, stop
			scanner = scanner170; // revert to the scanner170
		else if (Character.isWhitespace(remainder.charAt(0))) // check if there's a whitespace char there
			if (remainder.length() == 1) // if the only thing left was a whitespace character, stop
				scanner = scanner170; // revert to the scanner170, there's nothing left
			else
			{
				// a whitespace character ended the previous next...
				remainder = remainder.substring(1); // remove that character ...
				scanner = new Scanner(remainder);  // and move the scanner down the remainder
			}
		if (DEBUG)
			System.out.println("at end of adjustScanner, remainder = \"" + remainder + "\""); // DEBUG
		if (DEBUG)
			System.out.println("at end of adjustScanner, scanner == scanner170: " + (scanner == scanner170)); // DEBUG
	}
	
	private void skipWhiteSpace() 
	// called by most hasNext... and next... methods: make sure we have a token to process
	{
		if (DEBUG)
			System.out.println("in skipWhiteSpace remainder = \"" + remainder + "\""); // DEBUG
		if (DEBUG)
			System.out.println("in skipWhiteSpace scanner == scanner170: " + (scanner == scanner170)); // DEBUG
		if (scanner != scanner170 && trimLeft(remainder).isEmpty())
		{
			if (DEBUG)
				System.out.println("in skipWhiteSpace moving past scanner170 nextLine"); // DEBUG
			if (stringScanner) // if this Scanner is reading from a String
				temp = scanner170.nextLine(); // move past the previously processed line
			scanner = scanner170; // revert to the scanner170, there's nothing left
		}
	}
	
	private String trimLeft(String s) // remove any whitespace at the front of a string
	{
		if (s == null || s.length() == 0) return s; // no whitespace in this string!
		int index;
		for (index = 0; index < s.length() && Character.isWhitespace(s.charAt(index)); index++);
			// empty for loop - moves index down the String until we get to a non-whitespace character, if any
		return s.substring(index); 
		// if s only contains whitespace characters this returns the empty String
	}
	
	private String getRemainder()
	{
		return remainder;
	}
	
	private boolean isScanner170()
	{
		if (scanner == scanner170)
			return true;
		return false;
	}
}   