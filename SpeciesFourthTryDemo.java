import java.util.Scanner170;

public class SpeciesFourthTryDemo
{
    public static void main(String[] args)
    {
        SpeciesFourthTry speciesOfTheMonth = new SpeciesFourthTry( );

        System.out.println("Enter number of years to project:");
        Scanner170 keyboard = new Scanner170(System.in);
        int numberOfYears = keyboard.nextInt( );

        System.out.println(
                       "Enter data on the Species of the Month:");
        speciesOfTheMonth.readInput( );
        speciesOfTheMonth.writeOutput( );
        int futurePopulation =
             speciesOfTheMonth.predictPopulation(numberOfYears);
        System.out.println("In " + numberOfYears +
						   " years the population will be " +
                           futurePopulation);

        //Change the species to show how to change 
        //the values of instance variables:
		speciesOfTheMonth.setSpecies("Klingon ox", 10, 15);
        System.out.println("The new Species of the Month:");
        speciesOfTheMonth.writeOutput( );

        futurePopulation = 
              speciesOfTheMonth.predictPopulation(numberOfYears);
        System.out.println("In " + numberOfYears +
                           " years the population will be " +
                           futurePopulation);
	}
}


