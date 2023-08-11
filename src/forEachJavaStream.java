import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class forEachJavaStream {
	
	//@Test
	public void directlyCreateStream() 
	{
		
		//There is no life for intermediate operation if there is no terminal operation like count
		// terminal operation will execute only if intermediate operation(only filter) is true
//		long d=Stream.of("Abhijeet","Don","Adam","Alokanand","Ram").filter(s->s.startsWith("A")).count(); //This can be written as below
		long d=Stream.of("Abhijeet","Don","Adam","Alokanand","Ram").filter(s->
		{
			return s.startsWith("R");
			
			
		}).count();
		System.out.println("This is d :"+d);
		
	}

								//MAP and forEach
	//@Test
	public void streamMap()
	{
		Stream.of("Abhijeet","Dona","Adam","Alokanand","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//print names which starts with a and are sorted
		//Create array list from array and use it to perform above 
		
		List <String> names=Arrays.asList("Azbhijeet","Dona","Adam","Alokanand","Rama");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
	}
	
	//@Test
	public void concatTwoStreams()
	{
		ArrayList<String> names = new ArrayList<String>(); 
		names.add("Abhijeet");
		names.add("Don");
		names.add("Adam");
		names.add("Alokanand");
		names.add("Ram");
		
		List <String> names1=Arrays.asList("Azbhijeet","Dona","Adam","Alokanand","Rama");
		
		//Merging 2 different list
		Stream<String>newStream=Stream.concat(names.stream(), names1.stream());
		//newStream.forEach(s->System.out.println(s));
		
					//Using .match to see if given string is present or not
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
					//Using collect
	@Test
	public void collectStream() 
	{
		//make list -> do manipulation ->convert back to new list
		List <String> ls=Stream.of("Abhijeet","Dona","Adam","Alokanand","Rama")//.filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());			//Converting to list
		System.out.println(ls.get(0)); 			//get first name from list by index
	}
	
					//Stream on integer
	@Test
	public void streamInteger()
	{
		List<Integer>values=Arrays.asList(1,3,7,8,2,2,3,4,6,6,5,9);
		
		//print unique numbers from list
		values.stream().distinct().forEach(s->System.out.println(s));
		
		//sort the list and print 3 number
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("Third num from li sorted list : "+li.get(2));
	}
}

