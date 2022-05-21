package model;

public class Vaccine {
	
	private String codename;
	private String type;
	private String brand;
	
	private final String[] approvedVac = {"mRNA-1273", "BNT162b2", "Ad26.COV2.S", "AZD1222"};
	
	public Vaccine(String name, String technology, String company) {
		this.codename = name;
		this.type = technology;
		this.brand = company;
	}
	
	public String getCodename() {return codename;}

	public String getType() {return type;}

	public String getBrand() {return brand;}

	public String toString() {
		
		boolean approved = false;
		
		for(int i = 0; i < approvedVac.length; i++) {
			if(this.codename.equals(approvedVac[i])) {
				approved = true;
			}
		}
		
		if(approved) {
			return "Recognized vaccine: " + this.codename + " (" + this.type + "; "+ this.brand + ")";
		}
		
		else {
			return "Unrecognized vaccine: " + this.codename + " (" + this.type + "; "+ this.brand + ")";
		}
		
	}
	
	
	
}
