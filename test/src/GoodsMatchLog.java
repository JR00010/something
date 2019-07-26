

import java.util.Date;

public class GoodsMatchLog {
     String bno;

    private String name;
    
    private String nameExcel;

    private String goodsCode;
    
    private String countryCode;
    
    private String customType;
    
    private String customTypeExcel;

    private Long matchCount;

    private String tableName;
    
    private String tableNameExcel;

    private String createEmp;
    
    private String usageRateInfo; //匹配使用信息。
    
    private Date startTime; //查询起始时间
    
    private Date endTime; // 查询结束时间 
    

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno == null ? null : bno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType == null ? null : customType.trim();
    }

    public Long getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(Long matchCount) {
        this.matchCount = matchCount;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

	public String getUsageRateInfo() {
		return usageRateInfo;
	}

	public void setUsageRateInfo(String usageRateInfo) {
		this.usageRateInfo = usageRateInfo;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getNameExcel() {
		if(null == this.name) return null;
		switch (this.name) {
		case "ts_goods_code":
			this.nameExcel = "基础商品编码表";
			break;
		case "ts_personal_hscode":
			this.nameExcel = "个人物品基础编码表";
			break;
		case "ts_goods_code_new":
			this.nameExcel = "跨进电商基础编码表";
			break;
		case "ts_goods_code_port_dt":
			this.nameExcel = "大数据口岸商品编码表";
			break;
		case "ts_goods_code_dt":
			this.nameExcel = "大数据全口岸商品编码表";
			break;
		case "no_match_record":
			this.nameExcel = "未匹配数据";
			break;
		default:
			this.nameExcel = this.name;
			break;
		}
		return nameExcel;
	}

	public void setNameExcel(String nameExcel) {
		this.nameExcel = nameExcel;
	}

	public String getCustomTypeExcel() {
		if(null == this.customType) return null;
		switch (this.customType) {
		case "A":
			this.customTypeExcel = "非个人物品";
			break;
		case "B":
			this.customTypeExcel = "个人物品";
			break;
		default:
			break;
		}
		return customTypeExcel;
	}

	public void setCustomTypeExcel(String customTypeExcel) {
		this.customTypeExcel = customTypeExcel;
	}

	public String getTableNameExcel() {
		if(null == this.tableName)return null;
		switch (this.tableName) {
		case "ts_goods_code":
			this.tableNameExcel = "基础商品编码表";
			break;
		case "ts_personal_hscode":
			this.tableNameExcel = "个人物品基础编码表";
			break;
		case "ts_goods_code_new":
			this.tableNameExcel = "跨进电商基础编码表";
			break;
		case "ts_goods_code_port_dt":
			this.tableNameExcel = "大数据口岸商品编码表";
			break;
		case "ts_goods_code_dt":
			this.tableNameExcel = "大数据全口岸商品编码表";
			break;
		case "no_match_record":
			this.tableNameExcel = "未匹配数据";
			break;
		default:
			this.tableNameExcel = this.tableName; 
			break;
		}
		return tableNameExcel;
	}

	public void setTableNameExcel(String tableNameExcel) {
		this.tableNameExcel = tableNameExcel;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode == null ? null : countryCode.trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bno == null) ? 0 : bno.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((customType == null) ? 0 : customType.hashCode());
		result = prime * result + ((goodsCode == null) ? 0 : goodsCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsMatchLog other = (GoodsMatchLog) obj;
		if (bno == null) {
			if (other.bno != null)
				return false;
		} else if (!bno.equals(other.bno))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (customType == null) {
			if (other.customType != null)
				return false;
		} else if (!customType.equals(other.customType))
			return false;
		if (goodsCode == null) {
			if (other.goodsCode != null)
				return false;
		} else if (!goodsCode.equals(other.goodsCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tableName == null) {
			if (other.tableName != null)
				return false;
		} else if (!tableName.equals(other.tableName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsMatchLog [bno=" + bno + ", name=" + name + ", nameExcel=" + nameExcel + ", goodsCode=" + goodsCode
				+ ", countryCode=" + countryCode + ", customType=" + customType + ", customTypeExcel=" + customTypeExcel
				+ ", matchCount=" + matchCount + ", tableName=" + tableName + ", tableNameExcel=" + tableNameExcel
				+ ", createEmp=" + createEmp + ", usageRateInfo=" + usageRateInfo + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
    
    
}