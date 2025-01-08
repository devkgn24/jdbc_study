package com.gn.study.model.vo;

public class Car {
	private int carNo;
	private String carModel;
	private int carPrice;
	private String carDate;
	
	public Car() {}
	
	public Car(String carModel, int carPrice, String carDate) {
		this.carModel = carModel;
		this.carPrice = carPrice;
		this.carDate = carDate;
	}
	
	public String getCarModel() {
		return carModel;
	}
	
	public int getCarPrice() {
		return carPrice;
	}
	
	public String getCarDate() {
		return carDate;
	}
}
