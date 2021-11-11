/*
This program contains the introduction that provides the prompt for the program 
*/

//This imports the Java util library 
import java.util.*;

public class ProjectRandomNumbers{
	public static void main(String[] args){
		//Initialize an instance of the Scanner class called console 
		Scanner console = new Scanner(System.in);
		//The main welcome message 
		System.out.println("Welcome User!");
		System.out.println("You tell us what you want and we deliver");
		System.out.println("***********************************************************");
		//A prompt for user name
		System.out.println("But first, what is your name?");
		String userName1 = console.next();
		String userName2 = console.next();		
		
		
		//A prompt for the number of digits. The randomDigits method is called using the digitCount variable as its input	
		System.out.println("Specify the number of digits:");	
		int digitCount = console.nextInt();

		//This creates a Vector to store the desired divisors  
		Vector<Integer> divisors = new Vector();

		//This do while loop prompts the user for successive divisors that the user desires 
		int count = 0;
		int divisor = 1;
		do{
			System.out.println("Enter the desired factor for the number (-1 to stop): ");
			divisor = console.nextInt();
			divisors.add(divisor);
			count++;
		}while(divisor != -1 && count < 4);

		
		
		//We run the randomDigit method until we find a number that is divisible by all the desired factors. 
		boolean bool = true; 
		int number = 0;
		int steps = 0;
		while(bool){//bool
			number = randomDigits(digitCount);
			bool = !conditions(divisors, number);
			steps++;
		}
		

		System.out.println("Hey, " + userName1 + " " + userName2 + ". " + "Your number is " +  number  + " and it took us " + steps + " steps to get it.");
		

	
	}
//*********************************************************************************************************************
	//This generates random digits 
	public static int randomDigits(int numDigits){
        		int maximum = (int)Math.pow(10,numDigits);
        		int minimum = (int)Math.pow(10,(numDigits-1));
       		Random random= new Random();
       		int number = random.nextInt(maximum-minimum)+minimum;
       		return number;
   	}
//*********************************************************************************************************************
	//This generates random digits 
	//This method checks if the number is divisible by all stated factors and returns a boolean
	public static boolean conditions(Vector<Integer> vector, int number){
		int count = 0;
		int comparator = 0;
		for(int i = 0; i < vector.size();i++){
			comparator = vector.get(i);
			if(number % comparator == 0){
				count++;
			}
		}
		return count == vector.size();
	}
}