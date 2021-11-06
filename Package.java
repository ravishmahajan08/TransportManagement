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

public abstract class Package {
	/**
	 * the tracking number of the package.
	 */
	private String trackingNumber;
	/**
	 * the weight of the package.
	 */
	private double weight;
	/**
	 * the shipping cost of the package.
	 */
	private double shippingCost;
	
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	
	// abstract method to calculate the shipment cost.
	abstract double shipcost(double cost);
	/**
	 * this method takes in the weight of the package in pounds and convert into Ounces
	 * @param weight
	 * @return double
	 */
	double toOunces(double weight)
	{
		return weight*16.0;
	}
	/**
	 * this method takes in the weight of the package in ounces and convert into pounds
	 * @param weight
	 * @return double
	 */
	double toPounds(double weight)
	{
		return 0.0625*weight;
	}
	
}
