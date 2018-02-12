//  Nikita Khomenko 311677553

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;

public class Technician extends Worker implements EmployeeFunc{
	
	double HourFee;
    ArrayList<Celular> CelularsCanFix = new ArrayList<>();  //list of celulars he premitted to fix.
	
	public Technician(int ID, String name, String address, String phoneNum, String DateOfBirth, String DateOfEmployment,
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

	public void showCelularsCanFixList() {						//show list of celulars the technician can fix.
		System.out.println("List of celulars the technician can fix:");

			for (int i = 0; i < CelularsCanFix.size(); i++) {
				System.out.println(CelularsCanFix.get(i).toString());
			}
		}
		
	
	public boolean canFix(Celular celular) {     //checks if Technician can fix a specific celular model.
		boolean res = false;
		for (int i = 0; i <  CelularsCanFix.size(); i++) {
			if (CelularsCanFix.get(i).equals(celular))
				res = true;
		}
		return res;	
	}

	public void addCelularsCanFix(Celular celular) {
		CelularsCanFix.add(celular);
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
		str.append("\nCelulars premitted to fix: \n");
		for (int i = 0; i < CelularsCanFix.size() ; i++ ) {
			str.append((i+1) + "- " + CelularsCanFix.get(i).toString() + "\n");
		}
		return str.toString();
	}
	

}
