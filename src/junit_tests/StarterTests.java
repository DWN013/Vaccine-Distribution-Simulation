package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

/*
 * Requirement: Any classes you create must reside in the `model` package and be imported properly.
 * For example, creating a new class `Foo` in the `model` package should result in:
 * 	import model.Foo;
 * 
 * All attributes you declare in the model classes must be private. 
 * 	If necessary, define public accessors/getters and/or mutators/setters for these private attributes. 
 */
public class StarterTests {

	/* 
	 * Programming Requirements:
	 * 
	 * 	- You are only allowed to use primitive arrays (e.g., int[], String[], Product[]) 
	 * 		for declaring attributes and implementing the idea of collections.
	 * 	- Any use of a Java library class or method is forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format)
	 * 
	 * Violating the above programming requirements will result in a penalty (see lab instructions for details). 
	 * 
	 * Tests included in this class serve as documentation on how instances of an Apple AppStore operates.
	 * 
	 * Before attempting this lab, it is expected that you already completed background study materials:
	 * 	1. Review Tutorial Series on OOP in Java (Part 1 and Part 2): 
	 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#refurbished_store
	 * 	2. Written Notes on Reference-Typed, Multi-Valued Attributes:
	 * 		https://www.eecs.yorku.ca/~jackie/teaching/lectures/2021/F/EECS2030/notes/EECS2030_F21_Tracing_PointCollectorTester.pdf
	 * 	3. Written Notes on Inferring Classes from JUnit Tests:
	 * 		https://www.eecs.yorku.ca/~jackie/teaching/lectures/2021/F/EECS2030/notes/EECS2030_F21_Inferring_Classes_from_JUnit.pdf 
	 * 
	 * Be sure to also read the following sections from your Lab1 instructions PDF:
	 * 	- The `Requirements of this Lab` section (page 3) 
	 * 	- Section 2.3 The Vaccination Tracker Problem
	 * 	- Section 2.4 Hints and Requirements
	 * 
	 * Programming IDEs such as Eclipse are able to fix some compilation errors for you. 
	 * However, you are advised to follow the guidance as specified in the written notes above
	 * to fix these compilation errors manually, because: 
	 * 	1) it helps you better understand how the intended classes and methods work together; and 
	 * 	2) you may be tested in a written test or exam without the assistance of IDEs.
	 */

	/*
	 * Tests related to the Vaccine class.
	 */ 

	@Test
	public void test_vaccine_01() {
		/* 
		 * Initialize records of vaccines recognized in Canada. 
		 * Input values of the constructor consist of the codename, type, and manufacturer. 
		 * No error handling is necessary for these input values.
		 * See Section 2.3 of the lab manual for the list of recognized vaccines.
		 */ 
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		Vaccine v3 = new Vaccine("Ad26.COV2.S", "Non Replicating Viral Vector", "Janssen");
		Vaccine v4 = new Vaccine("AZD1222", "Non Replicating Viral Vector", "Oxford/AstraZeneca");

		assertEquals("Recognized vaccine: mRNA-1273 (RNA; Moderna)", v1.toString());
		assertEquals("Recognized vaccine: BNT162b2 (RNA; Pfizer/BioNTech)", v2.toString());
		assertEquals("Recognized vaccine: Ad26.COV2.S (Non Replicating Viral Vector; Janssen)", v3.toString());
		assertEquals("Recognized vaccine: AZD1222 (Non Replicating Viral Vector; Oxford/AstraZeneca)", v4.toString());
	}

	@Test
	public void test_vaccine_02() {
		/* 
		 * Initialize records of vaccines not recognized in Canada. 
		 * Input values of the constructor consist of the codename, type, and manufacturer. 
		 * No error handling is necessary for these input values.
		 * See Section 2.3 of the lab manual for the list of recognized vaccines. 
		 */ 
		Vaccine v5 = new Vaccine("Covishield", "Non Replicating Viral Vector", "Serum Institute of India");
		Vaccine v6 = new Vaccine("BBIBP-CorV", "Inactivated", "Sinopharm");
		Vaccine v7 = new Vaccine("CoronaVac", "Inactivated", "Sinovac"); 

		assertEquals("Unrecognized vaccine: Covishield (Non Replicating Viral Vector; Serum Institute of India)", v5.toString());
		assertEquals("Unrecognized vaccine: BBIBP-CorV (Inactivated; Sinopharm)", v6.toString());
		assertEquals("Unrecognized vaccine: CoronaVac (Inactivated; Sinovac)", v7.toString()); 
	}

	/*
	 * Tests related to the VaccineDistribution class.
	 */
	
	@Test 
	public void test_vaccine_distribution_01() {
		/* Create a distribution of some recognized vaccine. */
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		VaccineDistribution dist1 = new VaccineDistribution(v1, 10000);
		assertEquals("10000 doses of mRNA-1273 by Moderna", dist1.toString());

		/* Create a distribution of some unrecognized vaccine. */
		Vaccine v6 = new Vaccine("BBIBP-CorV", "Inactivated", "Sinopharm");
		VaccineDistribution dist2 = new VaccineDistribution(v6, 25000);
		assertEquals("25000 doses of BBIBP-CorV by Sinopharm", dist2.toString());
	}

	/*
	 * Tests related to the HealthRecord class.
	 */
	
	@Test
	public void test_health_record_01() {
		/* 
		 * Create a health record with the patient name and 
		 * 	the limit on the number of doses appearing on their vaccination history.
		 */
		HealthRecord rec = new HealthRecord("Alan", 5);
		
		/* No vaccination history yet for the patient. */
		String s1 = rec.getVaccinationReceipt();
		assertEquals("Alan has not yet received any doses.", s1);
		
		/* No appointments booked yet for the patient */
		String s2 = rec.getAppointmentStatus();
		assertEquals("No vaccination appointment for Alan yet", s2);
	}
	
	@Test
	public void test_health_record_02() {
		/* 
		 * Create a health record with the patient name and 
		 * 	the limit on the number of doses appearing on their vaccination history.
		 */
		HealthRecord rec = new HealthRecord("Alan", 5);
		
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		
		/* 
		 * Add a record for the patient's 1st received dose.
		 * Each record contains:
		 * 	- the vaccine reference
		 * 	- the name of vaccination site
		 * 	- the date of receiving the dose  
		 */
		rec.addRecord(v1, "North York General Hospital", "April-20-2021");
		/* 
		 * A vaccination receipt contains:
		 * 	- The number of doses the patient has received
		 * 	- A semi-colon-separated list, where each item gives information about: 
		 * 		+ the vaccine info
		 * 		+ the name of vaccination site
		 * 		+ the date of vaccination
		 */
		assertEquals("Number of doses Alan has received: 1 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on April-20-2021]", rec.getVaccinationReceipt());
		
		/* Add a record for the patient's 2nd received dose. */
		rec.addRecord(v2, "Humber River Hospital", "June-30-2021");
		assertEquals("Number of doses Alan has received: 2 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on April-20-2021; Recognized vaccine: BNT162b2 (RNA; Pfizer/BioNTech) in Humber River Hospital on June-30-2021]", rec.getVaccinationReceipt());
		
		/* 
		 * Patient's appointment status does not get changed by adding records.
		 * It's only changed when the `bookAppointment` method is invoked on a VaccinationSite object.
		 * (See below.) 
		 */
		assertEquals("No vaccination appointment for Alan yet", rec.getAppointmentStatus());
	}

	/*
	 * Tests related to the VaccinationSite class.
	 */
	
	@Test
	public void test_vaccination_site_01() {
		/* 
		 * Create a vaccination site with its name and
		 * 	the limit on the number of doses accumulated from the added distributions.
		 * For illustration, the limit is set with a small number.
		 */
		VaccinationSite vs = new VaccinationSite("North York General Hospital", 10);
		
		assertEquals("North York General Hospital has 0 available doses: <>", vs.toString());
		
		/* Initially, there is no supply on the site. */
		int totalSupply = vs.getNumberOfAvailableDoses();
		assertEquals(0, totalSupply);
		
		/* 
		 * When inquiring about the supply of a kind of vaccines,
		 * 	it is assumed that the codename is used. 
		 */
		
		/* Supplies of recognized vaccines (but remember that the site is empty) */
		int supplyOfModerna = vs.getNumberOfAvailableDoses("mRNA-1273");
		int supplyOfPfizer = vs.getNumberOfAvailableDoses("BNT162b2");
		assertEquals(0, supplyOfModerna);
		assertEquals(0, supplyOfPfizer);
		
		/* 
		 * Supplies of unrecognized vaccines should always be zero,
		 * 	as their distributions can never be added to the site. 
		 */
		int supplyOfSinovac = vs.getNumberOfAvailableDoses("CoronaVac");
		assertEquals(0, supplyOfSinovac);
	} 
	
	@Test
	public void test_vaccination_site_02a() {
		/* 
		 * Create a vaccination site with its name and
		 * 	the limit on the number of doses accumulated from the added distributions.
		 * For illustration, the limit is set with a small number.
		 */
		VaccinationSite vs = new VaccinationSite("North York General Hospital", 10);
		
		/* Add distributions of three recognized vaccines (identified by their codenames) */
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		Vaccine v3 = new Vaccine("AZD1222", "Non Replicating Viral Vector", "Oxford/AstraZeneca");
		
		try {
			/* 
			 * The string description of a vaccination site includes:
			 * 	1) its name
			 * 	2) total supply
			 * 	3) supplies of available kinds of vaccines (each displayed with their manufacturer; see below)
			 * 	
			 * 	Note. For 3), the order in which these supplies are reported corresponds to 
			 * 			the chronological order of their first-added distributions.
			 * 		  See the remaining test for an example. See the next test method for contrast.
			 */
			
			vs.addDistribution(v1, 3); /* 1st distribution of Moderna */
			assertEquals("North York General Hospital has 3 available doses: <3 doses of Moderna>", vs.toString());
			
			vs.addDistribution(v2, 2); /* 1st distribution of Pfizer */
			assertEquals("North York General Hospital has 5 available doses: <3 doses of Moderna, 2 doses of Pfizer/BioNTech>", vs.toString());
			
			vs.addDistribution(v1, 1); 
			assertEquals("North York General Hospital has 6 available doses: <4 doses of Moderna, 2 doses of Pfizer/BioNTech>", vs.toString());
			
			vs.addDistribution(v3, 1); /* 1st distribution of AZ */
			assertEquals("North York General Hospital has 7 available doses: <4 doses of Moderna, 2 doses of Pfizer/BioNTech, 1 doses of Oxford/AstraZeneca>", vs.toString());
			
			vs.addDistribution(v2, 3);
			assertEquals("North York General Hospital has 10 available doses: <4 doses of Moderna, 5 doses of Pfizer/BioNTech, 1 doses of Oxford/AstraZeneca>", vs.toString());
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
	}
	
	@Test
	public void test_vaccination_site_02b() {
		/* 
		 * Create a vaccination site with its name and
		 * 	the limit on the number of doses accumulated from the added distributions.
		 * For illustration, the limit is set with a small number.
		 */
		VaccinationSite vs = new VaccinationSite("North York General Hospital", 10);
		
		/* Add distributions of three recognized vaccines (identified by their codenames) */
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		Vaccine v3 = new Vaccine("AZD1222", "Non Replicating Viral Vector", "Oxford/AstraZeneca");
		
		try {
			/* 
			 * The string description of a vaccination site includes:
			 * 	1) its name
			 * 	2) total supply
			 * 	3) supplies of available kinds of vaccines (each displayed with their manufacturer; see below)
			 * 	
			 * 	Note. For 3), the order in which these supplies are reported corresponds to 
			 * 			the chronological order of their first-added distributions.
			 * 		  See the remaining test for an example. See the previous test method for contrast.
			 */
			
			vs.addDistribution(v3, 3); /* 1st distribution of AZ */
			assertEquals("North York General Hospital has 3 available doses: <3 doses of Oxford/AstraZeneca>", vs.toString());
			assertEquals(3, vs.getNumberOfAvailableDoses());
			assertEquals(3, vs.getNumberOfAvailableDoses("AZD1222"));
			assertEquals(0, vs.getNumberOfAvailableDoses("mRNA-1273"));
			assertEquals(0, vs.getNumberOfAvailableDoses("BNT162b2"));
			
			vs.addDistribution(v1, 2); /* 1st distribution of Moderna */
			assertEquals("North York General Hospital has 5 available doses: <3 doses of Oxford/AstraZeneca, 2 doses of Moderna>", vs.toString());
			assertEquals(5, vs.getNumberOfAvailableDoses());
			assertEquals(3, vs.getNumberOfAvailableDoses("AZD1222"));
			assertEquals(2, vs.getNumberOfAvailableDoses("mRNA-1273"));
			assertEquals(0, vs.getNumberOfAvailableDoses("BNT162b2"));
			
			vs.addDistribution(v3, 1); 
			assertEquals("North York General Hospital has 6 available doses: <4 doses of Oxford/AstraZeneca, 2 doses of Moderna>", vs.toString());
			assertEquals(6, vs.getNumberOfAvailableDoses());
			assertEquals(4, vs.getNumberOfAvailableDoses("AZD1222"));
			assertEquals(2, vs.getNumberOfAvailableDoses("mRNA-1273"));
			assertEquals(0, vs.getNumberOfAvailableDoses("BNT162b2"));
			
			vs.addDistribution(v2, 1); /* 1st distribution of Pfizer */
			assertEquals("North York General Hospital has 7 available doses: <4 doses of Oxford/AstraZeneca, 2 doses of Moderna, 1 doses of Pfizer/BioNTech>", vs.toString());
			assertEquals(7, vs.getNumberOfAvailableDoses());
			assertEquals(4, vs.getNumberOfAvailableDoses("AZD1222"));
			assertEquals(2, vs.getNumberOfAvailableDoses("mRNA-1273"));
			assertEquals(1, vs.getNumberOfAvailableDoses("BNT162b2"));
			
			vs.addDistribution(v1, 3);
			assertEquals("North York General Hospital has 10 available doses: <4 doses of Oxford/AstraZeneca, 5 doses of Moderna, 1 doses of Pfizer/BioNTech>", vs.toString());
			assertEquals(10, vs.getNumberOfAvailableDoses());
			assertEquals(4, vs.getNumberOfAvailableDoses("AZD1222"));
			assertEquals(5, vs.getNumberOfAvailableDoses("mRNA-1273"));
			assertEquals(1, vs.getNumberOfAvailableDoses("BNT162b2"));
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
	}
	
	@Test
	public void test_vaccination_site_02c() {
		/* 
		 * Create a vaccination site with its name and
		 * 	the limit on the number of doses accumulated from the added distributions.
		 * For illustration, the limit is set with a small number.
		 */
		VaccinationSite vs = new VaccinationSite("North York General Hospital", 10);
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("Covishield", "Non Replicating Viral Vector", "Serum Institute of India");
		
		try {
			/* Add the distribution of a recognized vaccine (identified by its codename) */
			vs.addDistribution(v1, 6); // 4 doses left before reaching the maximum    
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
		
		/* up to this point, the site is 4 doses away from being "full". */
		
		try {
			/* 
			 * Add the distribution of an unrecognized vaccine (identified by its codename).
			 * Even though the quantity to add (5) will cause the resulting supply 
			 * 	to exceed the limit 10 (set above), the error of unrecognized vaccine takes priority.	
			 */
			vs.addDistribution(v2, 5);   
			fail("Expected exception not thrown");
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			// Expected
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
	}
	
	@Test
	public void test_vaccination_site_02d() {
		/* 
		 * Create a vaccination site with its name and
		 * 	the limit on the number of doses accumulated from the added distributions.
		 * For illustration, the limit is set with a small number.
		 */
		VaccinationSite vs = new VaccinationSite("North York General Hospital", 10);
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		
		try {
			/* Add the distribution of a recognized vaccine (identified by its codename) */
			vs.addDistribution(v1, 6); // 4 doses left before reaching the maximum    
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
		
		/* up to this point, the site is 4 doses away from being "full". */
		
		assertEquals(6, vs.getNumberOfAvailableDoses());
		try {
			/* 
			 * Add the distribution of another recognized vaccine (identified by its codename).
			 * Given that the vaccine's codename is recognized, 
			 * 	because the quantity to add (5) will cause the resulting supply 
			 * 	to exceed the limit 10 (set above), an error related to too much distribution will occur.	
			 */
			vs.addDistribution(v2, 5);   
			fail("Expected exception not thrown");
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			// Expected
		}
		
		/* 
		 * Suggestion: write a case to add distributions of a number of different recognized vaccines,
		 * and let the last addition cause a TooMuchDistributionException.
		 */
	}
	
	@Test
	public void test_vaccination_site_03a() {
		/* 
		 * Create a vaccination site with its name and
		 * 	the limit on the number of doses accumulated from the added distributions.
		 * For illustration, the limit is set with a small number.
		 */
		VaccinationSite vs = new VaccinationSite("North York General Hospital", 10);
		
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		try {
			/* Add distributions of two recognized vaccines. */
			vs.addDistribution(v1, 1);   
			vs.addDistribution(v2, 2); 
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
		
		/* 3 doses are available: 3 appointments are possible */
		assertEquals(3, vs.getNumberOfAvailableDoses());
		
		HealthRecord alan = new HealthRecord("Alan", 5);
		HealthRecord mark = new HealthRecord("Mark", 5);
		HealthRecord tom = new HealthRecord("Tom", 5);
		
		try {
			/* 
			 * See Section 2.3 in lab manual for the maximum number of allowed appointments for a site.
			 */
			vs.bookAppointment(alan);
			/* success of appointment is reflected on the patient's appointment status */
			assertEquals("Last vaccination appointment for Alan with North York General Hospital succeeded", alan.getAppointmentStatus());
			vs.bookAppointment(mark);
			assertEquals("Last vaccination appointment for Mark with North York General Hospital succeeded", mark.getAppointmentStatus());
			vs.bookAppointment(tom);
			assertEquals("Last vaccination appointment for Tom with North York General Hospital succeeded", tom.getAppointmentStatus());
		}
		catch(InsufficientVaccineDosesException e) {
			fail("Unexpected exception thrown");
		}
		
		/* 
		 * 3 appointments reserved: once they are administered, no doses will be left for further appointments.
		 * 
		 * However, since these appointments have not yet been administered, 
		 * 	  the counting of available doses still includes ones that will be consumed by these appointments.  
		 */
		assertEquals(3, vs.getNumberOfAvailableDoses());
		
		HealthRecord jim = new HealthRecord("Jim", 5);
		try {
			vs.bookAppointment(jim);
			fail("Expeted exception not thrown");
		}
		catch(InsufficientVaccineDosesException e) {
			/* failure of appointment is reflected on the patient's appointment status */
			assertEquals("Last vaccination appointment for Jim with North York General Hospital failed", jim.getAppointmentStatus());
		}
	}
	
	@Test
	public void test_vaccination_site_03b() {
		/* 
		 * Create two vaccination sites with their names and
		 * 	limits on the number of doses accumulated from the added distributions.
		 * For illustration, the limits are set with small numbers.
		 */
		VaccinationSite vs1 = new VaccinationSite("North York General Hospital", 10);
		VaccinationSite vs2 = new VaccinationSite("Humber River Hospital", 8);
		
		Vaccine v1a = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v1b = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2a = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		Vaccine v2b = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		try {
			/* Add distributions of two recognized vaccines to each site. */
			vs1.addDistribution(v1a, 2);   
			vs1.addDistribution(v2a, 4);
			vs2.addDistribution(v1b, 3);   
			vs2.addDistribution(v2b, 4);
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
		
		/* 6 appointments possible for site 1 and 7 appointments possible for site 2 */
		assertEquals(6, vs1.getNumberOfAvailableDoses());
		assertEquals(7, vs2.getNumberOfAvailableDoses());
		
		HealthRecord alan = new HealthRecord("Alan", 5);
		try {
			/* 
			 * Book the 1st dose appointment for alan.
			 * Success of appointment is reflected on the patient's appointment status. 
			 */
			vs1.bookAppointment(alan);
			assertEquals("Last vaccination appointment for Alan with North York General Hospital succeeded", alan.getAppointmentStatus());
			
			/* 
			 * Book the 2nd dose appointment for alan. 
			 * Success of appointment is also updated on the patient's appointment status. 
			 */
			vs2.bookAppointment(alan);
			assertEquals("Last vaccination appointment for Alan with Humber River Hospital succeeded", alan.getAppointmentStatus());
			
			/* 
			 * Since these appointments have not yet been administered, 
			 * 	  the counting of available doses still includes ones that will be consumed by these appointments.  
			 */
			assertEquals(6, vs1.getNumberOfAvailableDoses());
			assertEquals(7, vs2.getNumberOfAvailableDoses());
		}
		catch(InsufficientVaccineDosesException e) {
			fail("Unexpected exception thrown");
		}
	}
	
	/*
	 * Recommended exercises: 
	 * 	Visualizing and tracing (on both debugger and paper) on how objects are created and manipulated
	 * 	in each test would be extremely valuable for reinforcing your understanding.
	 */
	@Test
	public void test_vaccination_site_04() {
		/* 
		 * Create a vaccination site with its name and
		 * 	the limit on the number of doses accumulated from the added distributions.
		 * For illustration, the limit is set with a small number.
		 */
		VaccinationSite vs = new VaccinationSite("North York General Hospital", 10);
		
		/* Add distributions of three recognized vaccines (identified by their codenames) */
		Vaccine v1 = new Vaccine("mRNA-1273", "RNA", "Moderna");
		Vaccine v2 = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
		Vaccine v3 = new Vaccine("AZD1222", "Non Replicating Viral Vector", "Oxford/AstraZeneca");
		
		try { 
			vs.addDistribution(v3, 1); /* 1st distribution of AZ */
			vs.addDistribution(v1, 1); /* 1st distribution of Moderna */
			vs.addDistribution(v3, 1);
			vs.addDistribution(v2, 1); /* 1st distribution of Pfizer */
			vs.addDistribution(v1, 1);
			assertEquals("North York General Hospital has 5 available doses: <2 doses of Oxford/AstraZeneca, 2 doses of Moderna, 1 doses of Pfizer/BioNTech>", vs.toString());
			
			HealthRecord alan = new HealthRecord("Alan", 5);
			HealthRecord mark = new HealthRecord("Mark", 5);
			HealthRecord tom = new HealthRecord("Tom", 5);
			HealthRecord jim = new HealthRecord("Jim", 5);
			
			/* Book 1st-dose appointments */
			vs.bookAppointment(alan);
			vs.bookAppointment(mark);
			vs.bookAppointment(tom); 
			
			/* 
			 * When administering vaccines doses for appointments,
			 * 	the order in which doses are consumed corresponds to 
			 * 	the chronological order in which their first-distributions were added. 
			 * 	(That is, for the purpose of this lab, we do not worry about receiving doses from the same kind of vaccine for each patient).
			 * 
			 * From the above example, AZ will be consumed first, then Moderna, and finally Pfizer. 
			 */
			vs.administer("April-23-2021");
			
			/* 
			 * After administering all patients' first doses,
			 * 	updates should have occurred on both the vaccination site and each of the patients:
			 * 		- Updates on the site: 
			 * 			+ The supply decreases accordingly. 
			 * 			+ The list of appointments is cleared/reset and 
			 * 				new appointments may be accepted should the remaining supply allow.
			 *		- Updates on each patient:
			 *			+ The vaccination's information is added to their record
			 *				(i.e., vaccine, name of site, and date of vaccination).
			 */
			
			/* updated site */
			assertEquals("North York General Hospital has 2 available doses: <0 doses of Oxford/AstraZeneca, 1 doses of Moderna, 1 doses of Pfizer/BioNTech>", vs.toString());
			
			/* updated patients */
			assertEquals("Number of doses Alan has received: 1 [Recognized vaccine: AZD1222 (Non Replicating Viral Vector; Oxford/AstraZeneca) in North York General Hospital on April-23-2021]", alan.getVaccinationReceipt());
			assertEquals("Number of doses Mark has received: 1 [Recognized vaccine: AZD1222 (Non Replicating Viral Vector; Oxford/AstraZeneca) in North York General Hospital on April-23-2021]", mark.getVaccinationReceipt());
			assertEquals("Number of doses Tom has received: 1 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on April-23-2021]", tom.getVaccinationReceipt());
			
			/* unchanged patients */
			assertEquals("Jim has not yet received any doses.", jim.getVaccinationReceipt());
			
			/* 
			 * Book 1st-dose and 2nd-dose appointments.
			 * Specially, alan and tom should not exist in the new appointment list.  
			 */
			vs.bookAppointment(mark);
			vs.bookAppointment(jim);
			
			vs.administer("August-31-2021");
			
			/* updated site */
			assertEquals("North York General Hospital has 0 available doses: <0 doses of Oxford/AstraZeneca, 0 doses of Moderna, 0 doses of Pfizer/BioNTech>", vs.toString());
			
			/* updated patients */
			assertEquals("Number of doses Mark has received: 2 [Recognized vaccine: AZD1222 (Non Replicating Viral Vector; Oxford/AstraZeneca) in North York General Hospital on April-23-2021; Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on August-31-2021]", mark.getVaccinationReceipt());
			assertEquals("Number of doses Jim has received: 1 [Recognized vaccine: BNT162b2 (RNA; Pfizer/BioNTech) in North York General Hospital on August-31-2021]", jim.getVaccinationReceipt());
			
			/* unchanged patients */
			assertEquals("Number of doses Alan has received: 1 [Recognized vaccine: AZD1222 (Non Replicating Viral Vector; Oxford/AstraZeneca) in North York General Hospital on April-23-2021]", alan.getVaccinationReceipt());			
			assertEquals("Number of doses Tom has received: 1 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on April-23-2021]", tom.getVaccinationReceipt());
			
		}
		catch(UnrecognizedVaccineCodeNameException e) {
			fail("Unexpected exception thrown");
		}
		catch(TooMuchDistributionException e) {
			fail("Unexpected exception thrown");
		}
		catch(InsufficientVaccineDosesException e) {
			fail("Unexpected exception thrown");
		}
		
		/*
		 * Suggestion: write a case to add distributions in a different order,
		 * 	so that when appointments are administered, avaialble vaccines will be consumed in a different order accordingly.
		 */
	}
} 