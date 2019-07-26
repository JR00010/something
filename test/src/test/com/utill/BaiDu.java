package test.com.utill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.json.JSONArray;


public class BaiDu {
	private static final String  URL = "https://fanyi.baidu.com/";
	private static String  URI = URL;
	
	private final Map<String, List<String>> map;
	
	private BaiDu() {
		this(URL);
	}
	private BaiDu(String uri) {
		URI = uri;
		this.map = getResponse(uri);
	}
    public static void main(String[] args) throws Exception{
//    	 SimpleHttpClient.get(URL);
    	 String url = "https://fanyi.baidu.com/v2transapi";
    	 
    	 BaiDu baidu  = new BaiDu();
         String from = "zh";
         String to = "en";
         String q = "大白鲨";
         String token = baidu.getToken();
         String gtk = baidu.getGtk();
         String sign = getSign(q, gtk);
         Map<String, Object> params = new HashMap<String, Object>();
         params.put("from", from);
         params.put("to", to);
         params.put("query", q);
         params.put("transtype", "translang");
         params.put("simple_means_flag", "3");
         params.put("sign", sign);
         params.put("token", token);
         
         System.err.println(token  +"---------" +  gtk);
         Map<String, String> headers = new HashMap<String, String>();
         headers.put("Cookie",SimpleHttpClient.getCookie().toString());
         headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

    	String s = SimpleHttpClient.post(url, params, headers);
    	JSONObject o = JSONObject.parseObject(s);
    	JSONObject result = (JSONObject)((com.alibaba.fastjson.JSONArray)((JSONObject)o.get("trans_result")).get("data")).get(0);
    	System.err.println(result.get("dst"));
    	
    	
//    	SimpleHttpClient.post(url, params, headers)
 
    }
    
    private void translate() throws ClientProtocolException, IOException {
       	BaiDu baidu  = new BaiDu();
       	String from = "zh";
        String to = "en";
        String q = "电脑";
//        String token ="63ff932361c6ccc3581f6d2affc77d1f"; //baidu.getToken();
        String token = baidu.getToken();
//        String gtk = "320305.131321201";//baidu.getGtk();
        String gtk = baidu.getGtk();
        String url = "https://fanyi.baidu.com/v2transapi";
        String sign = getSign(q, gtk);
        System.err.println(token + "---" + gtk + "---"+ sign );
        System.err.println(baidu.getCookie());
        Map<String, String> params = new HashMap<String, String>();
        params.put("from", from);
        params.put("to", to);
        params.put("query", q);
        params.put("transtype", "translang");
        params.put("simple_means_flag", "3");
        params.put("sign", sign);
        params.put("token", token);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost request = new HttpPost(url);
        request.setEntity(new UrlEncodedFormEntity(convertParams(params), "UTF-8"));
//        request.setHeader("Cookie", "locale=zh; BAIDUID=B786362D87C66C6F0F21036CB7181B99:FG=1");
        request.setHeader("Cookie",baidu.getCookie());
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();

        String result = EntityUtils.toString(entity, "utf-8");
        System.out.println(result);
        EntityUtils.consume(entity);

        response.getEntity().getContent().close();
        response.close();
    }

    private static List<? extends NameValuePair> convertParams(Map<String, String> params) {
    	List<NameValuePair> list  = new ArrayList<NameValuePair>();
    	Set<Entry<String, String>> entryMap = params.entrySet();
    	for (Entry<String, String> entry : entryMap) {
    		BasicNameValuePair value = new BasicNameValuePair(entry.getKey(), entry.getValue());
    		list.add(value);
    	}
		return list;
	}
	private static String getSign(String value, String sign) {
        String result = "";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        try {
            FileReader reader = new FileReader("resource/Baidu.js");
            engine.eval(reader);
            if (engine instanceof Invocable) {
                Invocable invoke = (Invocable)engine;
                result = String.valueOf(invoke.invokeFunction("token", value, sign));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private  String getContent() throws ClientProtocolException, IOException {
    	SimpleHttpClient.get(URI);
      String s = SimpleHttpClient.get(URI);
    return  s;
    }
    
    private   Map<String, List<String>> getResponse(String url) {
//    	return HttpRequest.sendGet(url, null);
    	return null;
    }
    
    private  String getCookie() {
    	return this.map.get("Set-Cookie").toString().replace("[", "").replace("]", "");
    }
    
    private   String getGtk() throws ClientProtocolException, IOException {
    	String result = getContent();
    	return match(result,"gtk.*(\\d{6}[.]{1}\\d{9})");
    }
    
    private static String  match(String o,String pattern) {
    	Pattern p = Pattern.compile(pattern);
    	Matcher matcher = p.matcher(o); 
    	if(matcher.find())
    		return matcher.group(1);
    	return null;
    }
    
    private String getToken() throws ClientProtocolException, IOException {
    	String result = getContent();
    	return match(result,"token[:\\s']{3}([0-9a-z]+)");
    }
    
    
    private static void s() {
    	CookieStore cookieStore = new BasicCookieStore();
    	CloseableHttpClient httpClient = HttpClients.custom()
                 .setDefaultCookieStore(cookieStore)
                 .build();
         try {
         	
              HttpPost post = new HttpPost("https://fanyi.baidu.com/");
              BasicClientCookie cookie = new BasicClientCookie("name", "zhaoke"); 
              cookie.setVersion(0);  
              cookie.setDomain("/pms/");   //设置范围
              cookie.setPath("/"); 
              cookieStore.addCookie(cookie);
              httpClient.execute(post);//
              List<Cookie> cookies = cookieStore.getCookies();
              for (int i = 0; i < cookies.size(); i++) {
                  System.out.println("Local cookie: " + cookies.get(i));
              }
            } catch (Exception e) {
    			e.printStackTrace();
    		}finally{
    			
    		}
    }
    
    /*
     * unicode编码转中文
     */
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
}
