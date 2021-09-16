import java.util.Scanner170;

public class BankBalance
{
    public static final double OVERDRAWN_PENALTY = 8.00;
    public static final double INTEREST_RATE = 0.02;//2% annually
	
    public static void main(String[] args)
    {
        double balance;
		
        System.out.print("Enter your checking account balance: $");
        Scanner170 keyboard =  new Scanner170(System.in);
        balance = keyboard.nextDouble( );
        System.out.println("Original balance $" + balance);
		
        if (balance >= 0)
            balance = balance + (INTEREST_RATE * balance)/12;
        else
            balance = balance - OVERDRAWN_PENALTY;
			
        System.out.println("After adjusting for one month");
        System.out.println("of interest and penalties,");
        System.out.println("your new balance is $" + balance);
    }
}
