import java.io.File; // Import the File class to read list of food
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Random; //Generates random numbers

/**
 * This class imports a file with food names &
 * outputs a random food name from the list.
 * 
 * @author Filune
 * @version 2022-04-10
 */
public class FoodToCook {
	
	
	public static void main(String[] args) {
		String[] foodList;
		int foodIndex;
		
		foodList = listOfFood();
		Random random = new Random();
		foodIndex = random.nextInt(foodList.length);
		System.out.println("You should make " + foodList[foodIndex] + " today!");
	}
	
	/**
	 * Imports list of food names and outputs string array.
	 * @return foodList
	 */
	public static String[] listOfFood() {
		
		int index = 0;
		int linesInFile = 0;

		try {
			File list = new File("foodList.txt");
			Scanner counter = new Scanner(list);
			Scanner readFile = new Scanner(list);
			
			//Counts lines in file to determine amount of food.
			while (counter.hasNext()) {
				counter.nextLine();
				linesInFile++;
			}
			
			String[] tempFoodList = new String[linesInFile];
			
			//Puts food names in string array.
			while (readFile.hasNext()) {
				tempFoodList[index] = readFile.nextLine();
				index++;
			}
			
			readFile.close();
			counter.close();
			return tempFoodList;
		} catch (Exception e) {
			 System.out.println("An error occurred. Did you specify the correct path to your list of food?");
			 e.printStackTrace();
		}
		return new String[0];
	}
}
