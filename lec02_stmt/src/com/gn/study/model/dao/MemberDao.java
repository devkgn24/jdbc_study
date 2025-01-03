package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.gn.study.model.vo.Member;

public class MemberDao {

	public void insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO member (m_id ,m_pw ,m_name ,m_email ,m_gender ,m_phone) "
					+ " VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()+"','"+m.getMemberName()
					+"','"+m.getMemberEmail()+"','"+m.getMemberGender()+"','"+m.getMemberPhone()+"')";
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
