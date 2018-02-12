//  Nikita Khomenko 311677553

import java.util.InputMismatchException;

public class Seller extends Worker{
	double HourFee;

	public Seller(int ID, String name, String address, String phoneNum, String DateOfBirth, String DateOfEmployment,
			int HoursInMonth, int workPercentage, double HourFee) throws Exception {
		super(ID, name, address, phoneNum, DateOfBirth, DateOfEmployment, HoursInMonth, workPercentage);
		setHourFee(HourFee);
	}

	public double getHourFee() {
		return HourFee;
	}

	public void setHourFee(double HourFee) {
		try {
			this.HourFee = HourFee;
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

	public void SalaryCalc() {
		super.SalaryCalc(HourFee, HoursInMonth);
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());           //inherits from Worker 
		str.append("\nHour fee: " + HourFee);
		return str.toString();
	}

}
