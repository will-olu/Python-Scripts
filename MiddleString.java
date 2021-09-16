import java.util.Scanner170;

public class MiddleString {

    public static void main(String[] args) {
        System.out.println("Please enter three words separated by spaces");
        // could also ask for three lines of text and read them using nextLine

        Scanner170 reader = new Scanner170(System.in);
        String word1 = reader.next();
        String word2 = reader.next();
        String word3 = reader.next();

        String middle;

		// compare each string in turn to see if it's between the other two
        if ( word1.compareTo(word2)<=0 && word2.compareTo(word3)<=0 || // ascending order
			 word3.compareTo(word2)<=0 && word2.compareTo(word1)<=0) { // descending order
            // word2 is the middle word
            middle = word2;
        } else if( word2.compareTo(word3)<=0 && word3.compareTo(word1)<=0 || // ascending order
				   word1.compareTo(word3)<=0 && word3.compareTo(word2)<=0) { // descending order
            // word3 is the middle word
            middle = word3;
        } else
            middle = word1; // word1 is the middle word

        System.out.println("The middle word is "+ middle);
    }
}