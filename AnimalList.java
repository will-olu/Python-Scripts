import java.util.*;
public class AnimalList
{
	private String name;
	private List<String> gut;

	public AnimalList(String name) // constructor – sets instance variables
	{
		this.name = name; this.gut = new ArrayList<String>();
	}
	public String getName()
	{
		return name;
	}
	public void greet()
	{
		System.out.println("Hello, my name is " + name);
	}
	public void eat(String food)
	{
		if (food != null && food.length() != 0) gut.add(food); // don’t consume “empty” calories
	}
	public void excrete()
	{
		if (gut.size() > 0) { String food = gut.remove(0); System.out.println("excreted: " + food); }
	}
	@Override
	public String toString()
	{
		String foodlist = "Animal " + name + " ate: ";
		for (int i = 0; i < gut.size() - 1; i++)
			foodlist += gut.get(i) + ", "; // add all items in gut
		if (gut.size() > 0) return foodlist + gut.get(gut.size() - 1);
		else return foodlist + "nothing";
	}
}