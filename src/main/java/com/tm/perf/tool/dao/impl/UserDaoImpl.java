package com.tm.perf.tool.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tm.perf.tool.dao.UserDao;
import com.tm.perf.tool.request.ReviewReport;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
    @Qualifier("namedJdbcPerformance")
    private NamedParameterJdbcTemplate namedJdbcPerformance;
	
	@Override
	public ReviewReport getReviewReport() {
		StringBuilder sql = new StringBuilder();
		
		List<ReviewReport> reportsList = namedJdbcPerformance.query("SELECT * FROM t_perf_review ", new RowMapper<ReviewReport>() {
			@Override
			public ReviewReport mapRow(ResultSet rs, int arg1) throws SQLException {
				ReviewReport report = new ReviewReport();
				report.setId(rs.getInt("f_id"));
				report.setCompanyId(rs.getInt("f_company_id"));
				report.setUserId(rs.getInt("f_user_id"));
				report.setDesignation(rs.getString("f_designation"));
				report.setManagerId(rs.getInt("f_manager_id"));
				report.setSubConfigurationName(rs.getString("f_sub_config_name"));
				report.setActualPoints(rs.getInt("f_actual_points"));
				report.setReceivedPoints(rs.getInt("f_received_points"));
				report.setFromDate(rs.getDate("f_from_date"));
				report.setToDate(rs.getDate("f_to_date"));
				report.setAgent(rs.getString("f_agent"));
				report.setCreatedAt(rs.getDate("f_create_time"));
				report.setUpdatedAt(rs.getDate("f_update_time"));
				return report;
			}
		});
		return reportsList.isEmpty()? null : reportsList.get(0);
	}

}
