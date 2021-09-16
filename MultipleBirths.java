import java.util.Scanner170;

public class MultipleBirths
{
    public static void main(String[] args)
    {
        int numberOfBabies;
        System.out.print("Enter number of babies: ");
        Scanner170 keyboard = new Scanner170(System.in);
        numberOfBabies = keyboard.nextInt();
		
        switch (numberOfBabies)
        {
            case 1:
                System.out.println("Congratulations.");
                break;
            case 2:
                System.out.println("Wow. Twins.");
                break;
            case 3:
                System.out.println("Wow. Triplets.");
                break;
            case 4:
            case 5:
                System.out.print("Unbelievable; ");
                System.out.println(numberOfBabies + " babies.");
                break;
            default:
                System.out.println("I don't believe you.");
                break;
        }
    }
}












