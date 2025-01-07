package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Member;

public class MemberDao {
	public int updateMemberInfo(int memNo, String memName, String memPhone, String memEmail) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw ="tiger";
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			String sql = "UPDATE `member` "
					+"SET m_name = '"+memName+"' "
					+",m_email = '"+memEmail+"'"
					+",m_phone = '"+memPhone+"'"
					+"WHERE m_no = "+memNo;
			result = stmt.executeUpdate(sql);
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
		return result;
	}
	
	public Member selectMemberOneByIdAndPw(String memId, String memPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw ="tiger";
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member WHERE m_id = '"+memId+"' AND m_pw = '"+memPw+"'");
			if(rs.next()) {
				m = new Member(rs.getInt("m_no"),rs.getString("m_id"),rs.getString("m_pw"));
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
		return m;
	}
	
	
	public Member selectMemberOneById(String memId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw ="tiger";
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member WHERE m_id = '"+memId+"'");
			if(rs.next()) {
				m = new Member(rs.getInt("m_no"),rs.getString("m_id"),rs.getString("m_pw"));
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
		return m;
	}
	
	public List<Member> selectMemberAll() {
		// 전체 member 정보 조회 -> List<Member>
		List<Member> list = new ArrayList<Member>();
		// DB에 SQL문 요청
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw ="tiger";
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member");
			while(rs.next()) {
				Member m = new Member(rs.getInt("m_no")
						,rs.getString("m_id")
						,rs.getString("m_pw")
						,rs.getString("m_name")
						,rs.getString("m_email")
						,rs.getString("m_phone")
						,rs.getString("m_gender")
						,rs.getTimestamp("reg_date").toLocalDateTime()
						,rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m);
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

		
		
		return list;
	}

	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
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
			result = stmt.executeUpdate(sql);
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
		return result;
	}
}
