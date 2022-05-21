package model;

public class VaccineDistribution {
	
	private Vaccine vaccine;
	
	private int amountOfDoses;
	
	public VaccineDistribution(Vaccine vaccineClass, int amount) {
		this.vaccine = vaccineClass;
		this.amountOfDoses = amount;
	}
	
	public String toString() {
		return this.amountOfDoses + " doses of " + this.vaccine.getCodename() + " by " + this.vaccine.getBrand();
	}
	
	public String toStringSimple() {
		return this.amountOfDoses + " doses of " + this.vaccine.getBrand();
	}

	public int getAmount() {return this.amountOfDoses;}

	public void setAmountOfDoses(int amountOfDoses) {this.amountOfDoses = this.amountOfDoses + amountOfDoses;}
	
	public void doseUsed() {this.amountOfDoses --;}
	
	public Vaccine getVaccine() {return vaccine;}
}
