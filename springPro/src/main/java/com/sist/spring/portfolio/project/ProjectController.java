package com.sist.spring.portfolio.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public ProjectController() {	
	}
	
	@Autowired
	ProjectService pjtService;
	
	
}
