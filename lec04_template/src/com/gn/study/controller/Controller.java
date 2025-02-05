package com.gn.study.controller;

import java.util.List;
import java.util.Map;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

// View로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private Service service = new Service();
	
	public int updateCarOne(int carNo, Map<String,Object> map) {
		return service.updateCarOne(carNo, map);
	} 
	
	public int deleteCarOne(int carNo) {
		return service.deleteCarOne(carNo);
	}
	
	public List<Car> searchCarList(int option, Object obj){
		return service.searchCarList(option,obj);
	}
	
	public Car selectCarOne(String modelName) {
		return service.selectCarOne(modelName);
	}
	
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
	
	public int insertCarOne(String modelName ,int price ,String date) {
		Car car = new Car(modelName ,price ,date);
		int result = service.insertCarOne(car);
		return result; 
	}
}
