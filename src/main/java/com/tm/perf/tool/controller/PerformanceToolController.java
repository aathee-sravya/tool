package com.tm.perf.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tm.perf.tool.api.request.ReviewReport;
import com.tm.perf.tool.api.response.UserResponse;
import com.tm.perf.tool.service.ReportService;
import com.tm.perf.tool.service.UserService;

@RestController
@RequestMapping("/tool/")
public class PerformanceToolController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(method = RequestMethod.GET, value="test")
	public String test(){
		return "SUCCESS";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="listofUsers")
	public UserResponse listofUsers(@RequestParam("companyId") int id){
		return reportService.listofUsers(id);
	}
	
	@GetMapping(value="getReviewReports")
	public ReviewReport getReviewReport() {
		ReviewReport report = new ReviewReport();
		report = userService.getReviewReport();
		System.out.println("reportt::"+report);
		return report;
	}
}
