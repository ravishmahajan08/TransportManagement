/*
 Name and ID : Sukoon Tandon 40151789 and Ravish Mahajan 40152664
 Comp 249
 Assignment 2
 Due Date : 4th Aug, 2021
 */


package driver;

/*
Assignment 2
Part 1
Written by: Sukoon Tandon 40151789 and Ravish Mahajan 40152664
*/
import java.util.Scanner;

import postCanada.PackageExpection;
import postCanada.Truck;

 
public class CargoTest {

	public static void main(String[] args) throws PackageExpection {

		Scanner sc = new Scanner(System.in);
		
		// creating an object for Truck class 
		Truck t1 = new Truck();
		
		boolean flag= true;
		while(flag) {
		
			System.out.println("\nWhat would you like to do?\n" +
				"1. Start a cargo\n" + 
				"2. Load the truck with packages\n" + 
				"3. Unload a package\n" + 
				"4. The number of packages loaded\n" + 
				"5. The gross income earned by shipping of the cargo\n" + 
				"6. Weight the truck(after it has been completely loaded)\n" + 
				"7. Drive the truck to destination\n" + 
				"0. To quit\n"+
				"Please enter your choice and press <Enter>:");
				
	int option=sc.nextInt();
	
		
	if(option==1) {
	
		System.out.println("Enter Driver's name");
		String n = sc.next(); 
	
		t1.setDriverName(n);


		System.out.println("Enter Unloaded weight of Truck: ");
		double n1 = sc.nextDouble();

		System.out.println("Weight entered in pounds or kilograms? Press p for pound and k for kilograms! ");
		String x = sc.next();
		if(x.equals("k"))
		{
			double y = t1.toPounds(n1);
			t1.setUnloadedWeight(y);
		}
		else if(x.equals("p"))
		{
			t1.setUnloadedWeight(n1);
		}
		
		System.out.println("Enter Originating city");
		String n2 = sc.next(); 
		t1.setOriginatingCity(n2);
	
		System.out.println("Enter Destination city");
		String n3 = sc.next(); 
		t1.setDestinationcity(n3);
		
		}
	
		
	else if(option==2) {
		
		System.out.println("enter the number of packages to be loaded: ");
		int numberOfPackages=sc.nextInt();
		
		t1.setNumberOfPackages(numberOfPackages);
		
		if(numberOfPackages>200) {
			throw new PackageExpection("cannot carry the truck is full");
		}
		
			for(int i =0;i< numberOfPackages;i++) {
			
			System.out.println("Enter Tracking Number of Package: ");
			String str =sc.next();

			System.out.println("Enter Weight of Package: " );
			double wei = sc.nextDouble();
			System.out.println("Weight entered in pounds or ounces? Press p for pound and o for ounces! ");
			String q = sc.next();

			try
			{
				t1.load(str, wei,q);
			}
			catch (PackageExpection e){
				e.printStackTrace();
			}
			System.out.println("*****************************************************************************");
			System.out.println(" number of packages that are loaded till now : " + Truck.packageLoaded);
			System.out.println("*****************************************************************************");
		}

	}
	
	else if(option==3) {
		System.out.println("the truck is unloading the packages\n");
		
		t1.displayinfo();
		t1 = new Truck();
	}
	else if(option==4) {
		System.out.println("The total no. of packages loaded in truck are: ");
		t1.display();
	}
	else if(option==5) {
		System.out.println("The total Shipping cost is: ");
		t1.displayTotalShipCost();
	}
	else if(option==6) {
		t1.displayTotalWeight();
	}
	else if(option==7) {
		System.out.println("The truck and its driver "+ t1.getDriverName()+" is driving from "+ t1.getOriginatingCity()+ " to "+ t1.getDestinationcity() );
	}
	else if(option==0) {
		flag =false;
	}
		}
	}
}

