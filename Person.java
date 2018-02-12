//  Nikita Khomenko 311677553

import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Locale;

public abstract class Person {
	protected  int ID;
	protected  String name;
	protected  String address;
	protected  String phoneNum;
	protected  String DateOfBirth;
	
	public Person (int ID, String name, String address, String phoneNum, String DateOfBirth) throws Exception {
		setID(ID);
		setName(name);
		setAddress(address);
		setPhoneNum(phoneNum);
		setDateOfBirth(DateOfBirth);
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	protected void setDateOfBirth(String DateOfBirth) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		this.DateOfBirth = DateOfBirth;
    	try {
			java.util.Date date = format.parse(DateOfBirth);     //checks if date is in the correct format
			
    	} catch (ParseException e) {
    		System.out.println("Sorry, that's not valid date format. Please try again in the format yyyy-MM-dd.");
    		DateOfBirth = null;
    	} 
    	
	    Calendar cal = Calendar.getInstance();
	    String today = format.format(cal.getTime());
	    java.util.Date  d1 = format.parse(DateOfBirth);
	    java.util.Date  d2 = format.parse(today);
		
		if(d2.getTime() - d1.getTime() < 0) {   //checks if date is not in the future.
			DateOfBirth = null;
			throw new Exception("The date has not passed yet.");
		}		
	}

	private void setAddress(String address) {
		this.address = address;
		
	}

	private void setPhoneNum(String phoneNum) { 
		try {
		     NumberFormat.getInstance().parse(phoneNum);
			this.phoneNum = phoneNum;

		}
		catch(ParseException e)
		{
		    phoneNum = null;
			System.out.println("Input is invaild, phone number needs to contain only numbers.");
		}

	}

	private void setName(String name) {
		this.name = name;
	}

	private void setID(int ID) {
		if(String.valueOf(ID).length() == 9) {
			try {
				this.ID = ID;
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
			}	
		}
		else {
			System.out.println("ID should be 9 digits.");
		}
	}
	
	public void PersonAge(String dateOfBirth) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	    Calendar cal = Calendar.getInstance();
	    String dateStop = format.format(cal.getTime());
		String dateStart = dateOfBirth;		

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = (Date) format.parse(dateStart);
			d2 = (Date) format.parse(dateStop);
			
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
			
			long diffDays = diff / (24 * 60 * 60 * 1000);
			long diffYears = diff / (365 * 24 * 60 * 60 * 1000);
			
			System.out.println("Person's age:");
			System.out.print(diffYears + " years, ");
			System.out.print(diffDays + " days, ");
			System.out.println("Born in: " + dateOfBirth);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer("\nID: " + ID + "\nName: " + name + "\nAddress: " + address + "\nPhone number: " + phoneNum + "\nDate Of Birth: " + DateOfBirth);
		return str.toString();
	}
	
}
