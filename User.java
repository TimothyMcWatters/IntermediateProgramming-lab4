
/**
This program:
Implements a program and prompts the user for their name, age, salary, email address
and develops a hacker name from the data. The program stores all that information to a file 
and displays their hacker name. Uses the same file for every user.

@author Timothy McWatters
@version 1.0

COP3022    Lab 4
File Name: User.java
*/

public class User {
	private String name = "";
	private int age = 0;
	private double salary = 0.0;
	private String emailAddress = "";
	
	/**
	 * Default Constructor for the User Class
	 */
	public User() {
		this.name = "";
		this.age = 0;
		this.salary = 0.0;
		this.emailAddress = "";
	} // end of default constructor
	
	/**
	 * returns the name 
	 * @return name = name of the user
	 */
	public String getName() {
		return name;
	} // end of getName method

	/**
	 * sets the users name
	 * @param name = the users name to set
	 */
	public void setName(String name) {
		this.name = name;
	} // end of setName method
	
	/**
	 * returns the age 
	 * @return age = age of the user
	 */
	public int getAge() {
		return age;
	} // end of getAge method

	/**
	 * sets the users age
	 * @param name = the users age to set
	 */
	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	} // end of setAge method
	
	/**
	 * returns the salary 
	 * @return salary = annual salary of the user
	 */
	public double getSalary() {
		return salary;
	} // end of getSalary method

	/**
	 * sets the users annual salary. The salary is passed in as a String and converted to 
	 * a double. If newSalary is not in the correct format the method will handle the NumberFormatException
	 * and pass false, otherwise it will return true and set the annual salary.
	 * @param salary = the users annual salary to set
	 */
	public boolean setSalary(String newSalary) {
		try {
			this.salary = Double.parseDouble(newSalary);
			return true;
		} 
		catch (NumberFormatException nfe) {
			return false;
		}
	} // end of setSalary method
	
	/**
	 * returns the users emailAddress 
	 * @return emailAddress = The email address of the user
	 */
	public String getEmail() {
		return emailAddress;
	} // end of getEmail method

	/**
	 * sets the users email address
	 * @param emailAddress = the users email address to set 
	 */
	public boolean setEmail(String emailAddress) {
		try {
			String EMAIL_FORMAT = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]{3}"; // xxx@xxx.xxx x = any char or num & 3 after the dot(.)
			if (!emailAddress.matches(EMAIL_FORMAT)) {
				throw new MalformedEmailAddress();
			} else {
				this.emailAddress = emailAddress;
				return true;
			}
		} catch (MalformedEmailAddress e) {
			System.out.println(e.getMessage());
			return false;
		}
	} // end of setEmail method
	
	/**
	 * Creates and returns a hacker name created from the users data
	 * @return hackerName = the users hacker name created from the users data
	 */
	public String setHackerName() {
		String hackerName = this.name.substring(0, 3) + "haxx" + this.age; 
		return hackerName;
	} // end of setHackerName method

} // end User class
