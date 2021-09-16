/**
 A demonstration program to test two arrays for equality.
*/
public class TestEquals
{
    public static void main(String[] args)
    {
        int[] a = new int[3]; 
		int[] b = new int[3];
		// since new was used twice, these are two different objects
        setArray(a);
		setArray(b);
		
        if (b == a)
            System.out.println("Equal by ==.");
        else
            System.out.println("Not equal by ==.");
			
        if (equals(b, a))
            System.out.println("Equal by the equals method.");
        else
            System.out.println("Not equal by the equals method.");
    }
   
    public static boolean equals(int[] a, int[] b)
    {
		boolean elementsMatch = true; //tentatively
		if (a.length != b.length)
			elementsMatch = false; // must be same length
		else
		{
			int i = 0;
			while (elementsMatch && (i < a.length))
			{
				if (a[i] != b[i])
					elementsMatch = false;
				i++;
			}
		}
	   
		return elementsMatch;
    }

    public static void setArray(int[] array)
    {
		for (int i = 0; i < array.length; i++)
            array[i] = i; // element = array index
    }
}
