import java.util.ArrayList;


public class JSTRM {

	public static void main(String[] args) 
	{
		ArrayList<String> names = new ArrayList<String>();
  		names.add("Arizona");
  		names.add("Alabama");
  		names.add("Massachusettes");
  		names.add("California");
  		names.add("America");
  		int count=0;
  		
  		for(String nm : names)
  		{
  			System.out.println(nm);
  			
  			if(nm.startsWith("A"))
  				{
  					count++;
  				}
  		}
  		
  		System.out.println(count);
  	}
	
	/*
	public void filterStram()
	{
		ArrayList<String> names = new ArrayList<String>();
  		names.add("Arizona");
  		names.add("Alabama");
  		names.add("Massachusettes");
  		names.add("California");
  		names.add("America");
  	
	    long c = names.stream().filter(i -> i.startsWith("A")).count();
		System.out.println(c);
	    
	
	}*/


	}
