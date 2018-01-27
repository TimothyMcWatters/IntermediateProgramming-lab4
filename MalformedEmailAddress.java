/**
This program:
Implements a program and prompts the user for their name, age, salary, email address
and develops a hacker name from the data. The program stores all that information to a file 
and displays their hacker name. Uses the same file for every user.

@author Timothy McWatters
@version 1.0

COP3022    Lab 4
File Name: MalformedEmailAddress.java
*/

public class MalformedEmailAddress extends Exception {

	/**
	 * Default constructor for the MalformedEmailAddress class
	 */
	public MalformedEmailAddress() {
		super("Email addresses must be of the form: xxxx@xxxx.xxx (where x is any character or number)");
	} // end of default MalformedEmailAddress constructor
	
	/**
	 * Parameterized constructor for the MalformedEmailAddress class
	 */
	public MalformedEmailAddress(String message) {
		super(message);
	} // end of parameterized MalformedEmailAddress constructor

} // end of MalformedEmailAddress class
