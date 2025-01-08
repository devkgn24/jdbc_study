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
	
	public Car(int carNo, String carModel, int carPrice, String carDate) {
		this.carNo = carNo;
		this.carModel = carModel;
		this.carPrice = carPrice;
		this.carDate = carDate;
	}
	

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public void setCarDate(String carDate) {
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
	
	@Override
	public String toString() {
		String str = "번호 : "+carNo+", 모델명 : "+carModel
				+", 가격 : "+carPrice+", 출시일 : "+carDate;
		return str;
	}
	
	
	
	
}
