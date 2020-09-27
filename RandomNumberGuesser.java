import java.util.Scanner;

/**
 * 
 * @author jmobe
 *
 */
public class RandomNumberGuesser {

	
public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);	//initialize scanner 
		String check;

		
		int randNumd;
		int nextGuess;
		int highGuess = 100;
		int lowGuess = 0;
		int badcount = 0;
		boolean goodGuess;

		do {
			
			System.out.println("You are being asked to guess a random number between 0-100");
			
			/**calls a random number and assigns it to the value randNumd*/
			randNumd = RNG.rand();
			/** This was used in the early stages to confirm that the random number printed equaled
			 * what was being tested
			 * System.out.println(randNumd); 
			 */
			System.out.println("Enter your first guess");
			badcount = 0;
			
		do {	
			
			do {
				nextGuess = keyboard.nextInt();
				/**
				 * @param uses nextGuess, lowGuess, and highGuess in the input validation method
				 */
				goodGuess = RNG.inputValidation(nextGuess, lowGuess, highGuess);
				if (goodGuess == false ) { 
					badcount += 1;
				}
				
			}while(!goodGuess);
			
			/**This line prints the counts minus the amount of badcounts*/
			System.out.println("Number of guesses is " + ( RNG.getCount() - badcount));
				
			if(nextGuess == randNumd) {
				/**breaks out of the wile loop if the guess is equal to the random number*/
				break;
			}
			else if (nextGuess < randNumd) {
				
				System.out.println("Your guess is too low");
				/**takes the maximum of the lowGuess and the guess*/
				lowGuess = Math.max(lowGuess, nextGuess);
			}
			else if(nextGuess> randNumd) {
				
				System.out.println("Your guess is too high");
				/**takes the minimum of the highGuess and the guess*/
				highGuess = Math.min(highGuess, nextGuess); 
				
			}
			
			System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
			
			
		}while(nextGuess!=randNumd);
	
		System.out.println("Congratulations you guessed correctly");
		System.out.println("Try again? (yes or no)");
		check = keyboard.next();
		
		/**Resets the highGuess, lowGuess, and the count in the case of the user requesting to play a new game*/
		highGuess = 100;
		lowGuess = 0;
		RNG.resetCount();
		
	}while(!check.equals("no"));
	
		System.out.print("Thanks for playing...");
	}
	}

