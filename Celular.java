//  Nikita Khomenko 311677553

import java.util.InputMismatchException;

public class Celular {
	
	public enum eState { Repair, Ready };   //in repair or ready to pick up from repair.
	
	private String phoneID;
	private String name, origin, series;
	private eState state;
	private double priceToFix;
	
	public Celular(String phoneID, String series, String name, String origin, eState state,  double priceToFix ) {
		setPhoneID(phoneID);
		setSeries(series);
		setName(name);
		setOrigin(origin);
		setState(state);
		setPriceToFix(priceToFix);
	}

	public double getPriceToFix() {
		return priceToFix;
	}

	private void setPriceToFix(double priceToFix) {
		try {
			this.priceToFix = priceToFix;
		} catch(InputMismatchException e) {       //checks if input in digits
			System.out.println(e.getMessage());
		}		
	}

	public eState getState() {
		return state;
	}

	public void setState(eState state) {
		try {
			this.state = state;
		} catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}		
	}

	public String getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(String phoneID) {
		this.phoneID = phoneID;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	//checks final price after client discount
	public double finalPrice (Client client) {    
		double price = getPriceToFix();
		return (double) (price - (price*client.getPercentDiscount()/100)); 

	}

	
	public String toString() {
		StringBuffer str = new StringBuffer ("\nPhone ID: " + phoneID + "\nName: " + name + "\nOrigin: " + origin + "\nSeries: " + series + "\nState: " + state
				+ "\nPrice before discount: " + priceToFix);
		return str.toString();
	}

	

}
