import java.util.Scanner170;

public class MiddleStrings {

    public static void main(String[] args) {
        System.out.println("Please enter three words separated by spaces");
        // could also ask for three lines of text and read them using nextLine

        Scanner170 reader = new Scanner170(System.in);
        String word1 = reader.next();
        String word2 = reader.next();
        String word3 = reader.next();

        String middle;

        if ( word1.compareTo(word2)<0 && word1.compareTo(word3)<0 ) {
            // word1 is smallest
            if ( word2.compareTo(word3)<0 )
                middle = word2;
            else
                middle = word3;
        } else if ( word2.compareTo(word3)<0 ) { // word1 is not smallest
            // word2 is smallest
            if ( word1.compareTo(word3)<0 )
                middle = word1;
            else
                middle = word3;
        } else // word3 is smallest (neither word1 nor word2 is smallest)
            if ( word1.compareTo(word2)<0 )
                middle = word1;
            else
                middle = word2;

        System.out.println("The middle word is "+ middle);
    }
}