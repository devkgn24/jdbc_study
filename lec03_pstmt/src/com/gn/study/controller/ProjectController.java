package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.ProjectDao;
import com.gn.study.model.vo.ProjectVo;

public class ProjectController {
	private ProjectDao pd = new ProjectDao();
	
	public int deleteProjectOne(int projectNo) {
		int result = pd.deleteProjectOne(projectNo);
		return result;
	}
	
	public int updateProjectOne(int projectNo, String projectName) {
		int result = pd.updateProjectOne(projectNo, projectName);
		return result;
	}
	
	public List<ProjectVo> selectProjectAllByManagerName(String managerName){
		List<ProjectVo> list = pd.selectProjectAllByManagerName(managerName);
		return list;
	}
	
	public List<ProjectVo> selectProjectAllByName(String projectName){
		List<ProjectVo> list = pd.selectProjectAllByName(projectName);
		return list;
	}
	
	public int insertProjectOne(String projectName, String managerName) {
		int result = pd.insertProjectOne(projectName, managerName);
		return result;
	}
	
	public List<ProjectVo> selectProjectAll(){
		List<ProjectVo> list = pd.selectProjectAll();
		return list;
	}

}
