public class Pet
{
    private String name;
    private int age;      //in years
    private double weight;//in pounds
    
    public Pet(String initialName, int initialAge, 
               double initialWeight)
    {
        setPet(initialName, initialAge, initialWeight);
    }
	
    public void setPet(String newName, int newAge, double newWeight)
    {
        name = newName;
        if ((newAge < 0) || (newWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = newAge;
            weight = newWeight;
        }
    }

    public Pet(String initialName)
    {
        setPet(initialName, 0, 0);
    } 
    
    public void setName(String initialName)
    {
        setPet(initialName, age, weight); //age and weight are unchanged.
    }
    
    public Pet(int initialAge)
    {
        setPet("No name yet.", initialAge, 0);
    }
    
    public void setAge(int newAge)
    {
        setPet(name, newAge, weight); //name and weight are unchanged. 
    }

    public Pet(double initialWeight)
    {
        setPet("No name yet.", 0, initialWeight);
    }
	
    public void setWeight(double newWeight)
    {
        setPet(name, age, newWeight); //name and age are unchanged.
    }
    
    public Pet( )
    {
        setPet("No name yet.", 0, 0); 
    }
    
    public String getName( )
    {
        return name;
    }
    
    public int getAge( )
    {
        return age;
    }
    
    public double getWeight( )
    {
        return weight;
    }

    public void writeOutput( )
    {
        System.out.println("Name:   " + name);
        System.out.println("Age:    " + age + " years");
        System.out.println("Weight: " + weight + " pounds");
    }
	
	public static void main(String[] args)
	{
		Pet[] pets = new Pet[3]; // create a Pet array to hold the 3 Pets
		for (int i = 0; i < pets.length; i++)
		{
			// read info for a pet from the user: name, age, weight
			Pet[i] = new Pet(name, age, weight);
		}
		// other parts of the program
	}
}
