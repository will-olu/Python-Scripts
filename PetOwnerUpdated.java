public class PetOwnerUpdated // in PetOwnerUpdated.java
{
    private String owner = ""; // the PetOwner’s name – Strings are immutable, they don’t need protecting
    private Pet pet; // the PetOwner's pet - Pet's are not immutable, they must be protected

    public PetOwnerUpdated(String owner, Pet pet) // the only constructor
    {
         this.owner = owner;
		 this.pet = new Pet(pet.getName(), pet.getAge(), pet.getWeight());
    } // now the PetOwner pet instance variable refers to a new Pet object with the same data

    public void writeOutput()
    {
         System.out.println("Hi, I’m " + owner + " and this is my pet:");
		 pet.writeOutput();
    }

    public String getOwner() { return owner; } // standard getter methods
    public Pet getPet() { return new Pet(pet.getName(), pet.getAge(), pet.getWeight()); }
	// getPet() now returns a different Pet object from the one PetOwner refers to
}