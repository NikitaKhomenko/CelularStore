//  Nikita Khomenko 311677553

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Locale;

//class worker implements 'EmployeeFunc' and extending classes inherit those functions too.
public abstract class Worker extends Person implements EmployeeFunc { 
	
	protected String DateOfEmployment;
	protected int HoursInMonth;
	protected int workPercentage;
	protected static final int Full_Time_Job = 175; 
	
	public Worker (int ID, String name, String address, String phoneNum, String DateOfBirth,
			String DateOfEmployment, int HoursInMonth, int workPercentage) throws Exception {
		super(ID, name, address, phoneNum, DateOfBirth);
		setDateOfEmployment(DateOfEmployment);
		setHoursInMonth(HoursInMonth);
		workPercentage = (HoursInMonth / Full_Time_Job) * 100;
	}

	public String getDateOfEmployment() {
		return DateOfEmployment;
	}

	private void setDateOfEmployment(String DateOfEmployment) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		this.DateOfEmployment = DateOfEmployment;
    	try {
			java.util.Date date = format.parse(DateOfEmployment);
			
    	} catch (ParseException e) {
    		System.out.println("Sorry, that's not valid date format. Please try again in the format yyyy-MM-dd.");
    		DateOfEmployment = null;
    	} 
    	
	    Calendar cal = Calendar.getInstance();
	    String today = format.format(cal.getTime());
	    java.util.Date  d1 = format.parse(DateOfEmployment);
	    java.util.Date  d2 = format.parse(today);
		
		if(d2.getTime() - d1.getTime() < 0) {     //checks if date is in the future
			DateOfEmployment = null;
			throw new Exception("The date has not passed yet.");
		}		
	}

	public int getHoursInMonth() {
		return HoursInMonth;
	}

	public void setHoursInMonth(int HoursInMonth) {
		try {
			this.HoursInMonth = HoursInMonth;
		} catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public int getWorkPercentage() {
		return workPercentage;
	}
	
	@Override
	public double SalaryCalc(double HourFee, int HoursInMonth) {
		return HourFee * HoursInMonth;
	}

	@Override
	public void Seniority(String DateOfEmployment) {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		    Calendar cal = Calendar.getInstance();
		    String dateStop = format.format(cal.getTime());
			String dateStart = DateOfEmployment;		

			try {
				java.util.Date d1 =  format.parse(dateStart);
				java.util.Date d2 =  format.parse(dateStop);
				
				System.out.println(d1);
				System.out.println(d2);

				//in milliseconds
				long diff = d2.getTime() - d1.getTime();
				System.out.println(diff);
				
				long diffDays = diff / (24 * 60 * 60 * 1000);
				long diffYears = diff / (365 * 24 * 60 * 60 * 1000);

				System.out.println("Worker's seniority:");
				System.out.print(diffYears + " years, ");
				System.out.print(diffDays + " days, ");
				System.out.println("Started: " + DateOfEmployment);

			} catch (Exception e) {
				System.out.println("Date not in correct format.");
			}
	 }

	@Override
	public void workerType(Object o) {
		if (o instanceof Seller)
			System.out.println("Worker's position: Seller");
		else if (o instanceof Technician)
			System.out.println("Worker's position: Technician");
		else if (o instanceof Manager)
			System.out.println("Worker's position: Manager");
		else
			System.out.println("Has no position.");
	}
	
			
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());          //inherits from Person
		str.append("\nDate of employment: " + DateOfEmployment + "\nHours worked in month: " + HoursInMonth + "\nPercent of work: " + workPercentage);
		return str.toString();
	}
}
	
	         


