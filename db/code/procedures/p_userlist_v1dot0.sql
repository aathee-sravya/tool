/* call p_login_user_v1dot0('sravya@tm.in','test123',null,'Y',@a,@b,@c);
select @a,@b,@c */

USE perftool;
DELIMITER #

DROP PROCEDURE IF EXISTS p_userlist_v1dot0 # 

CREATE PROCEDURE p_userlist_v1dot0(
    IN company_id            INT,
    OUT out_status           VARCHAR(1),
    OUT out_error_code       VARCHAR(100),
    OUT out_error_msg        TEXT
) p_userlist_v1dot0:BEGIN

    DECLARE v_count bigint;

    DECLARE USER_NOT_FOUND CONDITION FOR SQLSTATE '01001';  

    DECLARE EXIT HANDLER FOR USER_NOT_FOUND 
    BEGIN
        GET DIAGNOSTICS CONDITION 1 out_error_msg = MESSAGE_TEXT;
        SET out_error_msg = CONCAT('p_login_user_v1dot0 :: user not found in system :: ',out_error_msg);
        SET out_error_code = 'USER_NOT_FOUND';
        SET out_status = 'N';
        ROLLBACK;
    END;
    
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' 
    BEGIN
        GET DIAGNOSTICS CONDITION 1 out_error_msg = MESSAGE_TEXT;
        SET out_error_msg = CONCAT('p_login_user_v1dot0 :: constraint failure :: ',out_error_msg);
        SET out_error_code = 'DEBIT_CONSTRAINT_FAILURE';
        SET out_status = 'N';
    END;    

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        GET DIAGNOSTICS CONDITION 1 out_error_msg = MESSAGE_TEXT;
        SET out_error_msg = CONCAT('p_login_user_v1dot0:: failed :: ',out_error_msg);
        SET out_status = 'N';
        SET out_error_code = 'DB_PROC_FAILURE';
        ROLLBACK;
    END;
    
    SET out_status = 'N';

    SELECT COUNT(1) INTO v_count FROM t_user WHERE f_email = in_user_mail AND f_password = in_password;

    IF(v_count <> 1) THEN
        SIGNAL USER_NOT_FOUND;
    END IF;


    SET out_status = 'Y';

END #

DELIMITER ;