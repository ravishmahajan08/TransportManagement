package driver;

import postCanada.PackageExpection;
import postCanada.Truck;

public class Testing {

	 public static void main(String[] args) throws PackageExpection {
	//1
		Truck x = new Truck();
		int numberOfPackages=200;
		
		
		x.setDriverName("Sam");
		x.setUnloadedWeight(100);
		x.setOriginatingCity("Montreal");
		x.setDestinationcity("Toronto");
	//7
		System.out.println("/----------------------------------------------------------------------------------/");
		System.out.println("The truck with "+ x.getUnloadedWeight() +" weight and its driver "+ x.getDriverName()+" is driving from "+ x.getOriginatingCity()+ " to "+ x.getDestinationcity() );
		System.out.println("/----------------------------------------------------------------------------------/");
		
		System.out.println();
		System.out.println();
		System.out.println();
	//2
		System.out.println("                 !! Start loading packages:  !!               ");
		x.setNumberOfPackages(numberOfPackages);
			
			String a[] = new String[numberOfPackages];
			double w[] = new double[numberOfPackages];

			
			for(int i=0;i<a.length;i++)
			{
				a[i]= "MonTor"+i;
				w[i]=2.0+i;
			
			
				try
				{
					x.load(a[i], w[i],"o");
				}
				catch (PackageExpection e){
					e.printStackTrace();
				}
	//4
				System.out.println("*****************************************************************************");
				System.out.println(" number of packages that are loaded till now : " + Truck.packageLoaded);
				System.out.println("*****************************************************************************");
			}
			
			System.out.println();
			System.out.println();
	//5
			System.out.println("The total Shipping cost is: ");
			x.displayTotalShipCost();
			
			System.out.println();
			System.out.println();
	//6
			x.displayTotalWeight();
			
			System.out.println();
			System.out.println();
	//3
			System.out.println("the truck is unloading the packages\n");
			x.displayinfo();
			x = new Truck();
			
	
	 
	 }		

}


