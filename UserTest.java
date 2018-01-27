import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
This program:
Implements a program and prompts the user for their name, age, salary, email address
and develops a hacker name from the data. The program stores all that information to a file 
and displays their hacker name. Uses the same file for every user.

@author Timothy McWatters
@version 1.0

COP3022    Lab 4
File Name: UserTest.java
*/

public class UserTest {

	public static void main(String[] args) {

		String fileName = "UserInfo.txt"; // name of the file to be opened, or if it doesn't exist, created.
		PrintWriter outputStream = null; // creates a new PrintWriter object to write to file
		String hackerName = ""; // variable to hold the created hacker name before printing to screen and file
		
		Scanner keyboard = new Scanner(System.in); // creates a new Scanner object to read input from the keyboard
		User user1 = new User(); // creates a User object
		
		try {
			File file1 = new File(fileName);
			file1.createNewFile();  // if file already exists will do nothing 
			outputStream = new PrintWriter(new FileOutputStream(file1, true)); 
		} catch (IOException e) {
			System.out.println("Error opening the file");
			System.exit(0);
		} 
		
		// asks for user input via keyboard and prints the name to the file
		System.out.print("Please enter your first name: ");
		user1.setName(keyboard.next());
		outputStream.println(user1.getName());
		
		// asks for user input via keyboard and prints the age to the file
		System.out.print("\nPlease enter your age: ");
		user1.setAge(keyboard.next());	
		outputStream.println(user1.getAge());
		
		// asks for user input via keyboard and prints the salary to the file unless the salary is input 
		// in the incorrect format. In that case the program will print an error message to screen, prints default salary to file
		// and continues to the next set of instructions.
		System.out.print("\nPlease enter your salary: ");
		if (user1.setSalary(keyboard.next())) {	
			outputStream.printf("%.2f\n", user1.getSalary());
		} else {
			System.out.printf("ERROR: Salary entered must be in the form of XXXXX.XX where X is a number");	
			outputStream.printf("%.2f\n", user1.getSalary());
		}
		
		// asks for user input via keyboard and prints the email address to the file. If the 
		// email address is formatted incorrectly, an error will be displayed on the screen and 
		// the user will be prompted for another input until the format is correct.
		System.out.print("\nPlease enter your email address: ");
		while (!user1.setEmail(keyboard.next())) {
			System.out.println("Please try again!");
		} outputStream.println(user1.getEmail());
		
		hackerName = user1.setHackerName();
		System.out.printf("\nYour new hacker name is: %s", hackerName);	
		outputStream.println(hackerName);
		
		//closes the Scanner and PrintWriter input
		outputStream.close();
		keyboard.close();
		
	} // end of main

} // end of UserTest class
