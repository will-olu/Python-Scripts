public class TestContact
{
  public static void main(String[] args)
  {
	 Contact c1 = new Contact("Marie Ortiz", "773-508-7890", 
							  "mortiz2@luc.edu");
	 Contact c2 = new Contact("Otto Heinz", "773-508-9999", 
							  "oheinz@luc.edu");
	 System.out.println("Marie's full name: " + c1.getName());
	 System.out.println("Her phone number: " + c1.getPhone());
	 System.out.println("Her email: " + c1.getEmail());         
	 System.out.println("\nFull contact info for Otto:");
	 c2.print(); 
  }
}