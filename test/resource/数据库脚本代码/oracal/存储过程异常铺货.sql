DECLARE
   dept_no   NUMBER (2) := 70;
BEGIN
   --开始事务
   INSERT INTO dept 
        VALUES (dept_no, '市场部', '北京');               --插入部门记录
   INSERT INTO dept 
        VALUES (dept_no, '后勤部', '上海');               --插入相同编号的部门记录        
   INSERT INTO emp                                        --插入员工记录
        VALUES (7997, '威尔', '销售人员', NULL, TRUNC (SYSDATE), 5000,300, dept_no);
   --提交事务
   COMMIT;
EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN                            --捕足异常
     DBMS_OUTPUT.PUT_LINE(SQLERRM);                   --显示异常消息
     ROLLBACK;                                           --回滚异常
END;
