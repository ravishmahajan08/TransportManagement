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

public class MetalCrate extends Crate {
	/**
	 * the tcost of carrying the MetalCrate
	 */
	private double tcost;
	@Override
    double shipcost(double wt)
    {
        tcost = 3.00 * wt;
        return tcost;
    }
	
}
