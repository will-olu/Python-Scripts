import java.util.Scanner170;

class WarpCalculator
{
	public static void main(String[] args)
	{
		// constants
		final int secondsPerMinute = 60;
		final int secondsPerHour = 60 * secondsPerMinute;
		final int secondsPerDay = 24 * secondsPerHour;
		final int secondsPerYear = 365 * secondsPerDay;
		
		// variables
		int years, days, hours, minutes, seconds, remainder, totalSeconds;
		double WF; // Warp Factor
		double velocity;
		
		System.out.println("This program will convert a distance in light years at");
		System.out.println("a given Warp Factor to the time to cover that distance,");
		System.out.println("or will tell you what Warp Factor to use to cover a");
		System.out.println("given distance in a given time (if this is possible).");
		System.out.println();
		System.out.println("You can do multiple/repeated calculations if so desired.");
		System.out.println();

		Scanner170 keyboard = new Scanner170(System.in);
		
		while (true)
		{
			System.out.println("Please choose what you want to calculate:,");
			System.out.print("T for time or W for Warp Factor: ");
			String choice = keyboard.next();
			while (!choice.equalsIgnoreCase("T") && !choice.equalsIgnoreCase("W"))
			{
				System.out.print("That's not a valid choice, enter T or W: ");
				choice = keyboard.next();
			}
			
			System.out.println();
			System.out.print("Please enter a positive number of light years: ");
			double lightYears = keyboard.nextDouble();
			while (lightYears < 0)
			{
				System.out.print("Please enter a POSITIVE number of light years: ");
				lightYears = keyboard.nextDouble();
			}
			double meters = lightYears * 9.461e15;
			
			if (choice.equalsIgnoreCase("T"))
			{
				System.out.print("Please enter a Warp Factor (WF) between 0 and 10: ");
				WF = keyboard.nextDouble();
				while (WF <= 0 || WF > 10)
				{
					System.out.print("Please enter WF in the correct range: ");
					WF = keyboard.nextDouble();
				}

				totalSeconds = (int) (meters / (Math.pow(7, WF) * 42_827_494));
				// from formula v (m/s) = 7^WF SAU/s * 42_827_494 m/SAU

				years = totalSeconds / secondsPerYear;
				remainder = totalSeconds % secondsPerYear;
				days = remainder / secondsPerDay;
				remainder = remainder % secondsPerDay;
				hours = remainder / secondsPerHour;
				remainder = remainder % secondsPerHour;
				minutes = remainder / secondsPerMinute;
				seconds = remainder % secondsPerMinute;

				System.out.println();
				System.out.println("At Warp " + WF + " it will take " +
					years + " years, " + days + " days, " + hours + " hours, ");
				System.out.println(minutes + " minutes, and " + seconds + " seconds " +
					"to cover " + lightYears + " light years.");
			}
			else
			{
				System.out.println("Please enter the time you want to take to cover that distance:");
				totalSeconds = 0; // total number of seconds to cover distance
				
				System.out.print("Enter a positive number of years (0 if none): ");
				years = keyboard.nextInt();
				if (years < 0)
				{
					System.out.println("Negative years not allowed, 0 assumed.");
					years = 0;
				}
				totalSeconds += years * secondsPerYear;
				
				System.out.print("Enter a positive number of days (0 if none): ");
				days = keyboard.nextInt();
				if (days < 0)
				{
					System.out.println("Negative days not allowed, 0 assumed.");
					years = 0;
				}
				totalSeconds += days * secondsPerDay;
				
				System.out.print("Enter a positive number of hours (0 if none): ");
				hours = keyboard.nextInt();
				if (hours < 0)
				{
					System.out.println("Negative hours not allowed, 0 assumed.");
					years = 0;
				}
				totalSeconds += hours * secondsPerHour;
				
				System.out.print("Enter a positive number of minutes (0 if none): ");
				minutes = keyboard.nextInt();
				if (minutes < 0)
				{
					System.out.println("Negative minutes not allowed, 0 assumed.");
					years = 0;
				}
				totalSeconds += minutes * secondsPerMinute;
				
				System.out.print("Finally, enter a positive number of seconds (0 if none): ");
				seconds = keyboard.nextInt();
				if (seconds < 0)
				{
					System.out.println("Negative seconds not allowed, 0 assumed.");
					years = 0;
				}
				totalSeconds += seconds;
				System.out.println();
				if (totalSeconds == 0)
				{
					System.out.println("0 seconds travel time requires infinite velocity, request ignored");
				}
				else
				{
					System.out.println(String.format("Total number of meters to travel = %g.", meters));
					System.out.println("Total amount of time (in seconds) requested = " + totalSeconds + ".");
					
					velocity = meters / totalSeconds;
					System.out.println(String.format("Velocity requested = %g m/s.", velocity));
					
					if (meters == 0)
						WF = 0;
					else
						WF = -(Math.log10(42_827_494 / velocity) / Math.log10(7));
					
					if (WF < 0 || WF > 10)
						System.out.println(String.format("Illegal Warp Factor calculated: %f.%n", WF));
					else
						System.out.println(String.format("Required Warp Factor is %f.", WF));
				}
			}
			
			System.out.println();
			System.out.print("Do you want to do another calculation? Enter y or n: ");
			choice = keyboard.next();
			if (!choice.equalsIgnoreCase("y")) 
				break;
			
			System.out.println();
		}
	}
}