public class TestPerson // in file TestPerson.java
{
    public static void main(String[] args)  // for testing the Person class
    {
        Person tommy = new Person(); // create a Person object
        tommy.writeOutput(); // should say no information yet â€“ no name, no age
        System.out.println();
        System.out.println("The following request is for the Person tommy");
 	    tommy.readInput(); // load in information about tommy
        tommy.writeOutput(); // should print out the name and age the user entered
        System.out.println("The following request is also for the Person tommy");
 	    tommy.readInput(); // load in new information about tommy
        tommy.writeOutput(); // should print out the new name and age the user entered
     }
}