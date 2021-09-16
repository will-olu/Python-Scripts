// this is Practice Program 4
public class SemanticError
{
 public static void main(String[] args)
 {
   int height=0, width=0, depth=0;
   System.out.println("Enter the height, width, and depth of");
   System.out.println("a box and I will compute the volume.");
   Scanner170 keyboard = new Scanner170(System.in);
   height = keyboard.nextInt();
   width = keyboard.nextInt();
   int volume = height * width * depth;
   System.out.println("The volume is " + volume);
 }
}
