package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class E_Insert_Transaction {
	public static void main(String[] args) {
		// 1. JDBC 작영용 객체 선언 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 2. try~catch~finally
		try {
			// 3. DriverManager 등록
			Class.forName("org.mariadb.jdbc.Driver");
			// 4. Connection 객체 생성
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			// 5. AutoCommit 해제
			conn.setAutoCommit(false);
			// 6. Statement 생성
			stmt = conn.createStatement();
			// 7. SQL문 실행
			// 데이터 존재 여부 -> 갯수
			String str = "테스트3";
			String sql1 = "SELECT COUNT(*) FROM test WHERE t_name='"+str+"'";
			rs = stmt.executeQuery(sql1);
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			// 8. 결과 확인
			// System.out.println(cnt);
			if(cnt == 0) {
				// INSERT하기
				String sql2 = "INSERT INTO test(t_name) VALUES ('"+str+"')";
				int result = stmt.executeUpdate(sql2);
				if(result > 0) {
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}
			} else {
				System.out.println("이미 존재하는 이름입니다.");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
