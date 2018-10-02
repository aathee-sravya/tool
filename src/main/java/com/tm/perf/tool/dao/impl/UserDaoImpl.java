package com.tm.perf.tool.dao.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.response.LoginResponse;
import com.tm.perf.tool.common.Constants.ErrorCodes;
import com.tm.perf.tool.common.Constants.HTTPResponse;
import com.tm.perf.tool.dao.UserDao;

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
    public LoginResponse loginUser(LoginRequest loginRequest) {
        LoginResponse response = null;
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
                response = new  LoginResponse(HTTPResponse.SUCCESS);
                return response;
            } else {
                response = new  LoginResponse(HTTPResponse.FAILED);
                response.setErrorCode(ErrorCodes.technical_error);
                return response;
            }
           

        } catch (Exception e) {
            LOGGER.error("Exception occured during loginUser()", e);
            response = new  LoginResponse(HTTPResponse.FAILED);
            response.setErrorCode(ErrorCodes.technical_error);
            return response;
        }
    }

}
