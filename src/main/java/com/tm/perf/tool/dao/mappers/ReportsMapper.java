package com.tm.perf.tool.dao.mappers;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tm.perf.tool.api.request.ReviewReport;


public class ReportsMapper implements RowMapper<ReviewReport> {
	@Override
	public ReviewReport mapRow(java.sql.ResultSet resultSet, int rowNum) throws SQLException {
		ReviewReport record = null; 
//				new ReportsMapper(resultSet.getLong("f_log_id"),
//				resultSet.getString("f_end_user_id"), resultSet.getString("f_frontend"), resultSet.getString("f_brand"),
//				resultSet.getString("f_product"), resultSet.getLong("f_old_balance"), resultSet.getLong("f_amount"),
//				resultSet.getLong("f_new_balance"), resultSet.getString("f_currency"),
//				resultSet.getString("f_ref_txn_id"), resultSet.getString("f_source"),
//				TransactionType.valueOf(resultSet.getString("f_txn_type")),
//				TransactionKind.valueOf(resultSet.getString("f_txn_kind")), resultSet.getString("f_create_time"),
//				resultSet.getString("f_agent"), resultSet.getString("f_comment"));
		return record;
	}
}
