package com.example.procencik;

public class Place {

	/** Store name **/
	private String name;
	/** Street store **/
	private String street;
	/** Point latitude **/
	private double latitude;
	/** Point longitude **/
	private double longitude;
	/** Common days open hours from **/
	private double commonFrom;
	/** Common days open hours to **/
	private double commonTo;
	/** Week days open hours to **/
	private double weekFrom;
	/** Week days open hours to **/
	private double weekTo;

	/**
     * Create Place.
     */
	public Place(String name, String street, double latitude, double longitude,
			double commonFrom, double commonTo, double weekFrom, double weekTo) {
		super();
		this.name = name;
		this.street = street;
		this.latitude = latitude;
		this.longitude = longitude;
		this.commonFrom = commonFrom;
		this.commonTo = commonTo;
		this.weekFrom = weekFrom;
		this.weekTo = weekTo;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return commonFrom
	 */
	public double getCommonFrom() {
		return commonFrom;
	}

	/**
	 * @param commonFrom
	 *            the commonFrom to set
	 */
	public void setCommonFrom(double commonFrom) {
		this.commonFrom = commonFrom;
	}

	/**
	 * @return commonTo
	 */
	public double getCommonTo() {
		return commonTo;
	}

	/**
	 * @param commonTo
	 *            the commonTo to set
	 */
	public void setCommonTo(double commonTo) {
		this.commonTo = commonTo;
	}

	/**
	 * @return weekFrom
	 */
	public double getWeekFrom() {
		return weekFrom;
	}

	/**
	 * @param weekFrom
	 *            the weekFrom to set
	 */
	public void setWeekFrom(double weekFrom) {
		this.weekFrom = weekFrom;
	}

	/**
	 * @return weekTo
	 */
	public double getWeekTo() {
		return weekTo;
	}

	/**
	 * @param weekTo
	 *            the weekTo to set
	 */
	public void setWeekTo(double weekTo) {
		this.weekTo = weekTo;
	}

	@Override
	public String toString() {
		return "Place [name=" + name + ", street=" + street + ", latitude="
				+ latitude + ", longitude=" + longitude + ", commonFrom="
				+ commonFrom + ", commonTo=" + commonTo + ", weekFrom="
				+ weekFrom + ", weekTo=" + weekTo + "]";
	}

}