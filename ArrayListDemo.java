import java.util.ArrayList;

public class ArrayListDemo
{
   public static void main(String[] args)
   {
      ArrayList<String> toDoList = new ArrayList<String>();
      System.out.println("Enter items for the list, when prompted.");
      boolean done = false;
      Scanner170 keyboard = new Scanner170(System.in);

      while (!done)
      {
          System.out.println("Type an entry:");
          String entry = keyboard.nextLine( );
          toDoList.add(entry);
          System.out.print("More items for the list? Enter yes or no: ");

          String ans = keyboard.nextLine( );
          if (!ans.equalsIgnoreCase("yes"))
              done = true;
      }

      System.out.println("The list contains:");
      int listSize = toDoList.size( );
      for (int position = 0; position < listSize; position++)
          System.out.println(toDoList.get(position));

/* Alternate code for displaying the list
      System.out.println("The list contains:");
      for (String element : toDoList)
          System.out.println(element);
*/
   }
}