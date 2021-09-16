public class MapFiles {

	Set<Map.Entry <String, String>> values = phonebook.entrySet();

	for(Map.Entry<String, String> e : values)
	{
		System.out.println(e.getKey() + " : " + e.getValue());
		e.setValue("III");
	}
}