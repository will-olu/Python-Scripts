public class AnimalListTest
{
	public static void main(String[] args)
	{
		AnimalList al = new AnimalList("goat");
		al.eat("can");
		al.eat("string");
		al.eat("grass");
		System.out.println(al);
		System.out.println();
		
		al.excrete();
		al.excrete();
		System.out.println(al); // only grass should be left
		System.out.println();
		
		al.excrete();
		al.excrete();
		System.out.println(al); // nothing should be left
	}
}