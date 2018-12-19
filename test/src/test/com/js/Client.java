package test.com.js;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import cn.hutool.core.util.ObjectUtil;

public class Client {
	public static void main(String[] args) throws NoSuchMethodException, ScriptException, IOException {
		ScriptEngineManager manager = new ScriptEngineManager();   
		ScriptEngine engine = manager.getEngineByName("javascript");     
 
		String jsFileName = "C:/Users/80003509/git/something/test/src/expression.js";   // 读取js文件   
 
		FileReader reader = new FileReader(jsFileName);   // 执行指定脚本   
		engine.eval(reader);   
 
		if(engine instanceof Invocable) {    
		Invocable invoke = (Invocable)engine;    // 调用merge方法，并传入两个参数    
 
		// c = merge(2, 3);    
 
		Double c = (Double)invoke.invokeFunction("merge", 2, 3);    
 
		System.out.println("c = " + c);   
		}   
		reader.close(); 
	}
}
