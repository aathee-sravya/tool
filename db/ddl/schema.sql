Basic assumptions : 

* user can be only in one corporate at a time
* review cycle is hardcoded as monthly, aggregated on FY End


CREATE SCHEMA perftool;

use perftool;

/* DEFINES COMPANY LEVEL PARAMS */
DROP TABLE IF EXISTS t_mst_params;
CREATE TABLE t_mst_params (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_param_name VARCHAR(100) NOT NULL,
	f_param_display_name VARCHAR(150) NOT NULL,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO t_mst_params(f_param_name,f_param_display_name) values ('company_level_params','Company Level Params');
INSERT INTO t_mst_params(f_param_name,f_param_display_name) values ('team_level_params','Team Level Params');
INSERT INTO t_mst_params(f_param_name,f_param_display_name) values ('user_level_params','User Level Params');


/** This table contains list of all company's **/
DROP TABLE IF EXISTS t_company;
CREATE TABLE t_company {
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_name VARCHAR(100) NOT NULL,
	f_legal_name VARCHAR(100) NOT NULL,
	f_website VARCHAR(70),
	f_business_nature VARCHAR(50),
	f_status VARCHAR(40),
	f_primary_address VARCHAR(100) NOT NULL,
	f_secondary_address VARCHAR(100),
	f_state VARCHAR(100),
	f_zip VARCHAR(10),
	f_country VARCHAR(100),
	f_phone INT(15),
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
};

INSERT INTO t_company(f_company_name,f_legal_name, f_website, f_business_nature,f_primary_address,f_state,f_zip,f_country, f_phone, f_agent) VALUES ('TECHMOJO','Techmojo Solutions Pvt Limited', 'www.techmojo.in','finance','active','10th floor, Q4, Cyber Towers', 'Telanagana','500073',
'040-33445333','user');


/* DEFINES MASTER ROLES Eg: user,manager,admin,lead   */
DROP TABLE IF EXISTS t_company_roles;
CREATE TABLE t_company_roles (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_role_name VARCHAR(100),
	f_company_id BIGINT NOT NULL,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO t_company_roles(f_role_name,f_company_id) VALUES ('admin',1);
INSERT INTO t_company_roles(f_role_name,f_company_id) VALUES ('user',1);
INSERT INTO t_company_roles(f_role_name,f_company_id) VALUES ('manager',1);
INSERT INTO t_company_roles(f_role_name,f_company_id) VALUES ('lead',1);


/** Company level config for teams */
DROP TABLE IF EXISTS t_comapany_teams;
CREATE TABLE t_company_teams (
	f_id  NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL,
	f_team_name VARCHAR(100) NOT NULL,
	f_display_name VARCHAR(150) NOT NULL,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY(f_team_name, f_company_id)
);

/** Company level config for designations */
DROP TABLE IF EXISTS t_company_designations;
CREATE TABLE t_company_designations (
	f_id  NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL,
	f_designation VARCHAR(100) NOT NULL,
	f_display_name VARCHAR(150) NOT NULL,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY(f_designation, f_company_id)
);

DROP TABLE IF EXISTS t_company_user_mapping;
CREATE TABLE t_company_user_mapping (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL REFERENCES t_company(f_id),
	f_user_id BIGINT NOT NULL,
	f_status VARCHAR(50) DEFAULT 'active',
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
);

/* config table for user team mapping */
DROP TABLE IF EXISTS t_team_config;
CREATE TABLE t_team_config (
	f_id  BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL,
	f_team_id BIGINT NOT NULL REFERENCES t_mst_teams(f_id),
	f_user_id BIGINT NOT NULL REFRENCES t_company_user_mapping(f_id),
	f_reports_to BIGINT NOT NULL REFERENCES t_company_user_mapping(f_id),
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY(f_company_id,f_team_id)
);


/* config table for performance parameters at team level */
DROP TABLE IF EXISTS t_sub_params_config;
CREATE TABLE t_sub_params_config (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL REFERENCES t_company(f_id),
	f_param_name VARCHAR(100) NOT NULL REFERENCES t_mst_params(f_param_name),
	f_sub_param_name VARCHAR(100) NOT NULL,
	f_sub_param_display_name VARCHAR(150) NOT NULL,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


DROP TABLE IF EXISTS t_sub_params_desg_config;
CREATE TABLE t_sub_params_desg_config (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL REFERENCES t_company(f_id),
	f_config_id BIGINT NOT NULL REFERENCES t_sub_params_config(f_id),
	f_designation VARCHAR(50) REFERENCES t_mst_designations(f_designation),
	f_points INT NOT NULL DEFAULT 0,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS t_user_role_mapping;
CREATE TABLE t_user_role_mapping (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL REFERENCES t_company(f_id),
	f_role_id BIGINT NOT NULL REFERENCES t_mst_roles(f_id),
	f_user_id BIGINT NOT NULL REFERENCES t_company_user_mapping(f_id),
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY(f_company_id,f_role_id,f_user_id)
);

DROP TABLE IF EXISTS t_perf_review;
CREATE TABLE t_perf_review (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_company_id BIGINT NOT NULL,
	f_user_id  BIGINT NOT NULL REFERENCES t_company_user_mapping(f_id),
	f_manager_id BIGINT NOT NULL REFERENCES t_company_user_mapping(f_id),
	f_sub_config_name VARCHAR(100) NOT NULL,
	f_designation_id BIGINT NOT NULL,
	f_actual_points INT NOT NULL DEFAULT 0,
	f_received_points INT NOT NULL DEFAULT 0,
	f_from_date DATE NOT NULL,
	f_to_date DATE NOT NULL,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS t_perf_review_log;
CREATE TABLE t_perf_review_log (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_master_id BIGINT REFERENCES t_perf_review(f_id),
	f_company_id BIGINT NOT NULL,
	f_user_id  BIGINT NOT NULL,
	f_manager_id BIGINT NOT NULL,
	f_sub_config_name VARCHAR(100) NOT NULL,
	f_designation_id BIGINT NOT NULL,
	f_actual_points INT NOT NULL DEFAULT 0,
	f_received_points INT NOT NULL DEFAULT 0,
	f_from_date DATE NOT NULL,
	f_to_date DATE NOT NULL,
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS t_perf_comments;
CREATE TABLE t_perf_comments (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_perf_id BIGINT REFERENCES t_perf_review(f_id),
	f_comments VARCHAR(500),
	f_role_name VARCHAR(50),
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)


/** TODO : need to add routes table */






**************** USER PROFILE TABLES **********************

CREATE TABLE t_user (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_unique_id VARCHAR(100),
	f_email VARCHAR(50),
	f_mobile VARCHAR(10),
	f_user_name VARCHAR(50),
	f_password VARCHAR(100),
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	
);

CREATE TABLE t_user_log (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	f_user_id VARCHAR(100),
	f_email VARCHAR(50),
	f_mobile VARCHAR(10),
	f_user_name VARCHAR(50),
	f_password VARCHAR(100),
	f_agent VARCHAR(100),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	
);

CREATE TABLE t_user_profile (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE
	f_user_id BIGINT NOT NULL REFERENCES t_user(f_id),
	f_primary_email VARCHAR(100),
	f_office_email VARCHAR(100),
	f_primary_mobile VARCHAR(10),
	f_office_mobile VARCHAR(10),
	f_emergency_contact VARCHAR(10),
	f_dob DATE,
	f_primary_address VARCHAR(200),
	f_permanent_address VARCHAR(200),
	f_fname VARCHAR(20), 
	f_lname VARCHAR(30),
	f_signup_date DATE,
	f_agent VARCHAR(100),
	f_status VARCHAR(50),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	f_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE t_user_profile_list (
	f_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE
	f_master_id BIGINT NOT NULL REFERENCES t_user_profile(f_id),
	f_user_id BIGINT NOT NULL REFERENCES t_user(f_id),
	f_primary_email VARCHAR(100),
	f_office_email VARCHAR(100),
	f_primary_mobile VARCHAR(10),
	f_office_mobile VARCHAR(10),
	f_emergency_contact VARCHAR(10),
	f_dob DATE,
	f_primary_address VARCHAR(200),
	f_permanent_address VARCHAR(200),
	f_fname VARCHAR(20), 
	f_lname VARCHAR(30),
	f_signup_date DATE,
	f_agent VARCHAR(100),
	f_status VARCHAR(50),
	f_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) COMMENT= 'log table for t_user_profile';

