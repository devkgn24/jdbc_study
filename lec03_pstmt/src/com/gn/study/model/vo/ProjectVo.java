package com.gn.study.model.vo;

import java.time.LocalDateTime;

public class ProjectVo {
	private int projectId;	// PK(번호)
	private String projectName; // 프로젝트명
	private int projectManager;	// FK(employee의 emp_id) -> 관리자 사번
	private LocalDateTime regDate;	// 등록일
	private LocalDateTime modDate;	// 수정일
	
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
		return "[projectId=" + projectId 
				+ ", projectName=" + projectName 
				+ ", projectManager="+ projectManager 
				+ ", regDate=" + regDate 
				+ ", modDate=" + modDate + "]";
	}
	
	
	
}
