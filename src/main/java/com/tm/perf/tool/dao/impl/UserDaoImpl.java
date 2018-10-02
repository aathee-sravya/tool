package com.tm.perf.tool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.response.CreateUserResponse;
import com.tm.perf.tool.constants.Constants.ErrorCodes;
import com.tm.perf.tool.constants.Constants.Status;
import com.tm.perf.tool.dao.UserDao;
import com.tm.perf.tool.request.ReviewReport;

@Repository
public class UserDaoImpl implements UserDao{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
    @Qualifier("namedJdbcPerformance")
    private NamedParameterJdbcTemplate namedJdbcPerformance;
	
	@Autowired
    @Qualifier("jdbcPerformance")
    private JdbcTemplate jdbcTemplate;
	
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

    @Override
    public CreateUserResponse loginUser(LoginRequest loginRequest) {
        CreateUserResponse response = null;
        try {
            String procName = "p_login_user_v1dot0";
            LOGGER.info("loginUser ::  Calling  procedure   " + procName);

            MapSqlParameterSource inParams = new MapSqlParameterSource();
            inParams.addValue("in_user_mail", loginRequest.getEmailId());
            inParams.addValue("in_password", loginRequest.getPassword());
            inParams.addValue("in_salt", null);
            inParams.addValue("in_do_commit", "Y");

            SimpleJdbcCall proc = new SimpleJdbcCall(jdbcTemplate).withProcedureName(procName);
            Map<String, Object> outMap = proc.execute(inParams);
            LOGGER.info("outMap is ::  Calling  procedure   " + outMap);

            if (outMap != null && "Y".equals(outMap.get("out_status"))) {
                response = new  CreateUserResponse(Status.success);
                return response;
            } else {
                response = new  CreateUserResponse(Status.failure);
                response.setErrorCode(ErrorCodes.technical_error);
                return response;
            }
           

        } catch (Exception e) {
            LOGGER.error("Exception occured during loginUser()", e);
            response = new  CreateUserResponse(Status.failure);
            response.setErrorCode(ErrorCodes.technical_error);
            return response;
        }
    }

}
