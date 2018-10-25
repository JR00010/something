DECLARE  
  CURSOR TEMP IS SELECT tablename,COLUMNSNAME, oderLength, newlength FROM temp_BNO ;
  STR  VARCHAR2(250) := ''; 
BEGIN
 DBMS_OUTPUT.ENABLE(1000000);-- 设置缓存大小，缓存太小 会报错。
 FOR S IN TEMP LOOP
  STR := 'ALTER TABLE '||S.tablename||' MODIFY('||S.COLUMNSNAME||' VARCHAR2('||s.oderLength||'))';  
  DBMS_OUTPUT.PUT_LINE(STR); 
  EXECUTE IMMEDIATE STR ; 
 END LOOP; 
 commit;
 exception  
     when DUP_VAL_ON_INDEX  then  
     DBMS_OUTPUT.PUT_LINE(SQLERRM);
     ROLLBACK; 
   when others  then  
     DBMS_OUTPUT.PUT_LINE(SQLERRM); 
    ROLLBACK;
END;
