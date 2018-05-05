package com.bsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsp.dao.AdministratorMapper;
import com.bsp.dao.PrimaryClassificationMapper;
import com.bsp.dao.SecondaryClassificationMapper;
import com.bsp.entity.Administrator;
import com.bsp.entity.PrimaryClassification;
import com.bsp.entity.SecondaryClassification;


@Controller
@Scope(value="prototype")
@RequestMapping("/test")
public class TestController {
	
	@Autowired private SecondaryClassificationMapper secondaryClassificationMapper;
	@Autowired private PrimaryClassificationMapper primaryClassificationMapper;
	@Autowired private AdministratorMapper administratorMapper;
	
	public void setPrimaryClassificationMapper(PrimaryClassificationMapper primaryClassificationMapper) {
		this.primaryClassificationMapper = primaryClassificationMapper;
	}

	public void setAdministratorMapper(AdministratorMapper administratorMapper) {
		this.administratorMapper = administratorMapper;
	}

	public void setSecondaryClassificationMapper(SecondaryClassificationMapper secondaryClassificationMapper) {
		this.secondaryClassificationMapper = secondaryClassificationMapper;
	}

	@RequestMapping("sc")
	@ResponseBody
	public SecondaryClassification testSecondaryClassificationMapper() {
		return secondaryClassificationMapper.selectByPrimaryKey(248);
	}
	
	@RequestMapping("pc")
	@ResponseBody
	public PrimaryClassification testPrimaryClassificationMapper() {
		return primaryClassificationMapper.selectByPrimaryKey(1);
	}
	
	@RequestMapping("adm")
	@ResponseBody
	public Administrator testAdministratorMapper() {
		return administratorMapper.selectByPrimaryKey("e55b4494e04146aca17c3c59ca760bcc");
	}
	
}
