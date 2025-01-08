package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;

// DB에 접속 -> Connection 객체 생성
public class Service {
	private Dao dao = new Dao();
	
	public int deleteCarOne(int carNo) {
		Connection conn = getConnection();
		int result = dao.deleteCarOne(carNo,conn);
		close(conn);
		return result;
	}
	
	public List<Car> searchCarList(int option, Object obj){
		Connection conn = getConnection();
		List<Car> list = dao.searchCarList(option,obj,conn);
		close(conn);
		return list;
	}
	
	public Car selectCarOne(String modelName) {
		Connection conn = getConnection();
		Car car = dao.selectCarOne(conn,modelName);
		close(conn);
		return car;
	}
	
	public List<Car> selectCarAll(){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarAll(conn);
		close(conn);
		return list;
	}
	
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.insertCarOne(car, conn);
		close(conn);
		return result;
		
//		Connection conn = null;
//		int result = 0;
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url ="jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
//			String user = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url, user, pw);
//			result = dao.insertCarOne(car,conn);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn != null) conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}
}
