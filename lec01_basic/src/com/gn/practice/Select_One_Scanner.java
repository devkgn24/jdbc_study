package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.gn.study.model.vo.Test;


public class Select_One_Scanner {
	public static void main(String[] args) {
		// 사용자로부터 조회하고자 하는 행의 번호 입력받기
		// 조회한 결과를 Vo에 담아서 출력하기
		
		// 조회하고자 하는 행의 번호를 입력하세요.
		// 번호 : **2**
		// 번호:2, 이름:테스트2, 등록일:2024년05월15일 16시15분50초	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("조회하고자 하는 행의 번호를 입력하세요");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			// 3
			stmt = conn.createStatement();
			// 4
			// 입력받은 번호를 t_no로 가지고 있는 행의 정보 조회
			String sql = "SELECT t_no ,t_name ,t_date FROM test WHERE t_no = "+num;
			rs = stmt.executeQuery(sql);
			
			// 5
			Test t = null;
			if(rs.next()) {
				int tNo = rs.getInt("t_no");
				String tName = rs.getString("t_name");
				LocalDateTime ldt = rs.getTimestamp("t_date").toLocalDateTime();
				t = new Test(tNo,tName,ldt);
			}
			// 6
			if(t == null) {
				System.out.println("조회된 결과가 없습니다.");
			} else {
				// 번호:2, 이름:테스트2, 등록일:2024년05월15일 16시15분50초
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초");
				System.out.println("번호:"+t.getTestNo()+", 이름:"+t.getTestName()
						+", 등록일:"+t.getTestDate().format(dtf));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
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
