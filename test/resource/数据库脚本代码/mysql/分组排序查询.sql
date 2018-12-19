场景： 数据表user  中有三个字段 id ,name,age  . age 相同的人肯定有很多 。现在要根据id插入的顺序，把 age相同的人
前三 查询出来

sql：
	SELECT
	*,
	new_rank AS rank
	FROM
		(
			SELECT
				*,
				IF (
					@tmp = EPI_UIFID ,@rank :=@rank + 1 ,@rank := 1
				) AS new_rank,
				@tmp := age AS tmp
			FROM
				数据表user
			ORDER BY
				id DESC
		) b
	WHERE
		new_rank <= 3;
		
	注：	mysql中变量不用事前申明，在用的时候直接用“@变量名”使用就可以了。
		第一种用法：set @num=1; 或set @num:=1; //这里要使用变量来保存数据，直接使用@num变量
		第二种用法：select @num:=1; 或 select @num:=字段名 from 表名 where ……
		注意上面两种赋值符号，使用set时可以用“=”或“：=”，但是使用select时必须用“：=赋值