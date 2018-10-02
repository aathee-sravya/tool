package com.tm.perf.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tm.perf.tool.request.ReviewReport;
import com.tm.perf.tool.service.UserService;

@RestController
@RequestMapping("/tool/")
public class PerformanceToolController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value="test")
	public String test(){
		return "SUCCESS";
	}
	
	@GetMapping(value="getReviewReports")
	public ReviewReport getReviewReport() {
		ReviewReport report = new ReviewReport();
		report = userService.getReviewReport();
		System.out.println("reportt::"+report);
		return report;
	}
}
