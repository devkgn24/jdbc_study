package com.gn.study.model.vo;

import java.time.LocalDateTime;

public class ProjectVo {
	private int projectId;	// PK(번호)
	private String projectName; // 프로젝트명
	private int projectManager;	// FK(employee의 emp_id) -> 관리자 사번
	private LocalDateTime regDate;	// 등록일
	private LocalDateTime modDate;	// 수정일
	private String managerName;	// 관리자 이름
	
	public ProjectVo() {}
	
	public ProjectVo(int projectId, String projectName, int projectManager) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
	}

	public ProjectVo(int projectId, String projectName, int projectManager
			, LocalDateTime regDate,
			LocalDateTime modDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName; 
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
//		System.out.println("프로젝트 매니저 : "+projectManager);
//		System.out.println("매니저 이름 : "+managerName);
//		System.out.println("매니저 이름의 타입 : "+(managerName instanceof String));
		
		return "[번호 : " + projectId 
				+ ", 이름 : " + projectName 
				// projectManager가 없으면 -> 미정
				// projectManager가 있다면 -> 관리자이름(사번)
				+ ", 관리자 : "+ (projectManager == 0 ? "미정":managerName+"("+projectManager+")") 
				+ ", 등록일 : " + regDate 
				+ ", 수정일 : " + modDate + "]";
	}
	
	
	
}
