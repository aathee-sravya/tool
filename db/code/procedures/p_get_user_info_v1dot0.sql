/* call p_get_user_info_v1dot0('tool_001',@a,@b,@c);
select @a,@b,@c */

USE cfp;
DELIMITER #

DROP PROCEDURE IF EXISTS p_get_user_info_v1dot0 # 

CREATE PROCEDURE p_get_user_info_v1dot0(
    IN in_unique_id VARCHAR(100),
    OUT out_status           VARCHAR(1),
    OUT out_error_code       VARCHAR(100),
    OUT out_error_msg        TEXT
) p_get_user_info_v1dot0:BEGIN

    DECLARE v_unique_id VARCHAR(100);

    DECLARE USER_NOT_FOUND CONDITION FOR SQLSTATE '01001';  

    DECLARE EXIT HANDLER FOR USER_NOT_FOUND 
    BEGIN
        GET DIAGNOSTICS CONDITION 1 out_error_msg = MESSAGE_TEXT;
        SET out_error_msg = CONCAT('p_get_user_info_v1dot0 :: user not found in system :: ',out_error_msg);
        SET out_error_code = 'USER_NOT_FOUND';
        SET out_status = 'N';
        ROLLBACK;
    END;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        GET DIAGNOSTICS CONDITION 1 out_error_msg = MESSAGE_TEXT;
        SET out_error_msg = CONCAT('p_get_user_info_v1dot0:: failed :: ',out_error_msg);
        SET out_status = 'N';
        SET out_error_code = 'DB_PROC_FAILURE';
        ROLLBACK;
    END;
    
    SET out_status = 'N';

    SELECT f_unique_id INTO v_unique_id FROM t_user WHERE f_unique_id = in_unique_id;

    IF(v_unique_id IS NULL) THEN
        SIGNAL USER_NOT_FOUND;
    END IF;

    SELECT 
        f_user_id,
        f_primary_email,
        f_office_email,
        f_primary_mobile,
        f_dob,
        f_primary_address,
        f_fname, 
        f_lname
    FROM t_user u INNER JOIN t_user_profile p ON 
    u.f_id = p.f_user_id
    WHERE u.f_unique_id = in_unique_id;
    
    SET out_status = 'Y';

END #

DELIMITER ;