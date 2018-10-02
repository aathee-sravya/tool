package com.tm.perf.tool.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.tm.perf.tool.api.request.ReportRequest;
import com.tm.perf.tool.api.request.ReviewReport;
import com.tm.perf.tool.dao.ReportDao;


public class ReportDaoImpl implements ReportDao{
	@Autowired
    @Qualifier("namedJdbcPerformance")
    private NamedParameterJdbcTemplate namedJdbcPerformance;
	
	@Autowired
    @Qualifier("jdbcPerformance")
    private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<ReviewReport> getReviewReport(ReportRequest request) {
		List<ReviewReport> list = new ArrayList<ReviewReport>();
		String procName = "proc_reports_v1dot0";
		try {
			SimpleJdbcCall proc = new SimpleJdbcCall(jdbcTemplate).withProcedureName(procName);
			
			//proc.returningResultSet("reports", new ReportsMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("in_lock_for_update", "N");
			
			Map<String, Object> outMap = proc.execute(inParams);
			
			int result = (Integer) outMap.get("out_status");
			int totalRecordCount = (Integer) outMap.get("out_total_records");
			if (result == 1) {
//				@SuppressWarnings("unchecked")
//				List<ReviewReport> list = (List<ReviewReport>) outMap.get("reports");
			} else {
				throw new Exception("else case exception while calling database proc " + procName);
			}
		} catch (Exception e) {
			
//			throw new Exception("exception while calling database proc " + procName + " :: " + e.getMessage());
		} finally {
		}
		return list;
	}

}
