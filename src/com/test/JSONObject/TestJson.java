package com.test.JSONObject;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * String——>JSONObject
 * @date 2018年11月29日 下午6:54:08
 */
public class TestJson {
	public static void main(String[] args) {

		JSONObject jsb;
		try {
			jsb = new JSONObject("{\"code\":{\"寻\":\"98ed\",\"叼\":\"53fc\"},\"name\":\"1489112433945\"}");
			System.out.println("配置文件default_map内容读取结果："+jsb);
			//getString可以根据名字获取
			String code = jsb.getString("name");
			System.out.println("getString获取内容："+code);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
