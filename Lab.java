//  Nikita Khomenko 311677553

import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Locale;

public class Lab {
	private int lab_ID;
	private String LabName, address, phoneNum;
	private Manager manager;
	private String Date_of_establishment;
    private ArrayList<Worker> allWorkers = new ArrayList<>();
    private ArrayList<Celular> allCelulars = new ArrayList<>();
    private ArrayList<Client> allClients = new ArrayList<>();

	
	public Lab(int lab_ID, String LabName, String address, String phoneNum, Manager manager, String Date_of_establishment) throws Exception {
		setLab_ID(lab_ID);
		this.LabName = LabName;
		this.address = address;
		setPhoneNum(phoneNum);
		setManager(manager);
		setDate_of_establishment(Date_of_establishment);

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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setManager (Manager manager) {         //first we set manager then we put it in the workers array.
		this.manager = manager;
		addWorker(manager);
	}
	
	public void addWorker(Worker theWorker) {
		allWorkers.add(theWorker);
	}
	
	public void addCelular(Celular theCelular) {
		allCelulars.add(theCelular);
	}
	
	public void addClient(Client theClient) {
		allClients.add(theClient);
	}

	public void setDate_of_establishment(String Date_of_establishment) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		this.Date_of_establishment = Date_of_establishment;
		
	    	try {
				java.util.Date date = format.parse(Date_of_establishment);
				
	    	} catch (ParseException e) {     //checks if in the right format
	    		System.out.println("Sorry, that's not valid date format. Please try again in the format yyyy-MM-dd.");
	    		Date_of_establishment = null;
	    	} 
	    	
		    Calendar cal = Calendar.getInstance();
		    String today = format.format(cal.getTime());
		    java.util.Date d1 = format.parse(Date_of_establishment);
		    java.util.Date d2 = format.parse(today);
			
			if(d2.getTime() - d1.getTime() < 0) {    //checks if date is not in the future.
				Date_of_establishment = null;
				throw new Exception("The date has not passed yet.");
			}
	    	
	
	}
	

	private void setLab_ID(int lab_ID) {
		if(String.valueOf(lab_ID).length() == 9) {
			try {
				this.lab_ID = lab_ID;
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
			}	
		}
		else {
			System.out.println("ID should be 9 digits.");
		}
	}

	//methods to get worker/client/celular. we get them by a personal mark (name/ID..).
	//this way a user can search the item without having the object itself, without the whole knowledge of it.


	public Worker getWorkerByName(String name) {
		for (int i = 1; i < allWorkers.size(); i++) {
			if (allWorkers.get(i).getName().contains(name)) {   
				System.out.println("\nWorker exist:");
				return allWorkers.get(i);
			}
		}
		System.out.println("Worker do not exist.");
		return null;
	}
	
	public  Worker getWorkerByID(int ID) {
		for (int i = 1; i < allWorkers.size(); i++) {
			if (allWorkers.get(i).getID() == ID) {   
				System.out.println("\nWorker exist:");
				return allWorkers.get(i);
			}
		}
		System.out.println("Worker do not exist.");
		return null;
	}
	
	public Celular getCelularByID(String phoneID) {
		for (int i = 0; i < allCelulars.size(); i++) {
			if (allCelulars.get(i).getPhoneID().contains(phoneID)) {   
				System.out.println("\nCelular exist:");
				return allCelulars.get(i);
			}
		}
		System.out.println("Celular do not exist.");
		return null;
	}
	
	public Celular.eState getCelularStateByID(String phoneID) {    //method to check only the state of celular that's in the lab.
		for (int i = 0; i < allCelulars.size(); i++) {
			if (allCelulars.get(i).getPhoneID().contains(phoneID)) {   
				System.out.print("\nCelular State:  ");
				return allCelulars.get(i).getState();
			}
		}
		System.out.println("Celular do not exist.");
		return null;
	}
	
	public  Client getClientByID(int ID) {
		for (int i = 0; i < allClients.size(); i++) {
			if (allClients.get(i).getID() == ID) {   
				System.out.println("\nClient exist:");
				return allClients.get(i);
			}
		}
		System.out.println("Client do not exist.");
		return null;
	}
	
	public void AgeOfStore(String Date_of_establishment) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	    Calendar cal = Calendar.getInstance();
	    String dateStop = format.format(cal.getTime());
		String dateStart = Date_of_establishment;		

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = (Date) format.parse(dateStart);
			d2 = (Date) format.parse(dateStop);
			
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();     //calculate dates difference.
			
			long diffDays = diff / (24 * 60 * 60 * 1000);
			long diffYears = diff / (365 * 24 * 60 * 60 * 1000);
			
			System.out.println("Age of Store:");
			System.out.print(diffYears + " years, ");
			System.out.print(diffDays + " days, ");
			System.out.println("Since " + Date_of_establishment);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public int getLab_ID() {
		return lab_ID;
	}

	public String getLabName() {
		return LabName;
	}

	public String getAddress() {
		return address;
	}

	public Manager getManager() {
		return manager;
	}

	public String getDate_of_establishment() {
		return Date_of_establishment;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Lab details: \n\nLab ID: " + lab_ID + "\nLabName: " + LabName + "\nAddress: " + address + "\nPhone number: " + phoneNum + "\nLab manager: "  + manager + "\nDate of establishment: " + Date_of_establishment + "\n\n");
		str.append("Number of workers: " + (allWorkers.size()-1) + "\nNumber of clients: " + allClients.size() + "\nNumber of celulars in the lab: " + allCelulars.size() + "\n\n");
		str.append("\nWorkers:\n");
		for (int i = 1; i < allWorkers.size() ; i++ ) {
			str.append((i+1) + "- " + allWorkers.get(i).toString() + "\n");
		}
		str.append("\nClients:\n");
		for (int i = 0; i < allClients.size() ; i++ ) {
			str.append((i+1) + "- " + allClients.get(i).toString() + "\n");
		}
		str.append("\nCelulars:\n");
		for (int i = 0; i < allCelulars.size() ; i++ ) {
			str.append((i+1) + "- " + allCelulars.get(i).toString() + "\n");
		}
		return str.toString();
		
	}

}
