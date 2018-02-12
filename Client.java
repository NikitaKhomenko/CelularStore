//  Nikita Khomenko 311677553

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Locale;

public class Client extends Person {
	
	private String DateOfJoining;
	private int percentDiscount;
    ArrayList<Celular> CelularsToFix = new ArrayList<>();


	public Client(int ID, String name, String address, String phoneNum, String DateOfBirth, String DateOfJoining, int percentDiscount) throws Exception {
		super(ID, name, address, phoneNum, DateOfBirth);
		setDateOfJoining(DateOfJoining);
		setPercentDiscount(percentDiscount);
	}

	
	public int getPercentDiscount() {
		return percentDiscount;
	}


	public void setPercentDiscount(int percentDiscount) {
		if (percentDiscount < 100 && percentDiscount > 0) {
			try {
				this.percentDiscount = percentDiscount;
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
			}	
		}
		else {
			System.out.println("Percents must be between 0 and 100.");
		}

	}


	public String getDateOfJoining() {
		return DateOfJoining;
	}


	private void setDateOfJoining(String DateOfJoining) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		this.DateOfJoining = DateOfJoining;
    	try {
			java.util.Date date = format.parse(DateOfJoining);
			
    	} catch (ParseException e) {
    		System.out.println("Sorry, that's not valid date format. Please try again in the format yyyy-MM-dd.");
    		DateOfJoining = null;
    	} 
    	
	    Calendar cal = Calendar.getInstance();
	    String today = format.format(cal.getTime());
	    java.util.Date d1 = format.parse(DateOfJoining);
	    java.util.Date d2 = format.parse(today);
		
		if(d2.getTime() - d1.getTime() < 0) {
			DateOfJoining = null;
			throw new Exception("The date has not passed yet.");
		}		
	}
	
	public void showCelularsToFix() {						//show list of celulars the client gave to fix.
		System.out.println("List of phones client gave to fix:");

		for (int i = 0; i < CelularsToFix.size(); i++) {
			System.out.println(CelularsToFix.get(i).toString());
		}
	}
	
	public boolean gaveToFix(String phoneID) {     //checks if the client gave the specific celular to fix.
		boolean res = false;
		for (int i = 0; i < CelularsToFix.size(); i++) {
			if (CelularsToFix.get(i).getPhoneID().contains(phoneID));
				res = true;
		}
		return res;	
	}

	public void addCelularsToFix(Celular Celular) {
			CelularsToFix.add(Celular);
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());          //inherits from Person
		str.append("\nDate of joining: " + DateOfJoining + "\nPercent discount: " + percentDiscount);
		str.append("\nCelulars gave to fix: \n");
		for (int i = 0; i < CelularsToFix.size() ; i++ ) {
			str.append((i+1) + "- " + CelularsToFix.get(i).toString() + "\n");
		}
		return str.toString();
	}

}
