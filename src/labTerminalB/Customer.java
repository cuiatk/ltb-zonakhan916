package labTerminalB;

import Movie;
import Rental;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
		private String _name;
		private Vector<Rental> _rentals = new Vector<Rental>();
		public Customer (String name){
			_name = name;
		};
		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}
		public String getName (){
			return _name;
		};
		
		/*
		 * TODO 4		20 Marks
		 * Identify the bad smells in the statement method and refactor the code
		 * In case you add a new method also provide specifications for new method
		 * after refactoring all test cases must still be passed
		 * Commit after each change and include a meaningful message about the change you made
		 * e.g. Method Move methodName();
		 * 
		 */
		
		/**
		 * frequentRenterPoints-> added amount in movies's price according to their categories
		 * totalAmount -> total amount after adding rental points in movies's rent
		 * result ->rental record of a customer
		 * return result include all customer name and rental record
		 * Bed smells-> alighment is not correct
		 *  long method
		 *  use of magic number
		 */
		
		public String statement() {  
			double totalAmount = 0;   
			int frequentRenterPoints = 0; 
			Enumeration rentals = _rentals.elements();     
			String result = "Rental Record for " + getName() + "\n";  
			while (rentals.hasMoreElements()) {         
				double thisAmount = 0;         
				Rental each = (Rental) rentals.nextElement(); 
		 
                      thisAmount = amountFor(each); 

      
        result += "\t" + each.getMovie().getTitle()+ "\t" +String.valueOf(thisAmount) + "\n";   
        totalAmount += thisAmount; 

     }        //add footer lines      
		result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";    
		result += "You earned " + String.valueOf(frequentRenterPoints) +   " frequent renter points";      
		return result; 

   } private int amountFor(Rental each) {   
	  int thisAmount = 0;     
  switch (each.getMovie().getPriceCode()) {       
  case Movie.REGULAR:          
	  thisAmount += 2;           
	  if (each.getDaysRented() > 2)            
		  thisAmount += (each.getDaysRented() - 2) * 1.5;       
	  break;         case Movie.NEW_RELEASE:        
		  thisAmount += each.getDaysRented() * 3;   
		  break;         case Movie.CHILDRENS:      
			  thisAmount += 1.5;           
			  if (each.getDaysRented() > 3)                
	  thisAmount += (each.getDaysRented() - 3) * 1.5;     
			  break; 

  }     return thisAmount; }

	}
