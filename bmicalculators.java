package bmicalculator;

import java.util.Scanner;
import java.util.Locale;

public class bmicalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		char repeat = 0;
		
		do {
			
			int unitChoice = getUnitChoice(scanner);
			
			double weight = (unitChoice == 1) ? getValidInput(scanner, "Enter your weight in kilograms: ", 10, 600) 
					: getValidInput(scanner, "Enter your weight in Pounds: ", 22, 1300);
			
			double height = (unitChoice == 1) ? getValidInput(scanner, "Enter your height in meters: ", 0.5, 7.5) 
					: getValidInput(scanner, "Enter your height in inches: ", 20, 100);
			
			double bmi = calculateBMI(unitChoice, weight, height);
			System.out.println("Your BMI is: " + bmi);
			
			double category = displayCategory(bmi);
			
			repeat = askToRepeat(scanner);
			System.out.println();
		}
		
		while(repeat == 'Y' || repeat == 'y');

	}
	
	// Units (metric & imperial)
	public static int getUnitChoice(Scanner scanner) {
		
		int choice;
		
		while(true) {
			System.out.println("Select a perferred unit:\n" 
					+ "1. Metric (kg, m)\n"
					+ "2. Imperial (lbs, in)\n"
					+ "Please select either option 1 or 2");
			
			if(scanner.hasNextInt()){
				choice = scanner.nextInt();
				if(choice == 1 || choice == 2) {
					break;
			 	} else {
					System.out.println("Invalid choice. Please enter either 1 or 2");
				}
				
			} else {
				System.out.println("Invalid input. Please enter a number (1 or 2)");
				scanner.next();
			}
		}
		
		return choice;

	}
	
	public static double getValidInput(Scanner scanner, String prompt, double min, double max) {
		double value;
		
		while(true) {
			System.out.println(prompt);
			
			if(scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				if(value >= min && value <= max) {
					break;
				} else {
					System.out.printf("Please enter a value between %.1f and %.1f.\n", min, max);
				}
			} else {
				System.out.println("Invalid input. Please enter a value");
				scanner.next();
			}
		}
		
		return value;
	}
	
	public static double calculateBMI(int unitChoice, double weight, double height) {
		double totalBMI;
		
		if(unitChoice == 1) {
			totalBMI = weight / (height * height);
		} else {
			totalBMI = (703 * weight) / (height * height);
		}
		
		return totalBMI;
	}
	
	public static double displayCategory(double bmi) {
		
		// categories for bmi 
		if(bmi < 16) {
			System.out.println("You are obese");
		}
		else if(bmi >= 16.0 && bmi <= 18.5) {
			System.out.println("You are underweight");
		}
		else if(bmi >= 18.5 && bmi <= 29.9 ) {
			System.out.println("You are healthy");
		}
		else if(bmi >= 30 && bmi <= 34.99) {
			System.out.println("You are moderately obese");
		}
		else if(bmi >= 35 && bmi <= 39.99) {
			System.out.println("You are severely obese");
		}
		else if(bmi >= 40) {
			System.out.println("You are morbidly obese");
		}
		else {
			System.out.println("Error, please try again later");
					}
		
		return bmi;
	}
	
	public static char askToRepeat(Scanner scanner) {
		
		char repeat;
		
		System.out.println("Do you want to run the program again? (Y/y to continue/ N/n to stop):");
		repeat = scanner.next().charAt(0);
		
		if(repeat == 'y' || repeat == 'Y') {
			return repeat;
		}
		else if(repeat == 'n' || repeat == 'N') {
			return repeat;
		}
		else {
			System.out.println("Invalid answer. Try again later");
		}
		
		
		return repeat;
	
	}
	}
