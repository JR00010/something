package test.com.enum_;
public enum GoodsStatusEnum {
	// 数据状态 未启用 1 原始 2 已修改3 已删除 （未删除）4 新增 5  
	original("未启用",1),notEnabled("原始",1),updated("已修改",1),add("updated",1),removed(" 新增",5),  
	// 是否人工介入过 ： 未介入0  介入1 
	noReCord("未启用",0),reCorded("未启用",0),  
	// 大数据同步 ：T 页面导入数据：I  页面新增 ：A 删除 D 更新：U
	OperationCode_T("大数据同步","T"),OperationCode_I("页面导入","I"),OperationCode_A("未启用","A")
	,OperationCode_D("未启用","D"),OperationCode_U("未启用","U")
	
	;
	private  String name;
	private  String operationCode;
	private  Integer status;
    
    private GoodsStatusEnum(String name,int status)
    {
    	this.name = name;
        this.status = status;
    }
    private GoodsStatusEnum(String name,String operationCode)
    {
    	this.name = name;
        this.operationCode = operationCode;
    }

    public Integer getStatus() {
        return status;
    }
    public String getOperationCode() {
        return operationCode;
    }
    public String getName() {
        return name;
    }
	
}