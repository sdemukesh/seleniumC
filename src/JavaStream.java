
import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;



public class JavaStream {

	// Count the number names starting with A in list
	//@Test
	public void regular() 
	{
	ArrayList<String> names = new ArrayList<String>(); 
	names.add("Abhijeet");
	names.add("Boss");
	names.add("Adam");
	names.add("Alokanand");
	names.add("Ram");
	
	int count=0;
	for(int i=0;i<names.size();i++)
	{
		String actual =names.get(i);
		if(actual.startsWith("B"))
		{
			count++;
		}
	}
	System.out.println(count);

	}
	
	@Test
	public void streamFilters()
	{
		ArrayList<String> names = new ArrayList<String>(); 
		names.add("Abhijeet");
		names.add("Don");
		names.add("Adam");
		names.add("Alokanand");
		names.add("Ram");
		
		//converting list into stream by .stream()
		//Using intermediate filter() method in stream and terminating method count()
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("This is c : "+c);
		
		//this will get all the names greater than 4 here we see use of forEach and used limit get limited result
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	//Directly creating a stream with list in it
	@Test
	public void directlyCreateStream() 
	{
		//There is no life for intermediate operation if there is no terminal operation like count
		// terminal operation will execute only if intermediate operation(only filter) is true
		//Stream.of("Abhijeet","Don","Adam","Alokanand","Ram").filter(s->s.startsWith("A")).count(); //This can be written as below
		long d=Stream.of("Abhijeet","Don","Adam","Alokanand","Ram").filter(s->
		{
			return s.startsWith("A");
			
		}).count();
		System.out.println("This is d :"+d);
	}
	
}
