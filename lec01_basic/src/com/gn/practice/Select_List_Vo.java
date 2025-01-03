package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Test;

public class Select_List_Vo {
	public static void main(String[] args) {
		// Test 테이블에 있는 모든 정보 조회
		// 조회 결과를 List<Test>에 담기
		// 조회 결과 출력해보기
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. DriverManager 위치 알려주기
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. Connection 객체 생성
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			// 3. Statement 객체 생성
			stmt = conn.createStatement();
			// 4. SQL문 실행
			String sql = "SELECT t_no ,t_name ,t_date FROM test";
			rs = stmt.executeQuery(sql);
			// 5. 결과 파싱
			List<Test> list = new ArrayList<Test>();
			while(rs.next()) {
				Test t = new Test();
				t.setTestNo(rs.getInt("t_no"));
				t.setTestName(rs.getString("t_name"));
				t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
				list.add(t);
			}
			// 6. 결과 출력
			if(list.isEmpty()) {
				System.out.println("조회된 결과가 없습니다.");
			} else {
				for(int i = 0 ; i < list.size() ; i++) {
					System.out.println(list.get(i));
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 8. 사용한 객체 close
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
