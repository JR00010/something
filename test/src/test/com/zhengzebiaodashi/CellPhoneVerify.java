package test.com.zhengzebiaodashi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CellPhoneVerify {
	private static Map<String,String> cellPhonePattern = new HashMap<>();
	static {
		cellPhonePattern.put("US", "^(\\+?1)?[2-9]\\d{2}[2-9](?!11)\\d{6}$"); //英语(美国)
		cellPhonePattern.put("CZ", "^(\\+?420)? ?[1-9][0-9]{2} ?[0-9]{3} ?[0-9]{3}$");//捷克语(捷克共和国)
		cellPhonePattern.put("DE", "^(\\+?49[ \\.\\-])?([\\(]{1}[0-9]{1,6}[\\)])?([0-9 \\.\\-\\/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$"); //德语(德国)
		cellPhonePattern.put("DK", "^(\\+?45)?(\\d{8})$");//英语(丹麦)
		cellPhonePattern.put("GR", "^(\\+?30)?(69\\d{8})$");//希腊语(希腊)
		cellPhonePattern.put("AU", "^(\\+?61|0)4\\d{8}$");//英语(澳大利亚)
		cellPhonePattern.put("GB", "^(\\+?44|0)7\\d{9}$");//英语(英国)
		cellPhonePattern.put("HK", "^(\\+?852\\-?)?[569]\\d{3}\\-?\\d{4}$");// 中国香港
		cellPhonePattern.put("IN", "^(\\+?91|0)?[789]\\d{9}$");//英语(印度)
		cellPhonePattern.put("NZ", "^(\\+?64|0)2\\d{7,9}$"); //英语(新西兰)
		cellPhonePattern.put("ZA", "^(\\+?27|0)\\d{9}$");  //英语(南非)
		cellPhonePattern.put("ES", "^(\\+?34)?(6\\d{1}|7[1234])\\d{7}$");//西班牙语(拉丁美洲)
		cellPhonePattern.put("FI", "^(\\+?358|0)\\s?(4(0|1|2|4|5)?|50)\\s?(\\d\\s?){4,8}\\d$");//英语(芬兰)
		cellPhonePattern.put("FR", "^(\\+?33|0)[67]\\d{8}$");//法语(法国)
		cellPhonePattern.put("IL", "^(\\+972|0)([23489]|5[0248]|77)[1-9]\\d{6}");//英语(以色列)
		cellPhonePattern.put("HU", "^(\\+?36)(20|30|70)\\d{7}$"); //匈牙利语(匈牙利)
		cellPhonePattern.put("IT", "^(\\+?39)?\\s?3\\d{2} ?\\d{6,7}$");//意大利语(意大利)
		cellPhonePattern.put("JP", "^(\\+?81|0)\\d{1,4}[ \\-]?\\d{1,4}[ \\-]?\\d{4}$");// 日本
		cellPhonePattern.put("MY", "^(\\+?6?01){1}(([145]{1}(\\-|\\s)?\\d{7,8})|([236789]{1}(\\s|\\-)?\\d{7}))$");//英语(马来西亚)
		cellPhonePattern.put("BE", "^(\\+?32|0)4?\\d{8}$");//荷兰语(比利时)
		cellPhonePattern.put("NO", "^(\\+?47)?[49]\\d{7}$");//挪威语(挪威)
		cellPhonePattern.put("PL", "^(\\+?48)? ?[5-8]\\d ?\\d{3} ?\\d{2} ?\\d{2}$");//波兰语(波兰)
		cellPhonePattern.put("BR", "^(\\+?55|0)\\-?[1-9]{2}\\-?[2-9]{1}\\d{3,4}\\-?\\d{4}$");//葡萄牙语(巴西)
		cellPhonePattern.put("PT", "^(\\+?351)?9[1236]\\d{7}$");//葡萄牙语(葡萄牙)
		cellPhonePattern.put("RU", "^(\\+?7|8)?9\\d{9}$");//俄语(俄罗斯)
		cellPhonePattern.put("TR", "^(\\+?90|0)?5\\d{9}$");//土耳其语(土耳其)
		cellPhonePattern.put("CN", "^(\\+?0?86\\-?)?1[345789]\\d{9}$");
		cellPhonePattern.put("TW", "^(\\+?886\\-?|0)?9\\d{8}$");
	}
	public static void main(String[] args) {
		
	}
	
	public static Boolean verifyCellPhone(String counrtyCode,String cellPhone) {
		if(null == counrtyCode)
			throw new NullPointerException("国别代码不能为空");
		String p = cellPhonePattern.get(counrtyCode);
		
		return cellPhone.matches(p);
	}
	
	public static String getCounrtyCode(String cellPhone) {
		if(null == cellPhone)
			throw new IllegalArgumentException("电话号码不能为空");
		Set<Entry<String, String>> entry = cellPhonePattern.entrySet();
		for (Entry<String, String> entry2 : entry) {
			if(cellPhone.matches(cellPhone)) {
				return entry2.getKey();
			}
		}
		return null;
	}
}
