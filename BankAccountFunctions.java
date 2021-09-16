public class BankAccountFunctions
{
    private static Scanner170 keyboard = new Scanner170(System.in);

	/** promptDouble - ask for and return a double
	 *  @param prompt a String to prompt with
	 *  @return a double value read from the keyboard
	 */

	public static double promptDouble(String prompt)
	{
		if (prompt == null || prompt.trim().length() == 0)
				prompt = "Please enter a decimal number: ";
		else
				prompt = prompt.trim() + " "; // make sure prompt has an ending space
		System.out.print(prompt);
		return keyboard.nextDouble();
	}

	/** calculateBalance - compound a balnce at a given interest rate multiple times yearly
	 *  @param balance the initial balance
	 *  @param interestRate the yearly interest rate
	 *  @param years the number of years to compound the balance
	 *  @param timesPerYear the number of times per year interest is accumulated
	 *  @return the compounded balance rounded to 2 decimal places
	 */

	public static double calculateBalance(double balance, double interestRate,
										  int years, int timesPerYear)
	{
		for (int i = 0; i < years * timesPerYear; i++)
				balance *= (1 + interestRate / timesPerYear);
		return balance;
	}

 	/** $ - provide a String that represents a double as a $ value
 	 *  @param value the double to convert to a $ String
 	 *  @return a String representing that double as a $ value
 	 */

 	public static String $(double value)
 	{
 		if (value < 0)
		{
			value = -value;
			return String.format("($%4.2f)", value); // round to 2 decimal places
		}
		return String.format("$%4.2f", value); // round to 2 decimal places
 	}

	/** askYN - ask the user a yes/no question and return character y or n
	 *  @param prompt a String to prompt with
	 *  @return y or n depending on the user's answer
	 */

	public static char askYN(String prompt)
	{
		if (prompt == null || prompt.trim().length() == 0)
				prompt = "Do you want to continue? ";
		else
				prompt = prompt.trim() + " "; // make sure prompt has an ending space
		System.out.print(prompt);

		while (true) // validation loop for the user's answer
		{
			char answer = keyboard.next().toLowerCase().charAt(0); // get the first character
			switch (answer)
			{
				case 'n':
				case 'y':
						return answer; // this leaves the function for these cases
				default:
						System.out.println("You must answer yes or no, please try again: ");
			}
		}
	}

    public static void main(String[] args)
    {
        double initialBalance;
        double interestRate;
        double newBalance; // after 10 years
        char answer; // sentinel to repeat or end program

		// constant number of years to compound the balance (10):
        final int NUM_YEARS = 10;
		// how many times per year to compound the balance:
		final int ANNUALLY = 1;
		final int MONTHLY = 12;
		final int DAILY = 365;

        do // repeat entire program if user says yes
        {
            initialBalance = promptDouble("Please enter an initial balance "
										  + "(dollars.cents):");
            interestRate = promptDouble("Please enter an interest rate in percent "
										+ "(e.g. 5.25) or as a fraction:");
			if (interestRate >= 1.0)
				interestRate /= 100; // assume this is a percentage if >= 1
			String rate = String.format("%.2f", interestRate*100); // to 2 decimal places

			System.out.println(); // for readability

            // Display initial information before calculations
            System.out.println("In ten years an initial balance of $"
                               + initialBalance);
            System.out.println("at an interest rate of "
                               + rate + "% will be worth");

            newBalance = calculateBalance(initialBalance, interestRate,
										  NUM_YEARS, ANNUALLY);
            System.out.println($(newBalance) + " compounded annually");

            newBalance = calculateBalance(initialBalance, interestRate,
										  NUM_YEARS, MONTHLY);
            System.out.println($(newBalance) + " compounded monthly");

            newBalance = calculateBalance(initialBalance, interestRate,
										  NUM_YEARS, DAILY);
            System.out.println($(newBalance) + " compounded daily");

			System.out.println(); // for readability

            answer = askYN("Do you want to do it again?\n" +
						   "Enter y for yes or n for no.");
			if (answer == 'y')
					System.out.println(); // for readability
        } while (answer == 'y');
    }
}
