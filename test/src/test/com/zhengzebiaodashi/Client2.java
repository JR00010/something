package test.com.zhengzebiaodashi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.container.Suspended;

import com.alibaba.fastjson.JSONObject;

public class Client2 {
	public static void main(String[] args) {
		
//		Pattern p = Pattern.compile("token[:\\s']{3}([0-9a-z]+)");
//		Matcher m = p.matcher("indow['common'] = { 大会上看到   token: '9b8bb341109338ba7e875bd9a9dd88ba',    systime: '1553219007648',");
//		m.find();
//		System.err.println(m.group(0));
//		tGroup();
		
//		Pattern p1 = Pattern.compile("^(\\+?0?86\\-?)?1[345789]\\d{9}$");
//		JSONObject j = new JSONObject();
//		j.put("A", "B");
//		JSONObject.parseObject("{"":"","",""}");
//		System.err.println(j);
//		System.err.println("601119772618".matches("^(\\+?6?01){1}(([145]{1}(\\-|\\s)?\\d{7,8})|([236789]{1}(\\s|\\-)?\\d{7}))$"));
//		try {
//			System.err.println(CellPhoneVerify.verifyCellPhone("TW", "0936466856"));
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.err.println(CellPhoneVerify.verifyCellPhone("HK", "96944814"));
//		System.err.println(CellPhoneVerify.getCounrtyCode("07037764382"));
		/**************************************************** */
		
		Pattern p = Pattern.compile("[\\u4E00-\\u9FA5]+");
		Matcher m = p.matcher("indow['common'] = { 大会上看到   token: 大萨达撒分开'9b8bb341109338ba7e875bd9a9dd88ba',    systime: '1553219007648',");
		while (m.find()) {
			System.err.println(m.group());
			
		}
		System.err.println("大萨达撒分开".matches("[\\u4E00-\\u9FA5]+"));
		System.err.println(Pattern.matches("[\\u4E00-\\u9FA5]+", "大萨达撒分开"));
		
		
		System.err.println("1234567890".replace("\\B(?=(?:\\d{3})+(?!\\d))",","));
		
	}
	
	
	public static String substringBeforeDigit(String str) {
		if (str == null)
			return null;
		int index = -1;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				index = i;
				break;
			}
		}
		if (index > 0) {
			str = str.substring(0, index);
		}
		if (str.contains(",")) {
			str = str.substring(0, str.indexOf(","));
		}
		return str;
	}
	
	
	/**捕获组测试
	 * 一、(?:)非捕获组
	 * (?=)和(?<=) 前后查找
	 * 
	 */
	public static  void tGroup() {

	      // 按指定模式在字符串查找
	      String line = "This order was placed for QT3000! OK?";
	      String pattern = "(\\D*)(\\d+)(.*)";
	 
	      // 创建 Pattern 对象
	      Pattern r = Pattern.compile(pattern);
	 
	      // 现在创建 matcher 对象
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );// 默认捕获
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	         System.out.println("Found value: " + m.group(3) ); 
	      } else {
	         System.out.println("NO MATCH");
	      }
	      
	      m.reset();
	      m.usePattern(Pattern.compile("(\\d+)+([$￥])"));
	      m.find();
	      System.err.println(m.group());
	      
	}
	
	public  void test () {
		//正则表发式的边界匹配
		
		Pattern p = Pattern.compile("^[0-9]{12}|^[A-Za-z]{2}[0-9]{13}$");
		System.err.println("1-----"+p.matcher("SF1236352152596").matches());
		System.err.println("2-----"+"dd56".matches("^[A-Za-z]{2}[0-9]{1}$"));
		String s = "070036987522,856230644535,856230647555256asasas";
		String[] sw= s.split("\n", s.length());
		System.err.println("3-----"+Arrays.toString(sw));
		
		System.err.println("4-----"+"sf1236352152596".matches("^(SF|sf|[0-9])[0-9]*"));
//		p = Pattern.compile("([0-9]{1,3}[%]|法)");
//		p = Pattern.compile("(\\(([^}]*)\\))");
		p = Pattern.compile("([0-9]+个|[0-9]+([\\s]*)个)");
		p = Pattern.compile("([([\\s]*)`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？])");
		s = "5+59f(sdsa50%)ds()adsa696 个法6%     规200%696个";
		System.err.println("5 -- " + s.matches("[.*\\d{1,3}]"));
		Matcher  matcher= p.matcher(s);
		
		System.err.println(" 6666 :" +matcher.replaceAll(""));
//		while(matcher.find()){
//		System.out.println(" 6666 :"+matcher.group());
//		}
		
		
		String str="判断的字符串%";
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p1=Pattern.compile(regEx);
		Matcher m=p1.matcher(str);
		System.out.println(m.find());
		
		
		Pattern pattern =Pattern.compile("(http://|https://){1}[\\w\\.\\-/:]+");

		matcher =pattern.matcher("dsdsds<http://dsds//gfgffdfd>fdfg<http://fdsf佛挡杀佛//gfgffdfd>");

		StringBuffer buffer = new StringBuffer();
//		matcher.find();
//		while(matcher.find()){

//		buffer.append(matcher.group(0));

//		buffer.append("\r\n");

//		System.out.println(buffer.toString());
		
		String gdesc = "大衣66 10.5%dd";
		gdesc.contains("千克");
		String washStr ;
		//1.剔除括号及括号内的部分。如：（）或（******）
//		p = Pattern.compile("([\\(（]([^}]*)[\\)）])");
//		matcher= p.matcher(gdesc);
//		washStr =  matcher.replaceAll("");
		//1.剔除百分数。如：100%，若只有%号不剔除
		p = Pattern.compile("([0-9.]+[%])");
		matcher= p.matcher(gdesc);
		washStr = matcher.replaceAll("");
		System.err.println("=================>ooo" + washStr);
		//3)      剔除数量和标准单位的组合。如：1个或1  个（数量和单位有空格也剔除）
		p = Pattern.compile("([0-9]+([\\s]*)[条个双袋只千克杯瓶份]{1,2})");
		p = Pattern.compile("([0-9]+([\\s]*)[对對 Pairs万套萬套Ten Thousand Set码碼Yard百枝百枝Hundred Pcs千块千塊Thousand Pcs平方英尺平方英尺Sq Ft副副Pcs平方码平方碼Sq Yd克拉克拉Ct短吨短噸Just Ton发發Pcs艘艘Pcs枚枚Pcs支支Pcs头頭Pcs英加仑英加侖Ukgal两兩Tael美加仑美加侖Usgal短担短擔Short Hundredseight千个千個Thousand Pcs万张萬張Ten Thousand Pcs袋袋Bag平方尺平方尺Sq Ft千枝千枝Thousand Pcs块塊Pcs片片Pcs英担英擔Cwt箱箱Box千粒千粒Thousand Pcs令令Ream盘盤Pcs司马斤司馬斤Catty立方尺立方尺Cf本本Pcs罐罐Can千支千支Thousand Pcs千瓦时千瓦時Kwh桶桶Bbl瓶瓶Bottle千米千米Km部部Pcs株株Pcs根根Pcs克克G千克千克Kg万粒萬粒Ten Thousand Pcs筐筐Basketful千张千張Thousand Pcs亿个億個Hundred Million Piece组組Set磅磅Lb公制马力公制馬力Ps扇扇Pcs万双萬雙Ten Thousand Pairs套套Set长吨長噸Gross Ton百万贝可百萬貝可Mbq筒筒Pcs幅幅Pcs刀刀Hundred Sheets捆捆Bundle枝枝Pcs百片百片Hundred Pcs亿支億支Hundred Million Piece千盒千盒Thousand Box百副百副Hundred Pairs司马担司馬擔Picul包包Bag辆輛Pcs棵棵Pcs盆盆Pcs具具Pcs英寸英寸Inch市尺市尺Chi千英尺千英尺Kfeet公担公擔Quintal斤斤Jin批批Batch升升L册冊Volume条條Pcs只只Pcs台台Set打打Dozen英尺英尺Feet平方米平方米Sq.M.盒盒Box双雙Pairs百把百把Hundred Pcs件件Pcs千升千升Kl千只千隻Thousand Pcs万个萬個Ten Thousand Pcs疋疋Roll立方英尺立方英尺Cf百支百支Hundred Pcs英制马力英制馬力Hp匹匹Bolt份份Pcs担擔Picul张張Pcs把把Pcs个個Pcs米米M寸寸Inch千瓦千瓦Kw市担市擔Dan千伏安千伏安Kva毫升毫升Ml扎紮Bundle盎司盎司Ngs立方米立方米Cubic Meters卷卷Roll吨噸Ton粒粒Pcs架架Pcs百个百個Hundred Pcs\r\n" + 
				"]+.*+)");
		matcher= p.matcher(washStr);
		washStr = matcher.replaceAll("");
		// 4)      剔除特殊符号。如：# ? * & + !(中文感叹号) .  -  \n(换行符)
		p = Pattern.compile("([([\\s]*)`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}\\\\【】‘；：”“’。，、？])");
		matcher= p.matcher(washStr);
		washStr = matcher.replaceAll("");
		washStr = washStr.toLowerCase();
		System.err.println("*********===========1:"+ washStr);
		
		String s2= "Ten Thousand Set mathch you  单位的案发时 500 平方英尺";
//		s2 = "女棉大衣500 双 ";
		s2 = "巧克力，32.5盎司922克";
		System.err.println("*********++++++:"+ s2);
		p = Pattern.compile("([0-9]+)");
		matcher= p.matcher(s2);
		ArrayList<String> munlist = new ArrayList<String>();
		int i = 0;
		while (matcher.find()) {
			munlist.add( matcher.group());
		}
		for (int j = 0; j < munlist.size(); j++) {
			s2 = s2.replace(munlist.get(j), munlist.get(j) + " ");
		}	
		System.err.println("*********2:"+ s2);
		
		p = Pattern.compile("[0-9]+([\\s]{0,})\\b(对|万套|码|百枝|千块|平方英尺|副|平方码|克拉|短吨|发|艘|枚|支|头|英加仑|两|美加仑|短担|千个|万张|袋|平方尺|千枝|块|片|英担|箱|千粒|令|盘|司马斤|立方尺|本|罐|千支|千瓦时|桶|瓶|千米|部|株|根|克|千克|万粒|筐|千张|亿个|组|磅|公制马力|扇|万双|套|长吨|百万贝可|筒|幅|刀|捆|枝|百片|亿支|千盒|百副|司马担|包|辆|棵|盆|具|英寸|市尺|千英尺|公担|斤|批|升|册|条|只|台|打|英尺|平方米|盒|双|百把|件|千升|千只|万个|疋|立方英尺|百支|英制马力|匹|份|担|张|把|个|米|寸|千瓦|市担|千伏安|毫升|扎|盎司|立方米|卷|吨|粒|架|百个|\r\n" + 
				"|對|萬套|碼|百枝|千塊|平方英尺|副|平方碼|克拉|短噸|發|艘|枚|支|頭|英加侖|兩|美加侖|短擔|千個|萬張|袋|平方尺|千枝|塊|片|英擔|箱|千粒|令|盤|司馬斤|立方尺|本|罐|千支|千瓦時|桶|瓶|千米|部|株|根|克|千克|萬粒|筐|千張|億個|組|磅|公制馬力|扇|萬雙|套|長噸|百萬貝可|筒|幅|刀|捆|枝|百片|億支|千盒|百副|司馬擔|包|輛|棵|盆|具|英寸|市尺|千英尺|公擔|斤|批|升|冊|條|只|台|打|英尺|平方米|盒|雙|百把|件|千升|千隻|萬個|疋|立方英尺|百支|英制馬力|匹|份|擔|張|把|個|米|寸|千瓦|市擔|千伏安|毫升|紮|盎司|立方米|卷|噸|粒|架|百個|\r\n" + 
				"|Pairs|Ten Thousand Set|Yard|Hundred Pcs|Thousand Pcs|Sq Ft|Pcs|Sq Yd|Ct|Just Ton|Pcs|Pcs|Pcs|Pcs|Pcs|Ukgal|Tael|Usgal|Short Hundredseight|Thousand Pcs|Ten Thousand Pcs|Bag|Sq Ft|Thousand Pcs|Pcs|Pcs|Cwt|Box|Thousand Pcs|Ream|Pcs|Catty|Cf|Pcs|Can|Thousand Pcs|Kwh|Bbl|Bottle|Km|Pcs|Pcs|Pcs|G|Kg|Ten Thousand Pcs|Basketful|Thousand Pcs|Hundred Million Piece|Set|Lb|Ps|Pcs|Ten Thousand Pairs|Set|Gross Ton|Mbq|Pcs|Pcs|Hundred Sheets|Bundle|Pcs|Hundred Pcs|Hundred Million Piece|Thousand Box|Hundred Pairs|Picul|Bag|Pcs|Pcs|Pcs|Pcs|Inch|Chi|Kfeet|Quintal|Jin|Batch|L|Volume|Pcs|Pcs|Set|Dozen|Feet|Sq.M.|Box|Pairs|Hundred Pcs|Pcs|Kl|Thousand Pcs|Ten Thousand Pcs|Roll|Cf|Hundred Pcs|Hp|Bolt|Pcs|Picul|Pcs|Pcs|Pcs|M|Inch|Kw|Dan|Kva|Ml|Bundle|Ngs|Cubic Meters|Roll|Ton|Pcs|Pcs|Hundred Pcs|\r\n" + 
				")\\b.*+");
		matcher= p.matcher(s2);
//		matcher.find();
//		System.err.println("-------------"+matcher.group() );
		while (matcher.find()) {
			System.err.println("--------------------");
			munlist.add( matcher.group());
		}
		s2 = matcher.replaceAll("");
		System.err.println("*********3:"+ s2);
//		s2  = "女棉20 大衣";
		p = Pattern.compile("[0-9]+\\s");
		matcher= p.matcher(s2);
		munlist.clear();
		while (matcher.find()) {
			
			munlist.add( matcher.group());
		}
		
		for (int j = 0; j < munlist.size(); j++) {
			System.err.println(munlist.get(j));
			
			s2 = s2.replace(munlist.get(j), munlist.get(j) .trim());
			System.err.println(s2);
		}
		System.err.println("*********++++++:"+ s2);
		
		System.err.println("ceshi=======> " + substringBeforeDigit("6个核桃 1箱"));
		
		
		Map<String, String> m2 = new HashMap<>();
		m2.put("M", "SS/");
		m2.put("m", "SS/");
		System.err.println(m2);
		
//		
//		String sss = "785968794144,785988589622,785983980630,785950510748,785903230341,785969700601,785986028098,785944190249,785947936767,785968345818,785972799135,785974206260,785998978736,785928473231,785949140705,785949495833,785958049389,785967392013,785947924281,785922926446,785921464078,785951106592";
//		System.err.println(sss.replace(",", "\r"));
		
	}
}
