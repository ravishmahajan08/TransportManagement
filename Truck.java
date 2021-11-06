/*
 Name and ID : Sukoon Tandon 40151789 and Ravish Mahajan 40152664
 Comp 249
 Assignment 2
 Due Date : 4th Aug, 2021
 */

package postCanada;

/*
Assignment 2
Part 1
Written by: Sukoon Tandon 40151789 and Ravish Mahajan 40152664
*/

import java.util.Scanner;

public class Truck {

	/**
	 * The Driver assigned to the truck.
	 */
	private	String DriverName;
	/**
	 * The originating city of the truck.
	 */
	private	String originatingCity;
	/**
	 * The Destination city of the truck.
	 */
	private	String destinationcity;
	/**
	 * The Gross weight of the truck.
	 */
	private	int grossWeight;
	/**
	 * The unloaded weight of the truck.
	 */
	private	double unloadedWeight;
	/**
	 * The number of packages assigned to  the truck.
	 */
	private	int numberOfPackages;
	/**
	 * The actual number of packages loaded into to the truck.
	 */
	public static int packageLoaded;
	/**
	 * the total letters shipment cost.
	 */
	private double totalLetterscost=0;
	/**
	 * the total box shipment cost.
	 */
	private double totalBoxcost = 0;
	/**
	 * the total metalCrate shipment cost.
	 */
	private double totalMCcost = 0;
	/**
	 * the total woodCrate shipment cost.
	 */
	private double totalWCcost =0;
	/**
	 * Total weight of all packages that are suppossed to be carried by the truck.
	 */
	private double total= 0;
	
	// Creating a package array to store the packages to be loaded on the truck.
	Package[] array = new Package[200];
	
	/**
	 * This method filter out the packages from the packages that are not supposed to be carried by the Truck.
	 * @param str
	 * @param weight
	 * @throws PackageExpection
	 */
	public void load(String str, double weight,String q) throws PackageExpection {
		
		Scanner sc = new Scanner(System.in);
		
		if (str.charAt(str.length()-1)== '0') {
			
			Letter l1 = new Letter();
			
			
			if(q.equals("o"))
			{
				weight = l1.toPounds(weight);
				l1.setWeight(weight);
			}
			else
			{
				l1.setWeight(weight);
			}
			
			l1.setTrackingNumber(str);
			
			if(weight>2.0) {
				throw new PackageExpection("package Letter overWeighted cannot be Loaded "+ " the tracking number is "+ str+ " "+" the weight is "+ weight );
			}
			
			System.out.println("get some space");
			
			array[packageLoaded] = l1;
			
			totalLetterscost = totalLetterscost + l1.shipcost(l1.getWeight());
		}
		
		else if (str.charAt(str.length()-1)== '1' ) {
			
			Box b1 = new Box();
			
			
			if(q.equals("o"))
			{
				weight = b1.toPounds(weight);
				b1.setWeight(weight);
			}
			else
			{
				b1.setWeight(weight);
			}

			b1.setTrackingNumber(str);
			if(weight>40.0) {
				
				throw new PackageExpection("package Box overWeighted cannot be Loaded "+ " the tracking number is "+ str+ " "+" the weight is "+ weight);
			}
			System.out.println("get some space");
			array[packageLoaded] = b1;
			totalBoxcost = totalBoxcost+ b1.shipcost(b1.getWeight());
		}
		
		else if (str.charAt(str.length()-1)== '2' ) {
			WoodCrate w1 = new WoodCrate();
			
			
			if(q.equals("o"))
			{
				weight = w1.toPounds(weight);
				w1.setWeight(weight);
			}
			else
			{
				w1.setWeight(weight);
			}

			w1.setTrackingNumber(str);
			if(weight >80.0) {
				throw new PackageExpection("package WoodCrate overWeighted cannot be Loaded "+" the tracking number is "+ str+ " "+" the weight is "+ weight);
			}
			System.out.println("get some space");
			array[packageLoaded] = w1;
			totalWCcost = totalWCcost+ w1.shipcost(w1.getWeight());
		}
	
		else if (str.charAt(str.length()-1)== '3' ) {
			MetalCrate  m1 = new MetalCrate();

			if(q.equals("o"))
			{
				weight = m1.toPounds(weight);
				m1.setWeight(weight);
			}
			else
			{
				m1.setWeight(weight);
			}

			m1.setTrackingNumber(str);
			if(weight>100.0) {
				throw new PackageExpection("package MetalCrate overWeighted cannot be Loaded "+ " the tracking number is "+ str+ " "+" the weight is "+ weight);
			}
			System.out.println("get some space");
			array[packageLoaded] = m1;
			totalMCcost = totalMCcost+ m1.shipcost(m1.getWeight());
		}
		
		else {
			throw new PackageExpection("package UnKnown !!!!No such Package is allowed to carry by this truck!!!! " + " the tracking number is "+ str+ " "+" the weight is "+ weight);
		}
	
		packageLoaded++;
		
		if(packageLoaded>200) {
			throw new PackageExpection("cannot carry the truck is full !!!No more package allowed to be load in the Truck!!! "+" the tracking number is "+ str+ " "+" the weight is "+ weight);
		}
	}
	
	
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	public String getOriginatingCity() {
		return originatingCity;
	}
	public void setOriginatingCity(String originatingCity) {
		this.originatingCity = originatingCity;
	}
	public String getDestinationcity() {
		return destinationcity;
	}
	public void setDestinationcity(String destinationcity) {
		this.destinationcity = destinationcity;
	}
	public int getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(int grossWeight) {
		this.grossWeight = grossWeight;
	}
	public double getUnloadedWeight() {
		return unloadedWeight;
	}
	public void setUnloadedWeight(double unloadedWeight) {
		this.unloadedWeight = unloadedWeight;
	}
	public int getNumberOfPackages() {
		return numberOfPackages;
	}
	public void setNumberOfPackages(int numberOfPackages) {
		this.numberOfPackages = numberOfPackages;
	}
	
	/**
	 * This method converts the truck weight into pounds from kilograms
	 * @param UnloadedWeight
	 * @return
	 */
	public double toPounds(double UnloadedWeight)
	{
		return UnloadedWeight*2.205;
	}
	/**
	 * This method converts the truck weight into kilograms from pounds
	 * @param UnloadedWeight
	 * @return
	 */
	public double toKilograms(double UnloadedWeight)
	{
		return UnloadedWeight/2.205;
	}
	/**
	 * This method display the actual number of packages loaded after filtering out
	 */
	public void display() {
	
		System.out.println(packageLoaded);
	}
	/**
	 * This method display the Gross income generated by the Truck.
	 */
	public void displayTotalShipCost() {
		

		System.out.println(totalLetterscost+ totalBoxcost+ totalWCcost+totalMCcost );
	}
	/**
	 * This method display the total weight of the packages loaded into the Truck.
	 */
	public void displayTotalWeight() {
		
		for(int i =0;i<packageLoaded;i++) {
		if(array[i].getWeight()==0)
		{
			System.out.println("The truck has not been loaded yet!!");
			break;
		}
		else {
			total = total + array[i].getWeight();
		}
	}
	System.out.println("Weight of truck in pounds is: " + (double)(unloadedWeight+total) + " lb");
	System.out.println("Weight of truck in Kilograms is: " + toKilograms(unloadedWeight+total) + " kg");
	}
	
	/**
	 * this display the package information as well its tracking number and weight.
	 */
	public void displayinfo()
	{
		for(int i =0;i<packageLoaded;i++)
		{
			System.out.println("Details of Unloaded Package " + (i+1) );
			System.out.println("The Tracking number is: " + array[i].getTrackingNumber());
			System.out.println("The weight is: " + array[i].getWeight());
			System.out.println();
		}
	}
	
}
