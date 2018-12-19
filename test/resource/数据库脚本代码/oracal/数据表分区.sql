create table pdba (id number, time date) partition by range (time)
(
   partition p1 values less than (to_date('2010-10-1', 'yyyy-mm-dd')),
   partition p2 values less than (to_date('2010-11-1', 'yyyy-mm-dd')),
   partition p3 values less than (to_date('2010-12-1', 'yyyy-mm-dd'))
)

INSERT INTO pdba VALUES(1,to_date('2018-10-1', 'yyyy-mm-dd'))
SELECT * pdba

-- 添加分区
ALTER TABLE pdba ADD PARTITION pdba_P421
VALUES
	LESS THAN (
		TO_DATE (
			'2018-12-1', 'yyyy-mm-dd'
		)
	) TABLESPACE USERS;

-- 删除分区
alter table PDBA DROP PARTITION  p4;

--  查询分区
select * from user_tab_partitions where table_name = 'PDBA';