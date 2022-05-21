package model;

public class VaccinationSite {

	private int dosesLimit;
	private int dosesAvaliable;
	private int vaccineBrandCounter;
	private int appointmentCounter;

	private String location;

	private VaccineDistribution[] vaccinesAvaliableArray;
	private HealthRecord[] appointmentList;

	public VaccinationSite(String vacSite, int limitDoses) {
		this.location = vacSite;
		this.dosesAvaliable = 0;
		this.dosesLimit = limitDoses;

		this.vaccinesAvaliableArray = new VaccineDistribution[3];
		this.vaccineBrandCounter = 0;
		
		this.appointmentList = new HealthRecord[200];
		this.appointmentCounter = 0;
	}

	public String toString() {

		String tempString = "";

		for(int i = 0; i < this.vaccineBrandCounter; i++) {
			tempString += this.vaccinesAvaliableArray[i].toStringSimple();
			if (i + 1 != this.vaccineBrandCounter) {
				tempString = tempString + ", ";
			}
		}

		return this.location + " has " + this.dosesAvaliable + " available doses: <" + tempString + ">";
	}

	public int getNumberOfAvailableDoses() {return this.dosesAvaliable;}

	public int getNumberOfAvailableDoses(String codeName) {
		int tempAmnt = 0;
		
		for(int i = 0; i < this.vaccineBrandCounter; i++) {
			if(this.vaccinesAvaliableArray[i].getVaccine().getCodename().equals(codeName)) {
				tempAmnt = this.vaccinesAvaliableArray[i].getAmount();
			}
		}
		
		return tempAmnt;
	}

	public void addDistribution(Vaccine vaccine, int doseAmount) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException {

		boolean found = false;
		boolean alreadyInDB = false;

		int tempPlaceFinder = 0;

		if(vaccine.getCodename().equals("mRNA-1273") || vaccine.getCodename().equals("BNT162b2") || vaccine.getCodename().equals("Ad26.COV2.S") || vaccine.getCodename().equals("AZD1222")) {
			found = true;
		}
		
		//loop to see if the vaccine is already in the system, if it is, save the place of where it is
		if(found) {
			for(int i = 0; i < this.vaccineBrandCounter; i++) {
				if(this.vaccinesAvaliableArray[i].getVaccine().equals(vaccine)) {
					alreadyInDB = true;
					tempPlaceFinder = i;
				}
			}
		}

		if(!found) {
			throw new UnrecognizedVaccineCodeNameException("");
		}
		//if the doses in total currently equal the max, throw an exception
		if(this.dosesAvaliable == this.dosesLimit) {
			throw new TooMuchDistributionException("");
		}
		//if adding the specified amount would be over the limit throw an exception
		if(this.dosesAvaliable + doseAmount > this.dosesLimit) {
			throw new TooMuchDistributionException("");
		}

		if(found && !alreadyInDB) {
			this.vaccinesAvaliableArray[this.vaccineBrandCounter] = new VaccineDistribution(vaccine, doseAmount);
			this.vaccineBrandCounter ++;
			this.dosesAvaliable = this.dosesAvaliable + doseAmount;
		}
		if(found && alreadyInDB) {
			this.vaccinesAvaliableArray[tempPlaceFinder].setAmountOfDoses(doseAmount);
			this.dosesAvaliable = this.dosesAvaliable + doseAmount;
		}

	}
	
	public void bookAppointment(HealthRecord name) throws InsufficientVaccineDosesException{
		
		boolean enoughDoses = false;
		
		if(this.appointmentCounter + 1 <= this.dosesAvaliable) {
			enoughDoses = true;
		}
		
		if(!enoughDoses) {
			name.setStatus("Last vaccination appointment for " + name.getName() + " with " + this.location + " failed");
			throw new InsufficientVaccineDosesException("");
		}
		
//		if(this.appointmentCounter + 1 > 200) {
//			
//		}
		
		if(this.appointmentCounter + 1 < 200 && enoughDoses) {
			name.setStatus("Last vaccination appointment for " + name.getName() + " with " + this.location + " succeeded");
			this.appointmentList[this.appointmentCounter] = name;
			this.appointmentCounter ++;
		}
	}
	
	public void administer(String dateCode) {
		
		int placeCounter = 0;
		
		for(int i = 0; i < appointmentCounter; i++) {
			if(this.vaccinesAvaliableArray[placeCounter].getAmount() > 0) {
				this.vaccinesAvaliableArray[placeCounter].doseUsed();
				this.appointmentList[i].addRecord(vaccinesAvaliableArray[placeCounter].getVaccine(), this.location, dateCode);
			}
			else {
				placeCounter ++;
				this.vaccinesAvaliableArray[placeCounter].doseUsed();
				this.appointmentList[i].addRecord(vaccinesAvaliableArray[placeCounter].getVaccine(), this.location, dateCode);
			}
		}
		
		this.dosesAvaliable = this.dosesAvaliable - this.appointmentCounter;
		this.appointmentCounter = 0;
		this.appointmentList = new HealthRecord[200];
	}
}