package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.ProjectVo;

public class ProjectDao {
	public List<ProjectVo> selectProjectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);	
			
			String sql = "SELECT * FROM project";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProjectVo vo = new ProjectVo();
				vo.setProjectId(rs.getInt("project_id"));
				vo.setProjectName(rs.getString("project_name"));
				vo.setProjectManager(rs.getInt("project_manager"));
				vo.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				vo.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertProjectOne(String projectName, String managerName) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "INSERT INTO project(project_name ,project_manager) "
						+ "VALUES ( ? ,(SELECT emp_id "
						+ "				FROM employee "
						+ "				WHERE emp_name = ?))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectName);
			pstmt.setString(2, managerName);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
}
