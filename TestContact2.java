public class TestContact2
{																				// main chunk																					 
	public static void main(String[] args)
	{
	 Contact c1 = new Contact2("Marie Ortiz", "773-508-7890", 
								"mortiz2@luc.edu");
	 Contact c2 = new Contact2("Otto Heinz", "773-508-9999", 
								"oheinz@luc.edu");
	 System.out.println("Marie's full name: " + c1.getName());
	 System.out.println("Her phone number: " + c1.getPhone());
	 System.out.println("Her email: " + c1.getEmail());				 
	 System.out.println("All together:\n{0}", c1); 
	 System.out.println("Full contact info for Otto:");
	 c2.print(); 
	 c1.setEmail("maria.ortiz@gmail.com");
	 c2.setPhone("123-456-7890");
	 System.out.println(c1);
	 System.out.println(c2);
	 }
	}
}																			 // end of chunk