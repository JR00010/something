-- 先解释下 sql执行计划中的执行类型 
MySQL中explain的type类型
|  ALL              |  全表扫描

|  index            |  索引全扫描

|  range            |  索引范围扫描，常用语<,<=,>=,between等操作

|  ref                |  使用非唯一索引扫描或唯一索引前缀扫描，返回单条记录，常出现在关联查询中

|  eq_ref           |  类似ref，区别在于使用的是唯一索引，使用主键的关联查询

|  const/system  |  单条记录，系统会把匹配行中的其他列作为常数处理，如主键或唯一索引查询

|  null                |  MySQL不访问任何表或索引，直接返回结果


查询常量集合的最佳个数

EXPLAIN select count(*) from table where id in (list)

当 list.lenght/count(*) <= 0.17 的时候 ，explain的type类型 是range  
在 0.17 ~0.20 是个不定的范围    大于0.20 explain的type类型 是All 也就是全表扫描 效率越低 
