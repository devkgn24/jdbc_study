package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gn.study.model.vo.Car;

public class Dao {
	public int insertCarOne(Car car, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO car (car_model ,car_price ,car_date) "
						+ "VALUES(?,?,STR_TO_DATE(?,'%Y-%m-%d')) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getCarModel());
			pstmt.setInt(2, car.getCarPrice());
			pstmt.setString(3, car.getCarDate());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
