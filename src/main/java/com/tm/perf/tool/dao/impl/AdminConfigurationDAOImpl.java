package com.tm.perf.tool.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tm.perf.tool.api.common.Loggers;
import com.tm.perf.tool.api.common.exceptions.DatabaseErrorException;
import com.tm.perf.tool.api.request.config.UserInfo;
import com.tm.perf.tool.common.Constants;
import com.tm.perf.tool.dao.AdminConfigurationDAO;

@Repository
public class AdminConfigurationDAOImpl implements AdminConfigurationDAO {

	@Autowired
	@Qualifier("namedJdbcPerformance")
	private NamedParameterJdbcTemplate namedJdbcPerformance;

	@Autowired
	@Qualifier("jdbcPerformance")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserInfo> getUserInfo(String companyId) throws DatabaseErrorException{
		final String procedureCall = "{call proc_get_user_info_v1dot0(?,?,?)}";
		List<UserInfo> userInfoList = new ArrayList<>();
		Connection connection = null;
		CallableStatement cStmt = null;
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			cStmt = connection.prepareCall(procedureCall);
			cStmt.setString(1, companyId);
			cStmt.registerOutParameter(2, Types.TINYINT);
			cStmt.registerOutParameter(3, Types.VARCHAR);
			ResultSet rs = cStmt.executeQuery();
			if (cStmt.getInt(cStmt.getInt(2)) == Constants.DB_SUCCESS) {
				while (rs.next()) {
					UserInfo userInfo = new UserInfo();
					userInfo.setUniqueId(rs.getString("f_unique_id"));
					userInfo.setEmailId(rs.getString("f_email"));
					userInfo.setMobileNumber(rs.getString("f_mobile"));
					userInfo.setUserName(rs.getString("f_user_name"));
					userInfoList.add(userInfo);
				}
			}
			else {
				throw new DatabaseErrorException(rs.getString(3)); 
			}
			Loggers.TOOL_LOGGER.info(" getUserInfoList : {}", userInfoList);
		} catch (Exception e) {
			Loggers.TOOL_LOGGER.error("Error in getUserInfo {}", e);
		} finally {
			try {
				Loggers.TOOL_LOGGER.debug("Closing getUserInfo connection");
				cStmt.close();
				connection.close();
			} catch (SQLException e) {
				Loggers.TOOL_LOGGER.error("Unable to close the getUserInfo connection!!", e);
			}
		}
		return userInfoList;
	}

}
