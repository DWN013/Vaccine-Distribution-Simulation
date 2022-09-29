package model;

public class HealthRecord {

	private String name;
	private String status;

	private int dosesTotal;

	private Vaccine[] vaccineRecord;
	private String[] locationArray;
	private String[] dateCodeArray;

	public HealthRecord(String name, int dosesAmntHistory) {
		this.name = name;
		this.dosesTotal = 0;
		//base status if no appointments have been booked yet
		this.status = "No vaccination appointment for " + name + " yet";
		
		//Arrays for storing record info
		this.vaccineRecord = new Vaccine[dosesAmntHistory];
		this.locationArray = new String[dosesAmntHistory];
		this.dateCodeArray = new String[dosesAmntHistory];
	}
	//Prints out a vaccination receipt which states total number of vaccines taken if any
	public String getVaccinationReceipt() {

		String stringReport = "Number of doses " + this.name + " has received: " + this.dosesTotal + " [";

		if(this.dosesTotal == 0) {
			return this.name +  " has not yet received any doses.";
		}
		else {
			for(int i = 0; i < this.dosesTotal; i++) {
				stringReport += this.vaccineRecord[i].toString();
				stringReport += " in " + this.locationArray[i] + " on " + this.dateCodeArray[i];
				if (i  + 1 != this.dosesTotal) {
					stringReport = stringReport + "; ";
				}
				if(i + 1 == this.dosesTotal) {
					stringReport += "]";
				}
			}
			return stringReport;
		}
	}

	public String getAppointmentStatus() {return status;}
	
	//Adds a new vaccination record with the type of vaccine, date, and hospital location and increments total vaccine count
	public void addRecord(Vaccine vaccine, String location, String date) {
		this.vaccineRecord[dosesTotal] = vaccine;
		this.locationArray[dosesTotal] = location;
		this.dateCodeArray[dosesTotal] = date;
		this.dosesTotal ++;
	}
	//Sets status message status
	public void setStatus(String status) {this.status = status;}
	//Gets the name of the client
	public String getName() {return name;}
	
}
