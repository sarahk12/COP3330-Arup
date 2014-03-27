import java.util.Scanner;

/*
 *  @author Sarah Kidd (www.linkedin.com/in/sarahkidd/)
 *	Description of problem at: http://www.cs.ucf.edu/~dmarino/ucf/transparency/cop3330/asgn/
 */
public class Slot {
	private double amount = 0.00;
	private boolean first = true;
	public static void main(String[] args) {
		Slot slot = new Slot();
		slot.menu();
	}
	
	public void menu() {
		if (first == true) {
			System.out.println("Welcome to the slot machine!");
			amount = 10.00;
			first = false;
		}
		else if (amount == 0) {
			System.out.println("You have no money to play anymore. Better luck next time!");
			System.exit(0);
		}
		System.out.printf("You have $%.2f\n", amount);
		System.out.println("Choose one of the following menu options:");
		System.out.println("1. Play the slot machine.");
		System.out.println("2. Cash out.");
		userInput();
	}
	
	public void userInput() {
		try (Scanner scanner = new Scanner(System.in)) {
			int input = scanner.nextInt();
			if (input == 1) {
				playSlot();
			}
			else if(input == 2) {
				cashOut();
			}
			else {
				System.out.println("Input not recognized, try again:");
				userInput();
			}
		}
	}
	
	public void playSlot() {
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);
		int num3 = (int) (Math.random() * 10);
		amount = amount - .25;
		System.out.printf("The slot machine shows %d%d%d.\n", num1, num2, num3);
		if ((num1 == num2) && (num1 == num3)) {
			amount = amount + 10;
			System.out.println("You win the big prize, $10.00!");
		}
		else if ((num1 == num2) || (num1 == num3) || (num2 == num3)) {
			amount = amount + .5;
			System.out.println("You win 50 cents!");
		}
		else {
			System.out.println("Sorry, you don't win anything.");
		}
		System.out.println();
		menu();
	}
	
	public void cashOut() {
		System.out.printf("Thanks for playing! You ended up with $%.f!\n", amount);
		System.exit(0);
	}
}
