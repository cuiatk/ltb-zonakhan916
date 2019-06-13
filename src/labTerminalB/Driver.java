package labTerminalB;

public class Driver {
	/*
	 * TODO 1	10 Marks
	 * Write a regular express at line 10 so that you can remove all html tags from a given string
	 * after you write regular expression the out put should be
	 * The Good, the Bad, and the Ugly
	 * after completing each TODO task commit and push to remote repository with commit message
	 * 		"TODO 'TASK NUMBER' Complete" e.g. in this case "TODO 1 COMPLETED"
	 */
	public static void main(String[] args) {
		String input = "The <b>Good</b>,the<i>bad</i>,and the<strong>Ugly</strong>"; ;
		String regex = "TODO 1";
		String output = input.replaceAll("\\<.*?>","") ;
		System.out.println(output);
		
	
		
		Movie movie1= new Movie("Spancer", 0);
		Movie movie2= new Movie("Speed", 1);
		Movie movie3= new Movie("Blood Diamond", 2);
		
		Customer customer1 = new Customer("Nadir");
		Customer customer2 = new Customer("Allah Ditta");
		
		Rental r1=new Rental(movie2, 5);
		Rental r2=new Rental(movie3, 6);
		Rental r3=new Rental(movie1, 10);
		
		customer1.addRental(r1);
		customer1.addRental(r3);
		
		System.out.println(customer1.statement());

	}

	
}
