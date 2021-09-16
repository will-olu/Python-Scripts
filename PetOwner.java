public class PetOwner // in PetOwner.java
{
    private String owner = ""; // the PetOwner’s name – Strings are immutable, they don’t need protecting
    private Pet pet; // the PetOwner's pet - Pet's are not immutable, they must be protected

    public PetOwner(String owner, Pet pet) // the only constructor
    {
         this.owner = owner; this.pet = pet;
    }

    public void writeOutput()
    {
         System.out.println("Hi, I’m " + owner + " and this is my pet:");
		 pet.writeOutput();
    }

    public String getOwner() { return owner; } // standard getter methods
    public Pet getPet() { return pet; }
}