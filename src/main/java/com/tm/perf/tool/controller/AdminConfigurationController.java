package com.tm.perf.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.perf.tool.api.response.config.UserInfoResponse;
import com.tm.perf.tool.service.AdminConfigurationService;

@RestController
@RequestMapping("/tool/config/")
public class AdminConfigurationController {
	
	@Autowired
	private AdminConfigurationService adminConfigurationService;
	
	@GetMapping(value="getUserInfo")
	public UserInfoResponse getUserInfo(String companyId) {
		return adminConfigurationService.userInfo(companyId);
	}
}
