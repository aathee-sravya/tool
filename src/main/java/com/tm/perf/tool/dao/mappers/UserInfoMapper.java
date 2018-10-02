package com.tm.perf.tool.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tm.perf.tool.api.response.UserInfoResponse;
import com.tm.perf.tool.common.Constants.HTTPResponse;

public class UserInfoMapper implements RowMapper<UserInfoResponse>{

    @Override
    public UserInfoResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserInfoResponse userInfoResponse = new UserInfoResponse(HTTPResponse.SUCCESS);
        userInfoResponse.setDob(rs.getString("f_dob"));
        userInfoResponse.setUniqUserId(rs.getString("f_user_id"));
        userInfoResponse.setPrimaryEmail(rs.getString("f_primary_email"));
        userInfoResponse.setOfficeEmail(rs.getString("f_office_email"));
        userInfoResponse.setMobileNum(rs.getString("f_primary_mobile"));
        userInfoResponse.setfName(rs.getString("f_fname"));
        userInfoResponse.setlName(rs.getString("f_lname"));
        return userInfoResponse;
    }

}
