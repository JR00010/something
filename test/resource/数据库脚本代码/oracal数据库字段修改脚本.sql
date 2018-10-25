DECLARE  
    CURSOR TEMP IS SELECT 
				        c.TABLE_NAME,
				        c.COLUMN_NAME,
				        c.DATA_LENGTH 
			        FROM 
				        user_tables t 
				        INNER JOIN USER_TAB_COLUMNS c ON t.TABLE_NAME = c.TABLE_NAME 
			        WHERE c.COLUMN_NAME in('BNO','WAYBILLNO', 'SWAYBILLNO') AND DATA_LENGTH = 12 ;  -- AND TABLE_NAME in ('BNOTEMP','RPT_DL_I_PERSONAL_GOODS_TAX');  
    STR  VARCHAR2(250) := '';  
  	STR2  VARCHAR2(250) := ''; 
  	num   number;
  	newLength NUMBER := 31;
  BEGIN  
   DBMS_OUTPUT.ENABLE(1000000); -- 设置缓存大小，缓存太小 会报错。
   select count(1) INTO num from user_tables where table_name = upper('temp_BNO') ;
   if num > 0 then
     execute immediate 'drop table temp_BNO' ;
   end if;
    execute immediate 'CREATE TABLE temp_BNO(tablename VARCHAR(50), COLUMNSNAME VARCHAR(50) ,oderLength NUMBER(10),newlength NUMBER(10), INSERTDATE DATE)';
      FOR S IN TEMP LOOP  
        STR := 'ALTER TABLE '||S.TABLE_NAME||' MODIFY('||S.COLUMN_NAME||' VARCHAR2('||newLength||'))';  
       DBMS_OUTPUT.PUT_LINE(STR); 
    STR2 := 'INSERT INTO temp_BNO (tablename,COLUMNSNAME,oderLength,newlength,INSERTDATE) VALUES('''||S.TABLE_NAME||''', '''||s.COLUMN_NAME||''', '||s.DATA_LENGTH||', '||newLength||',SYSDATE)'; 
    
    DBMS_OUTPUT.PUT_LINE(STR2);  
      EXECUTE IMMEDIATE STR ; 
   EXECUTE IMMEDIATE STR2 ;
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