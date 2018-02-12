//  Nikita Khomenko 311677553

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;

public class Manager extends Worker implements EmployeeFunc {
	private int lab_ID;
	private double globalSalary;
	
	public Manager(int ID, String name, String address, String phoneNum, String DateOfBirth, String DateOfEmployment,
			int HoursInMonth, int workPercentage,int lab_ID, double globalSalary) throws Exception {
		super(ID, name, address, phoneNum, DateOfBirth, DateOfEmployment,
			HoursInMonth, workPercentage);
		setLab(lab_ID);
		setGlobalSalary(globalSalary);
		workPercentage = (HoursInMonth / 175)*100;
	}

	private void setGlobalSalary(double globalSalary) {
		try {
			this.globalSalary = globalSalary;
		} catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void Seniority(String DateOfEmployment) {
		super.Seniority(DateOfEmployment);
	}
	
	public void workerType(Object o) {
		super.workerType(o);
	}

	@Override
	public double SalaryCalc(double globalSalary , int workPercentage) {
		return globalSalary * workPercentage;
	}
	

	private void setLab(int lab_ID) {
		if(String.valueOf(lab_ID).length() == 9) {
			try {
				this.lab_ID = lab_ID;
			} catch(InputMismatchException e) {       //checks if input in digits
				System.out.println(e.getMessage());
			}	
		}
		else {
			System.out.println("ID should be 9 digits.");
		}	
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append ("\nLab ID: " + lab_ID + "\nGlobal salary: " + globalSalary);
		return str.toString();
	}
	
}
