

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HelloWorld {


	public static void main(String[] args) throws Exception{

		Collection<String> names = new ArrayList<String>();
		
		names.add("anup"); names.add("pankaj"); names.add(null); names.add("anup1");names.add("anup23");names.add("anup4");
		
		long count = names.stream().count();
		
		System.out.print(count);
	
		
		List<Integer> listWithoutNulls = new ArrayList();
		
		listWithoutNulls.add(2); listWithoutNulls.add(2);listWithoutNulls.add(null);
	    listWithoutNulls.removeIf(Objects::isNull);
	 
	    System.out.print(listWithoutNulls);
	    
	    
	    List<String> namesList = new LinkedList();
	    
	    
	}
}
	