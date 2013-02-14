package com.example.procencik;

public class Place {
	private String name;
	private String street;
	private double latitude;
	private double longitude;
	private double commonFrom;
	private double commonTo;
	private double weekFrom;
	private double weekTo;
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getCommonFrom() {
		return commonFrom;
	}
	public void setCommonFrom(double commonFrom) {
		this.commonFrom = commonFrom;
	}
	public double getCommonTo() {
		return commonTo;
	}
	public void setCommonTo(double commonTo) {
		this.commonTo = commonTo;
	}
	public double getWeekFrom() {
		return weekFrom;
	}
	public void setWeekFrom(double weekFrom) {
		this.weekFrom = weekFrom;
	}
	public double getWeekTo() {
		return weekTo;
	}
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