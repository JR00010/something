                                                                              
CREATE TABLE `tm_waybill_routes1` (                                                               
`ID`  int NOT NULL ,                                                                             
`attribute`  varchar(30) NULL COMMENT 'BSP 对外系统名称' ,                                             
`waybillno`  varchar(20) NULL COMMENT '运单号，可以是快件运单编号' ,                                          
`zonecode`  varchar(10) NULL COMMENT '网络网点' ,                                                    
`zonename`  varchar(50) NULL COMMENT '网络网点名称' ,                                                  
`outsidename`  varchar(50) NULL COMMENT '网点对外名称' ,                                               
`distname`  varchar(20) NULL COMMENT '所在城市' ,                                                    
`oprcode`  varchar(15) NULL COMMENT '巴枪操作员工号' ,                                                  
`couriercode`  varchar(15) NULL COMMENT '收派员工号',                                                 
`opcode` tinyint(10) NULL COMMENT '操作类型',                                                        
`barscantm` date NULL COMMENT '扫描时间',                                                            
`opname`  varchar(20) NULL COMMENT '备注(巴枪操作说明)' ,                                                
`staywhycode`  varchar(30) NULL COMMENT '原因代码' ,                                                 
`staywhyname`  varchar(100) NULL COMMENT '异常原因代码' ,                                              
`wqsremark`  varchar(255) NULL COMMENT '监控记录(WQS查单页面操作描述)' ,                                     
`owsremark`  varchar(100) NULL COMMENT '官网备注描述' ,                                                
`cvscode`  varchar(10) NULL COMMENT '便利店代码' ,                                                    
`cvsname`  varchar(30) NULL COMMENT '便利店名称' ,                                                    
`routecode`  varchar(15) NULL COMMENT '运力名称（航班号的等）' ,                                            
`extendattach3`  varchar(50) NULL COMMENT '增加的附属字段第三方快递公司' ,                                     
`extendattach4`  varchar(30) NULL COMMENT '外部单号' ,                                               
`abnormalreason`  varchar(50) NULL COMMENT 'OMP 异常原因' ,                                          
`isowsshow`  char(8) NULL COMMENT '是否官网显示' ,                                                     
`contnrcode`  varchar(50) NULL COMMENT '容器号码' ,                                                  
`linecode`  varchar(50) NULL COMMENT '线路编码' ,                                                    
`lastexpecteddeliverytmrange`  varchar(50) NULL COMMENT '预计派送时间 yyyy-MM-dd HH:mm-HH:mm' ,        
`lastexpecteddeliveryzonecode`  varchar(50) NULL COMMENT '预计派送网点' ,                              
`autoloading`  varchar(50) NULL COMMENT '巴枪数据来源' ,                                               
`oldwaybillno`  varchar(20) NULL COMMENT '旧单号' ,                                                 
`receivetime`  datetime NULL COMMENT 'CMSP接收数据时间' ,                                              
PRIMARY KEY (`ID`) ,
INDEX `IDX_TM_WAYBILL_ROUTES_BNO2` (`WAYBILLNO`) ,                                               
INDEX `IDX_TM_WAYBILL_ROUTES_RECETM2` (`RECEIVETIME`) ,                                          
INDEX `IDX_TM_WB_ROUTES_CONTNRCODE` (`CONTNRCODE`) ,                                             
INDEX `IDX_WR_BNO_OP_ZONECODE` (`WAYBILLNO`, `ZONECODE`, `OPCODE`)                                                                              
                                                                                                 
)                                                                                                
COMMENT='运单路由表';  