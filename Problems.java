public class Problems
{
    public static void main(String[] args)
    {
        Pet myPet = new Pet("Fido", 3, 10); // name, age, weight
        PetOwner dad = newPetOwner("Dad", myPet);
        dad.writeOutput(); // writes out Dad’s name and Fido’s information
		
        // Problem 1
        myPet.setPet("Rover", 5, 3.2); // this is the same Pet object Dad owns
        dad.writeOutput(); // now writes out Dad’s name and Rover’s information
        // we could do this even though PetOwner did not have any mutator methods
		
        // Problem 2
        Pet petRef = dad.getPet(); // another way to get access to Dad’s Pet object
        petRef.setPet("Lassie", 7, 8.5); // again, this is the same Pet Dad owns
        dad.writeOutput(); // now writes out Dad’s name and Lassie’s information
        // again, we could do this even though PetOwner only has accessor methods
    }
}