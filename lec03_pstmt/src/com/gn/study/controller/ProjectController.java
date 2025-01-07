package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.ProjectDao;
import com.gn.study.model.vo.ProjectVo;

public class ProjectController {
	private ProjectDao pd = new ProjectDao();
	
	public int insertProjectOne(String projectName, String managerName) {
		int result = pd.insertProjectOne(projectName, managerName);
		return result;
	}
	
	public List<ProjectVo> selectProjectAll(){
		List<ProjectVo> list = pd.selectProjectAll();
		return list;
	}

}
